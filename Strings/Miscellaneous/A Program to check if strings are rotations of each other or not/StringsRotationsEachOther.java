import java.util.*;

public class StringsRotationsEachOther
{
  public static void main(String args[])
  {
    Scanner s = new Scanner(System.in);
    System.out.println("Enter the string A:");
    String A = s.next();

    System.out.println("Enter the string B:");
    String B = s.next();

    String AA = A + A;

    int index = AA.indexOf(B);

    if(index > 0)
    {
      System.out.println("The string B is rotation of String A:");
    }
    else
      System.out.println("The string B is not a rotation of String A:");
  }

}
