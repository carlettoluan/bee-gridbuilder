package beegridbuilder.util;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

public abstract class MessageBuilder {
	
	public static void createMsg(TypeMessage typeMessage, RedirectAttributes redirectAttrs) {
		redirectAttrs.addFlashAttribute("msg",typeMessage.description);
	}

}
