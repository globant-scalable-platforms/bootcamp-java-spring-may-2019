package Kata2.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Kata2.config.Print;

@RestController
public class PrintEndpoint {

	@Autowired
    private Print print;

    @RequestMapping(value = "/print")
    public String getPrint(){
        return print.print();
    }
}
