package com.bot.watsappbot.dto;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class IntractiveButton {

    @JsonProperty("from")
    public String from;
    @JsonProperty("to")
    public String to;
    @JsonProperty("messageId")
    public String messageId;
    @JsonProperty("content")
    public Content content;

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public class Action {
        @JsonProperty("buttons")
        public ArrayList<Button> buttons;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public class Body {
        @JsonProperty("text")
        public String text;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public class Button {
        @JsonProperty("type")
        public String type;
        @JsonProperty("id")
        public String id;
        @JsonProperty("title")
        public String title;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Content {
        @JsonProperty("body")
        public Body body;
        @JsonProperty("action")
        public Action action;
        @JsonProperty("footer")
        public Footer footer;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public class Footer {
        @JsonProperty("text")
        public String text;
    }

}
