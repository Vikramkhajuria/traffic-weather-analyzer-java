package com.vikram.traffic.model;

import jakarta.persistence.*;

@Entity
@Table(name = "locations", uniqueConstraints = {
        @UniqueConstraint(columnNames = "name")
})
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    protected Location() {
        // JPA needs a no-args constructor
    }

    public Location(String name) {
        this.name = name;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
}