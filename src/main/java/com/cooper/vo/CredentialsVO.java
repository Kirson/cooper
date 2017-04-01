package com.cooper.vo;

import java.io.Serializable;

public class CredentialsVO implements Serializable {

	/**
	 * Serial version
	 */
	private static final long serialVersionUID = -8955306055909809291L;
	private String nick;
	private String password;
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
