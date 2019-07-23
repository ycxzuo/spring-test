package com.yczuoxin.springboot.test13.websocket;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@ServerEndpoint("/chat-room/{username}")
public class ChatRoomServerEndpoint {

    private static Map<String,Session> livingSession = new ConcurrentHashMap<>();

    @OnOpen
    public void openSession(@PathParam("username") String username, Session session) {
        livingSession.put(session.getId(), session);
        sendTextAll("欢迎用户[" + username + "] 来到聊天室");
    }

    @OnMessage
    public void onMessage(@PathParam("username") String username, Session session, String message) {
        sendTextAll("用户[" + username + "]: " + message);
    }

    @OnClose
    public void closeSession(@PathParam("username") String username, Session session) {
        livingSession.remove(session.getId());
        sendTextAll("用户[" + username + "] 已经离开聊天室");
    }

    private void sendText(Session session, String message) {
        RemoteEndpoint.Basic basic = session.getBasicRemote();
        try {
            basic.sendText(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sendTextAll(String message) {
        livingSession.forEach(((s, session) -> sendText(session, message)));
    }
}
