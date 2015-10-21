import java.util.*;
/**
 * Classe ConjuntoCompras
 * 
 * @author Grupo 77 LEI 
 * @version 1.0 20/05/2015
 */
public class ConjuntoCompras
{
    // variáveis de instância
    private Codigo codigo;
    private TreeMap<Codigo,Compra> compras;


    //construtores

    public ConjuntoCompras(){
        this.codigo = new Codigo();
        this.compras = new TreeMap<Codigo,Compra>();
    }
    public ConjuntoCompras(Codigo cod, TreeMap<Codigo,Compra> tmp, TreeMap<Codigo,Compra> tmc){
        this.codigo = new Codigo(cod);
        this.compras = new TreeMap<Codigo,Compra>();
        for (Compra c : tmp.values())
            this.compras.put(c.getCodigo(),c.clone());
    }

    public ConjuntoCompras(Codigo cod, TreeSet<Codigo> tree){
        this.codigo = new Codigo(cod);
        this.compras = new TreeMap<Codigo,Compra>();
        for (Codigo c : tree)
            this.compras.put(c.clone(),new Compra(c));

    }

    public ConjuntoCompras(Codigo cod){
        this.codigo = new Codigo(cod);
        this.compras = new TreeMap<Codigo,Compra>();
    }


    public ConjuntoCompras(ConjuntoCompras x){
        this.codigo = new Codigo(x.getCodigo());
        TreeMap<Codigo,Compra> y = x.getCompras();
        this.compras = new TreeMap<Codigo,Compra>();
        for (Compra c : y.values())
            this.compras.put(c.getCodigo(),c.clone());
    }
    

    //getters & setters

    public Codigo getCodigo(){
        return this.codigo;
    }

    public TreeMap<Codigo,Compra> getCompras(){
        TreeMap<Codigo,Compra> novoCompras = new TreeMap<Codigo,Compra>();
        for (Compra c : this.compras.values())
            novoCompras.put(c.getCodigo(),c.clone());
        return novoCompras;
    }


    


    public void clear(){
        this.codigo.setCodigo("");
        for (Compra c : this.compras.values())
            c.clear();
        
    }

     public boolean equals(Object obj){
      if(this == obj) return true; 
      if((obj == null) || (this.getClass() != obj.getClass())) return false;
      ConjuntoCompras c = (ConjuntoCompras) obj;
      return this.codigo.equals(c.getCodigo()) &&
                this.compras.equals(c.getCompras());
    }
    
    public ConjuntoCompras clone(){
        return new ConjuntoCompras(this);
    }
}