package com.example.speakingsnail.enums;

/**
 * 隠しコマンドを列挙するクラス
 * 
 */
public enum HiddenCommand {

    MINAMI("浜辺美波", "うちの奥さん"),
    HIGUCHI("樋口伸宏", "樋口伸宏大先輩");

    private final String before;
    private final String after;

    // コンストラクタ
    private HiddenCommand(String before, String after) {
        this.before = before;
        this.after = after;
    }

    public String getBefore() {
        return this.before;
    }

    public String getAfter() {
        return this.after;
    }

}
