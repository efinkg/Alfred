package com.efinkg.alfred;

import org.jivesoftware.smack.Chat;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.MessageListener;

public class Sender 
{

    public static void main(String a[]) throws XMPPException, InterruptedException
    {
         XMPPConnection connection = new XMPPConnection("jabber.iitsp.com");  
         System.out.println(connection);
         connection.connect();
         connection.login("efinkg@jabber.iitsp.com", "Ethan1");



         Chat chat = connection.getChatManager().createChat("coffeemaker@jabber.iitsp.com", new MessageListener() {

             public void processMessage(Chat chat, Message message) {
                 // Print out any messages we get back to standard out.
                 System.out.println("Received message: " + message);
             }
         });
         chat.sendMessage("Howdy test1!");

         while (true) {
        Thread.sleep(50);
    }
    }
}
