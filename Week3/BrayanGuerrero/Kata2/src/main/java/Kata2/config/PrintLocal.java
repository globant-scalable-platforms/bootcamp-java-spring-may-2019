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
@Profile("local")
public class PrintLocal implements Print{
	
	@Value("${app.message}")
    String message;

    @Override
    public String print() {
    	StringBuilder usuarios = new StringBuilder();
    	usuarios.append(message+"\n");
    	usuarios.append("Bryan\n");
    	usuarios.append("Michelle\n");
    	usuarios.append("Santiago\n");
    	usuarios.append("Camilo\n");
        return usuarios.toString();
    }

}
