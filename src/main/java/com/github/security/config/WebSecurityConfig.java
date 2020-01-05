package com.github.security.config;

import com.github.security.UserDetailsServiceImpl;
import com.github.security.filter.JwtAuthenticationTokenFilter;
import com.github.security.handle.AccessDeniedHandlerImpl;
import com.github.security.handle.AuthenticationEntryPointImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.RememberMeAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.AbstractRememberMeServices;
import org.springframework.security.web.authentication.rememberme.TokenBasedRememberMeServices;

/**
 * @Classname WebSecurityConfig
 * @Description Security配置类
 * @Author 李号东 lihaodongmail@163.com
 * @Date 2019-05-07 09:10
 * @Version 1.0
 */
@Slf4j
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private static final String SECRET = "scio@2019";

    @Autowired
    private AuthenticationEntryPointImpl unauthorizedHandler;

    @Autowired
    private AccessDeniedHandlerImpl accessDeniedHandler;

    @Autowired
    private JwtAuthenticationTokenFilter authenticationTokenFilter;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;


    /**
     * 解决 无法直接注入 AuthenticationManager
     *
     * @return
     * @throws Exception
     */
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    /**
     * RememberMeAuthenticationProvider.
     *
     * @return
     */
    @Bean
    public RememberMeAuthenticationProvider rememberMeAuthenticationProvider() {
        return new RememberMeAuthenticationProvider(SECRET);
    }

    /**
     * TokenBasedRememberMeServices.
     *
     * @return
     */
    @Bean("tokenBaseRememberMeServices")
    public TokenBasedRememberMeServices tokenBasedRememberMeServices() {
        TokenBasedRememberMeServices rememberMeServices =
                new TokenBasedRememberMeServices(SECRET, userDetailsService);
        rememberMeServices.setAlwaysRemember(false);
        rememberMeServices.setCookieName("remember-me");
        rememberMeServices.setTokenValiditySeconds(AbstractRememberMeServices.TWO_WEEKS_S);
        return rememberMeServices;
    }

    /**
     * 配置策略
     *
     * @param httpSecurity
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                // 由于使用的是JWT，我们这里不需要csrf
                .csrf().disable()
                // 认证失败处理类
                .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).accessDeniedHandler(accessDeniedHandler).and()
                // 如果需要就创建一个Session（默认）
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED).invalidSessionUrl("/pages/login.jsp")
                .and()
                // 过滤请求
                .authorizeRequests()
                .antMatchers(
                        /*HttpMethod.GET,*/
                        "/*.html",
                        "/**/*.html",
                        "/**/css/*.css",
                        "/**/*.js",
                        "/**/scripts/*.js",
                        "/**/img/**",
                        "/**/vendor/**",
                        "/**/error/*.jsp"
                ).permitAll()
                .antMatchers("/captcha.jpg").permitAll()
                // 访问/user 需要拥有admin权限
                .antMatchers("/**").hasRole("BASE_ROLE")
                // 除上面外的所有请求全部需要鉴权认证
                .anyRequest().authenticated()
                .and()
                .headers().frameOptions().disable()
                .and()
                .formLogin().loginPage("/pages/login.jsp")
                .loginProcessingUrl("/login")
                .permitAll()
                .successForwardUrl("/pages/index.jsp")
                .failureForwardUrl("/pages/login.jsp")
                .and()
                .logout().logoutUrl("/logout").logoutSuccessUrl("/pages/login.jsp")
                .invalidateHttpSession(true);//指定是否在注销时让HttpSession无效
        httpSecurity.rememberMe().rememberMeServices(tokenBasedRememberMeServices())
                .and()
                .authenticationProvider(rememberMeAuthenticationProvider());
        // 添加JWT filter
        //httpSecurity.addFilterBefore(authenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);
    }

    /**
     * 认证用户的来源（内存或者是数据库）
     * @param auth
     * @throws Exception
     */
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                // 设置UserDetailsService
                .userDetailsService(userDetailsService)
                // 使用BCrypt进行密码的hash
                .passwordEncoder(passwordEncoder());
    }

    /**
     * 装载BCrypt密码编码器 密码加密
     *
     * @return
     */
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

