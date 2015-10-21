
/**
 * Classe CodigoComparator
 * 
 * @author Grupo 77 LEI
 * @version 1.0 20/05/2015
 */

import java.util.Comparator;
import java.io.Serializable;
public class CodigoComparator implements Comparator<Codigo>,Serializable
{
    
    public int compare (Codigo c1, Codigo c2){
        return -(c1.getCodigo().compareTo(c2.getCodigo()));
    }
}