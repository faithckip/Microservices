package com.banking.onlineBanking.Model;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.banking.onlineBanking.Entity.Users;

@SuppressWarnings("serial")
public class UserPrincipal implements UserDetails{
	
	Users user;
	
	public UserPrincipal(Users user) {
		
		this.user = user;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities(){
		
		return Collections.singleton(new SimpleGrantedAuthority("USER"));
	}
	
	@Override
	public String getPassword() {
		return user.getPassword();
	}
	
	public String getName() {
		return user.getName().toLowerCase();
	}
	
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	
	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}

}
