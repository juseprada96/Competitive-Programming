import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class permencryp {

	
	
	
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		String line ="";
		while(!(line = in.readLine()).equals("0")) {
			
			StringTokenizer tokens = new StringTokenizer(line);
			int keyLenght = Integer.parseInt(tokens.nextToken());
			int[] key = new int[keyLenght];
			int contador = 0;
			while(tokens.hasMoreTokens()) {
				key[contador] = Integer.parseInt(tokens.nextToken());
				contador++;
			}
			String message = in.readLine();
			char[] messageArray = message.toCharArray();
			char[] messageAnsw = new char[(messageArray.length+(keyLenght-(messageArray.length%keyLenght)))];
			if(messageArray.length%keyLenght == 0) {
				messageAnsw = new char[messageArray.length];
			}
			int interaciones = (int) Math.ceil((double)messageArray.length/(double)keyLenght);
			int nexPos = 0;
			for(int i=0;i<interaciones;i++) {
				for(int j=0;j<key.length;j++) {
					int newPos = i*keyLenght + key[j] -1;
					if(newPos<messageArray.length) {
						messageAnsw[nexPos] = messageArray[newPos];
					}else {
						messageAnsw[nexPos] = 32;
					}
					nexPos++;
				}
			}
			
			out.write("'"+new String(messageAnsw)+ "'\n");
		}
		out.flush();
		
		
	}
	
	
	
}
