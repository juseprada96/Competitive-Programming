import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class flexible {

	
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader in =new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		TreeSet<Integer> tamanos = new TreeSet<>();
		
		StringTokenizer t = new StringTokenizer(in.readLine());
		
		int max = Integer.parseInt(t.nextToken());
		int div = Integer.parseInt(t.nextToken());
		int[] nums = new int[div+2];
		
		t = new StringTokenizer(in.readLine());
		nums[0] = 0;
		nums[div+1] = max;
		for(int i=1; i<div+1;i++) {
			nums[i] = Integer.parseInt(t.nextToken());
		}
		
		for(int i=nums.length-1; i>=0;i--) {
			for(int j=0;j<nums.length;j++) {
				if(j!=i) {
					tamanos.add(nums[i]-nums[j]);
				}else {
				break;
				}
			}
		}
		String answ = "";
		
		for (int i : tamanos) {
			answ+=i + " ";
		}
		out.write(answ.trim());
		out.flush();
	}
	
	
}
