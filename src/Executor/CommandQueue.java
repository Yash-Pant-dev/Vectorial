package Executor;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Queue;

import Protocol.Command;

public class CommandQueue {
    public static String table = "temp.vec";
    public static HashMap<String, Queue<Command>> queue = new HashMap<>();

    public static void add(Command cmd) {
        Queue<Command> tableQueue = queue.get(table);

        if (tableQueue == null) {
            tableQueue = new LinkedList<>();
            queue.put(table, tableQueue);
        }

        tableQueue.add(cmd);
    }

    public static Command next() {
        for (Entry<String, Queue<Command>> set: queue.entrySet()) {
            Command cmd = set.getValue().poll();

            if (cmd != null) {
                return cmd;
            }
        }
        
        return new Command(null);
    }
}
