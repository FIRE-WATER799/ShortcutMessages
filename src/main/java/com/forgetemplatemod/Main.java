package com.forgetemplatemod;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import com.forgetemplatemod.MyWebSocketServer;

@Mod(modid = "ShortcutMessages", version = "1.0")
public class Main {

    private static MyWebSocketServer webSocketServer;

    @Mod.EventHandler
    public void serverStarting(FMLServerStartingEvent event) {
        // Initialize and start the WebSocket server on a specific port
        webSocketServer = new MyWebSocketServer(65431);
        try {
            webSocketServer.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
