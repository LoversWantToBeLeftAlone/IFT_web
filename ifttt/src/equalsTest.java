import java.util.Scanner;

public class equalsTest {
	public static void main(String [] args){
		String s1,s2;
		@SuppressWarnings("resource")
		Scanner input=new Scanner(System.in);
		s1=input.nextLine();
		s2=input.nextLine();
		if(s1.equals(s2))
			System.out.println("----------------���");
		if(!s1.equals(s2)){
			System.out.println("----------------�����");
		}
	}
}
