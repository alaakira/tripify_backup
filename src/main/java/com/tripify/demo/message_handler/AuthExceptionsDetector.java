package com.tripify.demo.message_handler;

import com.tripify.demo.consts.Keys;
import com.tripify.demo.jwt_utils.JWTUtils;
import com.tripify.demo.strings.Messages;
import com.tripify.demo.users.admins.repositories.AdminRepository;
import com.tripify.demo.users.clients.repositories.UserRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;

public class AuthExceptionsDetector {

    HttpServletRequest request;
    HttpServletResponse response;
    String token;

    public AuthExceptionsDetector(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) {
        this.request = request;
        this.response = response;
        token = request.getHeader(Keys.AUTHORIZATION.getName());
        JSONObject object = new JSONObject();
        object.put("code",HttpServletResponse.SC_UNAUTHORIZED);
        object.put("message",findCauseUsingPlainJava(authException).getLocalizedMessage());
        JWTUtils jwtUtils = new JWTUtils();
        if(token == null || token.length() == 0)
            object.put("message", Messages.NO_TOKEN_PROVIDED);
        else if(!jwtUtils.isValidToken(token))
            object.put("message", Messages.INVALID_TOKEN);
        else if(jwtUtils.isTokenExpired(token))
            object.put("message", Messages.TOKEN_EXPIRED);
        else if(jwtUtils.getPhoneFromToken(token) == null)
            object.put("message", Messages.NO_CREDENTIAL_IN_TOKEN);
        try {
            response.getOutputStream().print(object.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Throwable findCauseUsingPlainJava(Throwable throwable) {
        Objects.requireNonNull(throwable);
        Throwable rootCause = throwable;
        while (rootCause.getCause() != null && rootCause.getCause() != rootCause) rootCause = rootCause.getCause();
        return rootCause;
    }
}
