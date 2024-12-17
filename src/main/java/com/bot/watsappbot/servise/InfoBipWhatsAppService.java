package com.bot.watsappbot.servise;

import com.bot.watsappbot.dto.IntractiveButton;
import com.bot.watsappbot.dto.Location;
import com.bot.watsappbot.dto.WhatsAppMessage;
import com.fasterxml.jackson.databind.ObjectMapper;


import okhttp3.*;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.stereotype.Service;


@Service
public class InfoBipWhatsAppService {

    private static final String API_URL = "https://d93e91.api.infobip.com/whatsapp/1/message/text";
    private static final String Image_API_URL = "https://d93e91.api.infobip.com/whatsapp/1/message/image";
    private static final String Doc_API_URL = "https://d93e91.api.infobip.com/1/message/document";
    private static final String Button_URL="https://d93e91.api.infobip.com/whatsapp/1/message/interactive/buttons";
    private static final String location_URL="https://d93e91.api.infobip.com/whatsapp/1/message/location";
    private static final String AUTHORIZATION = "App b1af1ec743ab891f5aed941ae562a8e9-ccafd53a-3c48-4656-8b17-bb0003698732";
    private static final String Message_id="a28dd97c-1ffb-4fcf-99f1-0b557ed381da";
    private static final String location_id="a28dd97c-1ffb-4fcf-99f1-0b557ed381da";
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public String sendWhatsAppReply(String sender, String replyText) {

        try {
            sendWhatsAppMessage("447860099299", sender, Message_id, replyText,null);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "successfully sended.........................";

    }

    public String sendWhatsappImage(String sender, String replyText) {

        try {
            sendImage("447860099299", sender, Message_id, null,replyText);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "successfully sended.........................";

    }

    public String sendWhatsappDocument(String sender, String document) {

        try {
            sendDoc("447860099299", sender, Message_id, null,document);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "successfully sended.........................";

    }
    public String sendLocation(String sender,double latitude,double longitude){
        try {
            sendLoc("447860099299", sender, location_id,latitude,longitude);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "successfully sended.........................";
    }

    public static void sendWhatsAppMessage(String from, String to, String messageId, String text,String mediaUrl) throws IOException {
        OkHttpClient client = new OkHttpClient();

        WhatsAppMessage.Content content = new WhatsAppMessage.Content();
        content.setText(text);
        content.setMediaUrl(mediaUrl);
        WhatsAppMessage message = new WhatsAppMessage(from, to, messageId,content);

        // Convert the object to JSO
        String jsonPayload = objectMapper.writeValueAsString(message);

        // Create request body
        RequestBody body = RequestBody.create(jsonPayload, MediaType.parse("application/json"));

        // Build the request
        Request request = new Request.Builder()
                .url(API_URL)
                .addHeader("Authorization", AUTHORIZATION)
                .addHeader("Content-Type", "application/json")
                .addHeader("Accept", "application/json")
                .post(body)
                .build();

        // Execute the request
        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }

            // Print the response
            System.out.println("Response: " + response.body().string());
        }
    }

    public static void sendDoc(String from, String to, String messageId,String text, String mediaUrl) throws IOException {
        OkHttpClient client = new OkHttpClient();

        // Create the WhatsAppMessage object
        WhatsAppMessage.Content content = new WhatsAppMessage.Content();
        content.setText(null);
        content.setMediaUrl(mediaUrl);
        WhatsAppMessage message = new WhatsAppMessage(from, to, messageId,content);

        // Convert the object to JSON
        String jsonPayload = objectMapper.writeValueAsString(message);
        System.out.println(jsonPayload.toString());
        // Create request body
        RequestBody body = RequestBody.create(jsonPayload, MediaType.parse("application/json"));
        System.out.println(body.toString());

        // Build the request
        Request request = new Request.Builder()
                .url(Doc_API_URL)
                .addHeader("Authorization", AUTHORIZATION)
                .addHeader("Content-Type", "application/json")
                .addHeader("Accept", "application/json")
                .post(body)
                .build();

        // Execute the request
        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }

            // Print the response
            System.out.println("Response: " + response.body().string());
        }
    }

    public static void sendImage(String from, String to, String messageId,String text, String mediaUrl) throws IOException {
        OkHttpClient client = new OkHttpClient();

        // Create the WhatsAppMessage object
        WhatsAppMessage.Content content = new WhatsAppMessage.Content();
        content.setText(null);
        content.setMediaUrl(mediaUrl);
        WhatsAppMessage message = new WhatsAppMessage(from, to, messageId,content);

        // Convert the object to JSON
        String jsonPayload = objectMapper.writeValueAsString(message);
        System.out.println(jsonPayload.toString());
        // Create request body
        RequestBody body = RequestBody.create(jsonPayload, MediaType.parse("application/json"));
        System.out.println(body.toString());

        // Build the request
        Request request = new Request.Builder()
                .url(Image_API_URL)
                .addHeader("Authorization", AUTHORIZATION)
                .addHeader("Content-Type", "application/json")
                .addHeader("Accept", "application/json")
                .post(body)
                .build();

        // Execute the request
        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }

            // Print the response
            System.out.println("Response: " + response.body().string());
        }
    }

    public String sendWhatButton(String senderNumber, String replyButtonText)  {
        try {
            sendWhatsAooButton("447860099299", senderNumber, Message_id);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "successfully sended.........................";
    }

    private void sendWhatsAooButton(String from, String to, String messageId) throws IOException {
                OkHttpClient client = new OkHttpClient();

                // Create the WhatsAppMessage object
                

                IntractiveButton message=new IntractiveButton();
                message.setFrom(from);
                message.setTo(to);
                IntractiveButton.Body body=message.new Body("DUET PORTALS");
                IntractiveButton.Footer footer=message.new Footer("given Bellow");
                IntractiveButton.Button b1=message.new Button("REPLY", "1","ADMIN");
                IntractiveButton.Button b2=message.new Button("REPLY", "2","STUDENT");

                IntractiveButton.Action action=message.new Action();
                action.buttons=new ArrayList<>();
                action.buttons.add(b1);
                action.buttons.add(b2);

                ArrayList<IntractiveButton.Button> buArrayList=new ArrayList<>();
                buArrayList.add(b1);
                buArrayList.add(b2);
                IntractiveButton.Content content = new IntractiveButton.Content();
                content.setAction(action);
                content.setBody(body);
                content.setFooter(footer);

                message.setContent(content);
                message.setMessageId(messageId);
                
                
                
        
                // Convert the object to JSON
                String jsonPayload = objectMapper.writeValueAsString(message);
                System.out.println(jsonPayload.toString());
                // Create request body
                RequestBody body2 = RequestBody.create(jsonPayload, MediaType.parse("application/json"));
                System.out.println(body2.toString());
        
                // Build the request
                Request request = new Request.Builder()
                        .url(Button_URL)
                        .addHeader("Authorization", AUTHORIZATION)
                        .addHeader("Content-Type", "application/json")
                        .addHeader("Accept", "application/json")
                        .post(body2)
                        .build();
        
                // Execute the request
                try (Response response = client.newCall(request).execute()) {
                    if (!response.isSuccessful()) {
                        throw new IOException("Unexpected code " + response);
                    }
        
                    // Print the response
                    System.out.println("Response: " + response.body().string());
                }
    }

    public void sendLoc(String from,String sender,String location_id,double latitude,double longitude)throws IOException{
        OkHttpClient client = new OkHttpClient();

        // Create the Location object
        //WhatsAppMessage.Content content = new WhatsAppMessage.Content();
        Location.Content content=new Location.Content();
        content.setLatitude(latitude);
        content.setLongitude(longitude);
        Location message = new Location(from, sender, location_id, content);

        // Convert the object to JSON
        String jsonPayload = objectMapper.writeValueAsString(message);
        System.out.println(jsonPayload.toString());
        // Create request body
        RequestBody body = RequestBody.create(jsonPayload, MediaType.parse("application/json"));
        System.out.println(body.toString());

        // Build the request
        Request request = new Request.Builder()
                .url(location_URL)
                .addHeader("Authorization", AUTHORIZATION)
                .addHeader("Content-Type", "application/json")
                .addHeader("Accept", "application/json")
                .post(body)
                .build();

        // Execute the request
        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }

            // Print the response
            System.out.println("Response: " + response.body().string());
        }
    }

}
