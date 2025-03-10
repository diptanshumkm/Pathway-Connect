package learning.example.learn;

import org.springframework.stereotype.Component;


@Component // Tells Spring that this class should be treated as a Bean (a managed object). Spring automatically creates an object of this class and manages its lifecycle.

public class MyService {
    public String getMessage(){
        return "Hello from spring boot!";
    }
}

