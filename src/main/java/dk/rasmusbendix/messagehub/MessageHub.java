package dk.rasmusbendix.messagehub;

import org.bukkit.plugin.java.JavaPlugin;

public class MessageHub extends JavaPlugin {

    private CustomConfig messages;

    @Override
    public void onEnable() {

        new CustomConfig(this);
        messages = new CustomConfig("messages");
        getServer().getPluginCommand("msghubstats").setExecutor(new MsgHubStatsCommand());

        loadMessages();

        MCore.registerMessage("player-not-found", new Message("Player not found!"));

    }

    @Override
    public void onDisable() {

    }

    public void reloadMessages() {
        messages.reloadConfig();
        loadMessages();
    }

    public void saveMessages() {

        for(String identifier : MCore.getAllIdentifiers()) {

            Message msg = MCore.getMessage(identifier);
            messages.set(msg.getType().name() + "." + identifier, msg.getMessage());

        }

        messages.saveConfig();

    }

    public void loadMessages() {

        for(String type : messages.getConfig().getKeys(false)) {

            MessageType mt = MessageType.valueOf(type);
            for(String identifier : messages.getConfig().getConfigurationSection(type).getKeys(false)) {
                MCore.registerMessage(identifier, new Message(messages.getString(type + "." + identifier), mt));
            }
        }

    }

}
