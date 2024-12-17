package com.bot.watsappbot.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WhatsAppMessage {

    @JsonProperty("from")
    private String from;

    @JsonProperty("to")
    private String to;

    @JsonProperty("messageId")
    private String messageId;

    @JsonProperty("content")
    private Content content;

    // Getters and setters (if necessary)

    @Getter
    @Setter
    public static class Content {
        @JsonProperty("text")
        private String text;

        @JsonProperty("mediaUrl")
        private String mediaUrl;

    }
}
