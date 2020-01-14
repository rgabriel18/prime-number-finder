package com.gabriel.challenge.sequencefinder.utils;

import java.io.File;
import java.net.URL;
import java.nio.file.Path;

public class ResourceManipulator {

    public Path getPathToResource(String resourceName) {
        ClassLoader loader = getClass().getClassLoader();
        URL resource = loader.getResource(resourceName);

        File file = new File(resource.getFile());

        return file.toPath();
    }
}
