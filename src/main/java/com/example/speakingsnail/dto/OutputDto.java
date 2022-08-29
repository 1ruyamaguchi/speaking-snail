package com.example.speakingsnail.dto;

import lombok.Data;

/**
 * かたつむりがしゃべる内容を返すdto
 * 
 */
@Data
public class OutputDto {

    /** 吹き出しの上側 */
    private String bubbleSpeakUpper;

    /** 吹き出しのセリフ部分 */
    private String bubbleSpeakSentence;

    /** 吹き出しの下側（画面側で反転処理して使用する） */
    private String bubbleSpeakLower;

}
