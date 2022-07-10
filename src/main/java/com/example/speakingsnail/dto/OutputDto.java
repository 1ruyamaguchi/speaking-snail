package com.example.speakingsnail.dto;

import lombok.Data;

/**
 * かたつむりがしゃべる内容を返すdto
 * 
 */
@Data
public class OutputDto {

    /** 吹き出しの上側 */
    private String bubbleUpper;

    /** しゃべる内容（吹き出し付き） */
    private String[] bubbleMiddle;

    /** 吹き出しの下側 */
    private String bubbleLower;

}
