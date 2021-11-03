package com.example.ipcheck.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class IpCheckRequest {

    protected List<String> ips = new ArrayList<>();
}
