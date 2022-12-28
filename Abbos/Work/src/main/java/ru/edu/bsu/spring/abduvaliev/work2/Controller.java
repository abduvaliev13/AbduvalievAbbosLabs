package ru.edu.bsu.spring.abduvaliev.work2;

import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.*;
import java.io.File;
@RestController
@RequestMapping("beans")
public class Controller {
    private final File service;
    public Controller(File service) {
        this.service = service;
    }
    @GetMapping
    public Class<? extends File> getBeans() {
        return service.getClass();
    }
    @SneakyThrows
    @PostMapping
    public boolean createBean(@RequestParam(value = "fileName", required = false) String fileName) {
        if(fileName == null) {
        }
        return service.createNewFile();
    }
}
