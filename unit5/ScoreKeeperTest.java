public class ScoreKeeperTest
{
    public static void main(String[] args)
    {
        ScoreKeeper score = new ScoreKeeper();

        score.scoreNormal();
        score.scoreBonus();
        score.scoreBonus();

        System.out.println("My total is:" + score.getTotal());
        score.scoreBonus();
        System.out.println("My total is:" + score.getTotal());
    }
}

