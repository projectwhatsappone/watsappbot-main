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
public class Admission {
    String messageText;
    String sendNumber;

    
    private final InfoBipWhatsAppService whatsAppService = new InfoBipWhatsAppService();
    

    public void admissionCall(String messageText, String senderNumber) {

      
       
            String replyText = " 1️⃣ fee structure\r\n" +
                    "2️⃣ Cpn calculator\r\n" +
                    "3️⃣ Eligibility Criteria\r\n" +
                    "0️⃣ Main menu \r\n" +
                    "Cllick below link for Admission \r\n" +
                    "🕞 24 july 2024 is last date to submit Application\r\n" + //
                    "📎 https://admissions.duet.edu.pk";
         

            String response = whatsAppService.sendWhatsAppReply(senderNumber, replyText);
            System.out.println("Response from Infobip: " + response);
      
    
    }
}
