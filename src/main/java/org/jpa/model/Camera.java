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

    @OneToOne(cascade = CascadeType.PERSIST)
    private Lens lens;

    private Camera setNameCamera(String nameCamera) {
        this.nameCamera = nameCamera;
        return this;
    }

    private Camera setMatrix(int matrix) {
        this.matrix = matrix;
        return this;
    }

    public Camera setISO(String ISO) {
        this.ISO = ISO;
        return this;
    }

    private Camera setProcessor(Processor processor) {
        this.processor = processor;
        return this;
    }

    private Camera setMaxPermission(int maxPermission) {
        this.maxPermission = maxPermission;
        return this;
    }

    private Camera setMount(String mount) {
        this.mount = mount;
        return this;
    }

    private Camera setLens(Lens lens) {
        this.lens = lens;
        return this;
    }
}
