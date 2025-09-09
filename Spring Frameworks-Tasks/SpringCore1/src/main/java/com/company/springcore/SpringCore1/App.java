package com.company.springcore.SpringCore1;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.company.springcore.SpringCore1.Student;

 public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Example of XML Based Configuratation:" );
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Bean.xml");
        
       Student s = context.getBean("stud1" , Student.class);
       System.out.println( s.getSid());
       System.out.println( s.getSname());
       System.out.println( s.getSaddr());
        
    }
}

