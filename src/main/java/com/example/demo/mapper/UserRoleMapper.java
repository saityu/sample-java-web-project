/**
 *
 */
package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.example.demo.dto.UserRoleDto;

/**
 * @author yusuke
 *
 */
@Mapper
public interface UserRoleMapper {

  /**
   * ユーザーロール取得.
   *
   * @param username
   * @return ユーザーロール情報Dto
   */
  UserRoleDto selectUserRole(@Param("username") String username);

}
