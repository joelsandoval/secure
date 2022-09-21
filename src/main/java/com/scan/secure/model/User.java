package com.scan.secure.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class User implements UserDetails{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7210632699188385531L;
	private Long idusuario;
	private String username;
	private String password;
	private String shortName;
	private String roleName;
	private Timestamp lastPasswordResetDate;
	private List<Authority> authorities;
	
	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public User(BigDecimal idusuario, String username, String password, 
			String roleName, String shortName) {
		this.idusuario = idusuario.longValue();
		this.username = username;
		this.password = password;
		this.roleName = roleName;
		this.shortName = shortName;
	}

	public Long getId() {
		return idusuario;
	}

	public void setId(Long idusuario) {
		this.idusuario = idusuario;
	}

	public Timestamp getLastPasswordResetDate() {
		return lastPasswordResetDate;
	}

	public void setLastPasswordResetDate(Timestamp lastPasswordResetDate) {
		this.lastPasswordResetDate = lastPasswordResetDate;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setAuthorities(List<Authority> authorities) {
        this.authorities = authorities;
    }
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.authorities;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
}
