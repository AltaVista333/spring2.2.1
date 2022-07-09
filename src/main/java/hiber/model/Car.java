package hiber.model;

import lombok.*;
import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@Table(name = "cars")
public class Car {

    public Car(String model, Integer series) {
        this.model = model;
        this.series = series;
    }

    public Car() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "model")
    private String model;

    @Column(name = "series")
    private Integer series;

    @OneToOne(mappedBy = "car")
    @ToString.Exclude
    private User user;


}
