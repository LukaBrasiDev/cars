package akademia.cars.controllers;

import akademia.cars.model.Car;
import akademia.cars.services.CarService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/")
public class CarController {

    private CarService carService; //zależność

    // @Autowired nie jest wymagane do dodania konstruktorem.
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("cars")
    public String getCarPage(Model model) {
        model.addAttribute("cars", carService.getCars());
        return "cars";
    }

    @GetMapping("add")
    public String addCar(
            //    Model model,
            @RequestParam(value = "brand", required = false, defaultValue = "") String name,
            @RequestParam(value = "model", required = false, defaultValue = "") String carModel,
            @RequestParam(value = "power", required = false, defaultValue = "") String power,
            @RequestParam(value = "year", required = false, defaultValue = "") String year,
            @RequestParam(value = "picture", required = false, defaultValue = "") String picture
    ) {
        Car car = new Car(name, carModel, power, year, picture);
        carService.addCar(car);
        //  cars.add(car);
        //  System.out.println(car);
        //  model.addAttribute("car", carService.addCar(car)); //mapowanie wartosci po kluczu.
        return "redirect:/cars"; //uruchamia metodę z tym mappingiem
    }

    @PostMapping("addpost")
    public String addCarPost(@ModelAttribute Car car) {
        carService.addCar(car);
        return "redirect:/cars";
    }

}
