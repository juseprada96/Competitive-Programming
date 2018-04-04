import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class secret {

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(in.readLine());

		while (n > 0) {

			String m = in.readLine();

			int square = (int) Math.ceil(Math.sqrt(m.length()));
			int total = square * square;
			int r = ((total - m.length()) / square);
			total -= r * square;
			StringBuilder[] answs = new StringBuilder[square];
			for(int i=0;i<answs.length;i++) {
				answs[i] = new StringBuilder(square);
			}
			for (int j = 0; j < square - r; j++) {
				for (int i = square; i > 0; i--) {
					int next = (total - i) - square * j;
					if (next < m.length()) {
						int pos = square-i;
						answs[pos].append(m.charAt(next)+"");
					}
				}
			}
			StringBuilder answ = new StringBuilder(m.length());
			for(int i=0;i<answs.length;i++) {
				answ.append(answs[i]);
			}
			String a = new String(answ.toString());
			out.write(a + "\n");
			n--;
		}
		out.flush();
	}

}
