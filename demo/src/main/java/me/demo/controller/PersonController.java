package me.demo.controller;

import me.crw.smart.annotated.Controller;
import me.crw.smart.annotated.Get;
import me.crw.smart.annotated.Inject;
import me.crw.smart.annotated.Post;
import me.demo.bean.Person;
import me.demo.service.PersonService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * ClassName: PersonController
 * Description:
 * date: 2020/3/20 1:55
 *
 * @author crwen
 * @create 2020-03-20-1:55
 * @since JDK 1.8
 */
@Controller
public class PersonController {

    @Inject
    private PersonService personService;

    @Get("/")
    public String index() {
        return "index.html";
    }

    @Get("/response")
    public void testResponse(Map<String, Object> map) throws IOException {
        HttpServletRequest request = (HttpServletRequest) map.get("HttpServletRequest");
        HttpServletResponse response = (HttpServletResponse) map.get("HttpServletResponse");

        response.getWriter().write("When you see this word, you are 成功！！！");
    }

    @Post("/view")
    public String testView(Map<String, Object> map) {
        Object username = map.get("username");
        Object password = map.get("password");
        System.out.println(username);
        System.out.println(password);

        return "success.html";
    }

    @Get("/data")
    public Person testGetData() {
        Person person = new Person();
        person.setName("张三");
        person.setGender("男");
        return person;
    }

    @Post("/data")
    public Person testPostData() {
        Person person = new Person();
        person.setName("张三");
        person.setGender("男");
        return person;
    }

}
