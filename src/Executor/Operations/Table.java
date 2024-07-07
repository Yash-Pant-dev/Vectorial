package Executor.Operations;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

import Util.Log;

public class Table {
    public static String currentTable;

    public static HashMap<String, Integer> storedTables = new HashMap<>();

    public static void load() {
        File folder = new File(path(""));
        File[] localTables = folder.listFiles(name -> name.getName().endsWith(".vec"));

        for (File table : localTables) {
            String name = table.getName();
            Integer dim;

            try {
                BufferedReader br = new BufferedReader(new FileReader(path(name)));
                String info = br.readLine();
                dim = Integer.parseInt(info.split("--")[2]);

                storedTables.put(name, dim);
                br.close();
            } catch (Exception e) {
                Log.w("[TableOp] Failed to add table: %s. Reason: %s", name, e.getMessage());
            }

        }

        Log.f();
    }

    public static void add(String name, Integer dimension) throws IOException, InterruptedException {
        File file = new File(path(name));

        if (!file.createNewFile()) {
            Log.e("Table already exists: %s\n", name);
            return;
        }

        FileWriter fw = new FileWriter(path(name));
        fw.write("VecDB--" + name + "--" + dimension + "--\n");
        fw.close();
        storedTables.put(name, dimension);
        Log.f();
    }

    public static void select(String name) {
        if (storedTables.containsKey(name)) {
            currentTable = name;
            Log.f();
            return;
        }

        Log.e("Table not found: %s", name);
    }

    public static String path(String str) {
        return "temp/" + str;
    }
}
