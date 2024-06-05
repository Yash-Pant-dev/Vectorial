package Protocol;

public class Command {
    public final Operation op;
    public final Object[] fields;
    
    public Command(Operation op, Object... fields) {
        this.op = op;
        this.fields = fields;
    }
}