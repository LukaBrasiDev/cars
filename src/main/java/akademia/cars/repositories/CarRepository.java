package akademia.cars.repositories;

import akademia.cars.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface CarRepository extends JpaRepository<Car, Long> {

    String BETWEEN_POWER = "select * from car where power between ?1 and ?2";

    List<Car> findByYear(String year);
    @Query(value = BETWEEN_POWER,nativeQuery = true)
    List<Car> findByBetweenPower(String from, String to);



}
