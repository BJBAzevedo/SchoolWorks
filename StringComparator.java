import java.util.Comparator;
import java.io.Serializable;

/**
 * Escreva a descrição da classe StringComparator aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class StringComparator implements Comparator<String>,Serializable
{
    
    public int compare (String s1, String s2){
        return s1.compareTo(s2);
    }
}
