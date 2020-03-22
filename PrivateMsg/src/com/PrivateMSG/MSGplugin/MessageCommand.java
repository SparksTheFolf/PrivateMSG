package com.PrivateMSG.MSGplugin;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class MessageCommand implements CommandExecutor {
	
	private Main main;
	
	public MessageCommand(Main main) {
		this.main = main;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		

		// TODO Auto-generated method stub
		
		Player player = (Player) sender;
		
		if (args.length >= 2) {
			if (Bukkit.getPlayerExact(args[0]) != null) {
				
				
				Player target = Bukkit.getPlayerExact(args[0]);
				
				StringBuilder message = new StringBuilder();
				for(int i = 1; i < args.length; i++){
					message.append(args[i]).append(" ");
				}
								((Player) sender).playSound(((OfflinePlayer) sender).getPlayer().getLocation(), Sound.BLOCK_NOTE_HARP, 2.0F, 1.0F);

				player.sendMessage(ChatColor.GREEN + "-> " + target.getName() + ChatColor.GRAY 
						+ " " + message.toString());

				
				target.sendMessage(ChatColor.GREEN + "<- " + player.getName()+ ChatColor.GRAY + " " + message.toString());
				((Player) sender).playSound(((OfflinePlayer) sender).getPlayer().getLocation(), Sound.BLOCK_NOTE_PLING, 1.0F, 1.0F);
				
				main.getMessageManager().recentlyMessaged.put(player, target);
			}else {
				player.sendMessage(ChatColor.RED + "Player Not Found!");
				((Player) sender).playSound(((OfflinePlayer) sender).getPlayer().getLocation(), Sound.BLOCK_NOTE_HARP, 2.0F, 1.0F);

			}
		}else {
			player.sendMessage(ChatColor.RED + "Invalid Usage!  Use /message <player> <message>");
			((Player) sender).playSound(((OfflinePlayer) sender).getPlayer().getLocation(), Sound.BLOCK_NOTE_HARP, 2.0F, 1.0F);

		}
		
		return false;
	}


}
