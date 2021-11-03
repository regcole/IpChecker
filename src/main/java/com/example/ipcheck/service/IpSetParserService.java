package com.example.ipcheck.service;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Service
public class IpSetParserService {

    ClassLoader classLoader = getClass().getClassLoader();

    /**
     * @return
     */
    public List<String> getCollectedIPSets() {
        List<String> dataLines = new ArrayList<String>();
        try {
            File file = new File(classLoader.getResource("sample.ipset").getFile());
            String data = FileUtils.readFileToString(file, "UTF-8");
            LineIterator iterator = FileUtils.lineIterator(file);
            while (iterator.hasNext()) {
                String dataLine = iterator.nextLine();
                if (!dataLine.contains("#")) {
                    dataLines.add(dataLine);
                }
            }
            System.out.println("Data has ipSet:" + StringUtils.contains("213.194.164.101\n", data));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataLines;
    }

    /**
     * @param ipsToCheck
     * @return
     */
    public List<String> getFlaggedIPs(List<String> ipsToCheck) {
        List<String> matchedIPs = new ArrayList<>();
        List<String> suspectIps = getCollectedIPSets();
        for (String ip : ipsToCheck) {
            if (suspectIps.contains(ip)) {
                matchedIPs.add(ip);
            }
        }
        return matchedIPs;
    }
}
