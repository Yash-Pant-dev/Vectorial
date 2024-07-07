package Executor.Operations;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.SortedSet;
import java.util.TreeSet;

import Protocol.Operations;
import QueryEngine.Parser;
import Util.Log;

public class Similarity {

    public static void bestMatches(Operations op, String rec, Integer limit) throws FileNotFoundException, IOException {
        Protocol.Record baseRecord = Parser.parseRecord(rec);
        SortedSet<Match> bestMatches = new TreeSet<>();

        BufferedReader br = new BufferedReader(new FileReader(Table.path(Table.currentTable)));
        Log.i(br.readLine()); // Read away the first file metadata line. 

        while (true) {
            String recStr = br.readLine();
            if (recStr == null) {
                br.close();
                break;
            }

            Protocol.Record record = Parser.parseRecord(recStr);
            Boolean metadataMatch = filter(record.metadata, baseRecord.metadata);
            if (!metadataMatch)
                continue;

            Float score = 0.0f;
            switch (op) {
                case DOT:
                    score = dot(record.embedding, baseRecord.embedding);
                    break;
                default:
                    break;
            }

            if (bestMatches.size() < limit) {
                bestMatches.add(new Match(score, record));
                continue;
            }

            if (score > bestMatches.first().score) {
                bestMatches.removeFirst();
                bestMatches.add(new Match(score, record));
            }
        }

        bestMatches.forEach(match -> Log.i(
                match.score.toString() + match.record.embedding.toString() + match.record.metadata.toString()));

        Log.f();
    }

    public static Float dot(ArrayList<Float> emb, ArrayList<Float> baseEmb) {
        Float value = 0.0f;
        for (int i = 0; i < emb.size(); i++) {
            value += emb.get(i) * baseEmb.get(i);
        }
        return value;
    }

    public static Boolean filter(HashMap<String, String> metadata, HashMap<String, String> baseMetadata) {
        
        for (Entry<String, String> set : baseMetadata.entrySet()) {
            if (set.getValue() == null && !metadata.containsKey(set.getKey()))
                return false;
            if (set.getValue() != null && !set.getValue().equals(metadata.get(set.getKey())))
                return false;
        }

        return true;
    }
}
