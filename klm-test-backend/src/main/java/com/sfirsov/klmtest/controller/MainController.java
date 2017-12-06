package com.sfirsov.klmtest.controller;

import com.sfirsov.klmtest.model.*;
import com.sfirsov.klmtest.services.TravelApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class MainController {
    @Autowired
    TravelApiService travelApiService;

    @RequestMapping(method = RequestMethod.GET, value = "/fares/{originCode}/{destinationCode}", produces = MediaType.APPLICATION_JSON_VALUE)
    public FareResponse getFare(@PathVariable String originCode, @PathVariable String destinationCode) throws ExecutionException, InterruptedException {
        CompletableFuture<Fare> fare = travelApiService.getFares(originCode, destinationCode);
        CompletableFuture<Location> origin = travelApiService.getLocation(originCode);
        CompletableFuture<Location> destination = travelApiService.getLocation(destinationCode);

        return new FareResponse(origin.get(), destination.get(), fare.get());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/locations", produces = MediaType.APPLICATION_JSON_VALUE)
    public Set<String> getLocations() throws ExecutionException, InterruptedException, IOException {
        Set<String> locations = travelApiService.getAllLocations().get()
            .getLocations().stream().map(l -> l.getCode()).collect(Collectors.toSet());

        return locations;
    }
}
