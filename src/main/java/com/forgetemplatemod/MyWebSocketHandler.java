package com.forgetemplatemod;

import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.WebSocketAdapter;
import net.minecraft.client.Minecraft;

public class MyWebSocketHandler extends WebSocketAdapter {
    @Override
    public void onWebSocketConnect(Session sess) {
        super.onWebSocketConnect(sess);
        // Handle authentication here if needed
    }

    @Override
    public void onWebSocketText(String message) {
        // Forward the message to Minecraft chat
        Minecraft.getMinecraft().ingameGUI.getChatGUI().printChatMessage(message);
    }
}
