
/**
 * Classe Compra
 * 
 * @author Grupo77 LEI 
 * @version 1.0 20/05/2015
 */
public class Compra implements Comparable<Compra>
{
    // variáveis de instância
    private Codigo codigo;
    private int[] numVendasN;
    private int[] numVendasP;
    private double[] faturadoN;
    private double[] faturadoP;
    //Construtores
    public Compra()
    {
        int i;
        this.codigo = new Codigo();
        this.numVendasN = new int[12];
        this.numVendasP = new int[12];
        this.faturadoP = new double[12];
        this.faturadoN = new double[12];
        for (i=0;i<12;i++){
            this.numVendasN[i] = 0;
            this.numVendasP[i] = 0;
            this.faturadoP[i] = 0;
            this.faturadoN[i] = 0;
        }
    }
    public Compra(Codigo cod, int[] a, int[] b, double[] c, double[] d ){
        int i;
        this.codigo = new Codigo(cod);
      this.numVendasN = new int[12];
        for (i=0;i<12;i++)
            this.numVendasN[i] = a[i];
        this.numVendasP = new int[12];
        for (i=0;i<12;i++)
            this.numVendasP[i] = b[i];
        this.faturadoN = new double[12];
        for (i=0;i<12;i++)
            this.faturadoN[i] = c[i];
        this.faturadoP = new double[12];
        for (i=0;i<12;i++)
            this.faturadoP[i] = d[i];
    }

    public Compra(Codigo cod ){
        int i;
        this.codigo = cod.clone();
        this.numVendasN = new int[12];
        this.numVendasP = new int[12];
        this.faturadoN = new double[12];
        this.faturadoP = new double[12];
        for (i=0;i<12;i++){
            this.numVendasN[i] = 0;
            this.numVendasP[i] = 0;
            this.faturadoP[i] = 0;
            this.faturadoN[i] = 0;
        }
    }
    public Compra(Compra x){
        int i;
        setCodigo(x.getCodigo());
        int[] a = x.getNumVendasN();
        int[] b = x.getNumVendasP();
        double[] c = x.getFaturadoP();
        double[] d = x.getFaturadoN();
        this.numVendasN = new int[12];
        for (i=0;i<12;i++)
            this.numVendasN[i] = a[i];
        this.numVendasP = new int[12];
        for (i=0;i<12;i++)
            this.numVendasP[i] = b[i];
        this.faturadoN = new double[12];
        for (i=0;i<12;i++)
            this.faturadoN[i] = c[i];
        this.faturadoP = new double[12];
        for (i=0;i<12;i++)
            this.faturadoP[i] = d[i];
    }

    //getters & setters

    public void setCodigo(Codigo cod){
        this.codigo = new Codigo(cod);
    }

    public Codigo getCodigo(){
        return this.codigo;
    }

    

    public int[] getNumVendasN(){
        int[] novoArray = new int[12];
        int i ;
        for(i=0;i<12;i++)
            novoArray[i] = this.numVendasN[i];
        return novoArray;
    }



    public int[] getNumVendasP(){
        int[] novoArray = new int[12];
        int i ;
        for(i=0;i<12;i++)
            novoArray[i] = this.numVendasP[i];
        return novoArray;
    }

    public void setFaturadoN(double[] x){
        int i ;
        for(i=0;i<12;i++)
            this.faturadoN[i] = x[i];
    }

    public double[] getFaturadoN(){
        double[] novoArray = new double[12];
        int i ;
        for(i=0;i<12;i++)
            novoArray[i] = this.faturadoN[i];
        return novoArray;
    }

    public void setFaturadoP(double[] x){
        int i ;
        for(i=0;i<12;i++)
            this.faturadoP[i] = x[i];
    }

    public double[] getFaturadoP(){
        double[] novoArray = new double[12];
        int i ;
        for(i=0;i<12;i++)
            novoArray[i] = this.faturadoP[i];
        return novoArray;
    }


    public void addCompra( double preco, int quant, char modo, int mes){
        if(modo == 'N'){
            this.numVendasN[mes-1] += quant;
            this.faturadoN[mes-1] += preco;
        }
        else{
            this.numVendasP[mes-1] += quant;
            this.faturadoP[mes-1] += preco;
        }
    }


    public int compareTo(Compra c){
        if (this.equals(c)) return 1;
        else return -1;
    }

    public void clear (){
        int i;
        for(i=0;i<12;i++){
            this.numVendasP[i] = 0;
            this.numVendasN[i] = 0;
            this.faturadoN[i] = 0;
            this.faturadoP[i] = 0;
            }
        this.codigo.setCodigo(""); 
    }

    public boolean equals(Object obj){
      if(this == obj) return true; 
      if((obj == null) || (this.getClass() != obj.getClass())) return false;
      Compra c = (Compra) obj;
      return this.codigo.equals(c.getCodigo()) &&
                this.numVendasN.equals(c.getNumVendasN()) &&
                this.numVendasP.equals(c.getNumVendasP()) &&
                this.faturadoN.equals(c.getFaturadoN()) &&
                this.faturadoP.equals(c.getFaturadoP());
    }

    public Compra clone(){
        return new Compra(this);
    }
}
