package teste;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello-world")
@Slf4j
public class Controller {
    @GetMapping
    public String helloWorld(){
        return "Hello World";
    }
}
