//package com.example.demo.common.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
///**
// * @author liuchen25
// * @description
// * @time 2019/3/27 10:40
// */
//@Configuration
//public class SignSecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        // 密码编译器
//        PasswordEncoder encoder = new BCryptPasswordEncoder();
//        // 使用内存存储
//        auth.inMemoryAuthentication()
//                // 设置密码编译器
//                .passwordEncoder(encoder)
//                // 注册用户 admin ， 密码为 123 ，并赋予 USER 和 ADMIN 的角色权限
//                .withUser("admin")
//                .password(encoder.encode("123"))
//                .roles("USER", "ADMIN")
//                .and()
//                // 注册用户 myuser，密码为 1234 ， 并赋予 USER 的角色权限
//                .withUser("myAdmin")
//                .password(encoder.encode("1234"))
//                .roles("USER");
//    }
//}
