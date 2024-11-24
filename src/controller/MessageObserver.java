package controller;

/**
 * Message observer. Defines an interface for observing messages, respond to messages for display notifications or logs.
 */
public interface MessageObserver {

    /**
     * Observer receive a text message.
     *
     * @param message the text message
     */
    void handleMessage(String message);
}
