import java.util.*;
/**
 * Classe Compras
 * 
 * @author Grupo 77 LEI
 * @version 1.0 20/05/2015
 */
public class Compras
{
    // variáveis de instância
    private int[] totalCompras;
    private TreeMap<Codigo,TreeMap<Codigo,Compra>> comprasProdutos;
    private TreeMap<Codigo,TreeMap<Codigo,Compra>> comprasClientes;


    //construtores
    public Compras()
    {
        this.totalCompras = new int[12];
        this.comprasClientes = new TreeMap<Codigo,TreeMap<Codigo,Compra>> ();
        this.comprasProdutos = new TreeMap<Codigo,TreeMap<Codigo,Compra>> ();
    }
    /* public Compras(int[] tot, TreeMap<Codigo,ArrayList<Compra>>  tmp, TreeMap<Codigo,ArrayList<Compra>>  tmc){
        setTotCompras(tot);
        setComprasP(tmp);
        setComprasC(tmc);
    }*/
    public Compras(Compras x){
        setTotCompras(x.getTotCompras());

        TreeMap<Codigo,TreeMap<Codigo,Compra>> y = x.getComprasP();
        for(Map.Entry<Codigo,TreeMap<Codigo,Compra>> j : y.entrySet()){
            TreeMap<Codigo,Compra> temp = new TreeMap<Codigo, Compra>();
            for (Compra c : j.getValue().values())
                temp.put(c.getCodigo(),c.clone());
            this.comprasProdutos.put(j.getKey().clone(),temp);
        }
       
        y = x.getComprasC();
        for(Map.Entry<Codigo,TreeMap<Codigo,Compra>> j : y.entrySet()){
            TreeMap<Codigo,Compra> temp = new TreeMap<Codigo,Compra>();
            for (Compra c : j.getValue().values())
                temp.put(c.getCodigo(),c.clone());
            this.comprasClientes.put(j.getKey().clone(),temp);
       
        }
    }
    //getters & setters

    public void setTotCompras(int[] x){
            int i;
            for(i=0;i<12;i++)
            this.totalCompras[i] = x[i];
    }
    public int[] getTotCompras(){
        int i;
        int[] tot = new int[12];
        for (i=0;i<12;i++)
            tot[i] = this.totalCompras[i];
            return tot;
    }
   /*
    public void setComprasP(TreeMap<Codigo,ArrayList<Compra>>  x){
        for (ConjuntoCompras cc : x.values())
            this.comprasProdutos.put(cc.getCodigo(),cc.clone());
    }*/
    public TreeMap<Codigo,TreeMap<Codigo,Compra>>  getComprasP (){
        TreeMap<Codigo,TreeMap<Codigo,Compra>> novoCompras = new TreeMap<Codigo,TreeMap<Codigo,Compra>>();
        for(Map.Entry<Codigo,TreeMap<Codigo,Compra>> j : this.comprasProdutos.entrySet()){
            TreeMap<Codigo,Compra> temp = new TreeMap<Codigo,Compra>();
            for (Compra c : j.getValue().values())
                temp.put(c.getCodigo(),c.clone());
            novoCompras.put(j.getKey().clone(),temp);
        }
        return novoCompras;
    }

    /*public void setComprasC(TreeMap<Codigo,ConjuntoCompras> x){
        for (ConjuntoCompras cc : x.values())
            this.comprasClientes.put(cc.getCodigo(),cc.clone());
    }*/
    public TreeMap<Codigo,TreeMap<Codigo,Compra>>  getComprasC (){
        TreeMap<Codigo,TreeMap<Codigo,Compra>> novoCompras = new TreeMap<Codigo,TreeMap<Codigo,Compra>>();
        for(Map.Entry<Codigo,TreeMap<Codigo,Compra>> j : this.comprasClientes.entrySet()){
            TreeMap<Codigo,Compra> temp = new TreeMap<Codigo,Compra>();
            for (Compra c : j.getValue().values())
                temp.put(c.getCodigo(),c.clone());
            novoCompras.put(j.getKey().clone(),temp);
        }
        return novoCompras;
    }



    /*public void iniciaCompras(TreeSet<Codigo> produtos, TreeSet<Codigo> clientes){
        this.comprasProdutos = new TreeMap<Codigo,TreeSet<Compra>> ();
        this.comprasClientes = new TreeMap<Codigo,TreeSet<Compra>> ();
        TreeSet<Compra> novoArray;
        for (Codigo c : produtos){
            novoArray = new TreeSet<Compra>();
            for (Codigo d : clientes)
                novoArray.add(new Compra(d));
            this.comprasProdutos.put(c.clone(),novoArray);
        }
       // for (Codigo c : clientes)
         //   this.comprasClientes.put(c.clone(),new ConjuntoCompras(c,produtos));
    }
*/


    public void addCompra(Codigo produto, double preco, int quant, char modo, Codigo cliente, int mes){
        this.totalCompras[mes-1]++; 
        TreeMap<Codigo,Compra> prod = this.comprasProdutos.get(produto);
        if (prod != null){
            Compra c = prod.get(cliente);
            if (c != null){
                c.addCompra(preco,quant,modo,mes);
            }
            else{
                c = new Compra(cliente);
                c.addCompra(preco,quant,modo,mes);
                prod.put(c.getCodigo(),c.clone());
            }
        }
        else{
            TreeMap<Codigo,Compra> tree = new TreeMap<Codigo,Compra>();
            Compra c = new Compra(cliente);
            c.addCompra(preco,quant,modo,mes);
            tree.put(c.getCodigo(),c.clone());
            this.comprasProdutos.put(produto.clone(),tree);
        }
        TreeMap<Codigo,Compra> clie = this.comprasClientes.get(cliente);
        if (clie != null){
            Compra c = clie.get(produto);
            if (c != null){
                c.addCompra(preco,quant,modo,mes);
            }
            else{
                c = new Compra(produto);
                c.addCompra(preco,quant,modo,mes);
                clie.put(c.getCodigo(),c.clone());
            }
        }
        else{
            TreeMap<Codigo,Compra> tree = new TreeMap<Codigo,Compra>();
            Compra c = new Compra(produto);
            c.addCompra(preco,quant,modo,mes);
            tree.put(c.getCodigo(),c.clone());
            this.comprasClientes.put(produto.clone(),tree);
        }
    }


    public int getNumCompras(){
        int i, tot=0;
        for (i=0;i<12;i++)
            tot += this.totalCompras[i];
        return tot;
    }


  /*  public void cleanCompras(){
        int i;
        for (ConjuntoCompras cc : this.comprasClientes.values())
            cc.clear();
        for (ConjuntoCompras cc : this.comprasProdutos.values())
            cc.clear();
        this.comprasProdutos.clear();
        this.comprasClientes.clear();
        for (i=0;i<12;i++){
            this.totalCompras[i]=0;
        }
    }*/




     public boolean equals(Object obj){
      if(this == obj) return true; 
      if((obj == null) || (this.getClass() != obj.getClass())) return false;
      Compras c = (Compras) obj;
      return this.comprasProdutos.equals(c.getComprasP()) && this.comprasClientes.equals(c.getComprasC());
    }
    
    public Compras clone(){
        return new Compras(this);
    }


}   