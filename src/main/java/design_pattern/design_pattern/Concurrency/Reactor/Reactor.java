package design_pattern.design_pattern.Concurrency.Reactor;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.*;

public class Reactor implements Runnable {
    private final Selector selector;
    private final Map<SelectableChannel, Handler> handlers;

    public Reactor() throws IOException {
        selector = Selector.open();
        handlers = new HashMap<>();
    }

    public void registerChannel(SelectableChannel channel, Handler handler) throws IOException {
        handlers.put(channel, handler);
        channel.configureBlocking(false);
        channel.register(selector, SelectionKey.OP_READ);
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                selector.select();
                Set<SelectionKey> keys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = keys.iterator();
                while (iterator.hasNext()) {
                    SelectionKey key = iterator.next();
                    iterator.remove();
                    if (!key.isValid()) {
                        continue;
                    }
                    if (key.isReadable()) {
                        handleRead(key);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void handleRead(SelectionKey key) throws IOException {
        SelectableChannel channel = key.channel();
        Handler handler = handlers.get(channel);
        SocketChannel socketChannel = (SocketChannel) channel;
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        int numBytes = socketChannel.read(buffer);
        if (numBytes == -1) {
            handler.handleDisconnect();
            socketChannel.close();
            key.cancel();
            return;
        }
        byte[] bytes = new byte[numBytes];
        buffer.flip();
        buffer.get(bytes);
        handler.handleInput(bytes);
    }
}
