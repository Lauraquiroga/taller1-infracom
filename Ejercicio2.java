import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//Ejercicio taller 1A implementando la interfaz Runnable en Java

public class Ejercicio2 implements Runnable{
	
	private static int superior;
	private static int n;
	private String name;
	
	public Ejercicio2(String name) {
		System.out.println("Implementando la interfaz Runnable.");
		this.name = name;
	}
	public void run() {
		try {
			for (int i=1; i<=superior; i++) {
				if (name=="Thread pares" && i%2==0) {
					System.out.println(name + " valor: " + i);
					Thread.sleep(n);
				}
				else if (name=="Thread impares" && i%2==1) {
					System.out.println(name + " valor: " + i);
					Thread.sleep(n);
				}
				
			}
		}
		catch (Exception e) {}
		
		System.out.println("Saliendo: " + name);
	}
	
	public static void main (String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader (new InputStreamReader(System.in));
		System.out.println("Por favor ingrese el límite superior.");
		String entrada = reader.readLine();
		superior = Integer.parseInt(entrada);
		System.out.println("Limite superior: " + superior);
		
		n=50;
		Thread t1 = new Thread (new Ejercicio2 ("Thread pares"));
		Thread t2 = new Thread (new Ejercicio2 ("Thread impares"));
		
		t1.start();
		t2.start();
	}
}