import java.util.*;
/**
 * Classe CatalogoProdutos
 * 
 * @author Grupo 77 LEI 
 * @version 1.0 20/05/2015
 */
public class CatalogoProdutos
{
    // variáveis de instância
    private TreeSet<Codigo> catalogo;
    private int numProd;

    public CatalogoProdutos( ){
        this.numProd = 0 ;
        this.catalogo = new TreeSet<Codigo>(new CodigoComparator());
    }
    public CatalogoProdutos(int n,TreeSet<Codigo> ts){
        this.numProd = n;
        this.catalogo = new TreeSet<Codigo>(new CodigoComparator());
        Iterator<Codigo> it = ts.iterator();
        while (it.hasNext()){
            this.catalogo.add(it.next().clone());
        } 
    }
    public CatalogoProdutos(CatalogoProdutos x){
        this.numProd  = x.getNumProd();
        TreeSet<Codigo> novoCatalogo = x.getCatalogo();
        Iterator<Codigo> it = novoCatalogo.iterator();
        while (it.hasNext()){
            this.catalogo.add(it.next().clone());
        }
    }
    
    
    
    public int getNumProd(){
        return this.numProd;
    }
    
    
    public TreeSet<Codigo> getCatalogo (){
        TreeSet<Codigo> novoCatalogo = new TreeSet<Codigo>(new CodigoComparator());
        Iterator<Codigo> it = this.catalogo.iterator();
        while (it.hasNext()){
            novoCatalogo.add(it.next().clone());
        }
        return novoCatalogo;
    }
    
    
    public ArrayList<String> getListaProdutos(){
        ArrayList<String> novoArray = new ArrayList<String>();
        Iterator<Codigo> it = this.catalogo.iterator();
        while (it.hasNext()){
            novoArray.add(it.next().getCodigo());
        }
       Collections.sort(novoArray, new StringComparator());
       return novoArray;
    }


    public void addProduto (String novoProduto){
        catalogo.add(new Codigo(novoProduto));
        numProd++;
    }
    public void cleanCatalogo(){
        catalogo.clear();
        numProd = 0;
    }



    public boolean existeProduto(Codigo c){
        if (this.catalogo.contains(c)) return true;
        else return false;
    }

    
    public String toString (){
        return this.catalogo.toString();
    }
    
    public boolean equals(Object obj){
      if(this == obj) return true; 
      if((obj == null) || (this.getClass() != obj.getClass())) return false;
      CatalogoProdutos c = (CatalogoProdutos) obj;
      return this.catalogo.equals(c.getCatalogo());
    }
    
    public CatalogoProdutos clone(){
        return new CatalogoProdutos(this);
    }
}