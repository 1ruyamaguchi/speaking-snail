package com.example.speakingsnail.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.speakingsnail.dto.InputDto;
import com.example.speakingsnail.dto.OutputDto;
import com.example.speakingsnail.service.SpeakingSnailService;

/**
 * しゃべるかたつむりのコントローラー
 * 
 */
@Controller
@RequestMapping(value = "/speaking-snail")
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
    @RequestMapping(value = "/input")
    public String welcome() {

        return "page/inout";
    }

    /**
     * セリフ出力
     * 
     * @param inputDto
     * @param model
     * @return
     */
    @RequestMapping(value = "/output")
    public String output(InputDto inputDto, Model model) {

        // サービス呼び出し
        OutputDto outputDto = speakingSnailService.callSnail(inputDto);
        // 返却値をモデルに格納
        model.addAttribute("outputDto", outputDto);

        return "page/inout";
    }

}
