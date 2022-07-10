package com.example.speakingsnail.logic.impl;

import org.springframework.stereotype.Component;

import com.example.speakingsnail.dto.InputDto;
import com.example.speakingsnail.dto.OutputDto;
import com.example.speakingsnail.logic.SpeakingSnailLogic;

/**
 * しゃべるかたつむりロジックの実装 縦書きで吹き出し付きのセリフを返す
 * 
 */
@Component
public class SpeakingSnailLogicImpl implements SpeakingSnailLogic {

    /**
     * {@inheritDoc}
     * 
     */
    @Override
    public OutputDto callSnail(InputDto inputDto) {

        // 入力された文字を1文字ずつに分割
        String[] speakContents = inputDto.getSpeakContent().split("");

        // 返却値を生成
        OutputDto outputDto = new OutputDto();
        // しゃべる内容（吹き出し付き）を格納する
        String[] bubbleSpeakContent = new String[speakContents.length + 2];

        // 吹き出しの上側を生成
        bubbleSpeakContent[0] = this.generateBubbleUpper();
        // 吹き出しのセリフ部分を生成
        String[] bubbleMiddle = this.generateBubbleMiddle(speakContents);
        for (int i = 1; i <= speakContents.length; i++) {
            bubbleSpeakContent[i] = bubbleMiddle[i - 1];
        }
        // 吹き出しの下側を生成
        bubbleSpeakContent[bubbleSpeakContent.length - 1] = this.generateBubbleLower();

        outputDto.setBubbleSpeakContent(bubbleSpeakContent);

        return outputDto;
    }

    /**
     * 吹き出しの上側を生成する
     * 
     * @param contentByte
     * @return
     */
    private String generateBubbleUpper() {

        String bubbleUpper = "_人人_";

        return bubbleUpper;
    }

    /**
     * 吹き出しの下側を生成する
     * 
     * @param contentByte
     * @return
     */
    private String generateBubbleLower() {

        String bubbleLower = "¯Y^Y¯";

        return bubbleLower;
    }

    /**
     * 吹き出しのメッセージ部分を生成する
     * 
     * @return
     */
    private String[] generateBubbleMiddle(String[] speakContents) {

        // メッセージの行数
        int lowNumber = speakContents.length;

        String[] bubbleMiddle = new String[lowNumber];

        for (int i = 0; i < lowNumber; i++) {
            bubbleMiddle[i] = "> " + speakContents[i] + " <";
        }

        return bubbleMiddle;
    }

}
