package com.bigshopper.www.big.shopper.Controllers;

import com.bigshopper.www.big.shopper.Configuration.JwtWebTokenUtil;
import com.bigshopper.www.big.shopper.Entities.JwtResponse;
import com.bigshopper.www.big.shopper.Entities.LoginTable;
import com.bigshopper.www.big.shopper.Services.JwtUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class JwtAuthenticationController {


    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtWebTokenUtil jwtWebTokenUtil;

    @Autowired
    private JwtUserDetailsService jwtUserDetailsService;


    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody LoginTable loginTable) throws Exception {

        authenticate(loginTable.getName(), loginTable.getPassword());


        final UserDetails userDetails = jwtUserDetailsService.loadUserByUsername(loginTable.getName());
        final String token = jwtWebTokenUtil.generateToken(userDetails);


        return ResponseEntity.ok(new JwtResponse(token));
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (Exception e) {
            throw new Exception("Authentication failed", e);
        }
    }

}
