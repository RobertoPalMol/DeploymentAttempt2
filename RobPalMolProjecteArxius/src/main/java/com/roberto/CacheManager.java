package com.roberto;

import com.roberto.POJO.Data;

import java.io.*;

public class CacheManager {

    public static void guardarCache(Object object) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("src/main/resources/web/cache.dat"))) {
            out.writeObject(object);
        }
    }

    public static Data cargarCache() throws IOException, ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("src/main/resources/web/cache.dat"))) {
            return (Data) in.readObject();
        }
    }
}
