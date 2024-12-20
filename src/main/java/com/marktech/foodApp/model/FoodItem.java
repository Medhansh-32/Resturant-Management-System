package com.marktech.foodApp.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class FoodItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    private String images;

    private String description;


    @Column(nullable = false)
    private Integer price;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImages() {
        return images;
    }

    public String getDescription() {
        return description;
    }

    public Integer getPrice() {
        return price;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
