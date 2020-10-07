/*
作者：李宁（蒙娜丽宁）
获得更多精彩文章和视频，请关注我的微信公众号：极客起源
配套鸿蒙（HarmonyOS）视频教程：https://www.bilibili.com/video/BV1mv411179B
别忘了一键三连哦！

更多精彩视频，请关注我的B站：https://space.bilibili.com/477001733


copyright 2020-2025
*/

package com.example.myapplication.slice;

import com.example.PhoneHap.ResourceTable;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.components.Button;
import ohos.agp.components.Component;
import ohos.agp.components.PositionLayout;
import ohos.agp.components.Text;
import ohos.agp.text.Font;
import ohos.agp.utils.Color;
import ohos.agp.colors.RgbColor;
import ohos.agp.components.element.ShapeElement;
import ohos.agp.components.ComponentContainer.LayoutConfig;
import ohos.global.resource.Resource;

public class MainAbilitySlice extends AbilitySlice {

    private PositionLayout myLayout = new PositionLayout(this);

    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        // 加载XML布局作为根布局

        super.setUIContent(com.example.PhoneHap.ResourceTable.Layout_main_layout);
        // 查找布局中控件


        Button btnAbility = (Button) findComponentById(ResourceTable.Id_ability);

        if (btnAbility != null) {


            btnAbility.setClickedListener(new Component.ClickedListener() {
                @Override
                // 在控件中增加对点击事件的监听
                public void onClick(Component Component) {
                    present(new AbilityDemo(),new Intent());
                }
            });
        }
    }

    @Override
    public void onActive() {
        super.onActive();
    }

    @Override
    public void onForeground(Intent intent) {
        super.onForeground(intent);
    }
}
