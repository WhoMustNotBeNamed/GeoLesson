package ru.hse.coursework.geolesson.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.hse.coursework.geolesson.repository.UserRepository;

@Service
public class NewUserDetailsService implements UserDetailsService {
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return (UserDetails) userRepository.findUserByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(username + " not found"));
    }
}
