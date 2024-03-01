package com.example.springct_coding;

public class Employee {
    private  String name,address,city;
    private int age;

    public Employee(String name,int age, String address,String city){
        this.name=name;
        this.age=age;
        this.address=address;
        this.city=address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public int getAge() {
        return age;
    }
}
