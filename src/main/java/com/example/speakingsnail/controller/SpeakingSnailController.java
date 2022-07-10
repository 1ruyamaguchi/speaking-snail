package com.example.speakingsnail.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.speakingsnail.service.SpeakingSnailService;

/**
 * しゃべるかたつむりのコントローラー
 * 
 */
@Controller
public class SpeakingSnailController {

    @Autowired
    private SpeakingSnailService speakingSnailService;

}
