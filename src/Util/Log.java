package Util;

import Executor.ExecQueue;

public class Log {
    public static void i(String fmt, Object... any) {
        System.out.printf("%s--[I]" + fmt + "\n",
                ExecQueue.currentCommand != null ? ExecQueue.currentCommand.toString() : "0", any);
    }

    public static void w(String fmt, Object... any) {
        System.out.printf("%s--[W]" + fmt + "\n",
                ExecQueue.currentCommand != null ? ExecQueue.currentCommand.toString() : "0", any);
        f();
    }

    public static void e(String fmt, Object... any) {
        System.out.printf("%s--[E]" + fmt + "\n",
                ExecQueue.currentCommand != null ? ExecQueue.currentCommand.toString() : "0", any);
    }

    public static void f() {
        System.out.printf("%s--[F]\n", ExecQueue.currentCommand != null ? ExecQueue.currentCommand.toString() : "0");
    }
}
