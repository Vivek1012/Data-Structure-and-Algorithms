import java.util.*;

public class FirstNonRepeatingCharacter
{
  public static void main(String args[])
  {
    Scanner s = new Scanner(System.in);
    System.out.println("Enter the string A:");
    String A = s.next();

    HashMap<Character , Integer> hm = new HashMap<Character, Integer>();
    char ch[] = A.toCharArray();
    int n = ch.length;

    for(int i = 0 ; i < n ; i++)
    {
      if(hm.containsKey(ch[i]))
        hm.put(ch[i] , hm.get(ch[i])+1);
      else
        hm.put(ch[i] , 1);
    }

    for(int i = 0 ; i < n ; i++)
    {
      if(hm.get(ch[i]) == 1)
        {
          System.out.println("character " + ch[i] + " is the first non repeating Character!");
          break;
        }
    }
  }
}
