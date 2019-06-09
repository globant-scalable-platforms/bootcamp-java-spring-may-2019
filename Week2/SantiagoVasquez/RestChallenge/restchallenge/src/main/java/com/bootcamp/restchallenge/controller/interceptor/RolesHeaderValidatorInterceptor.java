package com.bootcamp.restchallenge.controller.interceptor;

import com.bootcamp.restchallenge.exception.HeaderValidationException;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

public class RolesHeaderValidatorInterceptor implements HandlerInterceptor {

    private static final String ADMIN_ROLE = "admin";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (Objects.nonNull(request.getHeader("roles"))) {
            if (request.getHeader("roles").equals(ADMIN_ROLE)) {
                return true;
            }
        }
        throw new HeaderValidationException();
    }
}
