package com.example.speakingsnail.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.any;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.speakingsnail.dto.InputDto;
import com.example.speakingsnail.dto.OutputDto;
import com.example.speakingsnail.logic.SpeakingSnailLogic;

/**
 * SpeakingSnailServiceImplのテスト
 * 
 */
@SpringBootTest
public class SpeakingSnailServiceImplTest {

    @Autowired
    private SpeakingSnailService speakingSnailService;

    @MockBean
    private SpeakingSnailLogic speakingSnailLogic;

    /**
     * callSnailのテスト 正常系
     * 
     */
    @Test
    public void testCallSnail() {

        // 返却値の設定
        OutputDto outputDto = new OutputDto();
        outputDto.setBubbleSpeakUpper("＿人人人人人＿");
        outputDto.setBubbleSpeakSentence("＞　テスト　＜");
        outputDto.setBubbleSpeakLower("＿人人人人人＿");

        // 入力値の設定
        InputDto inputDto = new InputDto();
        inputDto.setSpeakContent("test");

        Mockito.when(speakingSnailLogic.callSnail(any())).thenReturn(outputDto);

        // 結果
        OutputDto result = new OutputDto();

        try {
            result = speakingSnailService.callSnail(inputDto);
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }

        assertEquals("＿人人人人人＿", result.getBubbleSpeakUpper());
        assertEquals("＞　テスト　＜", result.getBubbleSpeakSentence());
        assertEquals("＿人人人人人＿", result.getBubbleSpeakLower());
    }

    /**
     * callSnailのテスト inputが空だった場合に入力値に適切な文字列が入ること
     * 
     */
    @Test
    public void testCallSnail_empty_input() {

        // 返却値の設定
        OutputDto outputDto = new OutputDto();

        // 入力値の設定
        InputDto inputDto = new InputDto();
        inputDto.setSpeakContent("");

        Mockito.when(speakingSnailLogic.callSnail(any())).thenReturn(outputDto);

        try {
            speakingSnailService.callSnail(inputDto);
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }

        assertEquals(inputDto.getSpeakContent(), "なんか書いてよ！");
    }

}
