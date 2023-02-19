package design_pattern.design_pattern.Concurrency.Reactor;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.*;

public class ReactorPattern {
    public static void UseReactor() throws IOException {
        Reactor reactor = new Reactor();
        reactor.registerChannel(ServerSocketChannel.open().bind(new InetSocketAddress(8000)), new AcceptHandler());
        new Thread(reactor).start();
    }

    static class AcceptHandler implements Handler {
        @Override
        public void handleInput(byte[] input) {
            // Handle incoming request
        }

        @Override
        public void handleDisconnect() {
            // Handle disconnection
        }
    }
}