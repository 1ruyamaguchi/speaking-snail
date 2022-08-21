package com.example.speakingsnail.logic;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.speakingsnail.dto.InputDto;
import com.example.speakingsnail.dto.OutputDto;

/**
 * SpeakingSnailLogicImplのテストクラス
 * 
 */
@SpringBootTest
public class SpeakingSnailLogicImplTest {

    @Autowired
    private SpeakingSnailLogic speakingSnailLogic;

    /**
     * callSnailのテスト 正常系
     * 
     */
    @Test
    public void testCallSnail() {

        InputDto inputDto = new InputDto();
        inputDto.setSpeakContent("ジャスティス");

        OutputDto result = new OutputDto();

        try {
            result = speakingSnailLogic.callSnail(inputDto);
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }

        assertEquals(result.getBubbleSpeakContent().get(0), "_人人_");
        assertEquals(result.getBubbleSpeakContent().get(1), "> ジ <");
        assertEquals(result.getBubbleSpeakContent().get(2), "> ャ <");
        assertEquals(result.getBubbleSpeakContent().get(3), "> ス <");
        assertEquals(result.getBubbleSpeakContent().get(4), "> テ <");
        assertEquals(result.getBubbleSpeakContent().get(5), "> ィ <");
        assertEquals(result.getBubbleSpeakContent().get(6), "> ス <");
        assertEquals(result.getBubbleSpeakContent().get(7), "¯Y^Y¯");
    }

    /**
     * resolveHiddenCommandのテスト enumの隠しコマンドによる置換ができていること
     * 
     */
    @Test
    public void testCallSnail_hiddenCommand() {

        String speakContent = "浜辺美波は可愛い";
        String result = "";

        try {
            result = speakingSnailLogic.resolveHiddenCommand(speakContent);
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }

        assertEquals(result, "うちの奥さんは可愛い");
    }

}
