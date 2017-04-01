/**
 * Created by Joshua on 2017/3/12.
 */
import java.lang.Math;

public class OffByOne implements CharacterComparator {

    @Override
    public boolean equalChars(char x, char y) {
        return Math.abs(x - y) == 1;
    }
}
