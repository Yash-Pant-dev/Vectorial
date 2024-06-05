package QueryEngine;

import java.util.ArrayList;
import java.util.HashMap;

import Protocol.Command;
import Protocol.Operation;
import Protocol.Record;

public class Parser {

    public static Command parseCommand(String cmd) throws InvalidCommandException {
        String[] tokens = cmd.split(" ");

        if (tokens.length == 0) {
            throw new InvalidCommandException();
        }

        switch (tokens[0]) {
            case "TS":
                if (tokens.length != 2)
                    throw new InvalidCommandException();
                return new Command(Operation.TS, tokens[1]);

            case "RA":
                if (tokens.length != 2)
                    throw new InvalidCommandException();
                return new Command(Operation.RA, tokens[1]);

            default:
                throw new InvalidCommandException();
        }
    }

    public Record parseRecord(String str) {
        Record record = new Record();

        record.embedding = getEmbedding(str);
        record.metadata = getMetadata(str);

        return record;
    }

    private ArrayList<Float> getEmbedding(String str) {

        str = str.substring(str.indexOf('[') + 1, str.indexOf(']'));
        String[] tokens = str.split(",");

        ArrayList<Float> emb = new ArrayList<>();

        for (String token : tokens) {
            emb.add(Float.parseFloat(token));
        }

        return emb;
    }

    private HashMap<String, String> getMetadata(String str) {
        HashMap<String, String> metadata = new HashMap<>();

        str = str.substring(str.indexOf('{') + 1, str.indexOf('}'));
        String[] tokens = str.split(",");

        for (String token : tokens) {
            String[] pair = token.split("=");

            metadata.put(pair[0], pair.length == 1 ? "true" : pair[1]);
        }

        return metadata;
    }
}
