package com.yrw.test.enums;

public enum ReconStatus {

    RECON_STATUS_4("处理中", 4),
    RECON_STATUS_5("已处理", 5);


    public String key;
    public Integer value;

    ReconStatus(String key, Integer value) {
        this.key = key;
        this.value = value;
    }
}
