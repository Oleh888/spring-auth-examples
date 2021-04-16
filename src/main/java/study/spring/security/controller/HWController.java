package study.spring.security.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import study.spring.security.repository.HWRepository;

@RestController
@RequestMapping("/HW")
@AllArgsConstructor
public class HWController {
    private final HWRepository hwRepository;

    @GetMapping("/hello")
    public String getHello() {
        return hwRepository.getHello();
    }

    @GetMapping("/insecure")
    public String getInsecureMessage() {
        return "Insecure end-point!";
    }
}
