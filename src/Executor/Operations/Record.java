package Executor.Operations;

import java.io.FileWriter;
import java.io.IOException;

import QueryEngine.Parser;
import Util.Log;

public class Record {
    public static void add(String str) throws IOException{
        Protocol.Record record = Parser.parseRecord(str);

        Integer dim = Table.storedTables.get(Table.currentTable);
        if (record.embedding.size() != dim) {
            Log.e("Mismatch in record and table dimensions: %s, %s resp.", record.embedding.size(), dim);
            return;
        }

        FileWriter fw = new FileWriter(Table.path(Table.currentTable), true);
        System.out.println(record.embedding.toString() + record.metadata.toString());
        fw.write(record.embedding.toString() + record.metadata.toString() + '\n');
        fw.close();

        Log.f();
    }
}
