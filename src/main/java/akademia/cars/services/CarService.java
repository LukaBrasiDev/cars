package akademia.cars.services;

import akademia.cars.model.Car;

import java.util.List;

public interface CarService {

    List<Car> getCars();

    void addCar(Car car);


}
