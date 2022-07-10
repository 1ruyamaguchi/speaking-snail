package com.example.speakingsnail.dto;

import javax.validation.constraints.NotNull;

import lombok.Data;

/**
 * かたつむりにしゃべらせる内容を入力するdto
 * 
 */
@Data
public class InputDto {

    /** しゃべる内容 */
    @NotNull
    private String speakContent;

}
