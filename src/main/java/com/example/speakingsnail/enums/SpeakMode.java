package com.example.speakingsnail.enums;

/**
 * おしゃべりモードを列挙するクラス
 * 
 */
public enum SpeakMode {

    NORMAL("1"),
    GAL("2");

    private final String modeCode;

    // コンストラクタ
    private SpeakMode(String modeCode) {
        this.modeCode = modeCode;
    }

    public String getModeCode() {
        return this.modeCode;
    }

}
