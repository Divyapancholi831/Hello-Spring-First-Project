package org.launchcode.HelloSpringFirstProject.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloController {

    @ResponseBody
    @GetMapping("hello")
    public String hello(){
        return "Hello, Spring!";
    }


    @ResponseBody
    //@GetMapping("goodbye")
    @RequestMapping(value = "goodbye",method = {RequestMethod.GET,RequestMethod.POST})
    public String goodBye(){
        return "Good Bye,Spring";
    }


    @ResponseBody
    @RequestMapping(value="hello1",method = {RequestMethod.GET,RequestMethod.POST})
    public String helloWithQueryParam(@RequestParam  String name){
        return "hello " + name + "!";
    }

    //example for path parameter.
    @ResponseBody
    @GetMapping("hello/{name}")
    public String helloWithPathParam(@PathVariable String name){
        return "hello " + name + "!";
    }

    //form
    @GetMapping("form")
    @ResponseBody
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
