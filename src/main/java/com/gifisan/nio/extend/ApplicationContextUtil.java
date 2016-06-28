package com.gifisan.nio.extend;

import com.gifisan.nio.component.Session;
import com.gifisan.nio.extend.plugin.authority.AuthorityContext;
import com.gifisan.nio.extend.plugin.authority.AuthoritySessionAttachment;
import com.gifisan.nio.extend.security.Authority;
import com.gifisan.nio.extend.security.AuthorityManager;

public class ApplicationContextUtil {

	public static AuthorityManager getAuthorityManager(Session session){
		
		AuthorityContext plugin = AuthorityContext.getInstance();
		
		AuthoritySessionAttachment attachment = (AuthoritySessionAttachment) session.getAttachment(plugin);
		
		return attachment.getAuthorityManager();
	}
	
	public static Authority getAuthority(Session session){
		
		AuthorityManager authorityManager = getAuthorityManager(session);
		
		return authorityManager.getAuthority();
	}
	
	public static Authority getAuthority(FixedSession session){
		
		return getAuthority(session.getSession());
	}
	
}