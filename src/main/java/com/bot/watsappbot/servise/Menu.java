package com.bot.watsappbot.servise;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Menu {
    String messageText;
    String sendNumber;

    static int state = 0;
    static boolean session = false;
    static boolean Admissionsession = false;
    private final InfoBipWhatsAppService whatsAppService = new InfoBipWhatsAppService();
    Admission admission = new Admission();

    public void MenuCall(String messageText, String senderNumber) {

        if ("3".equalsIgnoreCase(messageText) && Admissionsession == true) {
           admission.admissionCall(messageText, senderNumber);
        } else if ("#".equalsIgnoreCase(messageText) && Admissionsession == true) {
            admission.admissionCall(messageText, senderNumber);
            
        } else if ("0".equalsIgnoreCase(messageText) && Admissionsession == true) {
            Admissionsession=false;
            admission.admissionCall(messageText, senderNumber);
            
            
        } else if ("1".equalsIgnoreCase(messageText) && Admissionsession == true) {
            
            session=true;
            admission.admissionCall(messageText, senderNumber);
        } else if("2".equalsIgnoreCase(messageText)){
            String replyDoc = "https://9fab-202-47-41-165.ngrok-free.app/doc/marks.pdf";
            String response = whatsAppService.sendWhatsappDocument(senderNumber,replyDoc);
            System.out.println("Response from Infobip: " + response);
            MenuCall("0", senderNumber);
        } else if("4".equalsIgnoreCase(messageText)){
            String replyButtonText = messageText;
            String response = whatsAppService.sendWhatButton(senderNumber,replyButtonText);
            System.out.println("Response from Infobip: " + response);
            //MenuCall("0", senderNumber);
        }
         else if("7".equalsIgnoreCase(messageText)){
            String replyimage = "https://9fab-202-47-41-165.ngrok-free.app/images/two.jpg";
            String response = whatsAppService.sendWhatsappImage(senderNumber,replyimage);
            System.out.println("Response from Infobip: " + response);
            MenuCall("0", senderNumber);
            
        }else if ("0".equalsIgnoreCase(messageText)) {

            String replyText = "Welcome to DUET chat bot\r\n" + //
                    "1️⃣ Admission 📝\r\n" +
                    "2️⃣ Results 🎖\r\n" +
                    "3️⃣ Academics 📕\r\n" +
                    "4️⃣ Portals 👥\r\n" +
                    "5️⃣ Updates 📢\r\n" +
                    "7️⃣ Transport🚌\r\n" +
                    "6️⃣ Contacts 📞";
            String response = whatsAppService.sendWhatsAppReply(senderNumber, replyText);
            System.out.println("Response from Infobip: " + response);
            state = 0;
            session = false;
            Admissionsession = true;

        } else {
            String replyText = "Welcome to DUET chat bot\r\n" + //
                    "1️⃣ Admission 📝\r\n" +
                    "2️⃣ Results 🎖\r\n" +
                    "3️⃣ Academics 📕\r\n" +
                    "4️⃣ Portals 👥\r\n" +
                    "5️⃣ Updates 📢\r\n" +
                    "7️⃣ Transport🚌\r\n" +
                    "6️⃣ Contacts 📞";
            String response = whatsAppService.sendWhatsAppReply(senderNumber, replyText);
            System.out.println("Response from Infobip: " + response);
            state = 0;
            session = false;
            Admissionsession = true;
        }
    }
}
