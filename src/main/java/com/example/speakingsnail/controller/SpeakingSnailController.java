package com.example.speakingsnail.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.speakingsnail.constants.UrlConst;
import com.example.speakingsnail.dto.ChangeSpeakModeDto;
import com.example.speakingsnail.dto.InputDto;
import com.example.speakingsnail.dto.OutputDto;
import com.example.speakingsnail.enums.SpeakMode;
import com.example.speakingsnail.service.SpeakingSnailService;

/**
 * しゃべるかたつむりのコントローラー
 * 
 */
@Controller
@RequestMapping(value = UrlConst.BASE_CLI)
public class SpeakingSnailController {

    @Autowired
    private SpeakingSnailService speakingSnailService;

    @ModelAttribute(value = "inputDto")
    public InputDto inputDto() {
        return new InputDto();
    }

    /**
     * 初期画面
     * 
     * @return
     */
    @RequestMapping(value = UrlConst.INPUT)
    public String welcome(HttpSession session, Model model) {

        // 初期はおしゃべりモード: 通常
        String speakModeCode = SpeakMode.NORMAL.getSpeakModeCode();
        session.setAttribute("speakModeCode", speakModeCode);
        // 画面表示用のモード名称を取得
        this.setModeCodeToSession(speakModeCode, session, model);

        return "page/inout";
    }

    /**
     * セリフ出力
     * 
     * @param inputDto
     * @param model
     * @return
     */
    @RequestMapping(value = UrlConst.OUTPUT)
    public String output(InputDto inputDto, Model model, HttpSession session) {

        // おしゃべりモードをセッションから取得してリクエストにセット
        String speakModeCode = (String) session.getAttribute("speakModeCode");
        inputDto.setSpeakMode(speakModeCode);
        // サービス呼び出し
        OutputDto outputDto = speakingSnailService.callSnail(inputDto);
        // 返却値をモデルに格納
        model.addAttribute("outputDto", outputDto);
        model.addAttribute("speakModeCode", session.getAttribute("speakModeCode"));

        // セッションにモード情報をセット
        this.setModeCodeToSession(speakModeCode, session, model);

        return "page/inout";
    }

    /**
     * モード変更
     * 
     * @return
     */
    @RequestMapping(value = UrlConst.MODE)
    public String mode(HttpSession session, Model model) {

        // モード変更のリクエストを作成
        ChangeSpeakModeDto changeSpeakModeDto = new ChangeSpeakModeDto();
        changeSpeakModeDto.setModeCode((String) session.getAttribute("speakModeCode"));

        // サービスの呼び出し
        String speakModeCode = speakingSnailService.changeSpeakMode(changeSpeakModeDto);

        // セッションにモード情報をセット
        this.setModeCodeToSession(speakModeCode, session, model);

        return "page/inout";
    }

    /**
     * セッションにおしゃべりモードのコード値をセットし、画面用にモード名称をモデルに格納する
     * 
     * @param speakModeCode
     */
    private void setModeCodeToSession(String speakModeCode, HttpSession session, Model model) {

        String displaySpeakMode = SpeakMode.getSpeakModeCodeMap().get(speakModeCode);
        session.setAttribute("speakModeCode", speakModeCode);
        model.addAttribute("speakModeCode", speakModeCode);
        model.addAttribute("displaySpeakMode", displaySpeakMode);
    }

}
