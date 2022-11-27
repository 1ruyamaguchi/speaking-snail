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
    // TODO バリデーション実装
    private String speakMode;

}
