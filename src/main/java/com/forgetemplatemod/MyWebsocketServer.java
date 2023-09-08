package com.forgetemplatemod;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.websocket.server.WebSocketHandler;
import org.eclipse.jetty.websocket.servlet.WebSocketServletFactory;
import com.forgetemplatemod.MyWebsocketHandler;

public class MyWebSocketServer {
    private Server server;

    public MyWebSocketServer(int port) {
        server = new Server(port);
        
        WebSocketHandler wsHandler = new WebSocketHandler() {
            @Override
            public void configure(WebSocketServletFactory factory) {
                factory.register(MyWebSocketHandler.class);
            }
        };

        server.setHandler(wsHandler);
    }

    public void start() throws Exception {
        server.start();
        server.join();
    }
}
