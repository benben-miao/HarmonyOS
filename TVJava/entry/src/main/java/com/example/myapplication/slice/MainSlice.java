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
import ohos.agp.components.Component;

public class MainSlice extends AbilitySlice {
    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);

        super.setUIContent(com.example.PhoneHap.ResourceTable.Layout_main_ability_layout);

        Button button = (Button)findComponentById(com.example.PhoneHap.ResourceTable.Id_btnBAbility);
        if(button != null) {
            button.setClickedListener(new Component.ClickedListener() {
                @Override
                public void onClick(Component component) {
                    Intent intent = new Intent();
                    intent.setAction("action.new");
                    intent.setParam("data","新页面");
                    startAbility(intent);

                }
            });

        }
    }
}