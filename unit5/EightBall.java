public class EightBall
{
    public static String ask(String str)
	{
        int answer = (int)(Math.random() * 8) + 1;
        
        if (answer == 1)
        {
            return "The answer to the question you are looking for is yes.";
        }
        else if (answer == 2)
        {
            return "Yes.";
        }
        else if (answer == 3)
        {
            return "Maybe.";
        }
        else if (answer == 4)
        {
           return "The answer to the question you are looking for is no.";
        }
        else if (answer == 5)
        {
            return "Nope.";
        }
        else if (answer == 6)
        {
            return "Nope not really.";
        }
        else if (answer == 7)
        {
            return "Definitely not";
        }
        else if (answer == 8)
        {
            return "It may or may not be so.";
        }
        return "";
    }
}