/**Descripción: Clase Cesar la cual encripta y desencripta mensajes
  Alumno: Oscar Fernández Durán
  Fecha: 23/03/19
*/
import java.util.Scanner;
public class Cesar {
	protected char[] original=new char[91];//Arreglo original
	protected char[] encriptar = new char[original.length];	// Arreglo encriptamiento
	protected char[] descifrar = new char[original.length];	// Arreglo desciframiento
	/** Constructor para inicializar los arreglos, original, de encriptamiento y
	 * desciframiento */
	public Cesar() {
		for(int a=0;a<original.length;a++)
                        original[a]=(char)(' '+a); //creación del arreglo original con ayuda del UNICODE.
		for (int i=0; i<original.length; i++) 
			encriptar[i] = original[((i + (10+i))) % original.length]; // rotar alfabeto 3 lugares
		for (int i=0; i<original.length; i++) 
			descifrar[encriptar[i]-' '] = original[i]; // descifrar inverso a encriptar
	}
	/** Método de encriptamiento */
	public String encriptar(String secreto) {
		char[] mensj = secreto.toCharArray(); // arreglo mensaje
		for (int i=0; i<mensj.length; i++){    // ciclo de encriptamiento
			for(int l=0; l<original.length;l++){
				if(mensj[i]==original[l]){ //verifica que si se puede ralizar el encriptado
					mensj[i] = encriptar[mensj[i] - ' ']; // usar letra como índice
					l=10000;
				}
			}
		}
		return new String(mensj);
	}
	/** Método de desciframiento */
	public String descifrar(String secreto) {
		secreto=secreto.replace('{',' '); 
		char[] mensj = secreto.toCharArray();		 // arreglo mensaje
		for (int i=0; i<mensj.length; i++){			 // ciclo desciframiento
			for(int l=0;l<original.length;l++){
                                if(mensj[i]==original[l]){ //verifica que si se puede ralizar el encriptado 
					mensj[i] = descifrar[mensj[i] - ' '];	 // usar letra como índice
					l=10000;
				}
			}
		}
		return new String(mensj);
	}
	/** Metodo main para probar el cifrador de César */
	public static void main(String[] args) {
		Cesar cifrador = new Cesar(); // Crear un objeto cifrado de César
		Scanner entr=new Scanner(System.in);
		int h=0;
		while(h==0){
			System.out.println("E para encriptar o D para desencriptar: ");
			char ch=entr.nextLine().charAt(0);
			ch=Character.toUpperCase(ch);
			if(ch=='E'){ //parte de encriptar en el método main 
				System.out.println("Ingrese el mensaje que quiere encriptar: ");
				String secreto = entr.nextLine(); 
				secreto = cifrador.encriptar(secreto);
                		System.out.println();
                		secreto=secreto.replace(' ','{');
                		System.out.println("Mensaje encriptado: "+secreto);
				h++;
	     		}
			else if(ch=='D'){ //Parte de desencriptar en el método main
				System.out.print("Ingrese el mensaje que quiere desencriptar: ");
				String secreto = entr.nextLine(); 
				System.out.println();
				secreto = cifrador.descifrar(secreto);
				System.out.println("Mensaje original: "+secreto);
				h++;
			}
		}
	}
}
