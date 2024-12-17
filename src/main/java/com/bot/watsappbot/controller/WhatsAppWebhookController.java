package com.bot.watsappbot.controller;

import com.bot.watsappbot.NEW.Main;
import com.bot.watsappbot.NEW.SessionId;
import com.bot.watsappbot.SERVISEs.EntryP;
import com.bot.watsappbot.SERVISEs.MainService;
import com.bot.watsappbot.SERVISEs.SessionIdService;
import com.bot.watsappbot.dto.WhatsappInboundMessagePayload;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WhatsAppWebhookController {
    @Autowired
    private MainService mainService;

    @Autowired
    private SessionIdService sessionIdService;

    @Autowired
    private EntryP entryP;

    // @Autowired
    // private EntryP entryP;

    @GetMapping("/get")
    public List<Main> getAllMains() {
        return mainService.getAllMains();
    }


    @GetMapping("/getsession/{id}")
    public SessionId getSessionIdById(@PathVariable int id) {
        //return sessionIdService.getSessionIdById(id);
        SessionId sessionId=sessionIdService.getSessionIdById(id);
        return sessionId;
    }

    // @PostMapping("/webhook")
    // public void receiveMessage(@RequestBody WhatsappInboundMessagePayload
    // payload) {
    // System.out.println("Received raw payload: " + payload);

    // if (payload.getResults() != null && !payload.getResults().isEmpty()) {
    // for (WhatsappInboundMessagePayload.Result result : payload.getResults()) {
    // // Assuming we only care about the first content item for simplicity
    // if (result.getContent() != null && !result.getContent().isEmpty()) {
    // String messageText = result.getContent().get(0).getText();
    // System.out.println("Received message: " + messageText);

    // // Handle the message (e.g., respond to the "hello" message)
    // if ("hello".equalsIgnoreCase(messageText)) {
    // System.out.println("Responding to hello message...");
    // // Logic to send a response back if needed
    // }
    // } else {
    // System.out.println("No text message in the content.");
    // }
    // }
    // }
    // }
    
    

    @PostMapping("/webhook")
    public void receiveMessage(@RequestBody WhatsappInboundMessagePayload payload) {
        System.out.println("controller called.............");
        System.out.println("Received raw payload: " + payload);

        String jsonString = payload.toString();
        System.out.println("paylod:"+jsonString);

        if (payload.getResults() != null && !payload.getResults().isEmpty()) {
            for (WhatsappInboundMessagePayload.Result result : payload.getResults()) {
                // Assuming we only care about the first content item for simplicity
                if (result.getContent() != null && !result.getContent().isEmpty()) {
                    String messageText = result.getContent().get(0).getText();
                    String senderNumber = result.getSender(); // Get the sender's number
                    System.out.println("Received message: " + messageText);
                    System.out.println("sending number: " + senderNumber);
                    //System.out.println(result.getContact().get(0).getName());

                    // String name=payload.getResults().get(0).getContact().getName();
                    // System.out.println(name);
                    // Respond to the "hello" message
                    // Menu m=new Menu();
                    // m.MenuCall(messageText,senderNumber);
                    //EntryP entryP=new EntryP();
                    entryP.MenuCall(messageText, senderNumber);
                    
                }
                else {
                    System.out.println("No text message in the content.");
                }

            }
        }
    }

}
