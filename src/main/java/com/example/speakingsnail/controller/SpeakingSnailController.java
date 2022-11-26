package com.example.speakingsnail.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.speakingsnail.constants.UrlConst;
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
     * 入力画面
     * 
     * @return
     */
    @RequestMapping(value = UrlConst.INPUT)
    public String welcome(HttpSession session) {

        // 初期はおしゃべりモード: 通常
        session.setAttribute("speakMode", SpeakMode.NORMAL.getModeCode());

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

        return "page/inout";
    }

}
