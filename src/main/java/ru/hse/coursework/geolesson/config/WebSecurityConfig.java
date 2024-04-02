package ru.hse.coursework.geolesson.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import ru.hse.coursework.geolesson.service.impl.user.NewUserDetailsService;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@Slf4j
public class WebSecurityConfig {
    // Конфигурация цепочки фильтров безопасности
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests(auth -> auth
                        .requestMatchers(
                                "/countries/addInfo", "/countries/addCountry", "/countries/deleteCountry/**", "/countries/updateInfo/**",
                                "/countries/addMountain", "/countries/mountain/add", "/countries/deleteMountain/**", "/countries/updateMountain/**",
                                "/countries/addRiver", "/countries/river/add", "/countries/deleteRiver/**", "/countries/updateRiver/**",
                                "/countries/addSea", "/countries/sea/add", "/countries/deleteSea/**", "/countries/updateSea/**",
                                "/testInfo/addTest", "/testInfo/add", "/testInfo/delete/**", "/testInfo/update/**",
                                "/users/deleteUser/**", "/users/updateRole**")
                        .hasAnyAuthority("ROLE_ADMIN")
                        .requestMatchers("/testPage", "/infoPage", "profilePage", "/countries/**", "/testInfo/**")
                        .hasAnyAuthority("ROLE_ADMIN", "ROLE_USER")
                        .requestMatchers("/", "/static/**", "/users/**", "/error")
                        .permitAll()
                        .anyRequest().permitAll()
                )
                .formLogin(form -> form
                        .loginPage("/users/login")
                        .failureHandler((request, response, exception) -> {
                            log.error("Authentication failure: ", exception);
                            response.sendRedirect("/error");
                        })
                        .defaultSuccessUrl("/mainPage", true)
                        .permitAll()
                )
                .logout(LogoutConfigurer::permitAll);
        return httpSecurity.build();
    }

    // Пользовательский сервис детализации пользователей
    @Bean
    public UserDetailsService userDetailsService() {
        return new NewUserDetailsService();
    }

    // Провайдер аутентификации
    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService());
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }

    // Кодировщик пароля
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
