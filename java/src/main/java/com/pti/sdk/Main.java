package com.pti.sdk;

import com.pti.sdk.core.Environment;

public class Main {
    public static void main(String[] args) {
        PTIClient client = new PTIClientBuilder()
                .environment(Environment.DEFAULT)
                .ptiClientId("3450582c-1955-11eb-adc1-0242ac120002")
                .privateKeyPath("/Users/remicartier/Documents/cucumber_key.pem")
                .build();

        System.out.println(client.wallets().getListOfAssets());
    }
}
