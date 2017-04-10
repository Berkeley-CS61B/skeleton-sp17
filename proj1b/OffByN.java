/**
 * Created by Xiao Shi on 2017/4/10.
 */
public class OffByN implements CharacterComparator {
    private int difference;

    public OffByN (int n) {
        difference = n;
    }

    @Override
    public boolean equalChars (char x, char y) {
        return (x - y) == difference || (y - x) == difference;
    }
}
