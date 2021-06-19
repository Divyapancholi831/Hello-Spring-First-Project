package org.launchcode.HelloSpringFirstProject.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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



    @RequestMapping(value="hello1",method = {RequestMethod.GET,RequestMethod.POST})
    public String helloWithQueryParam(@RequestParam  String name, Model model) {

        String greeting = "hello, " + name + "!";
        model.addAttribute("greeting",greeting);

        return "hello";
}

   // @ResponseBody
    //@GetMapping("hello1")
    //@RequestMapping(value="hello1",method = {RequestMethod.GET,RequestMethod.POST})
    //public String helloWithQueryParam(@RequestParam  String name){
     //   return "hello " + name + "!";
    //}

    //@ResponseBody
    @GetMapping("hello/{name}")
    public String helloWithPathParam(@PathVariable String name,Model model){
        //String greeting = "hello ," + name + "!";
        model.addAttribute("greeting","hello ," + name + "!");
        return "hello";
    }

    //form
    @GetMapping("form")
    public String helloWithForms(){
        return "form";
    }
}
