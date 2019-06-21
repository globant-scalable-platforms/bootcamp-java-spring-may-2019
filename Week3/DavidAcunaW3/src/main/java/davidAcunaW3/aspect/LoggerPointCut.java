//package davidAcunaW3.aspect;
//
//import org.aspectj.lang.annotation.After;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.aspectj.lang.annotation.Pointcut;
//import org.springframework.stereotype.Component;
//
//@Component
//@Aspect
//public class LoggerPointCut {
//
//    @Pointcut("execution(* davidAcunaW3.configuration.Command.execute(..))")
//    public void execute() {  }
//
//    @Before("execute()")
//    public void loggIn(){
//        System.out.println("entro 2");
//    }
//
//    @After("execute()")
//    public void loggInAfter(){
//        System.out.println("salio 2");
//    }
//}
