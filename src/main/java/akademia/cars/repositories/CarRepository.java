package akademia.cars.repositories;

import akademia.cars.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;


public interface CarRepository extends JpaRepository<Car, Long> {

    List<Car> findByYear(String year);

    String BETWEEN_POWER = "select * from car where power between ?1 and ?2";

    @Query(value = BETWEEN_POWER, nativeQuery = true)
    List<Car> findByBetweenPower(String from, String to);

    @Query(value = "select * from car where brand like ?1%", nativeQuery = true)
    List<Car> findBrandLike(String brand);

    @Query(value = "select * from car where model like ?1%", nativeQuery = true)
    Optional<Car> findCarByModel(String model);


}
