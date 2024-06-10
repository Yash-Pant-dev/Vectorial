package Executor.Operations;

import java.io.FileWriter;
import java.io.IOException;

import QueryEngine.Parser;

public class Record {
    public static void add(String str) throws IOException{
        Protocol.Record record = Parser.parseRecord(str);
        FileWriter fw = new FileWriter(Table.path(Table.currentTable), true);
        System.out.println(record.embedding.toString() + record.metadata.toString());
        fw.write(record.embedding.toString() + record.metadata.toString() + '\n');
        fw.close();
    }
}
