package QueryEngine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import Executor.ExecQueue;
import Protocol.Command;
import Util.Log;

public class QueryEngine implements Runnable {

    public void run() {
        try {
            handleQueries();
        } catch (Exception e) {
            Log.e("[Th][QH]: %s", e.getMessage());
        }
    }

    public void handleQueries() throws IOException, InterruptedException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String str = reader.readLine();

            try {
                Command command = Parser.parseCommand(str);
                ExecQueue.add(command);
            } catch (CommandException e) {
                Log.e("[QH] Command Exception:" + e.getMessage());
            }
        }
    }
}