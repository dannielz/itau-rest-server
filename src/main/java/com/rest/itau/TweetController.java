package com.rest.itau;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tweet")
public class TweetController {

    @Autowired
    TweetRepository tweetRepository;
    @GetMapping("/perhour")
    public List<?> getTweetPerHour(){
    	return tweetRepository.findTweetCountPerHour();
    }
    @GetMapping("/hashtag/lang")
    public List<?> getTweetByHashtagByLang(){
    	return tweetRepository.findTweetCountByHashtagByLang();
    }

}