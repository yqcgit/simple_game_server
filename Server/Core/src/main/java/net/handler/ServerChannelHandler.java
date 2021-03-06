package net.handler;

import handler.Handler;
import io.netty.channel.ChannelHandlerContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import thread.DispatchProcessor;

/**
 * Created by YongQc
 *
 * 2019-10-26 17:18.
 *
 * ServerChannelHandler
 */
public class ServerChannelHandler extends BaseChannelInHandler
{
    private static final Logger LOGGER = LoggerFactory.getLogger(ServerChannelHandler.class);

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception
    {
        if (ctx == null)
            return;

        if (msg instanceof Handler)
        {
            DispatchProcessor.getInstance().submitHandler((Handler) msg);
        }
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception
    {
        super.channelActive(ctx);

        LOGGER.info("连接已建立:");
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception
    {
        super.channelInactive(ctx);
        LOGGER.info("连接断开.");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception
    {
        super.exceptionCaught(ctx, cause);
    }
}
