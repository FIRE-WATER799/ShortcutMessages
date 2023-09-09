package com.forgetemplatemod;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.websocket.server.WebSocketHandler;
import org.eclipse.jetty.websocket.servlet.WebSocketServletFactory;
import org.eclipse.jetty.server.ServerConnector;
import com.forgetemplatemod.MyWebSocketHandler;

public class MyWebSocketServer {
    private Server server;

    public MyWebSocketServer(int port) {
        server = new Server();

        ServerConnector connector = new ServerConnector(server);
        connector.setHost("0.0.0.0");
        connector.setPort(port);
        server.addConnector(connector);
        
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
