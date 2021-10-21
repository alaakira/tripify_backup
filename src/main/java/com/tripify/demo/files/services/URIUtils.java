package com.tripify.demo.files.services;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.Arrays;

@Component
public class URIUtils {

    public static String buildURI(String ... pathes){
        ServletUriComponentsBuilder uriBuilder = ServletUriComponentsBuilder.fromCurrentContextPath();
        Arrays.stream(pathes).forEach(path -> uriBuilder.path("/").path(path));
        return uriBuilder.toUriString();
    }

}
