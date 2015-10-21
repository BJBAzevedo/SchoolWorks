import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
/**
 * Escreva a descrição da classe Escrita aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Escrita
{
    

 
    public static void main(String[] args) {
        try {
            FileWriter writer = new FileWriter("/Users/zecarlos/Test.txt", true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            int i;
            for(i=0;i<10000;i++){
                /*Vai Criar um ficheiro com 10000 linhas a dizer POO!!!**/
            bufferedWriter.write("POO!!!");
            bufferedWriter.newLine();
            }
           
 
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
 
    }
 
}
