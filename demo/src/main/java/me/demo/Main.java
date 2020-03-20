package me.demo;

import me.crw.smart.ApplicationContext;
import me.crw.smart.annotated.Controller;
import me.crw.smart.annotated.Inject;
import me.demo.service.PersonService;

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


    public static void main(String[] args) {
        ApplicationContext context = new ApplicationContext(Main.class);
        personService.find();
    }
}
