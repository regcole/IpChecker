package com.example.ipcheck.controllers;


import com.example.ipcheck.model.IpCheckRequest;
import com.example.ipcheck.model.IpCheckResponse;
import com.example.ipcheck.service.IpSetParserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
public class IpCheckController {

    @Autowired
    private IpSetParserService ipSetParserService;

    @PostMapping(path = "/checkIp", consumes = "application/json", produces = "application/json")
    public IpCheckResponse checkIP(@RequestBody IpCheckRequest dto) {
        List<String> flaggedIPs = ipSetParserService.getFlaggedIPs(dto.getIps());
        IpCheckResponse response = new IpCheckResponse();
        response.setMatchedIps(flaggedIPs);
        return response;
    }
}
