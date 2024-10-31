public class RectangleTest
{
    public static void main(String[] args)
    {
        Rectangle r = new Rectangle(5, 10);
        System.out.println("area: " + r.area());
        System.out.println("perimeter: " + r.perimeter());


        Rectangle h = new Rectangle(10, 10);
        System.out.println("area: " + h.area());
        System.out.println("perimeter: " + h.perimeter());
    }
}