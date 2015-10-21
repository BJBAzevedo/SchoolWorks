
/**
 * Classe Contas
 * 
 * @author Grupo 77 LEI
 * @version 1.0 20/05/2015
 */
public class Contas implements Comparable<Contas>
{
    // variáveis de instância
    private Codigo codigo;
    private int[] comprasN;
    private int[] comprasP;
    private double[] faturadoN;
    private double[] faturadoP;

    //construtores
    public Contas()
    {
        int i;
        this.codigo = new Codigo();
        this.comprasN = new int[12];
        this.comprasP = new int[12];
        this.faturadoN = new double[12];
        this.faturadoP = new double[12];
        for (i=0;i<12;i++){
            this.comprasN[i] = 0;
            this.comprasP[i] = 0;
            this.faturadoP[i] = 0;
            this.faturadoN[i] = 0;
        }
    }
    public Contas(Codigo cod, int[] a, int[] b, double[] c, double[] d )
    {
        int i;
        this.codigo = new Codigo(cod);
        this.comprasN = new int[12];
        for (i=0;i<12;i++)
            this.comprasN[i] = a[i];
        this.comprasP = new int[12];
        for (i=0;i<12;i++)
            this.comprasP[i] = b[i];
        this.faturadoN = new double[12];
        for (i=0;i<12;i++)
            this.faturadoN[i] = c[i];
        this.faturadoP = new double[12];
        for (i=0;i<12;i++)
            this.faturadoP[i] = d[i];
    }

    public Contas(Codigo cod)
    {
        int i;
        this.codigo = new Codigo(cod);
        this.comprasN = new int[12];
        this.comprasP = new int[12];
        this.faturadoN = new double[12];
        this.faturadoP = new double[12];
        for (i=0;i<12;i++){
            this.comprasN[i] = 0;
            this.comprasP[i] = 0;
            this.faturadoP[i] = 0;
            this.faturadoN[i] = 0;
        }
    }

    public Contas(Contas x)
    {
        setCodigo(x.getCodigo());
        setContasN(x.getContasN());
        setContasP(x.getContasP());
        setFaturadoN(x.getFaturadoN());
        setFaturadoP(x.getFaturadoP());
    }
    //getters & setters

    public void setCodigo(Codigo x ){
        this.codigo= new Codigo (x);
    }
    public Codigo getCodigo(){
        return this.codigo;
    }

    public void setContasN(int[] x){
        int i;
        this.comprasN = new int[12];
        for(i=0;i<12;i++)
            this.comprasN[i] = x[i];
    }
    public int[] getContasN(){
        return this.comprasN;
    }

    public void setContasP(int[] x){
        int i;
        this.comprasP = new int[12];
        for(i=0;i<12;i++)
            this.comprasP[i] = x[i];
    }
    public int[] getContasP(){
        return this.comprasP;
    }

    public void setFaturadoN(double[] x){
        int i;
        this.faturadoN = new double[12];
        for (i=0; i<12;i++)
            this.faturadoN[i] = x[i];
    }
    public double[] getFaturadoN(){
        return this.faturadoN;
    }

    public void setFaturadoP(double[] x){
        int i;
        this.faturadoP = new double[12];
        for (i=0; i<12;i++)
            this.faturadoP[i] = x[i];
    }
    public double[] getFaturadoP(){
        return this.faturadoP;
    }

    public int getTotalComprasN(){
        int i, tot = 0;
        for(i=0;i<12;i++)
            tot += this.comprasN[i];
        return tot; 
    }
    public int getTotalComprasP(){
        int i, tot = 0;
        for(i=0;i<12;i++)
            tot += this.comprasP[i];
        return tot; 
    }
    public double getTotalFaturadoN(){
        int i; double tot = 0;
        for(i=0;i<12;i++)
            tot += this.faturadoN[i];
        return tot; 
    }
    public double getTotalFaturadoP(){
        int i; double tot = 0;
        for(i=0;i<12;i++)
            tot += this.faturadoP[i];
        return tot; 
    }


    public int compareTo(Contas c){
        return this.codigo.compareTo(c.getCodigo());
    }

    public void add(double preco, int quant,  char modo, int mes){
        if (modo == 'N'){
            this.faturadoN[mes - 1] = preco;
            this.comprasN[mes - 1] = quant;
        }
        else{
            this.faturadoP[mes - 1] = preco;
            this.comprasP[mes - 1] = quant;
        }

    }

    public void addConta(double preco, int quant,  char modo, int mes){
        if (modo == 'N'){
            this.faturadoN[mes - 1] += preco;
            this.comprasN[mes - 1] += quant;
        }
        else{
            this.faturadoP[mes - 1] += preco;
            this.comprasP[mes - 1] += quant;
        }

    }






    public void clear(){
        int i;
        this.codigo.setCodigo("");
        for (i=0;i<12;i++){
            this.comprasN[i] = 0;
            this.comprasP[i] = 0;
            this.faturadoN[i] = 0;
            this.faturadoP[i] = 0;
        }
    }

    public String toString (){
        StringBuilder sb = new StringBuilder();
        sb.append("Cliente/Produto: ");
        sb.append(this.codigo.toString());
        sb.append(" | Compras em modo N: "); 
        sb.append(getTotalComprasN());
        sb.append(" | Compras me modo P: " );
        sb.append(getTotalComprasP());
        sb.append(" | Faturado em modo N: ");
        sb.append( getTotalFaturadoN()); 
        sb.append(" | Faturado em modo P: ");
        sb.append( getTotalFaturadoP());
        return sb.toString();
    }
    
    public boolean equals(Object obj){
      if(this == obj) return true; 
      if((obj == null) || (this.getClass() != obj.getClass())) return false;
      Contas c = (Contas) obj;
      return this.codigo.equals(c.getCodigo()) &&
                this.comprasN.equals(c.getContasN()) &&
                this.comprasP.equals(c.getContasP()) &&
                this.faturadoN.equals(c.getFaturadoN()) &&
                this.faturadoP.equals(c.getFaturadoP());
    }

    public Contas clone(){
        return new Contas(this);
    }
}