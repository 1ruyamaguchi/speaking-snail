package com.example.speakingsnail.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.speakingsnail.constants.UrlConst;
import com.example.speakingsnail.dto.ChangeSpeakModeDto;
import com.example.speakingsnail.dto.InputDto;
import com.example.speakingsnail.dto.OutputDto;

/**
 * しゃべるかたつむりサービスのインターフェース
 * 
 */
@Service
@RestController
@RequestMapping(value = UrlConst.BASE_API)
public interface SpeakingSnailService {

    /**
     * かたつむりに任意の内容をしゃべらせるメソッド
     * 入力された内容を吹き出し付きで返す
     * 
     * @param outputDto
     * @return
     */
    @PostMapping(value = UrlConst.CALL)
    OutputDto callSnail(InputDto inputDto);

    /**
     * おしゃべりモードを切り替えるメソッド
     * 
     * @param changeSpeakModeDto
     */
    @GetMapping(value = UrlConst.MODE_CHANGE)
    String changeSpeakMode(ChangeSpeakModeDto changeSpeakModeDto);
}
