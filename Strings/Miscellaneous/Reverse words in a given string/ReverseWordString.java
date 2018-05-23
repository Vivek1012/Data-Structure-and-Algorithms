import java.util.*;

public class ReverseWordString
{
  public static void main(String args[])
  {
    Scanner s = new Scanner(System.in);
    System.out.println("Enter the string A:");
    String str = s.nextLine();

    String ss[] = str.split(" ");
    int n = ss.length;

    for(int i = 0 ; i < n/2 ; i++)
    {
        String temp = ss[i];
        ss[i] = ss[n-i-1];
        ss[n-i-1] = temp;
    }

    for(int i = 0 ; i < n ; i++)
    {
      System.out.print(ss[i] + " ");
    }
  }
}
