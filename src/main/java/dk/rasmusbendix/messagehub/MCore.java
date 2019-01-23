package dk.rasmusbendix.messagehub;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

public class MCore {

    private static HashMap<String, Message> messages = new HashMap<>(); // Identifier, Message
    private static HashMap<MessageType, String> prefix = new HashMap<>();

    static void setPrefix(MessageType type, String prfx) {
        prefix.put(type, prfx);
    }

    public static Set<String> getAllIdentifiers() {
        return messages.keySet();
    }

    public static Collection<Message> getAllMessages() {
        return messages.values();
    }

    public static void registerMessage(String identifier, Message message) {
        messages.put(identifier, message);
    }

    public static Message getMessage(String identifier) {
        return messages.getOrDefault(identifier, null);
    }

    public static void sendMessage(CommandSender recipient, Message message) {
        recipient.sendMessage(ChatColor.translateAlternateColorCodes('&', getPrefix(message.getType()) + message.getMessage()));
    }

    public static String getPrefix(MessageType type) {
        return prefix.get(type);
    }

}
