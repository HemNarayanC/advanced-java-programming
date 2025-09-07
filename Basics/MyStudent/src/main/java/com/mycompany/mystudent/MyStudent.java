
package com.mycompany.mystudent;


class Person{
    private String name, address;
    private int age;
    void setAll(String name, String address, int age){
        this.name = name;
        this.address = address;
        this.age = age;
    }
    
    String getName(){
        return name;
    }
    
    String getAddress(){
        return address;
    }
    
    int getAge(){
        return age;
    }
}

class Student extends Person{
    private int roll_no;
    void setRollNo(int roll_no){
        if(getAge() > 16){
           this.roll_no = roll_no;
        }
        else{
            System.out.println("Roll number can only be set if age is greater than 16!");
        }
    }
    
    int getRollNo(){
        return roll_no;
    }
}

public class MyStudent {

    public static void main(String[] args) {
//        System.out.println("Hello World!");
        Student s = new Student();
        s.setAll("HomaNath Adhikari", "Dharan", 10);
        s.setRollNo(101);
        
        System.out.println("Name: " + s.getName());
        System.out.println("Address: " + s.getAddress());
        System.out.println("Age: " + s.getAge());
        System.out.println("RollNo: " + s.getRollNo());
    }
}
