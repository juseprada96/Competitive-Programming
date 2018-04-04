import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class cross {

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		int[] col = new int[9];
		int[] row = new int[9];
		int[][] cross = new int[9][9];

		for (int i = 0; i < 9; i++) {
			String l = in.readLine();
			for (int j = 0; j < 9; j++) {
				if (l.charAt(j) != '.') {
					int n = l.charAt(j) - '0';
					cross[i][j] = n;
					if (col[n - 1] == 0) {
						col[n - 1] = 1 << j;
					} else {
						col[n - 1] = col[n - 1] | 1 << j;
					}
					if (row[n - 1] == 0) {
						row[n - 1] = 1 << i;
					} else {
						row[n - 1] = row[n - 1] | 1 << i;
					}
				}
			}
		}
		boolean change = true;
		boolean error = true;
		while(change) {
			boolean ciclo = true;
		for (int i = 0; i < 3 && error; i++) {
			for (int j = 0; j < 3 && error; j++) {
				int[] contador = new int[9];
				int[] pos = new int[9];
				for (int k = 0; k < 3; k++) {
					int fila = i * 3 + k;
					for (int l = 0; l < 3; l++) {
						int columna = j * 3 + l;
						if (cross[fila][columna] == 0) {
							for (int m = 0; m < 9; m++) {
								if ((col[m] & (1<<columna)) != 0 || (row[m] & (1<<fila)) != 0) {
									contador[m]++;
									if (pos[m] != 0) {
										pos[m] = pos[m] | 1<<(k*3 + l);
									} else {
										pos[m] = 1<<(k*3 + l);
									}
								}
							}
						} else {
							for (int m = 0; m < 9; m++) {
								if(cross[fila][columna] == m+1) {
									contador[m] += 9;
								}
								contador[m]++;
								if (pos[m] != 0) {
									pos[m] = pos[m] | 1<<(k*3 + l);
								} else {
									pos[m] = 1<<(k*3 + l);
								}
							}
						}
					}
				}
				boolean f = true;
				for(int k=0;k<9 && f;k++) {
					if(contador[k]==8) {
					for(int l=0;l<9;l++) {
						if((pos[k] & (1<<l))==0) {
							int fila = i*3+ l/3;
							int columna = j*3 + l%3;
							cross[fila][columna] = k+1;
							col[k] = col[k] | 1<< columna;
							row[k] = row[k] | 1<< fila;
							f=false;
							ciclo = false;
							break;
						}
					}
				}else if(contador[k]==9 || contador[k]>18) {
					out.write("ERROR");
					error = false;
					change = false;
					break;
				}
				}
			}
		}
		if(ciclo) {
			change = false;
		}
		}
		if(error) {
		for(int i=0;i<9;i++) {
			String l = "";
			for(int j=0;j<9;j++) {
				if(cross[i][j] == 0) {
					l+=".";
				}else {
					l+=cross[i][j]+"";
				}
			}
			out.write(l+"\n");
		}
		}
		out.flush();
	}

}
