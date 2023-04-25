package org.example.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "countries")
@Getter
@Setter
@NoArgsConstructor
public class Country {
    @Id
    @GeneratedValue(
            generator = "country_gen",
            strategy = GenerationType.SEQUENCE
            )
    @SequenceGenerator(
                    name = "country_gen",
                    sequenceName = "country_seq",
                    allocationSize = 1
            )
    private Long id;
    private String name;
    private String language;

    @OneToOne(cascade = {
            CascadeType.PERSIST,
            CascadeType.REFRESH,
            CascadeType.REMOVE,
            CascadeType.DETACH,
            CascadeType.MERGE},
            fetch = FetchType.EAGER)
    private Capital capital;


    public Country(String name, String language, Capital capital) {
        this.name = name;
        this.language = language;
        this.capital = capital;
    }

    public Country(String name, String language) {
        this.name = name;
        this.language = language;
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", language='" + language + '\'' +
                ", capital=" + capital +
                '}';
    }
}
