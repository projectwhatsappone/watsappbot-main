package com.bot.watsappbot.servise;

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

    static boolean state = false;
    static boolean eligibilityC = false;
    private final InfoBipWhatsAppService whatsAppService = new InfoBipWhatsAppService();
    EligiblityCriteria eligiblityCriteria = new EligiblityCriteria();

    public void admissionCall(String messageText, String senderNumber) {

        if ("3".equalsIgnoreCase(messageText) && eligibilityC == true && state == true) {
            eligiblityCriteria.eligibilityCriteria(messageText, senderNumber);

        } else if ("1".equalsIgnoreCase(messageText) && eligibilityC == true && state == true) {
            eligiblityCriteria.eligibilityCriteria(messageText, senderNumber);

        } else if ("0".equalsIgnoreCase(messageText)) {
            eligibilityC = false;
            Menu menu = new Menu();
            menu.MenuCall(messageText, senderNumber);

        } else if ("#".equalsIgnoreCase(messageText) && eligibilityC == true && state == true) {
            state = false;
            eligiblityCriteria.eligibilityCriteria(messageText, senderNumber);

        } else if ("#".equalsIgnoreCase(messageText)) {
            String replyText = " 1️⃣ fee structure\r\n" +
                    "2️⃣ Cpn calculator\r\n" +
                    "3️⃣ Eligibility Criteria\r\n" +
                    "0️⃣ Main menu \r\n" +
                    "Cllick below link for Admission \r\n" +
                    "🕞 24 july 2024 is last date to submit Application\r\n" + //
                    "📎 https://admissions.duet.edu.pk";
            eligibilityC = true;
            state = true;

            String response = whatsAppService.sendWhatsAppReply(senderNumber, replyText);
            System.out.println("Response from Infobip: " + response);
        } else {

            String replyText = " 1️⃣ fee structure\r\n" +
                    "2️⃣ Cpn calculator\r\n" +
                    "3️⃣ Eligibility Criteria\r\n" +
                    "0️⃣ Main menu \r\n" +
                    "Cllick below link for Admission \r\n" +
                    "🕞 24 july 2024 is last date to submit Application\r\n" + //
                    "📎 https://admissions.duet.edu.pk";
            String response = whatsAppService.sendWhatsAppReply(senderNumber, replyText);
            System.out.println("Response from Infobip: " + response);
            eligibilityC = true;
            state = true;
        }
    }
}
