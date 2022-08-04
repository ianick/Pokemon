package com.pokemon.bellTest.util;



import org.springframework.core.io.Resource;

import java.io.IOException;
import java.nio.file.Files;

public class Utils {

    public static String getContentFile(Resource resource) {
        try {
            return new String(Files.readAllBytes(resource.getFile().toPath()));
        } catch (IOException e) {
            return null;
        }
    }
}
