package org.jpa.service;

import lombok.RequiredArgsConstructor;
import org.jpa.enums.Processor;
import org.jpa.model.Camera;
import org.jpa.repository.CameraRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CameraServiceImpl implements CameraService{

    private final CameraRepository cameraRepository;

    @Override
    @Transactional
    public void addCamera(Camera camera) {

        cameraRepository.addCamera(camera);
    }

    @Override
    @Transactional
    public void deleteCamera(UUID id) {

            Optional<Camera> optionalCamera = cameraRepository.getCameraById(id);

            optionalCamera.ifPresent(cameraRepository::deleteCamera);
    }

    @Override
    @Transactional
    public void updateCamera(Camera camera) {

        cameraRepository.updateCamera(camera);
    }

    @Override
    public Optional<Camera> getCameraById(UUID id) {
        return cameraRepository.getCameraById(id);
    }

    @Override
    public List<Camera> getCameraByProcessor(Processor processor) {
        return new ArrayList<>(cameraRepository.getCameraByProcessor(processor));
    }

    @Override
    public List<Camera> getAllCamera() {
        return cameraRepository.getAllCamera();
    }
}
