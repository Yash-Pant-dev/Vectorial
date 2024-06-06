package Executor;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Table {
    public static String table = "temp.vec";
    public static void add(String name, Integer dimension) throws IOException, InterruptedException {
        File table = new File(path(name));

        if (!table.createNewFile()) {
            System.out.printf("Table already exists: %s\n", name);
            return;
        }

        FileWriter fw = new FileWriter(path(name));
        fw.write("VecDB--" + name + "--" + dimension + "--\n");
        fw.close();
    }

    public static String path(String str) {
        return "temp/" + str;
    }
}
