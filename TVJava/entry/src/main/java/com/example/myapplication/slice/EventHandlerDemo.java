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
import ohos.eventhandler.EventHandler;
import ohos.eventhandler.EventRunner;
import ohos.eventhandler.InnerEvent;

public class EventHandlerDemo extends AbilitySlice {
    private class MyEventHandler extends EventHandler {
        private MyEventHandler(EventRunner runner) {
            super(runner);
        }
        // 重写实现processEvent方法
        @Override
        public void processEvent(InnerEvent event) {
            super.processEvent(event);
            if (event == null) {
                return;
            }
            int eventId = event.eventId;
            long param = event.param;
            switch (eventId ) {
                case 1:
                    System.out.println("processEvent:" + String.valueOf(eventId) + ":" + String.valueOf(param));
                    break;
                default:
                    break;
            }
        }
    }

    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(com.example.PhoneHap.ResourceTable.Layout_eventhandler_layout);
        Button button = (Button)findComponentById(com.example.PhoneHap.ResourceTable.Id_btnDB);
        if(button != null) {
            button.setClickedListener(new Component.ClickedListener() {
                @Override
                public void onClick(Component component) {
                    EventRunner runner = EventRunner.create(false);
                    if (runner == null) {
                        return;
                    }
                    MyEventHandler myHandler = new MyEventHandler(runner);
                    int eventId1 = 0;
                    int eventId2 = 1;
                    long param = 0;
                    Object object = null;
                    InnerEvent event1 = InnerEvent.get(eventId1, param, object);
                    InnerEvent event2 = InnerEvent.get(eventId2, param, object);
                    myHandler.sendSyncEvent(event1,EventHandler.Priority.IMMEDIATE);
                    myHandler.sendSyncEvent(event2,EventHandler.Priority.IMMEDIATE);
                    runner.run();

                }
            });
        }
    }
}
