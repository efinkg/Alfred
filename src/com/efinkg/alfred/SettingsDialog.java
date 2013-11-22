package com.efinkg.alfred;
 
import android.app.Dialog;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.Presence;
 
/**
 * Gather the xmpp settings and create an XMPPConnection
 */
public class SettingsDialog extends Dialog{
    private XMPPClient xmppClient;
 
    public SettingsDialog(XMPPClient xmppClient) {
        super(xmppClient);
        this.xmppClient = xmppClient;
    }
 
    public void XMPPClient() {
        String host = "jabber.iitsp.com";
        String port = "5222";
        String service = "jabber.iitsp.com";
        String username = "efinkg@jabber.iitsp.com";
        String password = "Ethan1";
 
        // Create a connection
        ConnectionConfiguration connConfig =
                new ConnectionConfiguration(host, Integer.parseInt(port), service);
        XMPPConnection connection = new XMPPConnection(connConfig);
 
        try {
            connection.connect();
            System.out.print("XMPPClient Connected to " + connection.getHost());
            Log.i("XMPPClient", "[SettingsDialog] Connected to " + connection.getHost());
        } catch (XMPPException ex) {
        	System.out.print("Failed to connect to " + connection.getHost());
            Log.e("XMPPClient", "[SettingsDialog] Failed to connect to " + connection.getHost());
            xmppClient.setConnection(null);
        }
        try {
            connection.login(username, password);
            Log.i("XMPPClient", "Logged in as " + connection.getUser());
 
            // Set the status to available
            Presence presence = new Presence(Presence.Type.available);
            connection.sendPacket(presence);
            xmppClient.setConnection(connection);
        } catch (XMPPException ex) {
            Log.e("XMPPClient", "[SettingsDialog] Failed to log in as " + username);
            xmppClient.setConnection(null);
        }
        dismiss();
    }
 
    private String getText(int id) {
        EditText widget = (EditText) this.findViewById(id);
        return widget.getText().toString();
    }
}