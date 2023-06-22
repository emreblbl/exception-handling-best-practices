package it.practice.local.sample.controller;

import it.practice.local.common.exception.exceptions.InternalErrorException;
import it.practice.local.common.exception.exceptions.ItemNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class TestController {

    @GetMapping("/testBusinessException")
    public String testBusinessException() {
        log.debug("testBusinessException");
        throw new ItemNotFoundException("Item not found - testBusinessException");
    }
    @GetMapping("/testGenericException")
    public String testGenericException() throws Exception {
        log.debug("testGenericException");
        throw new Exception("this is a generic exception");
    }


}
