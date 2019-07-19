package davidAcunaW3.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class MeasureTimeExecution {

    @Pointcut("execution(* davidAcunaW3.configuration.Command.execute(..))")
    public void execute() {  }

    @Around( value = "execute()")
    public String loggerInOut(ProceedingJoinPoint jp){
    	long start = System.nanoTime();
    	String value ="";
        try {
            value =  (String) jp.proceed();
        } catch (Throwable throwable) {
            System.out.println("Error "+throwable.getMessage());
        }
        long end = System.nanoTime();
        System.out.println("Time (Miliseconds) to execute the method execute(): " + ((end - start)/1000000));
        return value;
    }
}
