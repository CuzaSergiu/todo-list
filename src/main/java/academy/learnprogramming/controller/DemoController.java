package academy.learnprogramming.controller;


import academy.learnprogramming.service.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
// web controller
@Controller
public class DemoController {

    // == fields ==
    private final DemoService demoService;

    // == constructors ==
    @Autowired
    public DemoController(DemoService demoService) {
        this.demoService = demoService;
    }

    // == request methods ==
    // http://localhost:8080/todo-list/hello
    //@ResponseBody - indicates that the mothod's return value will be bound the web response body
    @ResponseBody
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    // == methods using Model and @Model Attributes

//    // http://localhost:8080/todo-list/welcome
//    @GetMapping("welcome")
//    // to use Model we need to define it in the parameters of our method
//    public String welcome(Model model) {
//        // this is one way to add an attribute to a model
//        model.addAttribute("user", "Sergiu");
//        log.info("model = {}", model);
//        // the return here represents the name of .jsp file, in our case "welcome"
//        // prefix + name + suffix
//        // ViewResolver will create for us : /WEB-INF/view/welcome.jsp
//        return "welcome";
//    }

//    // annotated Model method - Model Attributes
//    // this method is called before the welcome() method
//    @ModelAttribute("welcomeMessage")
//    public String welcomeMessage() {
//        log.info("welcomeMessage() called");
//        return "Welcome to this demo app";
//    }

    // == methods using @Service ==

    // http://localhost:8080/todo-list/welcome?user=Sergiu - with single param
    // http://localhost:8080/todo-list/welcome?user=Sergiu&age=30 - with multiple param
    @GetMapping("welcome")
    // with @RequestParam we can pass data entered from the browser
    public String welcome(@RequestParam String user, @RequestParam Integer age, Model model) {
        model.addAttribute("helloMessage", demoService.getHelloMessage(user));
        model.addAttribute("age", age);
        log.info("model = {}", model);
        return "welcome";
    }

    @ModelAttribute("welcomeMessage")
    public String welcomeMessage() {
        log.info("welcomeMessage() called");
        return demoService.getWelcomeMessage();
    }

}
