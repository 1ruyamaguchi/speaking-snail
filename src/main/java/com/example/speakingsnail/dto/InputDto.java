package com.example.speakingsnail.dto;

import lombok.Data;

/**
 * かたつむりにしゃべらせる内容を入力するdto
 * 
 */
@Data
public class InputDto {

    /** しゃべる内容 */
    private String speakContent;

    /** おしゃべりモード */
    private String speakMode;

}
