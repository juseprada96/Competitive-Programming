import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class bestrelayteam {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(in.readLine());
		
		ArrayList<corredor> first = new ArrayList<>();
		ArrayList<corredor> second = new ArrayList<>();
		
		while(n>0) {
			StringTokenizer t = new StringTokenizer(in.readLine());
			String name = t.nextToken();
			double a = Double.parseDouble(t.nextToken());
			double b = Double.parseDouble(t.nextToken());
			corredor p = new corredor(a,name);
			corredor s = new corredor(b,name);
			first.add(p);
			second.add(s);
			n--;
		}
		Collections.sort(first);
		Collections.sort(second);
		
		int mj = 0;
		double total = Double.MAX_VALUE;
		for(int i=0;i<4;i++) {
			corredor c = first.get(i);
			double comp = first.get(i).velocidad;
			int add = 0;
			for(int j=0;j<3+add;j++) {
				if(first.get(i).equals(second.get(j))) {
					add++;
				}else {
					comp+=second.get(j).velocidad;
				}
			}
			if(comp<total) {
				mj = i;
				total = comp;
			}
		}
		ArrayList<corredor> answ = new ArrayList<>();
		answ.add(first.get(mj));
		for(int i=0;i<4;i++) {
			if(!first.get(mj).equals(second.get(i))) {
				answ.add(second.get(i));
			}
		}
		out.write(total+"\n");
		for(int i=0;i<4;i++) {
			out.write(answ.get(i).nombre+"\n");
		}
		out.flush();
	}
	
	
}

class corredor implements Comparable<corredor>{
	
	double velocidad;
	String nombre;
	@Override
	public int compareTo(corredor arg0) {
		if(velocidad>arg0.velocidad) {
			return 1;
		}else if(velocidad<arg0.velocidad) {
			return -1;
		}
		return 0;
	}
	corredor(double velocidad, String nombre){
		this.velocidad = velocidad;
		this.nombre = nombre;
	}
	@Override
	public boolean equals(Object other) {
		if(other == null) return false;
		if(other instanceof corredor) {
			corredor c = (corredor) other;
		if(nombre.equals(c.nombre)) {
			return true;
		}
		return false;
	}else {
		return false;
	}
	
}
}
