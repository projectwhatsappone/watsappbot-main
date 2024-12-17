

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
public class CpnCalculator {
    String messageText;
    String sendNumber;

    
   
    private final InfoBipWhatsAppService whatsAppService = new InfoBipWhatsAppService();

    public void checkWeight(String messageText, String senderNumber) {


            String replyText = "CPN Weightage\r\n" + //
                                "SSC Percentage = 0.10\r\n" + //
                                "HSC Percentage = 0.30\r\n" + //
                                "Pre-Admission Test = 0.60\r\n" + //
                    "#️⃣Go back\r\n" +
                    "0️⃣ Main menu";
            String response = whatsAppService.sendWhatsAppReply(senderNumber, replyText);
            System.out.println("Response from Infobip: " + response);

       
         
    }
}


 

