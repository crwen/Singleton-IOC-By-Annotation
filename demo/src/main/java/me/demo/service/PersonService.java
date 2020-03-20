package me.demo.service;

import me.demo.bean.Person;
import me.crw.smart.annotated.Service;

/**
 * ClassName: PersonService
 * Description:
 * date: 2020/3/20 1:53
 *
 * @author crwen
 * @create 2020-03-20-1:53
 * @since JDK 1.8
 */
@Service
public class PersonService {

    public void find() {
        Person person = new Person();
        person.setGender("male");
        person.setName("张三");
        System.out.println("find a person" + person);
    }
}
