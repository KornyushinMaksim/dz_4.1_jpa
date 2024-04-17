package org.jpa.repository;

import org.jpa.enums.Processor;
import org.jpa.model.Camera;

import java.util.List;
import java.util.UUID;

public interface CameraRepository {

    void addCamera(Camera camera);

    void deleteCamera(Camera camera);

    void updateCamera(Camera camera);

    Camera getCameraById(UUID id);

    List<Camera> getCameraByProcessor(Processor processor);

    List<Camera> getAllCamera();
}
