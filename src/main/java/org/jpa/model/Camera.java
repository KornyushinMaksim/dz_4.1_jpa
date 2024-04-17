package org.jpa.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jpa.enums.Processor;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "camera")
public class Camera {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String nameCamera;

    private int matrix;

    private String ISO;

    @Enumerated(EnumType.STRING)
    private Processor processor;

    private int maxPermission; //макс. разрешение

    private String mount; //байонет

    @OneToOne
    private Lens lens;
}
