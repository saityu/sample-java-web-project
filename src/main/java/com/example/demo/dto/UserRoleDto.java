/**
 *
 */
package com.example.demo.dto;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * ユーザーロール情報Dto.
 *
 * @author yusuke
 *
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class UserRoleDto implements Serializable {

  /* ユーザー名 **/
  String username;

  /* パスワード **/
  String password;

  /* ロール **/
  String roleName;

  /* 氏名 **/
  String fullName;

}
