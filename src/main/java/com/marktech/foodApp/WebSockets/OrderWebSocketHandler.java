package com.marktech.foodApp.WebSockets;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.marktech.foodApp.model.CustomerOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderWebSocketHandler extends TextWebSocketHandler {

    @Autowired
    private ObjectMapper objectMapper;

    private final List<WebSocketSession> sessions = new ArrayList<>();

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        sessions.add(session);
    }

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        // Handle messages if needed (for example, receive commands from admin)
    }

    public void sendOrderUpdate(CustomerOrder order) throws IOException {
        String orderJson = objectMapper.writeValueAsString(order);

        // Iterate through all sessions
        for (WebSocketSession session : sessions) {
            try {
                // Check if the session is open before attempting to send the message
                if (session.isOpen()) {
                    session.sendMessage(new TextMessage(orderJson));  // Send order details to the admin
                } else {
                    // If the session is closed, remove it from the session list
                    sessions.remove(session);
                }
            } catch (IOException e) {
                e.printStackTrace();
                // Optionally remove the session if an error occurs
                sessions.remove(session);
            }
        }
    }

}

