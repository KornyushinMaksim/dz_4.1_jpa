package org.jpa.service;

import lombok.RequiredArgsConstructor;
import org.jpa.enums.Processor;
import org.jpa.model.Camera;
import org.jpa.repository.CameraRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CameraServiceImpl implements CameraService{

    private final CameraRepository cameraRepository;

    @Override
    @Transactional
    public void addCamera(Camera camera) {

    }

    @Override
    public void deleteCamera(Camera camera) {

    }

    @Override
    public void updateCamera(Camera camera) {

    }

    @Override
    public Camera getCameraById(UUID id) {
        return null;
    }

    @Override
    public List<Camera> getCameraByProcessor(Processor processor) {
        return List.of();
    }

    @Override
    public List<Camera> getAllCamera() {
        return List.of();
    }
}
