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
            throw new InvalidCommandException("No command passed");
        }

        switch (tokens[0]) {
            case "TA":
                if (tokens.length != 3)
                    throw new InvalidCommandException("Op TA requires 3 tokens");
                return new Command(Operation.TA, tokens[1], Integer.parseInt(tokens[2]));

            case "TS":
                if (tokens.length != 2)
                    throw new InvalidCommandException("Op TS requires 2 tokens");
                return new Command(Operation.TS, tokens[1]);

            case "RA":
                if (tokens.length != 2)
                    throw new InvalidCommandException("Op RA requires 2 tokens");
                return new Command(Operation.RA, tokens[1]);

            case "DOT":
                if (tokens.length != 3)
                    throw new InvalidCommandException("Op DOT requires 3 tokens");
                return new Command(Operation.DOT, tokens[1], Integer.parseInt(tokens[2])); 
            default:
                throw new InvalidCommandException("Unknown op:" + tokens[0]);
        }
    }

    public static Record parseRecord(String str) {
        Record record = new Record();

        record.embedding = getEmbedding(str);
        record.metadata = getMetadata(str);

        return record;
    }

    public static ArrayList<Float> getEmbedding(String str) {

        str = str.substring(str.indexOf('[') + 1, str.indexOf(']'));
        String[] tokens = str.split(",");

        ArrayList<Float> emb = new ArrayList<>();

        for (String token : tokens) {
            emb.add(Float.parseFloat(token));
        }
        
        return emb;
    }
    
    public static HashMap<String, String> getMetadata(String str) {
        HashMap<String, String> metadata = new HashMap<>();
        
        str = str.substring(str.indexOf('{') + 1, str.indexOf('}'));
        if (str.length() == 0) return metadata;

        String[] tokens = str.split(",");
        
        for (String token : tokens) {
            String[] pair = token.split("=");
            
            metadata.put(pair[0], pair.length == 1 ? null : pair[1]);
        }
        
        return metadata;
    }
}
