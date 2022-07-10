package com.example.speakingsnail.service;

import org.springframework.stereotype.Service;

import com.example.speakingsnail.dto.InputDto;
import com.example.speakingsnail.dto.OutputDto;

/**
 * しゃべるかたつむりサービスのインターフェース
 * 
 */
@Service
public interface SpeakingSnailService {

    /**
     * かたつむりに任意の内容をしゃべらせるメソッド
     * 入力された内容を吹き出し付きで返す
     * 
     * @param outputDto
     * @return
     */
    OutputDto callSnail(InputDto inputDto);

}
