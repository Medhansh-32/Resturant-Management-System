package com.marktech.foodApp.WebSockets;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.marktech.foodApp.model.CustomerOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger log = LoggerFactory.getLogger(OrderWebSocketHandler.class);
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
        log.info(orderJson);
        for (WebSocketSession session : sessions) {
            try {

                if (session.isOpen()) {
                    session.sendMessage(new TextMessage(orderJson));  
                } else {

                    sessions.remove(session);
                }
            } catch (IOException e) {
                e.printStackTrace();
                sessions.remove(session);
            }
        }
    }

}

