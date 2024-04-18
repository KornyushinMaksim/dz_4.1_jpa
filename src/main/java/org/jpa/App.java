package org.jpa;

import org.jpa.configuration.DBConfiguration;
import org.jpa.enums.Processor;
import org.jpa.model.Camera;
import org.jpa.model.Lens;
import org.jpa.service.CameraService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.UUID;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DBConfiguration.class);
        CameraService service = context.getBean(CameraService.class);

        Camera canon550D = Camera.builder()
                .nameCamera("Canon550D")
                .matrix(36)
                .ISO("100-6400")
                .mount("EF")
                .processor(Processor.DIGIC5)
                .lens(Lens.builder()
                        .nameLens("Canon")
                        .focalLength("50-100")
                        .depthOfField("f/2.2-f4.3")
                        .build())
                .build();

        Camera nikonD700 = Camera.builder()
                .nameCamera("Nikon_D700")
                .matrix(36)
                .ISO("100-6400")
                .mount("Nikon F")
                .processor(Processor.EXPEED3)
                .lens(Lens.builder()
                        .nameLens("Nikon")
                        .focalLength("50-300")
                        .depthOfField("f/4.2-f8.3")
                        .build())
                .build();

        Camera nikonD730 = Camera.builder()
                .nameCamera("Nikon_D730")
                .matrix(36)
                .ISO("100-12800")
                .mount("Nikon F")
                .processor(Processor.EXPEED3)
                .lens(Lens.builder()
                        .nameLens("Nikon")
                        .focalLength("50-300")
                        .depthOfField("f/4.2-f8.3")
                        .build())
                .build();


//        service.addCamera(canon550D);
//        service.addCamera(nikonD700);
//        service.addCamera(nikonD730);

        service.updateCamera(service.getCameraById(UUID.fromString("52b53bb2-daf6-4068-87af-6b74e0925e1a"))
                .get()
                .setISO("100-800"));

        System.out.println();
        service.getCameraByProcessor(Processor.EXPEED3)
                .forEach(System.out::println);

        System.out.println();
        service.getAllCamera()
                .forEach(System.out::println);
    }
}
