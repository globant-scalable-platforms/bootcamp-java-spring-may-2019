package davidAcunaW3.configuration;

import org.springframework.stereotype.Component;

@Component
public class BatchFacade implements Command{

    public String execute() {
        return "Success";
    }
    
    public void voidExecute() {
        System.out.println("This is a void method");
    }
}
