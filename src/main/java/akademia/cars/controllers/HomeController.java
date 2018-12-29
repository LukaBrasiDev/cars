package akademia.cars.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping("home")
    public String homePage() {
        return "index";
    }

    @GetMapping("welcome")
    public String home(Model model, @RequestParam(value = "name") String name) {
        model.addAttribute("name", name); //mapowanie wartosci po kluczu.
        return "index";
    }

}
