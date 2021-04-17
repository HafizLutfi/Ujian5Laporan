package com.juaracoding.ujian5.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.juaracoding.ujian5.entity.User;

public class CustomUserDetail implements UserDetails {
	 
    private User user;
     
    public CustomUserDetail(User user) {
        this.user = user;
    }
 
    
    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
    	final List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
    	
    	switch (this.user.getRole()) {
		case "ADMIN":
			authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
			break;

		case "USER":
			authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
			break;
		}
    
    	
    	
  /*  	
    	
     //   if (enabled) {
            if (this.getUser().isAdmin()) {
                authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
            }else {
            authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
            }
    //    }
     * 
     * 
     */
     
       return authorities;
    }
 
    @Override
    public String getPassword() {
        return user.getPassword();
    }
 
    @Override
    public String getUsername() {
        return user.getUsername();
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
     
    public String getFullName() {
        return user.getUsername();
    }
 
}

