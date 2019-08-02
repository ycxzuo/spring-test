package com.yczuoxin.springboot.test15.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.header.writers.frameoptions.AllowFromStrategy;
import org.springframework.security.web.header.writers.frameoptions.XFrameOptionsHeaderWriter;

import javax.servlet.http.HttpServletRequest;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 用 COOKIE 实现 token
        http.csrf().csrfTokenRepository(new CookieCsrfTokenRepository()).requireCsrfProtectionMatcher(
                // 匹配 POST 请求
                httpServletRequest -> httpServletRequest.getMethod().equals("POST")
        );
        // 设置信任的 javascript 地址
        // Content-Security-Policy: default-src 'self'; img-src *; media-src media1.com media2.com; script-src userscripts.example.com
        // 只允许 https://code.jquery.com/ 的 js 加载
        http.headers().contentSecurityPolicy("script-src https://code.jquery.com/");

        // 在请求头中加入 X-Frame-Options， 对于 iframe 的控制。貌似现在浏览器不支持控制请求头
        // 只允许相同域的访问
        //http.headers().frameOptions().sameOrigin();
        // 只允许 zuoxin.com 的域和自己访问
        //http.headers().addHeaderWriter(new XFrameOptionsHeaderWriter(new StaticAllowFromStrategy(new URI("zuoxin.com"))));
        http.headers().addHeaderWriter(new XFrameOptionsHeaderWriter(new AllowFromStrategy() {
            @Override
            public String getAllowFromValue(HttpServletRequest request) {
                return "zuoxin.com";
            }
        }));

        // XSS
        http.headers().xssProtection().block(false);

        http.authorizeRequests()
            .antMatchers("/css/**", "/js/**","/img/**", "**/favicon.ico", "/index").permitAll()
            .anyRequest().fullyAuthenticated()
            .and().formLogin().loginPage("/login").failureForwardUrl("/error").permitAll()
            .and().logout().permitAll();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
            .withUser("zuoxin").password(new BCryptPasswordEncoder().encode("123")).roles("ADMIN")
            .and().withUser("admin").password(new BCryptPasswordEncoder().encode("123")).roles("USER");
    }
}
