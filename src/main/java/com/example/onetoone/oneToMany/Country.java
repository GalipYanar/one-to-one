package com.example.onetoone.oneToMany;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name= "Countries")
@Getter
@Setter

public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "country_id")
    private Long countryId;
    private String name;

    @OneToMany (mappedBy = "country", cascade = CascadeType.ALL)
    private List<City> cities;



}
