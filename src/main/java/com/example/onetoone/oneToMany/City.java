package com.example.onetoone.oneToMany;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table (name = "Cities")
@Getter
@Setter

public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "city_id")
    private Long cityId;
    private String name;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;





}
