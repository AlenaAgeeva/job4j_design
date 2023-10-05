package ru.job4j.gc.cache;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;

public class DirFileCache extends AbstractCache<String, String> {

    private final String cachingDir;

    public DirFileCache(String cachingDir) {
        this.cachingDir = cachingDir;
    }

    @Override
    protected String load(String key) {
        StringBuilder content = new StringBuilder();
        try {
            Files.lines(Path.of(cachingDir, key)).forEach(l -> {
                if (l != null) {
                    content.append(l).append(System.lineSeparator());
                }
            });
        } catch (NoSuchFileException e) {
            System.out.println("This file doesn't exists, so it will be put in the cache with an empty context.");

        } catch (IOException e) {
            e.printStackTrace();
        }
        return content.toString();
    }
}
