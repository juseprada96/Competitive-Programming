import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;


public class collatz {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		String line = "";

		while (!(line = in.readLine()).equals("0 0")) {
			StringTokenizer tk = new StringTokenizer(line);

			long a = Long.parseLong(tk.nextToken());
			long b = Long.parseLong(tk.nextToken());
			long auxa = a;
			long auxb = b;
			HashMap<Long, Integer> primerIte = new HashMap<>();
			HashMap<Long, Integer> segundaIte = new HashMap<>();
			int contador = 0;
			while (true) {
				if(primerIte.get(auxa) == null)
				primerIte.put(auxa, contador);
				if(segundaIte.get(auxb) == null)
				segundaIte.put(auxb, contador);
				
				if (primerIte.get(auxb) != null || segundaIte.get(auxa) != null)
					break;
				if (auxa % 2 == 0 && auxa != 1)
					auxa /= 2;
				else if (auxa != 1)
					auxa = auxa * 3 + 1;
				if (auxb % 2 == 0 && auxb != 1)
					auxb /= 2;
				else if (auxb != 1)
					auxb = auxb * 3 + 1;
				contador++;
			}
			if (primerIte.get(auxb) == null) {
				out.write(a + " needs " + primerIte.get(auxa) + " steps, " + b + " needs " + segundaIte.get(auxa)
						+ " steps, they meet at " + auxa + "\n");
			} else {
				out.write(a + " needs " + primerIte.get(auxb) + " steps, " + b + " needs " + segundaIte.get(auxb)
						+ " steps, they meet at " + auxb + "\n");
			}
		}

		out.flush();
	}

}
