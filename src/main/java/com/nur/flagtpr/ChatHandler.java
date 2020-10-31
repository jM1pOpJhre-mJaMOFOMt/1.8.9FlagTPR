package com.nur.flagtpr;


import net.minecraft.event.ClickEvent;
import net.minecraft.event.ClickEvent.Action;
import net.minecraft.util.ChatStyle;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import java.util.regex.*;

public class ChatHandler {
	@SubscribeEvent
    public void onOtherChat(ClientChatReceivedEvent event)
    {
		String FLAG_REGEXP = "^\\[.+\\] (\\w+) VL \\d+";
		Pattern FLAG_PATTERN = Pattern.compile(FLAG_REGEXP);
		Matcher m = FLAG_PATTERN.matcher(event.message.getUnformattedText());
		if(m.find()) {
			ChatStyle style = new ChatStyle().setChatClickEvent(new ClickEvent(Action.RUN_COMMAND, "/tpr "+m.group(1)));
			event.message.setChatStyle(style);
		}
    }
}
