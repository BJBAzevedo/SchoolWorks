
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
 
/**
 * Escreva a descrição da classe Leitura aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Leitura
{
    public static void main(String[] args) {
	BufferedReader br = null;
	try {
		String line;
		br = new BufferedReader(new FileReader("/Users/andrepinto/Desktop/lei-2-ano/LI3/GesthiperJava/Compras.txt"));
		while ((line = br.readLine()) != null) {
		   System.out.println(line);
		   StringTokenizer stringTokenizer = new StringTokenizer(line, "\n");
		   /*Vai ler a linha até ao \n**/
		   while (stringTokenizer.hasMoreElements()) {
		    String str = stringTokenizer.nextElement().toString();
			StringBuilder sb = new StringBuilder();
			sb.append("\nString lida é: " + str);
			System.out.println(sb.toString());
		   }
		}
		System.out.println("Sucesso!!!");
	} catch (IOException e) {
		e.printStackTrace();
	} finally {
		try {
			if (br != null)
				br.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
 }
}