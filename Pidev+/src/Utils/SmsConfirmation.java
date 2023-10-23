/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import com.twilio.Twilio;
import com.twilio.converter.Promoter;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import java.net.URI;
import java.math.BigDecimal;
/**
 *
 * @author Asus
 */
// Install the Java helper library from twilio.com/docs/java/install
// Install the Java helper library from twilio.com/docs/java/install


public class SmsConfirmation {

	  public static final String ACCOUNT_SID = "ACa1450d196ca7a183daef209a51870ea5";
    public static final String AUTH_TOKEN = "f49158cdde421945e4a563b00324319b";

    public static void main(String[] args) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        com.twilio.rest.api.v2010.account.Message message = com.twilio.rest.api.v2010.account.Message.creator(
                new com.twilio.type.PhoneNumber("+21696086210"),
                new com.twilio.type.PhoneNumber("++12295958975"),
                "mrhbe,votre reservation est confirmée") .create();
        
        System.out.println(message.getSid());
    }
}

