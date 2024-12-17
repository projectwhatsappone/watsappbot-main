package com.bot.watsappbot.SERVISEs;

import com.bot.watsappbot.servise.InfoBipWhatsAppService;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LocationS {
    String messageText;
    String sendNumber;

    
    private final InfoBipWhatsAppService whatsAppService = new InfoBipWhatsAppService();
    

    public String locationCall(String messageText, String senderNumber) {

      
       
            String replyText = " 1️⃣ DUET JINNAH CAMPUS-karachi \r\n" +
                    "2️⃣ DUET Iqbal CAMPUS-karachi\r\n" +
                    "3️⃣ DUET (Gulberg Town)-karachi\r\n" +
                    "4️⃣ DUET (CEMET)-Sukhar\r\n" +
                    "0️⃣ Main menu";
         

            String response = whatsAppService.sendWhatsAppReply(senderNumber, replyText);
            System.out.println("Response from Infobip: " + response);
      
        return response;
    }
    public void locationMain(String messageText, String senderNumber){
        whatsAppService.sendLocation(senderNumber,24.8786,67.0477);
        String replyText ="0️⃣ Main menu";
         
        String response = whatsAppService.sendWhatsAppReply(senderNumber, replyText);
        System.out.println("Response from Infobip: " + response);
    }
    public void locationIqbal(String messageText, String senderNumber){
        whatsAppService.sendLocation(senderNumber,24.901207645148727, 67.08132124170734);
        String replyText ="0️⃣ Main menu";
         
        String response = whatsAppService.sendWhatsAppReply(senderNumber, replyText);
        System.out.println("Response from Infobip: " + response);
    }
    public void locationGulberg(String messageText, String senderNumber){
        whatsAppService.sendLocation(senderNumber,24.922628858223487, 67.071533333976);
        String replyText ="0️⃣ Main menu";
         
        String response = whatsAppService.sendWhatsAppReply(senderNumber, replyText);
        System.out.println("Response from Infobip: " + response);
    }
    public void locationCEMET(String messageText, String senderNumber){
        whatsAppService.sendLocation(senderNumber,27.693651946447314, 68.8550372693261);
        String replyText ="0️⃣ Main menu";
         
        String response = whatsAppService.sendWhatsAppReply(senderNumber, replyText);
        System.out.println("Response from Infobip: " + response);
    }
}
