package dk.rasmusbendix.messagehub;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class MsgHubStatsCommand implements CommandExecutor {

    MsgHubStatsCommand() {}

    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

        sender.sendMessage("Total messages registered: " + MCore.getAllMessages().size());

        return true;
    }
}
