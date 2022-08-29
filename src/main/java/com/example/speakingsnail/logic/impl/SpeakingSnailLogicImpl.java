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

        int bubbleSize = speakSentence.length();

        // 吹き出しの上側を生成
        String bubbleSpeakUpper = this.generateBubbleUpper(bubbleSize);
        // 吹き出しのセリフ部分を生成
        String bubbleSpeakSentence = this.generateBubbleMiddle(speakSentence);
        // 吹き出しの下側を生成
        String bubbleSpeakLower = this.generateBubbleLower(bubbleSize);

        // 返却値を生成
        OutputDto outputDto = new OutputDto();
        outputDto.setBubbleSpeakUpper(bubbleSpeakUpper);
        outputDto.setBubbleSpeakSentence(bubbleSpeakSentence);
        outputDto.setBubbleSpeakLower(bubbleSpeakLower);

        return outputDto;
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
     * 吹き出しの下側を生成する アプリ側で生成する文字列は上側と同じ 画面側で反転して制御する
     * 
     * @param contentByte
     * @return
     */
    private String generateBubbleLower(int bubbleSize) {

        String bubbleLower = "＿人";

        for (int i = 0; i < bubbleSize; i++) {
            bubbleLower = bubbleLower + "人";
        }

        bubbleLower = bubbleLower + "人＿";

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
