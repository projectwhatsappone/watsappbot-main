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
public class Location {
    @JsonProperty("from")
    private String from;

    @JsonProperty("to")
    private String to;

    @JsonProperty("messageId")
    private String messageId;

    @JsonProperty("content")
    private Content content;

   
    public static class Content{
        @JsonProperty("latitude")
        public double latitude;
        @JsonProperty("longitude")
        public double longitude;


        public double getLatitude() {
            return latitude;
        }
    
        public void setLatitude(double latitude) {
            this.latitude = latitude;
        }
    
        public double getLongitude() {
            return longitude;
        }
    
        public void setLongitude(double longitude) {
            this.longitude = longitude;
        }
    }
}




