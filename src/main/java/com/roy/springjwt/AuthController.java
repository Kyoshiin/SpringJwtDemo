package com.roy.springjwt;

import com.roy.springjwt.models.AuthenticationRequest;
import com.roy.springjwt.models.AuthenticationResponse;
import com.roy.springjwt.services.JwtUserDetailsService;
import com.roy.springjwt.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Roy on 14-07-2022
 */

@RestController
@CrossOrigin
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager; //needed to authenticate authenticationRequest

    @Autowired
    private JwtUserDetailsService userDetailsService; // for getting user details

    @Autowired
    private JwtUtil jwtUtil; // for gen auth token

    @RequestMapping("/check-access")
    public String hello() {
        return "You have access to our portal!!";
    }

    @PostMapping(value = "/authenticate")
    public ResponseEntity<?> createAuthToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        //trying to authenticate input details
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            authenticationRequest.getUserName(),
                            authenticationRequest.getPassword()
                    ));
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }

        //if auth successful need to create jwt token

        //since UserDetails obj is needed for jwtUtil to create jwt
        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authenticationRequest.getUserName());

        //create jwt
        final String jwt = jwtUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt));  // sending back d response
    }
}
