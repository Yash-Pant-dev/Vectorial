package Util;

import Executor.ExecQueue;

public class Log {
    public static void i(String fmt, Object... any) {
        System.out.printf("%d--[I]" + fmt + "\n", ExecQueue.currentCommand.toString(), any);
    }

    public static void w(String fmt, Object... any) {
        System.out.printf("%d--[W]" + fmt + "\n", ExecQueue.currentCommand.toString(), any);
        f();
    }

    public static void e(String fmt, Object... any) {
        System.out.printf("%d--[E]" + fmt + "\n", ExecQueue.currentCommand.toString(), any);
    }

    public static void f() {
        System.out.printf("%d--[F]\n", ExecQueue.currentCommand.toString());
    }
}
