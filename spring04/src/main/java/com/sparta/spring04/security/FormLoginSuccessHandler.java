package com.sparta.spring04.security;

import com.sparta.spring04.security.jwt.JwtTokenUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FormLoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
    public static final String AUTH_HEADER = "AccessToken";
    public static final String AUTH_header = "RefershToken";
    public static final String TOKEN_TYPE = "BEARER";



    @Override
    public void onAuthenticationSuccess(final HttpServletRequest request, final HttpServletResponse response,
                                        final Authentication authentication) {
        final UserDetailsImpl userDetails = ((UserDetailsImpl) authentication.getPrincipal());
        // Token 생성
        final String token = JwtTokenUtils.generateJwtToken(userDetails);
        response.addHeader(AUTH_HEADER, TOKEN_TYPE + " " + token);

        final String Rtoken = JwtTokenUtils.RefershJwtToken(userDetails);
        response.addHeader(AUTH_header, TOKEN_TYPE + " " + Rtoken);
    }



}

