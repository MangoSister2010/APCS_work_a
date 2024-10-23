public class ScoreKeeper
{
    public ScoreKeeper()  // note: constructor has no return type
    {
        total = 0;
    }

    public void scoreNormal()
    {
        total += 100;
    }

    public void scoreBonus()
    {
        total += 1000;
    }
    public int getTotal()
    {
        return total;
    }

    private int total;
}