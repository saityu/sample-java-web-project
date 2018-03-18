package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.example.demo.constant.UrlConstant;
import com.example.demo.constant.ViewConstant;

/**
 * ログインコントローラークラス.
 *
 * @author yusuke
 *
 */
@Controller
public class LoginController {

  /**
   * 初期表示
   *
   * @return 遷移先
   */
  @RequestMapping(path = {UrlConstant.BASE, UrlConstant.LOGIN},
      method = {RequestMethod.GET, RequestMethod.POST})
  public String init() {
    return ViewConstant.LOGIN;
  }

}
