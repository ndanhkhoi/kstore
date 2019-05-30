package com.ndanhkhoi.authentication;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.ndanhkhoi.service.AccountService;


@Component
public class customAuthenticationProvider  implements AuthenticationProvider{

	@Autowired
	AccountService accountService;
	
	@SuppressWarnings("serial")
	public Authentication authenticate(Authentication authentication) throws AuthenticationException
	{
			String userName = authentication.getName();
			String password = authentication.getCredentials().toString();
			final String authen = authorizedUser(userName, password);

			if (!authen.isEmpty())
			{
					List<GrantedAuthority> grantedAuths = new ArrayList<GrantedAuthority>();
					grantedAuths.add(new GrantedAuthority() {
						public String getAuthority() {return authen;}
					});
					Authentication auth = new UsernamePasswordAuthenticationToken(userName, password, grantedAuths);
					return auth;
			}
			else
			{
					throw new AuthenticationCredentialsNotFoundException("Invalid Credentials!");
			}
	}


	@Transactional
	private String authorizedUser(String username, String password)
	{ 
		if (accountService.authentication(username, password) )
				return accountService.findByUsername(username).getRoles().getCode();
		return "";
	}

	public boolean supports(Class<?> authentication)
	{
			return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
	}

}
