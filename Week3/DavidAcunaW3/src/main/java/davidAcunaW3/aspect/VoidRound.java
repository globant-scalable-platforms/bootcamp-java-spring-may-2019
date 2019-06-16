package davidAcunaW3.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class VoidRound {

    @Pointcut("execution(* davidAcunaW3.configuration.Command.voidExecute(..))")
    public void voidExecute() {  }


    @Around(value = "voidExecute()")
    public Integer loggerInOut(ProceedingJoinPoint jp){
        System.out.println("Void Around In");
        Integer value =1;
        try {
            value =  (Integer) jp.proceed();
        } catch (Throwable throwable) {
            System.out.println("Error "+throwable.getMessage());
        }
        System.out.println("Void Around Out");
        return value;
    }
}
