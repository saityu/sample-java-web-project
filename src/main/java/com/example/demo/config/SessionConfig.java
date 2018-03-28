/**
 *
 */
package com.example.demo.config;

import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.security.jackson2.SecurityJackson2Modules;
import org.springframework.session.data.redis.config.ConfigureRedisAction;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Spring Session設定クラス.
 *
 * @author yusuke
 *
 */
@EnableRedisHttpSession
public class SessionConfig implements BeanClassLoaderAware {

  private ClassLoader loader;

  @Bean
  public RedisSerializer<Object> springSessionDefaultRedisSerializer() {
    return new GenericJackson2JsonRedisSerializer(objectMapper());
  }

  private ObjectMapper objectMapper() {
    ObjectMapper mapper = new ObjectMapper();
    mapper.registerModules(SecurityJackson2Modules.getModules(this.loader));
    return mapper;
  }

  @Bean
  public ConfigureRedisAction configureRedisAction() {
    return ConfigureRedisAction.NO_OP;
  }

  /*
   * (非 Javadoc)
   *
   * @see org.springframework.beans.factory.BeanClassLoaderAware#setBeanClassLoader(java.lang.
   * ClassLoader)
   */
  @Override
  public void setBeanClassLoader(ClassLoader classLoader) {
    this.loader = classLoader;
  }

}
