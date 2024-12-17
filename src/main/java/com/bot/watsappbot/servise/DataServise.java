package com.bot.watsappbot.servise;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bot.watsappbot.NEW.Data;
import com.bot.watsappbot.repo.DataRepository;

@Service
public class DataServise {
    
    @Autowired
    private DataRepository dataRepository;

    public String getContentByPreviousIDAndUserText(String previusID, String userText) {
        Optional<Data> data = dataRepository.findByPreviusIDAndUserText(previusID, userText);
        if (data.isPresent()) {
            return data.get().getCONTENT();
        } else {
            throw new IllegalArgumentException("No content found for previusID: " + previusID + " and userText: " + userText);
        }
    }

    public String getCurrentIDByPreviousIDAndUserText(String previusID, String userText) {
        Optional<Data> data = dataRepository.findCurrentByPreviusIDAndUserText(previusID, userText);
        if (data.isPresent()) {
            return data.get().getCurrentID();
        } else {
            throw new IllegalArgumentException("No CurrentID found for previusID: " + previusID + " and userText: " + userText);
        }
    }
  
}
