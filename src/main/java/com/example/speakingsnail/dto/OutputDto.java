package com.example.speakingsnail.dto;

import java.util.List;

import lombok.Data;

/**
 * かたつむりがしゃべる内容を返すdto
 * 
 */
@Data
public class OutputDto {

    /** しゃべる内容（吹き出し付き） */
    private List<String> bubbleSpeakContent;

}
