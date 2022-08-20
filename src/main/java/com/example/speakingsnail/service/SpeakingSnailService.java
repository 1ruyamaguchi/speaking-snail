package com.example.speakingsnail.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.speakingsnail.dto.InputDto;
import com.example.speakingsnail.dto.OutputDto;

/**
 * しゃべるかたつむりサービスのインターフェース
 * 
 */
@Service
@RestController
@RequestMapping(value = "/v1/api/snail")
public interface SpeakingSnailService {

    /**
     * かたつむりに任意の内容をしゃべらせるメソッド
     * 入力された内容を吹き出し付きで返す
     * 
     * @param outputDto
     * @return
     */
    @GetMapping(value = "/call")
    OutputDto callSnail(InputDto inputDto);

}
