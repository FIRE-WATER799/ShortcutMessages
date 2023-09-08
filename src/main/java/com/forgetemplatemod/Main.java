package com.forgetemplatemod;


import com.forgetemplatemod.websocket.SocketServer;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

@Mod(modid = "ShortcutMessages", version = "1.0")
public class ShortcutMessages {

    private static MySocketServer SocketServer;

    @Mod.EventHandler
    public void serverStarting(FMLServerStartingEvent event) {
        // Initialize and start the WebSocket server on a specific port
        webSocketServer = new MySocketServer(8080);
        try {
            webSocketServer.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
