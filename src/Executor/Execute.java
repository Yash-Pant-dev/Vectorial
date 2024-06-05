package Executor;

import java.io.IOException;

import Protocol.Command;
import QueryEngine.InvalidCommandException;

public class Execute {
    public static String table = "temp.vec";
        // Implemented like a single threaded app for now.
    public static void exec() throws IOException, InvalidCommandException {
        Command cmd = CommandQueue.next();
        if (cmd == null)
            return;

        switch (cmd.op) {
            case TS:
                Table.add((String) cmd.fields[0], (Integer) cmd.fields[1]);
                break;

            default:
                throw new InvalidCommandException();
        }
    }

}
