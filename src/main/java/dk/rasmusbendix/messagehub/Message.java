package dk.rasmusbendix.messagehub;

public class Message {

    private MessageType type;
    private String message;

    public Message(String message) {
        this(message, MessageType.DEFAULT);
    }

    public Message(String message, MessageType type) {
        this.message = message;
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public MessageType getType() {
        return type;
    }

}
