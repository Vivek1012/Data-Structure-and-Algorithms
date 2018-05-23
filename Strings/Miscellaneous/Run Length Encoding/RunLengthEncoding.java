import java.util.*;

public class RunLengthEncoding
{
  public static void main(String args[])
  {
    Scanner s = new Scanner(System.in);
    System.out.println("Enter the string A:");
    String str = s.nextLine();
    char ch[] = str.toCharArray();
    int n = ch.length;

    Stack<Character> stack = new  Stack<Character>();
    String sret = "";


    for(int i = 0 ; i < n ; i++)
    {

      if(stack.isEmpty() || (stack.peek() == ch[i]))
      {
        stack.push(ch[i]);
      }
      else if(stack.peek() != ch[i] && !stack.isEmpty())
      {
        sret = sret + stack.peek() + "" + stack.size();
        stack.clear();
        stack.push(ch[i]);
      }
    }

    if(!stack.isEmpty())
      sret += stack.peek() + "" + stack.size();
    System.out.println(sret);
  }
}
