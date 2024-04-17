package org.jpa.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.util.UUID;

public class Lens {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String nameLens;

    private String focalLength; //фокусное расстояние

    private String depthOfField; //глубина резкости

    private Boolean IS; //стабилизатор

    @OneToOne
    private Camera camera;
}
