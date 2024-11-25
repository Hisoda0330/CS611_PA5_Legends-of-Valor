package controller;

/**
 * Message observer.Defines an interface for observing messages,
 * respond to messages for display notifications or logs.
 */
public interface MessageObserver {

    void handleMessage(String message);
}
