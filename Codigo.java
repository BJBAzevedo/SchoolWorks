
/**
 * Classe Codigo
 * 
 * @author Grupo 77 LEI 
 * @version 1.0 20/05/2015
 */
public class Codigo implements Comparable<Codigo>
{
    // variáveis de instância
    private String codigo;
    
    public Codigo( ){
        this.codigo = "N/A";
    }
    public Codigo(String a ){
        this.codigo = a;
    }
    public Codigo(Codigo x){
        setCodigo(x.getCodigo());
    }
    
    public void setCodigo (String x){
        this.codigo = x;
    }
    
    public String getCodigo (){
        return this.codigo;
    }
    
    public int compareTo(Codigo c){
        if (this.codigo.equals(c.getCodigo())) return 1;
        else return -1;
    }
    
    public String toString (){
        return this.codigo;
    }
    
    public boolean equals(Object obj){
      if(this == obj) return true; 
      if((obj == null) || (this.getClass() != obj.getClass())) return false;
      Codigo c = (Codigo) obj;
      return this.codigo.equals(c.getCodigo()) ;
    }
    
    public Codigo clone(){
        return new Codigo(this);
    }
}