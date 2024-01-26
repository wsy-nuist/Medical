package com.nuist.medical.Compoenent;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.PathParam;
import jakarta.websocket.server.ServerEndpoint;
import java.util.concurrent.ConcurrentHashMap;

@ServerEndpoint("/process/{id}")
public class WebSocket {
    private Session session;

    private String id;

    private ConcurrentHashMap<String, Object> pool=new ConcurrentHashMap<>();

    @OnOpen
    public void onOpen(Session session, @PathParam("id") String id){
        if(!pool.containsKey(id)){
            pool.put(id,session);
            this.id=id;
            this.session=session;
        }
        System.out.println(id+"打开了连接");
    }
    @OnMessage
    public void receiveMessage(String message){
        System.out.println(message);
    }


}
