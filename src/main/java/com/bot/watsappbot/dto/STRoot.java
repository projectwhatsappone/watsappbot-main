package com.bot.watsappbot.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import ch.qos.logback.core.status.Status;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class STRoot{
    @JsonProperty("to") 
    public String myto;
    public int messageCount;
    public String messageId;
    public Status status;
}

