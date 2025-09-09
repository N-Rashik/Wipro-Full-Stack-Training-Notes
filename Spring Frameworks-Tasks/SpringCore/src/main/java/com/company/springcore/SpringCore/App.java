package com.company.springcore.SpringCore;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.company.springcore.xmlbasedconfig.Student;

import org.springframework.context.ApplicationContext;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Example of XML Based Configuratation:" );
        ApplicationContext context = new ClassPathXmlApplicationContext("Bean.xml");
        
       Student s = context.getBean("stud1" , Student.class);
       System.out.println( s.getSid());
       System.out.println( s.getSname());
       System.out.println( s.getSaddr());
        
    }
}