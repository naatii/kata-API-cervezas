package daw2a.kataapicervezas.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/style")
public class StyleController {
    @GetMapping
    public String getStyle() {
        return "Style";
    }
    @PostMapping
    public String postStyle() {
        return "Style";
    }
    @DeleteMapping
    public String deleteStyle() {
        return "Style";
    }
    @PutMapping
    public String putStyle() {
        return "Style";
    }
}