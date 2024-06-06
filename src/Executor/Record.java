package Executor;

import java.io.FileWriter;
import java.io.IOException;

import QueryEngine.Parser;

public class Record {
    public static void add(String str) throws IOException{
        Protocol.Record record = Parser.parseRecord(str);
        FileWriter fw = new FileWriter(Table.path(Table.table), true);
        System.out.println(record.embedding.toString() + record.metadata.toString());
        fw.write(record.embedding.toString() + record.metadata.toString() + '\n');
        fw.close();
    }
}
