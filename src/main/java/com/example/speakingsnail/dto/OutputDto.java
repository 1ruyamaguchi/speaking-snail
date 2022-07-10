package com.example.speakingsnail.dto;

import lombok.Data;

/**
 * かたつむりがしゃべる内容を返すdto
 * 
 */
@Data
public class OutputDto {

    /** しゃべる内容（吹き出し付き） */
    private String[] bubbleSpeakContent;

}
