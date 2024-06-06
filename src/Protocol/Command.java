package Protocol;

public class Command {
    public static Integer counter = 1;
    public final Operation op;
    public final Object[] fields;
    public final Integer id;
    public Command(Operation op, Object... fields) {
        this.op = op;
        this.fields = fields;
        this.id = counter++;
    }
}