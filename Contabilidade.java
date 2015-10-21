package gesthipperli3;

import java.util.*;
/**
 * Classe Contabilidade
 * 
 * @author Grupo 77 LEI 
 * @version 1.0 20/05/2015
 */
public class Contabilidade
{
    // variáveis de instância
    private TreeMap<Codigo,Contas> contabilidadeProdutos;
    private TreeMap<Codigo,Contas> contabilidadeClientes;
    
    //construtores
     public Contabilidade( ){
        this.contabilidadeProdutos = new TreeMap<Codigo,Contas>();
        this.contabilidadeClientes = new TreeMap<Codigo,Contas>();
    }
    public Contabilidade(TreeMap<Codigo,Contas> tmc, TreeMap<Codigo,Contas> tmp){
        this.contabilidadeProdutos = new TreeMap<Codigo,Contas>();
        this.contabilidadeClientes = new TreeMap<Codigo,Contas>();
        for  (Contas c : tmp.values()){
            this.contabilidadeProdutos.put(c.getCodigo(), c.clone());
        }
        for  (Contas c : tmc.values()){
            this.contabilidadeClientes.put(c.getCodigo(), c.clone());
        } 
    }
    public Contabilidade(Contabilidade x){
        setContabilidadeClientes(x.getContabilidadeClientes());
        setContabilidadeProdutos(x.getContabilidadeProdutos());
    }

    
    //getters & setters
    public void setContabilidadeProdutos(TreeMap<Codigo,Contas> x){
        this.contabilidadeProdutos = new TreeMap<Codigo,Contas>();
        for  (Contas c : x.values()){
            this.contabilidadeProdutos.put(c.getCodigo(), c.clone());
        }
    }

    public TreeMap<Codigo,Contas> getContabilidadeProdutos(){
        TreeMap<Codigo,Contas> novaContabilidade = new TreeMap<Codigo,Contas>();
        for  (Contas c : this.contabilidadeProdutos.values()){
            novaContabilidade.put(c.getCodigo(), c.clone());
        }
        return novaContabilidade;
    }

    public void setContabilidadeClientes(TreeMap<Codigo,Contas> x){
        this.contabilidadeClientes = new TreeMap<Codigo,Contas>();
        for  (Contas c : x.values()){
            this.contabilidadeClientes.put(c.getCodigo(), c.clone());
        }
    } 

    public TreeMap<Codigo,Contas> getContabilidadeClientes(){
        TreeMap<Codigo,Contas> novaContabilidade = new TreeMap<Codigo,Contas>();
        for  (Contas c : this.contabilidadeClientes.values()){
            novaContabilidade.put(c.getCodigo(), c.clone());
        }
        return novaContabilidade;
    }



   /* public void iniciaContabilidade(TreeSet<Codigo> produtos, TreeSet<Codigo> clientes){
        this.contabilidadeProdutos = new TreeMap<Codigo,Contas>();
        this.contabilidadeClientes = new TreeMap<Codigo,Contas>();
        for (Codigo c : produtos)
            this.contabilidadeProdutos.put(new Codigo(c),new Contas(c));
        for (Codigo c : clientes)
            this.contabilidadeClientes.put(c.clone(),new Contas(c));
    }*/

    public void addConta(Codigo produto, double preco, int quant, char modo, Codigo cliente, int mes){
        Contas p = this.contabilidadeProdutos.get(produto);
        if (p != null)
           p.addConta(preco,quant,modo,mes);
        else{
            Contas temp = new Contas (produto);
            temp.add(preco,quant,modo,mes); 
            this.contabilidadeProdutos.put(produto.clone(),temp.clone());
        }
        Contas c = this.contabilidadeClientes.get(cliente);
        if (c != null)
            c.addConta(preco,quant,modo,mes);
        else{
            Contas tempp  = new Contas(cliente);
            tempp.add(preco,quant,modo,mes);
            this.contabilidadeClientes.put(cliente.clone(),tempp.clone());
        }
    }


   public void cleanContas(){
        
        for (Contas c : this.contabilidadeClientes.values())
            c.clear();
        for (Contas c : this.contabilidadeProdutos.values())
            c.clear();
        this.contabilidadeProdutos.clear();
        this.contabilidadeClientes.clear();
        
   }
    
    
   public String toString() {
        StringBuilder sb = new StringBuilder("--- Contabilidade ---\n");
        sb.append("xxx Contablididade dos produtos xxx:\n");
        for(Contas c : this.contabilidadeProdutos.values())
            sb.append(c.toString() + "\n");
        sb.append("xxx Contablididade dos clientes xxx:\n");
        for(Contas c : this.contabilidadeClientes.values())
            sb.append(c.toString() + "\n");
        return sb.toString();
    }
    
    public boolean equals(Object obj){
      if(this == obj) return true; 
      if((obj == null) || (this.getClass() != obj.getClass())) return false;
      Contabilidade c = (Contabilidade) obj;
      return this.contabilidadeClientes.equals(c.getContabilidadeClientes()) &&
                this.contabilidadeProdutos.equals(c.getContabilidadeProdutos()) ;
    }
    
    public Contabilidade clone(){
        return new Contabilidade(this);
    }

    
}