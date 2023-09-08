import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.WebSocketAdapter;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.websocket.server.WebSocketHandler;
import org.eclipse.jetty.websocket.servlet.WebSocketServletFactory;


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
