package hello;

import org.joda.time.LocalTime;

public class HelloWorld {
  public  void main(String[] args) {
    
    System.out.println("The current local time is: " + currentTime);

    Greeter greeter = new Greeter();
    System.out.println(greeter.sayHello());
  }
}