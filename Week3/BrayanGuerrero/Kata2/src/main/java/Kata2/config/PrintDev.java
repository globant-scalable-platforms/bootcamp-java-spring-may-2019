/**
 * 
 */
package Kata2.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * @author asus
 *
 */
@Component
@Profile("dev")
public class PrintDev implements Print{
	
    @Value("${app.message}")
    String message;

    @Override
    public String print() {
    	StringBuilder usuarios = new StringBuilder();
    	usuarios.append(message+"\n");
    	usuarios.append("Bryan\n");
    	usuarios.append("Michelle\n");
        return usuarios.toString();
    }
}
