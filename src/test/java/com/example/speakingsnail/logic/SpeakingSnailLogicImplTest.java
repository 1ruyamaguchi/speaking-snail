package com.example.speakingsnail.logic;

import static org.junit.jupiter.api.Assertions.assertNotNull;
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

        OutputDto outputDto = new OutputDto();

        try {
            outputDto = speakingSnailLogic.callSnail(inputDto);
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }

        assertNotNull(outputDto);
    }

}
