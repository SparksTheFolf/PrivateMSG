package com.PrivateMSG.MSGplugin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class ReplyCommand implements CommandExecutor {
	
		private Main main;
	
	public ReplyCommand(Main main) {
		this.main = main;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		// TODO Auto-generated method stub
		
		Player player = (Player) sender;
		
		
	if (args.length > 0) {
		if(main.getMessageManager().recentlyMessaged.containsKey(player)) {
			if(main.getMessageManager().recentlyMessaged.get(player) != null) {
				
				Player target = main.getMessageManager().recentlyMessaged.get(player);
				
				StringBuilder message = new StringBuilder();
				for(int i = 1; i < args.length; i++){
					message.append(args[i]).append(" ");
				}
				
				player.sendMessage(ChatColor.GREEN + "-> " + target.getName() + ChatColor.GRAY 
						+ " " + message.toString());
				
				target.sendMessage(ChatColor.GREEN + "<- " + player.getName()+ ChatColor.GRAY + " " + message.toString());
				
			}else {
				player.sendMessage(ChatColor.DARK_RED + "That Player has logged out! :(");
			}
		}else {
			player.sendMessage(ChatColor.DARK_RED + "You have not recived a msg lately! :(");
		}
	}else {
		
		player.sendMessage("Unvalid Usage! Use /reply <message>.");
		
	}
	return false;
	
	}

}
