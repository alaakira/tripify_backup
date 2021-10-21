package com.tripify.demo.filters;

import com.tripify.demo.consts.Keys;
import com.tripify.demo.exceptions.ExpiredJwtToken;
import com.tripify.demo.jwt_utils.JWTUtils;
import com.tripify.demo.users.admins.services.AdminAuthServices;
import com.tripify.demo.users.clients.services.ClientAuthServices;
import com.tripify.demo.users.types.UserTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {

    @Autowired
    JWTUtils jwtUtils;

    @Autowired
    AdminAuthServices adminAuthServices;
    @Autowired
    ClientAuthServices clientAuthServices;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest,
                                    HttpServletResponse httpServletResponse,
                                    FilterChain filterChain) throws ServletException, IOException {

        String requestToken = httpServletRequest.getHeader(Keys.AUTHORIZATION.getName());

        String phone = null;
        String type = null;

        if (requestToken != null) {
            try {
                phone = jwtUtils.getPhoneFromToken(requestToken);
                type = jwtUtils.getTypeFromToken(requestToken);
            } catch (ExpiredJwtToken expiredJwtToken) {
                expiredJwtToken.printStackTrace();
            }
        }

        if (phone != null && type != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails;
            if (type.equals(UserTypes.ADMIN.getType()))
                userDetails = this.adminAuthServices.loadUserByUsername(phone);
            else if (type.equals(UserTypes.CLIENT.getType()))
                userDetails = this.clientAuthServices.loadUserByUsername(phone);
            else
                userDetails = this.clientAuthServices.loadUserByUsername(phone);
            if (userDetails != null && jwtUtils.validateToken(requestToken, userDetails)) {
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities()
                );
                usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }
        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}
