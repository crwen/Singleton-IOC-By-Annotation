package me.demo.config;

import me.crw.smart.annotated.Bean;
import me.crw.smart.annotated.Configuration;
import me.crw.smart.annotated.Controller;
import redis.clients.jedis.Jedis;

/**
 * ClassName: RedisConfig
 * Description:
 * date: 2020/3/29 14:16
 *
 * @author crwen
 * @create 2020-03-29-14:16
 * @since JDK 1.8
 */
@Controller
@Configuration
public class RedisConfig {

    @Bean
    public Jedis test() {
        return new Jedis("localhost", 6379);
    }

}
