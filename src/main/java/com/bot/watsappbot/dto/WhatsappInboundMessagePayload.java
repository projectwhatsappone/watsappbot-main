package com.bot.watsappbot.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WhatsappInboundMessagePayload {

    private List<Result> results;

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    @Getter
    @Setter
    public static class Result {
        private String event;
        private String sender;
        private String destination;
        private String channel;
        private String receivedAt;
        private String messageId;
        private String pairedMessageId;
        private String callbackData;
        private List<Contact> contact;
        private List<Content> content;


        public List<Content> getContent() {
            return content;
        }

        public void setContent(List<Content> content) {
            this.content = content;
        }

        
        //new
        
        public List<Contact> getContact() {
            return contact;
        }

        public void setContact(List<Contact> contact) {
            this.contact = contact;
        }
    }

    @Getter
    @Setter
    public static class Contact{
        private String name;

        public String getName() {
            return name;
        }

        public void setNamee(String name) {
            this.name = name;
        }
    }

    @Getter
    @Setter
    public static class Content {
        private String type;
        private String text;
        private String cleanText;
        private String keyword;

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }
    }
}
