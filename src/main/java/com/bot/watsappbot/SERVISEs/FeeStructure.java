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
public class FeeStructure {
    String messageText;
    String sendNumber;

    
   
    private final InfoBipWhatsAppService whatsAppService = new InfoBipWhatsAppService();

    public void localFee(String messageText, String senderNumber) {


            String replyText = "Fee Details \nSemester Registration Fee\nPhD: 6000\nMS: 6000\nUG: 6000\nTuition Fee per Credit Hour\nPhD: 5000\nMS: 5000\nUG: 3700\nTransport/Fuel Charges (Optional)\nPhD: N/A\nMS: N/A\nUG: 7000\n"+
                    "#️⃣Go back\r\n" +
                    "0️⃣ Main menu";
            String response = whatsAppService.sendWhatsAppReply(senderNumber, replyText);
            System.out.println("Response from Infobip: " + response);

       
         
    }
}


 

