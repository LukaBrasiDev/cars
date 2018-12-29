package akademia.cars.model;


import lombok.*;

import javax.persistence.*;

//@Getter
//@Setter
//@ToString
@AllArgsConstructor
@NoArgsConstructor
@Data //to samo co gett, sett, toStr
@Entity
@Table(name = "car")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "brand")
    private String brand;

    @Column(name = "model", nullable = false)
    private String model;

    @Column(name = "power")
    private String power;

    @Column(name = "year")
    private String year;

    @Column(name = "picture")
    private String picture;

    public Car(String brand, String model, String power, String year, String picture) {
        this.brand = brand;
        this.model = model;
        this.power = power;
        this.year = year;
        this.picture = picture;
    }





    }
