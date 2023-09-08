package com.forgetemplatemod;

import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.WebSocketAdapter;
import net.minecraft.client.Minecraft;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;

public class MyWebSocketHandler extends WebSocketAdapter {
    @Override
    public void onWebSocketConnect(Session sess) {
        ITextComponent textComponent = new TextComponentString("Connecting");
        Minecraft.getMinecraft().ingameGUI.getChatGUI().printChatMessage(textComponent);
        super.onWebSocketConnect(sess);
        ITextComponent textComponent = new TextComponentString("Connected");
        Minecraft.getMinecraft().ingameGUI.getChatGUI().printChatMessage(textComponent);
        // Handle authentication here if needed
    }

    @Override
    public void onWebSocketText(String message) {
        // Forward the message to Minecraft chat
        ITextComponent textComponent = new TextComponentString(message);
        Minecraft.getMinecraft().ingameGUI.getChatGUI().printChatMessage(textComponent);
    }
}
