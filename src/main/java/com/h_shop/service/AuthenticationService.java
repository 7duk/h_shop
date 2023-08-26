package com.h_shop.service;

import com.h_shop.auth.AuthenticationRequest;
import com.h_shop.auth.AuthenticationResponse;
import com.h_shop.auth.RegisterRequest;
import com.h_shop.model.User;
import com.h_shop.repository.userRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final userRepository repository;
    private final PasswordEncoder passwordEncode;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    public AuthenticationResponse register(RegisterRequest request) {
        var user = User.builder()
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .password(passwordEncode.encode(request.getPassword()))
                .dateOfBirth(request.getDayOfBirth())
                .phone(request.getPhone())
                .address(request.getAddress())
                .role(request.getRole())
                .build();
        repository.save(user);
        var jwtToken = jwtService.generateToken(user);
        System.out.println("JWT Token : "+jwtToken);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
         authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                request.getEmail(),
                request.getPassword()
        ));
        var user =repository.findByEmail(request.getEmail()).orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        System.out.println("JWT Token : "+jwtToken);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}
