package akademia.cars.controllers;

import akademia.cars.model.Car;
import akademia.cars.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/")
public class RestCarController {

    //@Autowired
    private CarRepository carRepository;

    //   @Autowired // nie jest wymagane to oznaczenie dziala domyslnie
    public RestCarController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @GetMapping("cars")
    public List<Car> getCars() {

        return carRepository.findAll();
    }

    @GetMapping("cars/id")
    public ResponseEntity<Car> getCarsById(
            @RequestParam(value = "id") Long id
    ) {
        Optional<Car> optionalCar = carRepository.findById(id);
        if (optionalCar.isPresent()) {
            return new ResponseEntity<>(optionalCar.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("cars/year")
    public List<Car> getCarsByYear(
            @RequestParam(value = "year") String year
    ) {

        return carRepository.findByYear(year);
    }


}
