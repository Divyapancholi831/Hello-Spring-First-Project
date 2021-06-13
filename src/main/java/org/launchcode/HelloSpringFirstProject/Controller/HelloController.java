package org.launchcode.HelloSpringFirstProject.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("hello")
public class HelloController {

    public String hello(){
        return "Hello, Spring!";
    }

    //@GetMapping("goodbye")
    //method lives at hello/goodbye
    @RequestMapping(value = "goodbye",method = {RequestMethod.GET,RequestMethod.POST})
    public String goodBye(){
        return "Good Bye,Spring";
    }


    //method lives at hello/hello1?name=anything
    @RequestMapping(value="hello1",method = {RequestMethod.GET,RequestMethod.POST})
    public String helloWithQueryParam(@RequestParam  String name){
        return "hello " + name + "!";
    }

    //example for path parameter.
    //method lives at hello/name(name would be anything)
    @GetMapping("{name}")
    public String helloWithPathParam(@PathVariable String name){
        return "hello " + name + "!";
    }

    //form
    //method lives at hello/form
    @GetMapping("form")
    public String helloWithForms(){
        return "<html>" +
                "<body>"+
                "<form action='hello1' method='post'>"+
                "<input type='text' name='name'/>" +
                "<input type='submit' value='Greet Me !'/>"+
                "</form>"+
                 "</body>"+
                "</html>";
    }
}
