package com.example.speakingsnail.logic.impl;

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

        // 返却値を生成
        OutputDto outputDto = new OutputDto();
        // しゃべる内容（吹き出し付き）の宣言
        String bubbleSpeakContent = "";

        // 吹き出しの大きさを計算
        int bubbleSize = this.getBubbleSize(speakSentence);

        // 吹き出しの上側を生成
        bubbleSpeakContent = bubbleSpeakContent + this.generateBubbleUpper(bubbleSize);
        // 吹き出しのセリフ部分を生成
        bubbleSpeakContent = bubbleSpeakContent + "<br>" + this.generateBubbleMiddle(speakSentence);
        // 吹き出しの下側を生成
        bubbleSpeakContent = bubbleSpeakContent + "<br>" + this.generateBubbleLower(bubbleSize);

        outputDto.setBubbleSpeakContent(bubbleSpeakContent);

        return outputDto;
    }

    /**
     * 吹き出しの大きさを計算する
     * 
     * @param speakSentence
     * @return
     */
    private int getBubbleSize(String speakSentence) {

        String[] speakSentenceChar = speakSentence.split("");

        // 文字列のサイズ
        int contentSize = 0;

        // 1文字ごとに、全角ならサイズを2, 半角ならサイズを1として処理
        for (String nowChar : speakSentenceChar) {
            if (nowChar.getBytes().length > 1) {
                contentSize = contentSize + 2;
            } else {
                contentSize++;
            }
        }

        // 吹き出しのサイズ
        int bubbleSize = 0;

        // 文字列のサイズの半分を吹き出しのサイズとする 割り切れなければ切り上げ
        if (contentSize % 2 != 0) {
            bubbleSize = (contentSize + 1) / 2;
        } else {
            bubbleSize = contentSize / 2;
        }

        return bubbleSize;
    }

    /**
     * 吹き出しの上側を生成する
     * 
     * @param contentByte
     * @return
     */
    private String generateBubbleUpper(int bubbleSize) {

        String bubbleUpper = "＿人";

        for (int i = 0; i < bubbleSize; i++) {
            bubbleUpper = bubbleUpper + "人";
        }

        bubbleUpper = bubbleUpper + "人＿";

        return bubbleUpper;
    }

    /**
     * 吹き出しの下側を生成する
     * 
     * @param contentByte
     * @return
     */
    private String generateBubbleLower(int bubbleSize) {

        String bubbleLower = "￣";

        for (int i = 0; i < bubbleSize; i++) {
            bubbleLower = bubbleLower + "Y^";
        }

        bubbleLower = bubbleLower + "Y￣";

        return bubbleLower;
    }

    /**
     * 吹き出しのメッセージ部分を生成する
     * 
     * @return
     */
    private String generateBubbleMiddle(String speakSentence) {

        String bubbleMiddle = "＞　" + speakSentence + "　＜";

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
