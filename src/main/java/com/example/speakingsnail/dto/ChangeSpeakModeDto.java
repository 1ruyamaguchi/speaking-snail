package com.example.speakingsnail.dto;

import lombok.Data;

/**
 * おしゃべりモードの切り替えをするDto
 * 
 */
@Data
public class ChangeSpeakModeDto {

    /** おしゃべりモードのコード値 */
    private String modeCode;

}
