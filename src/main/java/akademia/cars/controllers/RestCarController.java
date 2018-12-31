package akademia.cars.controllers;

import akademia.cars.model.Car;
import akademia.cars.repositories.CarRepository;
import jdk.nashorn.internal.runtime.options.Option;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

/*    @GetMapping("cars/{id}")
    public ResponseEntity<Car> getCarsByIdPath(
            @PathVariable(value = "id") Long id
    ) {
        Optional<Car> optionalCar = carRepository.findById(id);
        if (optionalCar.isPresent()) {
            return new ResponseEntity<>(optionalCar.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }*/

    @GetMapping("cars/power")
    public List<Car> getCarsBetweenPower(
            @RequestParam(value = "from") String from,
            @RequestParam(value = "to") String to
    ) {

        return carRepository.findByBetweenPower(from, to);
    }

    @GetMapping("cars/brand")
    public List<Car> getCarsLikeBrand(
            @RequestParam(value = "brand") String brand
    ) {

        return carRepository.findBrandLike(brand);
    }

    @GetMapping("cars/model")
    public ResponseEntity<Car> getCarsByModel(
            @RequestParam(value = "model") String model
    ) {
        Optional<Car> optionalCar = carRepository.findCarByModel(model);
        if (optionalCar.isPresent()) {
            return new ResponseEntity<>(optionalCar.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("cars/add")
    public ResponseEntity<Car> addCar(
            @RequestBody Car car
    ) {
        Optional<Car> optionalCar = carRepository.findCarByModel(car.getModel());
        if (optionalCar.isPresent()) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(carRepository.save(car), HttpStatus.OK);
    }

    @PutMapping("cars/update")
    public ResponseEntity<Car> updateCar(@RequestParam String model, @RequestBody Car car) {
        Optional<Car> optionalCar = carRepository.findCarByModel(model);

        if (optionalCar.isPresent()) {

            optionalCar.get().setBrand(car.getBrand());
            optionalCar.get().setModel(car.getModel());
            optionalCar.get().setPower(car.getPower());
            optionalCar.get().setYear(car.getYear());
            optionalCar.get().setPicture(car.getPicture());


            return new ResponseEntity<>(carRepository.save(optionalCar.get()), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("cars/delete")
    public ResponseEntity<Car> deleteCarByModel(@RequestParam String model) {
        Optional<Car> optionalCar = carRepository.findCarByModel(model);
        if (optionalCar.isPresent()) {
            carRepository.delete(optionalCar.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
