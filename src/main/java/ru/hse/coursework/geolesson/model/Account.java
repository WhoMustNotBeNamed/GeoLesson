package ru.hse.coursework.geolesson.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;
import java.util.stream.Collectors;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Account implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Getter
    @Column(unique = true)
    private String username;

    private String password;

    private String roles;

    // Метод для получения ролей пользователя
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.stream(roles.split(", "))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    // Методы для проверки статуса аккаунта, не истек ли срок его действия и не заблокирован ли
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    // Метод для проверки статуса учетных данных, не истек ли срок действия учетных данных
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    // Метод для проверки активности учетной записи
    @Override
    public boolean isEnabled() {
        return true;
    }
}

