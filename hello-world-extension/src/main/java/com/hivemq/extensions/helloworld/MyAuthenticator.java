package com.hivemq.extensions.helloworld;

import java.nio.charset.Charset;

import com.hivemq.extension.sdk.api.auth.SimpleAuthenticator;
import com.hivemq.extension.sdk.api.auth.parameter.SimpleAuthInput;
import com.hivemq.extension.sdk.api.auth.parameter.SimpleAuthOutput;
import com.hivemq.extension.sdk.api.packets.connect.ConnectPacket;

public class MyAuthenticator implements SimpleAuthenticator {

   
    	@Override
        public void onConnect(SimpleAuthInput simpleAuthInput, SimpleAuthOutput simpleAuthOutput) {

            //get the contents of the MQTT connect packet from the input object
            ConnectPacket connect = simpleAuthInput.getConnectPacket();

            System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAA");
            System.out.println(connect.getUserName());
            System.out.println(connect.getPassword());
            //check if the client set username and password
            if (!connect.getUserName().isPresent() || !connect.getPassword().isPresent()) {
                simpleAuthOutput.failAuthentication();
            }

            //get username and password from the connect packet
            String username = connect.getUserName().get();
            String password = Charset.forName("UTF-8").decode(connect.getPassword().get()).toString();

            //check if the user is "admin" and the password is "hivemq"
            if (username.equals("admin") && password.equals("hivemq")) {
                simpleAuthOutput.authenticateSuccessfully();
            } else {
                simpleAuthOutput.failAuthentication();
            }
        }
    }

