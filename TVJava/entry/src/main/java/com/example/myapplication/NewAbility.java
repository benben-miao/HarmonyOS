/*
作者：李宁（蒙娜丽宁）
获得更多精彩文章和视频，请关注我的微信公众号：极客起源
配套鸿蒙（HarmonyOS）视频教程：https://www.bilibili.com/video/BV1mv411179B
别忘了一键三连哦！

更多精彩视频，请关注我的B站：https://space.bilibili.com/477001733


copyright 2020-2025
*/
package com.example.myapplication;

import com.example.myapplication.slice.ASlice;
import com.example.myapplication.slice.NewSlice;
import ohos.aafwk.ability.Ability;
import ohos.aafwk.content.Intent;

public class NewAbility extends Ability {
    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setMainRoute(NewSlice.class.getName());

    }
}
