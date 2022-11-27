package com.example.speakingsnail.dto;

import lombok.Data;

/**
 * おしゃべりモードの切り替えをするDto
 * 
 */
@Data
public class ChangeSpeakModeDto {

    /** おしゃべりモードのコード値 */
    // TODO バリデーション実装
    private String modeCode;

}
