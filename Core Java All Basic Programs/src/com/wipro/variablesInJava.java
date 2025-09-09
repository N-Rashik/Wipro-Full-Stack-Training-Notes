package com.wipro;//This defines the package name. It helps organize related classes
public class variablesInJava {//class declaration
	static String father="Nagarajan";//static variable(or)class variable.
		String mother="Kalaiselvi";//instance variable
	/**
	 * Instance variable: Declared inside the class but outside all methods.
	 */
	public static void main(String[] args) {//Entry point of program anything which is present outside it will not display
		// TODO Auto-generated method stub
int age=23;//local variable
String name="Rashik";//local variable
/**
 * These are local variables: declared inside the main() method.like it should be declared only inside methods,accessible only within that method
 */
System.out.println("Age: "+age);
System.out.println("My Full Name is: "+name+" "+father);

variablesInJava obj=new variablesInJava();//creating object to access non static members
System.out.println("My mother name is: "+obj.mother);//printing instance variable through object
/**
 * Now we can access instance variables and non-static methods using obj.
 */
obj.displayAge();//It calls the method displayAge() using the object obj of the class variablesInJava.
/**
 * Since displayAge() is non-static, you must use an object to call it.It cannot be called directly inside the main() method (which is static).
  * Non-static method: It doesn't use static keyword.So, it must be called using an object of the class.
 */
	}
	public void displayAge() {
		int real_age=23;//local variable inside method
		System.out.println("My current age is: "+real_age);
		/**
		 * This method uses only local variables, but it doesn't use static, so it's treated as a normal instance method.
           That means: It belongs to each object of the class, not the class itself.
           Why not static:
           You didn't write static before void displayAge(), so Java assumes this method should be:
           called using an object (obj.displayAge()), and it might (later) use non-static (instance) variables like mother.
            Because main() is static and static methods can't call non-static methods directly.
           		 */
	}
	}
