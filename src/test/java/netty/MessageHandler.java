package netty;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.SimpleChannelHandler;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;

class MessageHandler extends SimpleChannelHandler {

    private static final int HEADER_LENGTH = 4;

    public void messageReceived(ChannelHandlerContext ctx, MessageEvent e) {
        // 接收客户端请求
        ChannelBuffer buffer = (ChannelBuffer) e.getMessage();
        String message = new String(buffer.readBytes(buffer.readableBytes()).array(), StandardCharsets.UTF_8);
        System.out.println("<服务端>收到内容=" + message);

        // 给客户端发送回执
        byte[] body = "服务端已收到".getBytes();
        byte[] header = ByteBuffer.allocate(HEADER_LENGTH).order(ByteOrder.BIG_ENDIAN).putInt(body.length).array();
        Channels.write(ctx.getChannel(), ChannelBuffers.wrappedBuffer(header, body));
        System.out.println("<服务端>发送回执,time=" + System.currentTimeMillis());
    }

}