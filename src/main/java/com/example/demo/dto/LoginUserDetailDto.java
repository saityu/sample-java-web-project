/**
 *
 */
package com.example.demo.dto;

import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 認証ユーザー詳細情報Dto.
 *
 * @author yusuke
 *
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class LoginUserDetailDto extends User {

  // 必要な情報があれば追加

  /**
   * コンストラクタ.
   *
   * @param username
   * @param password
   * @param authorities
   */
  public LoginUserDetailDto(String username, String password,
      Collection<? extends GrantedAuthority> authorities) {
    super(username, password, authorities);
  }

}
