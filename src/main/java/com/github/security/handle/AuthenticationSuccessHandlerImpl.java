package com.github.security.handle;

import com.github.security.Tuser;
import com.github.security.util.JwtUtil;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthenticationSuccessHandlerImpl implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        /*Tuser userDetail = (Tuser) authentication.getPrincipal();
        String token = JwtUtil.generateToken(userDetail);
        System.out.println("token:"+token);
        httpServletRequest.setAttribute("token",token);
        // 登录成功重定向到home界面,这里先采用参数传递
        httpServletRequest.getRequestDispatcher("/pages/dispatch.jsp").forward(httpServletRequest,httpServletResponse);*/
        //httpServletResponse.sendRedirect("/pages/dispatch.jsp");
    }
}
