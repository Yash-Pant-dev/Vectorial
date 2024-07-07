package Executor;

import java.io.IOException;

import Executor.Operations.Record;
import Executor.Operations.Similarity;
import Executor.Operations.Table;
import Protocol.Command;
import Protocol.Operations;
import QueryEngine.CommandException;
import Util.Log;

public class Executor implements Runnable {

    public void run() {
        try {
            while (true)
                execute();
        } catch (Exception e) {
            Log.e("[Th][Ex]: %s", e.getMessage());
        }
    }

    public static void execute() throws IOException, CommandException, InterruptedException {
        Command cmd = ExecQueue.next();
        if (cmd == null)
            return;

        switch (cmd.op) {
            case TA:
                Table.add((String) cmd.fields[0], (Integer) cmd.fields[1]);
                break;
            case TS:
                Table.select((String) cmd.fields[0]);
                break;
            case RA:
                Record.add((String) cmd.fields[0]);
                break;
            case DOT:
                Similarity.bestMatches(Operations.DOT, (String) cmd.fields[0], (Integer) cmd.fields[1]);
                break;
            default:
                throw new CommandException("Unknown op:" + cmd.op.toString());
        }
    }
}
