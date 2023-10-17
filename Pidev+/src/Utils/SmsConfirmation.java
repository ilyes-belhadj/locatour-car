/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

/**
 *
 * @author Asus
 */
// Install the Java helper library from twilio.com/docs/java/install
// Install the Java helper library from twilio.com/docs/java/install

import com.twilio.Twilio;
import com.twilio.converter.Promoter;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import java.net.URI;
import java.math.BigDecimal;

public class SmsConfirmation {
    // Find your Account SID and Auth Token at twilio.com/console
    // and set the environment variables. See http://twil.io/secure
    public static final String ACCOUNT_SID = System.getenv("ACac548b2a9d57736718d5b9104f7a28aa");
    public static final String AUTH_TOKEN = System.getenv("647944132ebf60d0470b11dafb8c8d7c");

    public static void main(String[] args) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
                new com.twilio.type.PhoneNumber("+21696086210"),
                new com.twilio.type.PhoneNumber("+13155190263"),
                "Marhbe,votre reservation est confirmée") .create();

        System.out.println(message.getSid());
    }
}