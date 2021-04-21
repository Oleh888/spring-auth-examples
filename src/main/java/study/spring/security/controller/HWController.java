package study.spring.security.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import study.spring.security.dto.SimpleDTO;
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

    @GetMapping("/write/{text}")
    public String write(@PathVariable String text) {
        return "You wrote: " + text;
    }

    @PostMapping("/hello")
    public String getSimpleDto(@RequestBody SimpleDTO simpleDTO) {
        return simpleDTO.getName() + " is name and " + simpleDTO.getAge() + " is age";
    }
}
