package com.example.speakingsnail.enums;

/**
 * ギャル文字を列挙するクラス
 * 
 */
public enum GalChar {
    A("あ", "ぁ"),
    I("い", "ぃ"),
    U("う", "ぅ"),
    E("え", "ぇ"),
    O("お", "ぉ"),
    KA("か", "ｶゝ"),
    KI("き", "(ｷ"),
    KU("く", "〈"),
    KE("け", "(ﾅ"),
    KO("こ", "⊇"),
    SA("さ", "±"),
    SI("し", "Ｕ"),
    SU("す", "￡"),
    SE("せ", "七"),
    SO("そ", "ζ"),
    TA("た", "ﾅﾆ"),
    TI("ち", "干"),
    TU("つ", "⊃"),
    TE("て", "τ"),
    TO("と", "`⊂"),
    NA("な", "ﾅょ"),
    NI("に", "ﾚﾆ"),
    NU("ぬ", "又"),
    NE("ね", "礻"),
    NO("の", "σ"),
    HA("は", "ﾚ￡"),
    HI("ひ", "匕"),
    HU("ふ", "､ζ,"),
    HE("へ", "∧"),
    HO("ほ", "木"),
    MA("ま", "ма"),
    MI("み", "ゐ"),
    MU("む", "￡ヽ"),
    ME("め", "×"),
    MO("も", "м○"),
    YA("や", "ゃ"),
    YU("ゆ", "ゅ"),
    YO("よ", "ょ"),
    RA("ら", "５"),
    RI("り", "ﾚ)"),
    RU("る", "ゐ"),
    RE("れ", "яё"),
    RO("ろ", "З"),
    WA("わ", "ゎ"),
    WO("を", "を"),
    NN("ん", "ω"),
    GA("が", "ヵヽ”"),
    GI("ぎ", "(‡”"),
    GU("ぐ", "＜”"),
    GE("げ", "(†゛"),
    GO("ご", "⊇”"),
    ZA("ざ", "(＋”"),
    ZI("じ", "∪”"),
    ZU("ず", "￡”"),
    ZE("ぜ", "世”"),
    ZO("ぞ", "ζ゛"),
    DA("だ", "ﾅﾆ”"),
    DI("ぢ", "干”"),
    DU("づ", "⊃”"),
    DE("で", "τ゛"),
    DO("ど", "ヽ⊂゛"),
    BA("ば", "(よ”"),
    BI("び", "Ｍ”"),
    BU("ぶ", ",3､”"),
    BE("べ", "∧”"),
    BO("ぼ", "木”"),
    PA("ぱ", "(ょﾟ"),
    PI("ぴ", "Ｍﾟ"),
    PU("ぷ", ",3､○"),
    PE("ぺ", "∧○"),
    PO("ぽ", "木○");

    private final String normalChar;
    private final String galChar;

    // コンストラクタ
    private GalChar(String normalChar, String galChar) {
        this.normalChar = normalChar;
        this.galChar = galChar;
    }

    public String getNormalChar() {
        return this.normalChar;
    }

    public String getGalGhar() {
        return this.galChar;
    }

}
