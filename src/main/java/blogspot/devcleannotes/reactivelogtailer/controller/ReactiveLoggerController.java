package blogspot.devcleannotes.reactivelogtailer.controller;

import blogspot.devcleannotes.reactivelogtailer.service.ReactiveLogTailerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/log/")
@RequiredArgsConstructor
public class ReactiveLoggerController {

    final ReactiveLogTailerService reactiveLogTailerService;

    @GetMapping
    Flux<String> getLogs() {
        return null;
    }


}
