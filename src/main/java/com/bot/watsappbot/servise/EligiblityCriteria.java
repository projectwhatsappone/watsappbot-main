package com.bot.watsappbot.servise;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EligiblityCriteria {
    String messageText;
    String sendNumber;

    
    static boolean a=false;
    static boolean b=false;
    static boolean c=false;
    static boolean d=false;
    private final InfoBipWhatsAppService whatsAppService = new InfoBipWhatsAppService();

    public void eligibilityCriteria(String messageText, String senderNumber) {

        if ("1".equalsIgnoreCase(messageText)&&a==true) {

            String replyText = "1.      Intermediate / A-Level (IBCC equivalency required for merit calculation)/DAE with minimum 50% result (excluding grace marks) having group/major in:\r\n"
                    + //
                    "\r\n" + //
                    "i. Pre-Engineering\r\n" + //
                    "\r\n" + //
                    "ii.Pre-Medical with Addl. Maths(Group changed from Board)\r\n" + //
                    "\r\n" + //
                    "iii.*Pre-Medical (Apply only for BS Programs)\r\n" + //
                    "\r\n" + //
                    "iii. Computer Science\r\n" + //
                    "\r\n" + //
                    "2.The age of candidate shall be not more than 25 Years (For admission in BS) and 22 years (for admission in B Arch.) till last date of form submission for entry test.  \r\n"
                    + //
                    "\r\n" + //
                    "\r\n" + //
                    "*Candidates having Intermediate Pre-Medical shall required to clear Additional Mathematics courses of zero credit in 1st year\r\n"
                    +
                    "#️⃣Go back\r\n" +
                    "0️⃣ Main menu";
            String response = whatsAppService.sendWhatsAppReply(senderNumber, replyText);
            System.out.println("Response from Infobip: " + response);

        } else if ("#".equalsIgnoreCase(messageText)) {
            String replyText = " 1️⃣ B.S./ B.Arch. Programs\r\n" +
                    "2️⃣ B.E. Programs\r\n" +
                    "3️⃣ B.S. Industrial Management & Technology\r\n" +
                    "4️⃣BS Material Science\r\n" +
                    "#️⃣Go back\r\n" +
                    "0️⃣ Main menu";
            String response = whatsAppService.sendWhatsAppReply(senderNumber, replyText);
            System.out.println("Response from Infobip: " + response);
            a=true;
            b=true;
            c=true;
            d=true;
            
           
        } else {
            String replyText = " 1️⃣ B.S./ B.Arch. Programs\r\n" +
                    "2️⃣ B.E. Programs\r\n" +
                    "3️⃣ B.S. Industrial Management & Technology\r\n" +
                    "4️⃣BS Material Science\r\n" +
                    "#️⃣Go back\r\n" +
                    "0️⃣ Main menu";
            String response = whatsAppService.sendWhatsAppReply(senderNumber, replyText);
            System.out.println("Response from Infobip: " + response);
            a=true;
            b=true;
            c=true;
            d=true;
        }
    }
}
