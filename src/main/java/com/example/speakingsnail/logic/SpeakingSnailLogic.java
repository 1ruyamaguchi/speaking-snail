package com.example.speakingsnail.logic;

import org.springframework.stereotype.Component;

import com.example.speakingsnail.dto.InputDto;
import com.example.speakingsnail.dto.OutputDto;

/**
 * しゃべるかたつむりロジックのインターフェース
 * 
 */
@Component
public interface SpeakingSnailLogic {

    /**
     * かたつむりに任意の内容をしゃべらせるメソッド
     * 入力された内容を吹き出し付きで返す
     * 
     * @param outputDto
     * @return
     */
    OutputDto callSnail(InputDto inputDto);

    /**
     * 隠しコマンド（特定のワードを別ワードに置換）を処理するメソッド
     * 
     * @param speakContent
     * @return
     */
    String resolveHiddenCommand(String speakContent);

}
