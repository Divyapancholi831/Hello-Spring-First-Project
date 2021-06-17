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


    @RequestMapping(value = "hello2",method = {RequestMethod.POST,RequestMethod.GET})
    public String helloPost(@RequestParam String name,@RequestParam String language){
        if(name==null)
        {
            name="world";
        }
        return createMessage(name,language);

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
                "<form action='hello2' method='get'>"+
                "<input type='text' name='name'/>" +
                "<select name='language' id='select_language'>" +
                "<option value='english'>English</option>" +
                "<option value='french'>French</option>" +
                "<option value='spanish'>Spanish</option>" +
                "<option value='hindi'>Hindi</option>" +
                "<option value='german'>German</option>" +
                "</select>"+
                "<input type='submit' value='Greet Me !'/>"+
                "</form>"+
                 "</body>"+
                "</html>";
    }
    public static String createMessage(String n,String l){
        String greeting = "";
        if(l.equals("english")){
            greeting="Hello";
        }
        else if(l.equals("french")){
            greeting="Bonjour";
        }
        else if(l.equals("spanish")){
            greeting="HoLa";
        }
        else if(l.equals("hindi")){
            greeting="Namaste";
        }
        else if(l.equals("german")){
            greeting="Hallo";
        }
    return greeting + "" + n;

    }
}
