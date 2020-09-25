package org.yasking.easycrud.data.websocket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

/*
    WebSocket服务
    代码参考：https://juejin.im/post/6844903849233235981
    启动后可以使用在线工具进行发消息测试：http://coolaf.com/tool/chattest
    地址填写：ws://127.0.0.1:8080/websocket
 */

@ServerEndpoint(value = "/websocket") //接受websocket请求路径
@Component  //注册到spring容器中
public class WebSocketServer {
    //保存所有在线socket连接
    private static Map<String,WebSocketServer> webSocketMap = new LinkedHashMap<>();

    //记录当前在线数目
    private static int count=0;

    //当前连接（每个websocket连入都会创建一个MyWebSocket实例
    private Session session;

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    //处理连接建立
    @OnOpen
    public void onOpen(Session session){
        this.session=session;
        webSocketMap.put(session.getId(),this);
        addCount();
        log.info("新的连接加入：{} ",session.getId());
    }

    //接受消息
    @OnMessage
    public void onMessage(String message,Session session){
        log.info("收到客户端{}消息：{}",session.getId(),message);
        try{
            this.sendMessage("收到消息："+message);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //处理错误
    @OnError
    public void onError(Throwable error,Session session){
        log.info("发生错误{},{}",session.getId(),error.getMessage());
    }

    //处理连接关闭
    @OnClose
    public void onClose(){
        webSocketMap.remove(this.session.getId());
        reduceCount();
        log.info("连接关闭:{}",this.session.getId());
    }

    //群发消息

    //发送消息
    public void sendMessage(String message) throws IOException {
        this.session.getBasicRemote().sendText(message);
    }

    /*
        广播消息
        fixedRate上一次开始执行时间点后n秒再次执行
        fixedDelay上一次执行完毕时间点后n秒再次执行
     */
    @Scheduled(fixedRate = 3000)
    public static void broadcast(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        Date now = new Date();
        String strDate = sdf.format(now);

        WebSocketServer.webSocketMap.forEach((k,v)->{
            try{
                v.sendMessage("这是一条测试广播 " + strDate);
            } catch (Exception e){
                e.printStackTrace();
            }
        });
    }

    //获取在线连接数目
    public static int getCount(){
        return count;
    }

    //操作count，使用synchronized确保线程安全
    public static synchronized void addCount(){
        WebSocketServer.count++;
    }

    public static synchronized void reduceCount(){
        WebSocketServer.count--;
    }

}