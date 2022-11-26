package com.example.speakingsnail.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * おしゃべりモードを列挙するクラス
 * 
 */
public enum SpeakMode {

    NORMAL(CodeConstants.NORMAL_CODE, "通常モード"),
    GAL(CodeConstants.GAL_CODE, "ギャルモード");

    public static class CodeConstants {
        public static final String NORMAL_CODE = "1";
        public static final String GAL_CODE = "2";
    }

    private final String speakModeCode;
    private final String displaySpeakMode;

    // コンストラクタ
    private SpeakMode(String speakModeCode, String displaySpeakMode) {
        this.speakModeCode = speakModeCode;
        this.displaySpeakMode = displaySpeakMode;
    }

    public String getSpeakModeCode() {
        return this.speakModeCode;
    }

    public String getDisplaySpeakMode() {
        return this.displaySpeakMode;
    }

    /**
     * コード値と表示する文字列の対応を作成
     * 
     * @return
     */
    public static Map<String, String> getSpeakModeCodeMap() {

        Map<String, String> speakModeCodeMap = new HashMap<String, String>();

        SpeakMode[] arraySpealMode = SpeakMode.values();
        for (SpeakMode speakMode : arraySpealMode) {
            speakModeCodeMap.put(speakMode.getSpeakModeCode(), speakMode.getDisplaySpeakMode());
        }

        return speakModeCodeMap;
    }

}
