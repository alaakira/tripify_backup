package com.tripify.demo.message_handler;

import org.json.JSONObject;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomAccessDenied implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException {
        e.printStackTrace();
        JSONObject object = new JSONObject();
        object.put("code",HttpServletResponse.SC_FORBIDDEN);
        object.put("message", e.getMessage());
        httpServletResponse.setStatus(HttpServletResponse.SC_FORBIDDEN);
        httpServletResponse.setContentType("application/json");
        httpServletResponse.getOutputStream().print(object.toString());
    }
}
