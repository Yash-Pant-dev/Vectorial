package QueryEngine;

import java.util.ArrayList;
import java.util.HashMap;

import Protocol.Command;
import Protocol.Operations;
import Protocol.Record;

public class Parser {

    public static Command parseCommand(String cmd) throws CommandException {
        String[] tokens = cmd.split(" ");

        if (tokens.length == 0) {
            throw new CommandException("0 Command tokens.");
        }

        switch (Operations.valueOf(tokens[0])) {
            case Operations.TA:
                if (tokens.length != 3)
                    throw new CommandException("Incorrect fields length for OP. Given: " + tokens);
                return new Command(Operations.TA, tokens[1], Integer.parseInt(tokens[2]));

            case Operations.TS:
                if (tokens.length != 2)
                    throw new CommandException("Incorrect fields length for OP. Given: " + tokens);
                return new Command(Operations.TS, tokens[1]);

            case Operations.RA:
                if (tokens.length != 2)
                    throw new CommandException("Incorrect fields length for OP. Given: " + tokens);
                return new Command(Operations.RA, tokens[1]);

            case Operations.DOT:
                if (tokens.length != 3)
                    throw new CommandException("Incorrect fields length for OP. Given: " + tokens);
                return new Command(Operations.DOT, tokens[1], Integer.parseInt(tokens[2])); 
            default:
                throw new CommandException("Operation not implemented yet: " + tokens);
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
