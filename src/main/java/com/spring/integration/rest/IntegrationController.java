package com.spring.integration.rest;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Slf4j
@AllArgsConstructor
public class IntegrationController {

    private IntegrationServiceImpl  integrationService;

    @GetMapping("/api/send")
    @ResponseBody
    public String sendMessage(){

        integrationService.sendMessage();
        return "API invoked";
    }

}
