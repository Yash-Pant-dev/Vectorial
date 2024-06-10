package Protocol;

public class Command {
    public static Integer counter = 0;
    public final Operations op;
    public final Object[] fields;
    public final Integer id;
    public Command(Operations op, Object... fields) {
        this.op = op;
        this.fields = fields;
        this.id = ++counter;
    }

    @Override
    public String toString() {
        if (this.equals(null)) {
            return "0";
        }
        return counter.toString();
    }
}