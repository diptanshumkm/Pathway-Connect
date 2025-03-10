package learning.example.learn;

import org.springframework.stereotype.Component;

@Component
public class MyController {
    
    private final MyService myService;

    public MyController(MyService service){
        this.myService = service;
    }

    public void printMessage(){
        System.out.println(myService.getMessage());
    }

}
