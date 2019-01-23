package dk.rasmusbendix.messagehub;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class MsgHubStatsCommand implements CommandExecutor {

    private MessageHub plugin;

    public MsgHubStatsCommand(MessageHub plugin) {
        this.plugin = plugin;
    }

    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        return false;
    }
}
