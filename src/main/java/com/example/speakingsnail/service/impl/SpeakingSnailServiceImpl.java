package com.example.speakingsnail.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.speakingsnail.dto.ChangeSpeakModeDto;
import com.example.speakingsnail.dto.InputDto;
import com.example.speakingsnail.dto.OutputDto;
import com.example.speakingsnail.logic.SpeakingSnailLogic;
import com.example.speakingsnail.service.SpeakingSnailService;

/**
 * しゃべるかたつむりサービスの実装
 * 
 */
@Service
public class SpeakingSnailServiceImpl implements SpeakingSnailService {

    @Autowired
    private SpeakingSnailLogic speakingSnailLogic;

    /**
     * {@inheritDoc}
     * 
     */
    @Override
    public OutputDto callSnail(InputDto inputDto) {

        // 入力が空だった場合に特殊処理
        if (inputDto.getSpeakContent().equals("")) {
            inputDto.setSpeakContent("なんか書いてよ！");
        }

        // ロジック呼び出し
        OutputDto outputDto = speakingSnailLogic.callSnail(inputDto);

        return outputDto;
    }

    /**
     * {@inheritDoc}
     * 
     */
    @Override
    public String changeSpeakMode(ChangeSpeakModeDto changeSpeakModeDto) {

        return changeSpeakModeDto.getModeCode();
    }

}
