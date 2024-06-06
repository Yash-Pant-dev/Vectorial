import java.io.IOException;

import Executor.Executor;
import QueryEngine.QueryEngine;

public class Vectorial {

    static final String version = "0.1.0";

    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.printf("Vectorial v%s\n", version);
        System.out.println("---- QueryEngine:");

        new Thread(new Executor()).start();
        new Thread(new QueryEngine()).start();
    }
}