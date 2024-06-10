package Executor.Operations;

public class Match implements Comparable<Match> {
    public final Float score;
    public final Protocol.Record record;

    public Match(Float score, Protocol.Record record) {
        this.score = score;
        this.record = record;
    }

    @Override
    public int compareTo(Match a) {
        if (a.score > this.score)
            return -1;
        return 1;
    }
}