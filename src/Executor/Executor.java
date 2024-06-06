package Executor;

import java.io.IOException;

import Protocol.Command;
import QueryEngine.InvalidCommandException;

public class Executor implements Runnable {
    

    public void run() {
        try {
            while (true)
                exec();
        } catch (Exception e) {
            System.out.println("[E] Execute -" + e.getMessage());
        }
    }

    public static void exec() throws IOException, InvalidCommandException, InterruptedException {
        Command cmd = ExecQueue.next();
        if (cmd == null)
            return;
        
        switch (cmd.op) {
            case TA:
                Table.add((String)cmd.fields[0], (Integer) cmd.fields[1]);
                break;
            case TS:
                Table.table = (String) cmd.fields[0];
                break;
            case RA:
                Record.add((String) cmd.fields[0]);
                break;
            case DOT:
                Similarity.bestMatches(cmd.op, (String)cmd.fields[0], (Integer)cmd.fields[1]);
            default:
                throw new InvalidCommandException("Unknown op:" + cmd.op.toString());
        }

        ExecQueue.queue.remove();
    }
}
