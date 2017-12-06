package com.sfirsov.klmtest.services;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sfirsov.klmtest.model.Fare;
import com.sfirsov.klmtest.model.Location;
import com.sfirsov.klmtest.model.Locations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;

@Configuration
public class TravelApiService {

    @Value("${travel.api.uri}")
    String travelApiUri;

    @Autowired
    RestTemplate travelRestTemplate;

    @Async
    public CompletableFuture<Location> getLocation(String name) {
        Location location = travelRestTemplate.getForObject(travelApiUri + "/airports/" + name, Location.class);
        return CompletableFuture.completedFuture(location);
    }

    @Async
    public CompletableFuture<Fare> getFares(String origin, String destination) {
        StringBuffer sb = new StringBuffer();
        String url = sb.append(travelApiUri).append("/fares/").append(origin).append("/").append(destination).toString();

        Fare fare = travelRestTemplate.getForObject(url, Fare.class);

        return CompletableFuture.completedFuture(fare);
    }

    @Async
    public CompletableFuture<Locations> getAllLocations() throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        String json = travelRestTemplate.getForObject(travelApiUri + "/airports", String.class);
        final JsonNode node = mapper.readTree(json);

        if (!node.has("_embedded")) {
            return null;
        }

        String locationsJson = node.get("_embedded").toString();
        return CompletableFuture.completedFuture(mapper.readValue(locationsJson, Locations.class));
    }
}
