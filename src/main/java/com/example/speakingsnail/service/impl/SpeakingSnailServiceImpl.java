package com.example.speakingsnail.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.speakingsnail.dto.ChangeSpeakModeDto;
import com.example.speakingsnail.dto.InputDto;
import com.example.speakingsnail.dto.OutputDto;
import com.example.speakingsnail.logic.SpeakingSnailLogic;
import com.example.speakingsnail.service.SpeakingSnailService;

import lombok.extern.slf4j.Slf4j;

/**
 * しゃべるかたつむりサービスの実装
 * 
 */
@Service
@Slf4j
public class SpeakingSnailServiceImpl implements SpeakingSnailService {

    @Autowired
    private SpeakingSnailLogic speakingSnailLogic;

    /**
     * {@inheritDoc}
     * 
     */
    @Override
    public OutputDto callSnail(InputDto inputDto) {

        log.info("The service callSnail is called");

        // 入力が空だった場合に特殊処理
        if (inputDto.getSpeakContent().equals("")) {
            inputDto.setSpeakContent("なんか書いてよ！");
        }

        // ロジック呼び出し
        OutputDto outputDto = speakingSnailLogic.callSnail(inputDto);

        log.info("Successfully finished the service callSnail");

        return outputDto;
    }

    /**
     * {@inheritDoc}
     * 
     */
    @Override
    public String changeSpeakMode(ChangeSpeakModeDto changeSpeakModeDto) {
        // 現状モードが2種類しかないため暫定の実装・・・

        log.info("The service changeSpeakMode is called");

        // 返却値を定義
        String nextSpeakMode = "";

        if (changeSpeakModeDto.getModeCode().equals("1")) {
            nextSpeakMode = "2";
        } else {
            nextSpeakMode = "1";
        }

        log.info("Successfully finished the service changeSpeakMode");

        return nextSpeakMode;
    }

}
