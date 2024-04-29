package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/first") // добавляется префикс /first/hello или /first/goodbye
public class FirstController {

    @GetMapping("/hello")
    public  String helloPage(@RequestParam(value = "name", required = false) String name,
                             @RequestParam(value = "surname", required = false) String surname,
                             Model model){

//        System.out.println("Hello " + name + " " + surname);
        model.addAttribute("message", "Hello " + name + " " + surname);
        return "first/hello";
    }

    @GetMapping("/goodbye")
    public  String goodByePage(){
        return "first/goodbye";
    }

    @GetMapping("/calculator")
    public String calcPage(@RequestParam(value = "a", required = false) int a, @RequestParam(value = "b", required = false) int b, @RequestParam(value = "action", required = false) String action, Model model){
        double res;
        switch (action) {
            case "add":
                res = a + b;
                break;
            case "sub":
                res = a - b;
                break;
            case "mul":
                res = a * b;
                break;
            case "div":
                res = a / (double) b;
                break;
            default:
                res = 0;
        }

        model.addAttribute("result", res);

        return "first/calculator";
    }
}
