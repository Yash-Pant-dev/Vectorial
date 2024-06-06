package Executor;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

import Protocol.Command;

public class ExecQueue {
    public static Command currentCommand;
    public static String currentTable = "temp.vec";
    
    public static Queue<Command> queue = new LinkedBlockingQueue<>();
    
    public static void add(Command cmd) {
        queue.add(cmd);
    }

    public static Command next() {
        currentCommand = queue.poll();
        return currentCommand;
    }
}
