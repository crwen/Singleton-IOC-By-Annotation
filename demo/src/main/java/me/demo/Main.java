package me.demo;

import me.crw.smart.ApplicationContext;
import me.crw.smart.annotated.Controller;
import me.crw.smart.annotated.Inject;
import me.demo.service.PersonService;
import redis.clients.jedis.Jedis;

/**
 * ClassName: Main
 * Description:
 * date: 2020/3/20 2:06
 *
 * @author crwen
 * @create 2020-03-20-2:06
 * @since JDK 1.8
 */
@Controller
public class Main {
    @Inject
    private static PersonService personService;


    @Inject
    private static Jedis jedis;

    public static void main(String[] args) {
        ApplicationContext context = new ApplicationContext(Main.class);
        personService.find();
        System.out.println(jedis);
        System.out.println(jedis.ping());
        jedis.set("k1", "v1");
        jedis.set("k2", "v2");
        jedis.set("k3", "v3");
        System.out.println(jedis.get("k1"));
        System.out.println(jedis.get("k2"));
        System.out.println(jedis.get("k3"));


    }
}
