/**
 *
 */
package com.example.demo.service.login.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.demo.dto.LoginUserDetailDto;
import com.example.demo.dto.UserRoleDto;
import com.example.demo.mapper.UserRoleMapper;

/**
 * UserDetailsService実装クラス.
 *
 * @author yusuke
 *
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

  @Autowired
  UserRoleMapper userRoleMapper;

  @Autowired
  PasswordEncoder passwordEncoder;

  /*
   * (非 Javadoc)
   *
   * @see
   * org.springframework.security.core.userdetails.UserDetailsService#loadUserByUsername(java.lang.
   * String)
   */
  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    // 未入力チェック
    if (StringUtils.isBlank(username)) {
      throw new UsernameNotFoundException("ユーザーIDが未入力です");
    }

    // ユーザーロール情報取得
    UserRoleDto userRoleDto = userRoleMapper.selectUserRole(username);
    // 入力値チェック
    if (StringUtils.isBlank(userRoleDto.getUsername())) {
      throw new UsernameNotFoundException("ユーザーIDが不正です");
    }
    return new LoginUserDetailDto(username, this.passwordEncoder.encode(userRoleDto.getPassword()),
        AuthorityUtils.createAuthorityList(userRoleDto.getRoleName()));
  }
}
