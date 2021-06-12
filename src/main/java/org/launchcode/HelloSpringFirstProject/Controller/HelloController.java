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
    @GetMapping("hello1")
    public String helloWithQueryParam(@RequestParam  String name){
        return "hello " + name + "!";
    }

    //example for path parameter.
    @ResponseBody
    @GetMapping("hello/{name}")
    public String helloWithPathParam(@PathVariable String name){
        return "hello " + name + "!";
    }
}
