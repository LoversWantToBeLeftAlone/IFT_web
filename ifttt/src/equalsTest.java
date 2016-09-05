import java.util.Scanner;

public class equalsTest {
	public static void main(String [] args){
		String s1,s2;
		@SuppressWarnings("resource")
		Scanner input=new Scanner(System.in);
		s1=input.nextLine();
		s2=input.nextLine();
		if(s1.equals(s2))
			System.out.println("----------------相等");
		if(!s1.equals(s2)){
			System.out.println("----------------不相等");
		}
	}
}
