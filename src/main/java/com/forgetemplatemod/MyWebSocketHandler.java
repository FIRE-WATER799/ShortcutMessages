package com.forgetemplatemod;

import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.WebSocketAdapter;
import net.minecraft.client.Minecraft;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;

public class MyWebSocketHandler extends WebSocketAdapter {
    @Override
    public void onWebSocketConnect(Session sess) {
        ITextComponent connecting = new TextComponentString("Connecting");
        Minecraft.getMinecraft().ingameGUI.getChatGUI().printChatMessage(connecting);
        super.onWebSocketConnect(sess);
        ITextComponent connected = new TextComponentString("Connected");
        Minecraft.getMinecraft().ingameGUI.getChatGUI().printChatMessage(connected);
        // Handle authentication here if needed
    }

    @Override
    public void onWebSocketText(String message) {
        // Forward the message to Minecraft chat
        ITextComponent textComponent = new TextComponentString(message);
        Minecraft.getMinecraft().ingameGUI.getChatGUI().printChatMessage(textComponent);
    }
}
