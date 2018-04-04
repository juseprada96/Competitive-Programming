import java.util.Scanner;

public class judgingmoose {

	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int a = in.nextInt();
		int b = in.nextInt();
		if(a == b && a == 0) {
			System.out.println("Not a moose");
		}else
		if(a == b) {
			int answ = a*2;
			System.out.println("Even " + answ);
		}else {
			int answ = Math.max(a, b)*2;
			System.out.println("Odd "+ answ);
		}
	}
	
}
