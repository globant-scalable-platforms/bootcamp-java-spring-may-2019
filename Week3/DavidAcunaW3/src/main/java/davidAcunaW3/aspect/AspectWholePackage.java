package davidAcunaW3.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AspectWholePackage {

	@Pointcut("within(davidAcunaW3.controller..*)")
    public void execute() {  }

    @Before("execute()")
    public void loggIn(){
        System.out.println("Entered a RestController inside the package controller");
    }

    @After("execute()")
    public void loggInAfter(){
        System.out.println("A RestController came out in the package controller");
    }
}
