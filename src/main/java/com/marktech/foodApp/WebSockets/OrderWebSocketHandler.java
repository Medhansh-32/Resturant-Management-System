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
;
        String orderJson = objectMapper.writeValueAsString(order);
        for (WebSocketSession session : sessions) {
            try {
                session.sendMessage(new TextMessage(orderJson));  // Send order details to the admin
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

