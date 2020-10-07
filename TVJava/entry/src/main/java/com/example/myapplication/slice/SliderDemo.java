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
import ohos.agp.components.Button;
import ohos.agp.components.Component;
import ohos.agp.components.Slider;
import ohos.agp.components.Text;
import ohos.agp.components.element.ShapeElement;
import ohos.multimodalinput.event.TouchEvent;

public class SliderDemo extends AbilitySlice {
    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);

        super.setUIContent(ResourceTable.Layout_slider_layout);

        Slider slider = (Slider)findComponentById(ResourceTable.Id_slider);

        Text text = (Text)findComponentById(ResourceTable.Id_txtSlider);
        Button button = (Button)findComponentById(ResourceTable.Id_btnSlider);
        if(slider != null && text != null && button != null) {
            button.setClickedListener(new Component.ClickedListener() {
                @Override
                public void onClick(Component component) {
                    text.setText(String.valueOf(slider.getProgress()));
                }
            });
        }
    }


}
