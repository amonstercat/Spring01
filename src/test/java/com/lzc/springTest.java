package com.lzc;

import com.lzc.entity.Hello;
import com.lzc.entity.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class springTest {

    /**
     * 获取Bean的方式
     * 1.根据Beanid获取
     * 2.根据Bean类型获取，即Class类型（最常用，且class只能是具体类型不能是接口）
     * 如果一个接口有多个实现类，且这些实现类均配置了Bean，则无法通过接口类型获取Bean
     * 在满足bean唯一性的情况下：通过bean的类型，bean实现接口的类型，bean所继承父类的类型
     * 均可以获取bean
     */
    @Test
    public  void helloTest()
    {
        //获取IOC容器
        ApplicationContext ioc= new ClassPathXmlApplicationContext
                ("applicationContext.xml");
        //获取容器中的bean对象
       Hello hello =(Hello) ioc.getBean("hello");
       hello.sayHello();
       String[]  names=ioc.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
    }

    @Test
    public  void  stuTest()
    {
      ConfigurableApplicationContext ioc= new ClassPathXmlApplicationContext
                ("applicationContext.xml");
        Student student1= (Student) ioc.getBean("stu");
        System.out.println(student1);
        //Spring通过Java反射机制创建对象：Class.forName().newInstance()
        Student student2= ioc.getBean(Student.class);
        System.out.println(student2);
        ioc.close();
        //ApplicationContext的子类ConfigurableApplicationContext里定义了关闭IOC容器的方法
    }
}

