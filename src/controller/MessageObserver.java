package controller;

/**
 * Message observer.
 */
public interface MessageObserver {

    /**
     * Observer receive a text message.
     *
     * @param message the text message
     */
    void handleMessage(String message);
}
