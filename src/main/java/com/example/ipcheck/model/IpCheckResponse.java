package com.example.ipcheck.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class IpCheckResponse {

    protected List<String> matchedIps = new ArrayList<>();
}
