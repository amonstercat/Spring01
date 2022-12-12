package com.lzc.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class Student {

    private  String name;
    private  Integer age;
    private  String sex;

    public  Student()
    {
        System.out.println("生命周期1：通过无参构造实例化");
    }
    public  void  setName()
    {
        System.out.println("生命周期2：通过setter()依赖注入");
        this.name=name;
    }
    public  void initMethod()
    {
        System.out.println("生命周期3：初始化bean");
    }
    public  void destroyMethod()
    {
        System.out.println("生命周期4：销毁bean");
    }
}
