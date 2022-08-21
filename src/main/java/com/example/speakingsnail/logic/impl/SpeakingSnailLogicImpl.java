package com.example.speakingsnail.logic.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.speakingsnail.dto.InputDto;
import com.example.speakingsnail.dto.OutputDto;
import com.example.speakingsnail.enums.HiddenCommand;
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

        // 入力値の取り出し
        String speakSentence = inputDto.getSpeakContent();

        // 隠しコマンド処理
        speakSentence = this.resolveHiddenCommand(speakSentence);

        // 入力された文字を1文字ずつに分割
        String[] speakContents = speakSentence.split("");

        // 返却値を生成
        OutputDto outputDto = new OutputDto();
        // しゃべる内容（吹き出し付き）を格納する
        List<String> bubbleSpeakContent = new ArrayList<>();

        // 吹き出しの上側を生成
        bubbleSpeakContent.add(this.generateBubbleUpper());
        // 吹き出しのセリフ部分を生成
        String[] bubbleMiddle = this.generateBubbleMiddle(speakContents);
        for (int i = 1; i <= speakContents.length; i++) {
            bubbleSpeakContent.add(bubbleMiddle[i - 1]);
        }
        // 吹き出しの下側を生成
        bubbleSpeakContent.add(this.generateBubbleLower());

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

    /**
     * {@inheritDoc}
     * 
     */
    @Override
    public String resolveHiddenCommand(String speakContent) {

        // enumから隠しコマンドを全件取得
        HiddenCommand[] hiddenCommands = HiddenCommand.values();

        // 入力値に各コマンドが含まれていれば差し替える
        for (HiddenCommand hiddenCommand : hiddenCommands) {
            speakContent = speakContent.replace(hiddenCommand.getBefore(), hiddenCommand.getAfter());
        }

        return speakContent;
    }

}
