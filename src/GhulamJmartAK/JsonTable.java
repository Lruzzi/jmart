package GhulamJmartAK;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.lang.reflect.Array;
import java.util.Collections;
import java.util.Vector;


public class JsonTable<T> extends Vector {
    public final String filepath;
    private static final Gson gson = new Gson();

    public JsonTable(Class<T> clazz, String filepath) throws IOException {
        this.filepath = filepath;
        try {
            Class<T[]> array = (Class<T[]>) Array.newInstance(clazz, 0).getClass();
            T[] hasil = JsonTable.readJson(array, filepath);
            Collections.addAll(this, hasil);

        } catch (FileNotFoundException e) {
            File file = new File(filepath);
        }
    }

    public static <T> T readJson (Class<T>clazz, String filepath) throws FileNotFoundException{
        T readerJson = null;
        try {
            final JsonReader readJson = new JsonReader(new FileReader(filepath));
            readerJson = gson.fromJson(readJson, clazz);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        return readerJson;
    }

    public void writeJson () throws IOException {
        writeJson(this, this.filepath);
    }

    public static void writeJson (Object object, String filepath) throws IOException {
        final FileWriter writer = new FileWriter(filepath);
        writer.write(gson.toJson(object));
        writer.close();
    }
}
