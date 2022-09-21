package com.scan.secure.model;

import org.springframework.security.core.GrantedAuthority;

public class Authority implements GrantedAuthority {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1030475258380501718L;
	public String name;
	
	public Authority(String name) {
		this.name = name;
	}
		
	@Override
	public String getAuthority() {
		
		return name; 
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
