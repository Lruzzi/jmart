package com.GhulamJmartAK;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.*;
import java.lang.reflect.Array;
import java.util.Collections;
import java.util.Vector;


public class JsonTable<T> extends Vector {
    public final String filepath;
    private static final Gson gson = new Gson();

    public JsonTable(Class<T>clazz, String filepath) throws IOException {
        this.filepath = filepath;
        try{
            @SuppressWarnings("unchecked")
            Class<T[]> array = (Class<T[]>) Array.newInstance(clazz, 0).getClass();
            T[] newArr = JsonTable.readJson(array, filepath);
            Collections.addAll(this, newArr);
        }catch (FileNotFoundException e){
            File file = new File(filepath);
            File parent = file.getParentFile();
            parent.mkdirs();
            file.createNewFile();
        }
    }

    public static <T> T readJson (Class<T> clazz, String filepath) throws IOException {
        JsonReader read = new JsonReader(new FileReader(filepath));
        T reader = gson.fromJson(read, clazz);
        return reader;
    }


    public void writeJson () throws IOException{
        writeJson(this, this.filepath);
    }

    public static void writeJson (Object object, String filepath) throws IOException{
        FileWriter writer = new FileWriter(filepath);
        writer.write(gson.toJson(object));
        writer.close();
    }
}
