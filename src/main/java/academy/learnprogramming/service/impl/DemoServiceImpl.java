package academy.learnprogramming.service.impl;


import academy.learnprogramming.service.DemoService;
import org.springframework.stereotype.Service;

//@Service - will do the business logic of the application, in this case will return messages for us
@Service
public class DemoServiceImpl implements DemoService {

    @Override
    public String getHelloMessage(String user) {
        return "Hello " + user;
    }

    @Override
    public String getWelcomeMessage() {
        return "Welcome to this demo app!!!";
    }
}
