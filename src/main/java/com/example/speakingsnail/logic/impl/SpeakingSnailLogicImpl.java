package com.example.speakingsnail.logic.impl;

import org.springframework.stereotype.Component;

import com.example.speakingsnail.dto.InputDto;
import com.example.speakingsnail.dto.OutputDto;
import com.example.speakingsnail.logic.SpeakingSnailLogic;

/**
 * しゃべるかたつむりロジックの実装
 * 
 */
@Component
public class SpeakingSnailLogicImpl implements SpeakingSnailLogic {

    // TODO 一旦縦書きモードを作成したい

    /**
     * {@inheritDoc}
     * 
     */
    @Override
    public OutputDto callSnail(InputDto inputDto) {

        // 改行コード
        String br = System.getProperty("line.separator");
        // 入力された文字を改行ごとに分割
        String[] speakContents = inputDto.getSpeakContent().split(br);

        // 各行のバイト数を計算、最大値を取得
        int maxByte = this.getMaxByte(speakContents);

        // 返却値を生成
        OutputDto outputDto = new OutputDto();

        // 吹き出しの上側を生成
        outputDto.setBubbleUpper(this.generateBubbleUpper(maxByte));
        // 吹き出しの下側を生成
        outputDto.setBubbleLower(this.generateBubbleLower(maxByte));
        // しゃべる内容を吹き出し付きにする
        outputDto.setBubbleMiddle(this.generateBubbleMiddle(speakContents, maxByte));

        return outputDto;
    }

    /**
     * 吹き出しの上側を生成する
     * 
     * @param contentByte
     * @return
     */
    private String generateBubbleUpper(int contentByte) {

        String bubbleUpper = "_";

        while (bubbleUpper.getBytes().length <= contentByte) {
            bubbleUpper = bubbleUpper + "人";
        }

        bubbleUpper = bubbleUpper + "_";

        return bubbleUpper;
    }

    /**
     * 吹き出しの下側を生成する
     * 
     * @param contentByte
     * @return
     */
    private String generateBubbleLower(int contentByte) {

        String bubbleLower = "¯Y";

        while (bubbleLower.getBytes().length <= contentByte) {
            bubbleLower = bubbleLower + "^Y";
        }

        bubbleLower = bubbleLower + "¯";

        return bubbleLower;
    }

    /**
     * 吹き出しのメッセージ部分を生成する
     * 
     * @return
     */
    private String[] generateBubbleMiddle(String[] speakContents, int maxByte) {

        // メッセージの行数
        int lowNumber = speakContents.length;

        String[] bubbleMiddle = new String[lowNumber];

        // TODO 暫定対応 各行、> <の位置が揃うようにする必要がある。
        for (int i = 0; i < lowNumber; i++) {
            bubbleMiddle[i] = "> " + speakContents[i] + " <";
        }

        return bubbleMiddle;
    }

    /**
     * 各行のバイト数を計算し、最大値を返す
     * 
     * @param speakContents
     * @return
     */
    private int getMaxByte(String[] speakContents) {

        int maxByte = 0;

        for (int i = 0; i < speakContents.length; i++) {
            // i行目のバイト数
            int nowByte = speakContents[i].getBytes().length;
            if (maxByte < nowByte) {
                maxByte = nowByte;
            }
        }

        return maxByte;
    }

}
