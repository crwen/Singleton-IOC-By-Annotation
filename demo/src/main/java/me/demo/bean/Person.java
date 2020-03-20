package me.demo.bean;

import me.crw.smart.annotated.Service;

/**
 * ClassName: Person
 * Description:
 * date: 2020/3/20 1:52
 *
 * @author crwen
 * @create 2020-03-20-1:52
 * @since JDK 1.8
 */
@Service
public class Person {

    String name;

    String gender;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
