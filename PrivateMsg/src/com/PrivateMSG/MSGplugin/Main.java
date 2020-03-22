package com.PrivateMSG.MSGplugin;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{
	
	private MessageManager manager;
	
	@Override
	public void onEnable() {
		System.out.println("PrivateMSG ENABLED"); 
		
		getCommand("message").setExecutor(new MessageCommand(this));
		getCommand("reply").setExecutor(new ReplyCommand(this));
		
		manager = new MessageManager(this);
	}
	
	@Override
	public void onDisable() {
		System.out.println("PrivateMSG DISABLED");
	}
	
	public MessageManager getMessageManager() {return manager;}

}
