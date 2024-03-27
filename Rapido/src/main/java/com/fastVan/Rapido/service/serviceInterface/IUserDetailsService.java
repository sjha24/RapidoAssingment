package com.fastVan.Rapido.service.serviceInterface;

import com.fastVan.Rapido.DTO.LoginRequest;
import com.fastVan.Rapido.DTO.LoginResponse;
import com.fastVan.Rapido.customException.PleaseEnterValidEmailOrPassword;
import com.fastVan.Rapido.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface IUserDetailsService {
    ResponseEntity<String> registerUser(User user);
    ResponseEntity<LoginResponse> userLogin(LoginRequest loginRequest) throws PleaseEnterValidEmailOrPassword;
}
