/**
 *
 */
package com.example.demo.dto;

import java.io.Serializable;
import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
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
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class LoginUserDetailDto extends User implements Serializable {

  UserRoleDto userRoleDto;

  /**
   * コンストラクタ.
   *
   * @param username
   * @param password
   * @param authorities
   */
  @JsonCreator
  public LoginUserDetailDto(String username, String password,
      Collection<? extends GrantedAuthority> authorities) {
    super(username, password, authorities);
  }

}
