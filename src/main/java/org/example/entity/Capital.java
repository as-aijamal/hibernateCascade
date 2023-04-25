package org.example.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "capitals")
@Getter
@Setter
@NoArgsConstructor
public class Capital {
    @Id
    @GeneratedValue(
            generator = "capital_gen",
            strategy = GenerationType.SEQUENCE
    )
    @SequenceGenerator(
            name = "capital_gen",
            sequenceName = "capital_seq",
            allocationSize = 1
    )
    private Long id;
    private String name;
    private int population;

    @OneToOne(mappedBy = "capital",
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.REFRESH,
//                    CascadeType.REMOVE,
                    CascadeType.DETACH,
                    CascadeType.MERGE})
    private Country country;

    public Capital(String name, int population) {
        this.name = name;
        this.population = population;
    }

    @Override
    public String toString() {
        return "Capital{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", population=" + population +

                '}';
    }
}
