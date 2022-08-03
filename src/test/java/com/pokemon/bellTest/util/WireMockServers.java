package com.pokemon.bellTest.util;

import com.github.tomakehurst.wiremock.client.WireMock;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

@Component
public class WireMockServers {

    public void serverPosts(Resource body) {
        WireMock.stubFor(WireMock
                .get(String.format("/pokemon"))
                .willReturn(WireMock.aResponse().
                        withStatus(200).
                        withHeader("Content-Type", "application/json")
                        .withBody(Utils.getContentFile(body))));
    }

}
