package org.orglot.admin.monitoring.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping("/log")
public class TestLogController {

    @RequestMapping
    public String initLogs(@RequestBody String body) {

        log.warn("body is ={}", body);
        return "done";
    }
}
