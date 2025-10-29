public class OffByN implements CharacterComparator{
    public int coutn_minus;
    public OffByN(int N)
    {
        coutn_minus=N;
    }

    @Override
    public boolean equalChars(char x, char y) {
        if(Math.abs(x-y)==coutn_minus)
        {
            return true;
        }
        return false;
    }
}
