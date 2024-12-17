package com.bot.watsappbot.SERVISEs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bot.watsappbot.servise.DataServise;
import com.bot.watsappbot.servise.InfoBipWhatsAppService;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class EntryP {
    String messageText;
    String sendNumber;

    @Autowired
    private SessionIdService sessionIdService;
    @Autowired
    private DataServise dataServise;

    String response;
    private final InfoBipWhatsAppService whatsAppService = new InfoBipWhatsAppService();
    Admission admission = new Admission();
    FeeStructure feeStructure = new FeeStructure();
    CpnCalculator cpncalculator = new CpnCalculator();
    EligiblityCriteria eligiblityCriteria = new EligiblityCriteria();
    LocationS locationS=new LocationS();

    public void MenuCall(String messageText, String senderNumber) {
        String sessionId = sessionIdService.getSessionIdBySender(senderNumber);
        if (messageText.equals("0")||messageText.equals("1") ||messageText.equals("2") ||messageText.equals("3") || 
            messageText.equals("4") ||messageText.equals("5") ||messageText.equals("6") ||messageText.equals("7") ||messageText.equals("8") ||messageText.equals("9") ||
            "HY".equalsIgnoreCase(messageText)) {
            
            if (messageText.equals("0") || "HY".equalsIgnoreCase(messageText)) {
                sessionId=sessionIdService.updateSessionIdBySender(senderNumber, "home");
            };
            String replyText=dataServise.getContentByPreviousIDAndUserText(sessionId,messageText);

            if(replyText.equals("main-location")){
                locationS.locationMain(messageText, senderNumber);
            }else if(replyText.equals("iqbal-location")){
                locationS.locationIqbal(messageText, senderNumber);
            }else if(replyText.equals("gulberg-location")){
                locationS.locationGulberg(messageText, senderNumber);
            }else if(replyText.equals("cemet-location")){
                locationS.locationCEMET(messageText, senderNumber);
            }else if(replyText.equals("transport")){
                String replyimage = "https://e896-202-47-41-165.ngrok-free.app/images/two.jpg";
            String response = whatsAppService.sendWhatsappImage(senderNumber, replyimage);
            System.out.println("Response from Infobip: " + response);
            MenuCall("0", senderNumber);
            }else{

            String response = whatsAppService.sendWhatsAppReply(senderNumber, replyText);
            String newSessionId=dataServise.getCurrentIDByPreviousIDAndUserText(sessionId, messageText);
            sessionId = sessionIdService.updateSessionIdBySender(senderNumber, newSessionId);
            System.out.println("Response from Infobip: " + response);
            }
        } else if(messageText.equals("nunu")){
            whatsAppService.sendWhatsAppReply(senderNumber, "chutiya detencted");
                
        }  else if(messageText.equals("saman")){
            whatsAppService.sendWhatsAppReply(senderNumber, "dawood ka chodu");
                
        } 
        else {
            String replyText = "Invalid response \ntype 'hy' to start";
            String response = whatsAppService.sendWhatsAppReply(senderNumber, replyText);
            System.out.println("Response from Infobip: " + response);
        }

    }
}
