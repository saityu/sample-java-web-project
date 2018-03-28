/**
 *
 */
package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.example.demo.constant.UrlConstant;

/**
 * Spring Security設定クラス.
 *
 * @author yusuke
 *
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  PasswordEncoder passwordEncoder;

  @Autowired
  UserDetailsService userDetailsService;

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Override
  public void configure(WebSecurity web) throws Exception {
    // 静的リソースはセキュリティ設定を無視
    web.ignoring().antMatchers("/css/**", "/js/**", "/image/**", "/webjars/**");
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    // 認可設定
    http.authorizeRequests()
        // アクセス可能パス
        .antMatchers(UrlConstant.BASE, UrlConstant.LOGIN)
        // それ以外は認証必須
        .permitAll().anyRequest().authenticated();

    // ログイン設定
    http.formLogin()
        // ログインフォームパス
        .loginPage(UrlConstant.LOGIN)
        // 認証パス
        .loginProcessingUrl(UrlConstant.AUTHENTICATE)
        // 認証成功時
        .defaultSuccessUrl(UrlConstant.MENU)
        // 認証失敗時
        .failureUrl(UrlConstant.LOGIN + "?error")
        // ユーザー名、パスワードのパラメータ名を設定
        .usernameParameter("username").passwordParameter("password");

    // ログアウト設定
    http.logout().logoutUrl(UrlConstant.LOGOUT).logoutSuccessUrl(UrlConstant.LOGIN);
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    // 認証ユーザー設定
    auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
  }
}
