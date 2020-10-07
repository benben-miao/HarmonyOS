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
import ohos.agp.components.Checkbox;
import ohos.agp.components.Component;
import ohos.agp.components.Text;
import ohos.miscservices.pasteboard.PasteData;
import ohos.miscservices.pasteboard.SystemPasteboard;

public class ClipboardDemo extends AbilitySlice {
    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(com.example.PhoneHap.ResourceTable.Layout_clipboard_layout);
        Button button = (Button)findComponentById(ResourceTable.Id_clipboardButton);
        if(button != null) {
            button.setClickedListener(new Component.ClickedListener() {
                @Override
                public void onClick(Component component) {
                    clip();
                }
            });
        }

    }

    public void clip() {

        SystemPasteboard pasteboard = SystemPasteboard.getSystemPasteboard(this);
        if (pasteboard != null) {
            pasteboard.setPasteData(PasteData.creatPlainTextData("Hello, world!"));
            // 从剪贴板中获取数据
            PasteData pasteData = pasteboard.getPasteData();
            if (pasteData == null) {
                return;
            }
            PasteData.DataProperty dataProperty = pasteData.getProperty();
            boolean hasHtml = dataProperty.hasMimeType(PasteData.MIMETYPE_TEXT_HTML);
            boolean hasText = dataProperty.hasMimeType(PasteData.MIMETYPE_TEXT_PLAIN);
            if (hasHtml || hasText) {
                Text text = (Text) findComponentById(ResourceTable.Id_clipboardText);
                if(text != null) {
                    for (int i = 0; i < pasteData.getRecordCount(); i++) {
                        PasteData.Record record = pasteData.getRecordAt(i);
                        String mimeType = record.getMimeType();
                        if (mimeType.equals(PasteData.MIMETYPE_TEXT_PLAIN)) {
                            text.setText(record.getPlainText().toString());
                            break;
                        }
                    }

                }
            }
        }

    }
}
