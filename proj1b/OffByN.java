/**
 * Created by Joshua on 2017/3/12.
 */
public class OffByN implements CharacterComparator {

    /**
     * The abs value of two char
     */
    private int n;

    public OffByN(int n) {
        this.n = n;
    }

    @Override
    public boolean equalChars(char x, char y) {
        return Math.abs(x -y) == n;
    }
}
