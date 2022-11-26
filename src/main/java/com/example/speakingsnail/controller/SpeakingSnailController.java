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
        session.setAttribute("speakMode", SpeakMode.NORMAL.getModeCode());
        model.addAttribute("speakMode", session.getAttribute("speakMode"));

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
        inputDto.setSpeakMode((String) session.getAttribute("speakMode"));
        // サービス呼び出し
        OutputDto outputDto = speakingSnailService.callSnail(inputDto);
        // 返却値をモデルに格納
        model.addAttribute("outputDto", outputDto);
        model.addAttribute("speakMode", session.getAttribute("speakMode"));

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
        changeSpeakModeDto.setModeCode((String) session.getAttribute("speakMode"));

        // サービス呼び出し
        String speakMode = speakingSnailService.changeSpeakMode(changeSpeakModeDto);

        session.setAttribute("speakMode", speakMode);
        model.addAttribute("speakMode", speakMode);
        return "page/inout";
    }

}
