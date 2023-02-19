package design_pattern.design_pattern.Concurrency.Reactor;

public interface Handler {
    void handleInput(byte[] input);

    void handleDisconnect();
}