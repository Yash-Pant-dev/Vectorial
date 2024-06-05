package Executor;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Table {

    public static void add(String name, Integer dimension) throws IOException {
        System.out.println("nf");
        File table = new File(name);
        System.out.println(table.getAbsolutePath());
        if (!table.createNewFile()) {
            System.out.printf("Table already exists: %s\n", name);
            return;
        }

        FileWriter fw = new FileWriter(name);
        fw.write("--" + name + "--" + dimension + "--\n");
        fw.close();
    }

    public static String path(String str) {
        return "storage/" + str;
    }
}
