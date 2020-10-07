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
import ohos.agp.colors.RgbColor;
import ohos.agp.components.*;
import ohos.agp.components.element.ShapeElement;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;

class DataItem {
    public String text;
    public DataItem(String text) {
        this.text = text;
    }
}
class RecycleSimpleItemProvider extends RecycleItemProvider {

    private List<DataItem> list;

    private AbilitySlice slice;

    public RecycleSimpleItemProvider(List<DataItem> list) {
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }



    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public Component getComponent(int i, Component component, ComponentContainer componentContainer) {
        if (component == null) {
            Text text = new Text(componentContainer.getContext());
            text.setWidth(StackLayout.LayoutConfig.MATCH_PARENT);
            text.setHeight(StackLayout.LayoutConfig.MATCH_CONTENT);
            text.setText(((DataItem) this.list.get(i)).text);
            return text;
        } else {

            return component;
        }
    }

}


public class ListDemo extends AbilitySlice {
    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);

        super.setUIContent(ResourceTable.Layout_list_layout);
        ListContainer list1 = (ListContainer)this.findComponentById(ResourceTable.Id_list1);
        if(list1 != null) {
            List<DataItem> items = new ArrayList<>();
            items.add(new DataItem("hello"));
            items.add(new DataItem("world"));
            items.add(new DataItem("abcd"));
            items.add(new DataItem("ddddd"));
            list1.setItemProvider(new RecycleSimpleItemProvider(items));

        }
    }


}
