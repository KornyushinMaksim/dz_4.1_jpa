package org.jpa.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "lens")
public class Lens {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String nameLens;

    private String focalLength; //фокусное расстояние

    private String depthOfField; //глубина резкости

    @OneToOne(cascade = CascadeType.PERSIST, mappedBy = "lens")
    private Camera camera;

    private Lens setNameLens(String nameLens) {
        this.nameLens = nameLens;
        return this;
    }

    private Lens setFocalLength(String focalLength) {
        this.focalLength = focalLength;
        return this;
    }

    private Lens setDepthOfField(String depthOfField) {
        this.focalLength = focalLength;
        return this;
    }

    public UUID getId() {
        return this.id;
    }

    public String getNameLens() {
        return this.nameLens;
    }

    public String getFocalLength() {
        return this.focalLength;
    }

    public String getDepthOfField() {
        return this.depthOfField;
    }

    public Camera getCamera() {
        return this.camera;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setCamera(Camera camera) {
        this.camera = camera;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Lens)) return false;
        final Lens other = (Lens) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$nameLens = this.getNameLens();
        final Object other$nameLens = other.getNameLens();
        if (this$nameLens == null ? other$nameLens != null : !this$nameLens.equals(other$nameLens)) return false;
        final Object this$focalLength = this.getFocalLength();
        final Object other$focalLength = other.getFocalLength();
        if (this$focalLength == null ? other$focalLength != null : !this$focalLength.equals(other$focalLength))
            return false;
        final Object this$depthOfField = this.getDepthOfField();
        final Object other$depthOfField = other.getDepthOfField();
        if (this$depthOfField == null ? other$depthOfField != null : !this$depthOfField.equals(other$depthOfField))
            return false;
        final Object this$camera = this.getCamera();
        final Object other$camera = other.getCamera();
        if (this$camera == null ? other$camera != null : !this$camera.equals(other$camera)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Lens;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $nameLens = this.getNameLens();
        result = result * PRIME + ($nameLens == null ? 43 : $nameLens.hashCode());
        final Object $focalLength = this.getFocalLength();
        result = result * PRIME + ($focalLength == null ? 43 : $focalLength.hashCode());
        final Object $depthOfField = this.getDepthOfField();
        result = result * PRIME + ($depthOfField == null ? 43 : $depthOfField.hashCode());
        final Object $camera = this.getCamera();
        result = result * PRIME + ($camera == null ? 43 : $camera.hashCode());
        return result;
    }

    public String toString() {
        return "Lens(id=" + this.getId() + ", nameLens=" + this.getNameLens() + ", focalLength=" + this.getFocalLength() + ", depthOfField=" + this.getDepthOfField();
    }
}
