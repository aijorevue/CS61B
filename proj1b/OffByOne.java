public class OffByOne implements CharacterComparator{

    public int abs(int x,int y)
    {
        if(x-y<0)
        {
            return -(x-y);
        }
        else
        {
            return x-y;
        }
    }
    @Override
    public boolean equalChars(char x,char y)
    {
        if(abs((int) x,(int)y)==1)
        {
            return true;
        }
        else{
            return false;
        }
    }
}
