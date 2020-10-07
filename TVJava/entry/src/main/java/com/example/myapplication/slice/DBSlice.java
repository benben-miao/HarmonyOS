/*
作者：李宁（蒙娜丽宁）
获得更多精彩文章和视频，请关注我的微信公众号：极客起源
配套鸿蒙（HarmonyOS）视频教程：https://www.bilibili.com/video/BV1mv411179B
别忘了一键三连哦！

更多精彩视频，请关注我的B站：https://space.bilibili.com/477001733


copyright 2020-2025
*/

package com.example.myapplication.slice;

import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.components.Button;
import ohos.agp.components.Checkbox;
import ohos.agp.components.Component;
import ohos.agp.components.Text;
import ohos.data.DatabaseHelper;
import ohos.data.orm.OrmContext;
import ohos.data.rdb.*;
import ohos.data.resultset.ResultSet;

public class DBSlice extends AbilitySlice {
    private static final RdbOpenCallback callback;

    static {
        callback = new RdbOpenCallback() {
            @Override
            public void onUpgrade(RdbStore rdbStore, int i, int i1) {
            }
            @Override
            public void onCreate(RdbStore store) {
                store.executeSql("create table if not exists test (id integer primary key autoincrement, name TEXT NOT NULL, age INTEGER, salary REAL)");

            }
        };
    }

    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(com.example.PhoneHap.ResourceTable.Layout_db_layout);
        Button button = (Button)findComponentById(com.example.PhoneHap.ResourceTable.Id_btnDB);
        if(button != null) {
            button.setClickedListener(new Component.ClickedListener() {
                @Override
                public void onClick(Component component) {
                    StoreConfig config = StoreConfig.newDefaultConfig("test.db");

                    DatabaseHelper helper = new DatabaseHelper(DBSlice.this);
                    RdbStore store = helper.getRdbStore(config, 1, callback, null);
                    ValuesBucket values = new ValuesBucket();
                    values.putInteger("id", 1);
                    values.putString("name", "Bill");
                    values.putInteger("age", 20);
                    values.putDouble("salary", 12345.1);
                    // 插入记录
                    long id = store.insert("test", values);

                    String[] columns = new String[] {"id", "name", "age", "salary"};
                    RdbPredicates rdbPredicates = new RdbPredicates("test").equalTo("id", 1).orderByAsc("name");
                    ResultSet resultSet = store.query(rdbPredicates, columns);
                    resultSet.goToNextRow();
                    Text text = (Text)findComponentById(com.example.PhoneHap.ResourceTable.Id_dbText);
                    if(text != null) {
                        text.setText(resultSet.getString(1));

                        resultSet =  store.querySql("select age from test where id = ?",new String[]{"1"});
                        resultSet.goToFirstRow();
                        text.setText(text.getText() + ":" + resultSet.getString(0));
                    }



                }
            });
        }
    }
}
