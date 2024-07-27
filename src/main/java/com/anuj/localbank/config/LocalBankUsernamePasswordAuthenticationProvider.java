package com.anuj.localbank.config;

import com.anuj.localbank.model.Authority;
import com.anuj.localbank.model.Customer;
import com.anuj.localbank.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Component
public class LocalBankUsernamePasswordAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();
        List<Customer> customer = customerRepository.findByEmail(username);
        if (customer.isEmpty()) {
            if (passwordEncoder.matches(password, customer.get(0).getPwd())) {
//                List<GrantedAuthority> authorities = new ArrayList<>();
//                authorities.add(new SimpleGrantedAuthority(customer.get(0).getRole()));
                return new UsernamePasswordAuthenticationToken(username, password, getGrantedAuthorities(customer.get(0).getAuthorities()));
            } else {
                throw new BadCredentialsException("Bad credentials");
            }
        } else {
            throw new BadCredentialsException("No registered user found");
        }
    }

    private List<GrantedAuthority> getGrantedAuthorities(Set<Authority> authorities) {
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        for (Authority authority : authorities) {
            grantedAuthorities.add(new SimpleGrantedAuthority(authority.getName()));
        }
        return grantedAuthorities;
    }


    @Override
    public boolean supports(Class<?> authentication) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
    }
}