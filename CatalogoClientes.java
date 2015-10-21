import java.util.*;
/**
 * Classe CatalogoClientes
 * 
 * @author Grupo 77 LEI 
 * @version 1.0 20/05/2015
 */
public class CatalogoClientes
{
    // variáveis de instância
    private TreeSet<Codigo> catalogo;
    private int numClie;

    public CatalogoClientes( ){
        this.numClie = 0;
        this.catalogo = new TreeSet<Codigo>(new CodigoComparator());
    }
    
    public CatalogoClientes(int n, TreeSet<Codigo> ts){
        this.numClie = n;
        this.catalogo = new TreeSet<Codigo>(new CodigoComparator());
        Iterator<Codigo> it = ts.iterator();
        while (it.hasNext()){
            this.catalogo.add(it.next().clone());
        } 
    }
    public CatalogoClientes(CatalogoClientes x){
        this.numClie = x.getNumClie();
        this.catalogo = new TreeSet<Codigo>(new CodigoComparator());
        Iterator<Codigo> it = x.getCatalogo().iterator();
        while (it.hasNext()){
            this.catalogo.add(it.next().clone());
        } ;
    }
    
    
    //getters & setters
    public int getNumClie(){
        return this.numClie;
    }
    
    public TreeSet<Codigo> getCatalogo (){
        TreeSet<Codigo> novoCatalogo = new TreeSet<Codigo>(new CodigoComparator());
        Iterator<Codigo> it = this.catalogo.iterator();
        while (it.hasNext()){
            novoCatalogo.add(it.next().clone());
        }
        return novoCatalogo;
    }
    public ArrayList<String> getListaClientes(){
        ArrayList<String> novoArray = new ArrayList<String>();
        Iterator<Codigo> it = this.catalogo.iterator();
        while (it.hasNext()){
            novoArray.add(it.next().getCodigo());
        }
       Collections.sort(novoArray, new StringComparator());
       return novoArray;
    }


    public void addCliente (String novoCliente){
        catalogo.add(new Codigo(novoCliente));
        numClie++;
    }
    public void cleanCatalogo(){
        catalogo.clear();
        numClie = 0;
    }


    public boolean existeCliente(Codigo c){
        if (this.catalogo.contains(c)) return true;
        else return false;
    }
    
    public String toString (){
        return this.catalogo.toString();
    }
    
    public boolean equals(Object obj){
      if(this == obj) return true; 
      if((obj == null) || (this.getClass() != obj.getClass())) return false;
      CatalogoClientes c = (CatalogoClientes) obj;
      return this.catalogo.equals(c.getCatalogo()) ;
    }
    
    public CatalogoClientes clone(){
        return new CatalogoClientes(this);
    }
}