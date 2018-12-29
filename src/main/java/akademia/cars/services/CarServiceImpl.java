package akademia.cars.services;

import akademia.cars.model.Car;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    List<Car> cars;

    public CarServiceImpl() { //mockowanie testowej listy pojazdów.
        loadCars();
    }

    @Override //getter do listy.
    public List<Car> getCars() {
        return cars;
    }

    @Override
    public void addCar(Car car) { //to jest nasz setter do listy samochodów. Dodaje nowy pojazd
        this.cars.add(car);
    }

    private void loadCars() {

        System.out.println("Loading mock cars list........");

        cars = new ArrayList<>();
        cars.add(new Car("mazda", "6", "123", "2017","https://www.extremetech.com/wp-content/uploads/2018/01/Mazda-SKYACTIV-X-199-copy-640x354.jpg"));
        cars.add(new Car("peugeot", "partner", "152", "2014","https://www.extremetech.com/wp-content/uploads/2018/01/Mazda-SKYACTIV-X-199-copy-640x354.jpg"));
        cars.add(new Car("bmw", "3", "230", "2015","https://www.extremetech.com/wp-content/uploads/2018/01/Mazda-SKYACTIV-X-199-copy-640x354.jpg"));
        cars.add(new Car("suzuki", "gran vitara", "180", "2006","https://www.extremetech.com/wp-content/uploads/2018/01/Mazda-SKYACTIV-X-199-copy-640x354.jpg"));
    }


}
