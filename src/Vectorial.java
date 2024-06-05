import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import Executor.CommandQueue;
import Executor.Execute;
import Protocol.Command;
import Protocol.Operation;
import QueryEngine.InvalidCommandException;
import QueryEngine.Parser;

public class Vectorial {

    static final String version = "0.1.0";

    public static void main(String[] args) throws IOException {
        System.out.printf("Vectorial v%s\n", version);
        System.out.println("---- QueryEngine:");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String str = reader.readLine();
            try {
                Command command = Parser.parseCommand(str);

                if (command.op == Operation.TS) {
                    CommandQueue.table = (String)command.fields[0];
                    continue;
                }

                CommandQueue.add(command);
                Execute.exec();
            }
            catch (InvalidCommandException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}