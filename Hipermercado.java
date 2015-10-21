package gesthipperli3;

import java.io.*;
import java.util.*;
/**
 * Escreva a descrição da classe Hipermercado aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Hipermercado
{
    // variáveis de instância
    private static CatalogoProdutos catProd;
    private static CatalogoClientes catClie;
    private static Contabilidade contabilidade;
    private static Compras compras;
    private static int[] ficheirosLidos;
    



    public static void displayMenuConsultasInterativas() {
        System.out.print("+ + +    Menu Consultas Interativas    + + +:\n");
        System.out.print("1  - Ficheiros.\n");
        System.out.print("2  - Lista e total de produtos cujo código se inicia por uma dada letra.\n");
        System.out.print("3  - Número total de vendas em modo N e P, e total facturado com um produto num dado mês.\n");
        System.out.print("4  - Lista de códigos e número de produtos que ninguém comprou.\n");
        System.out.print("5  - Tabela com o número total de produtos comprados, mês a mês, por um dado    cliente.\n");
        System.out.print("6  - Lista de clientes cujo código se inicia por uma dada letra.\n");
        System.out.print("7  - Total de compras registadas e total facturado num dado intervalo fechado demeses.\n");
        System.out.print("8  - Lista de códigos e número total de clientes que compraram um dado produto.\n");
        System.out.print("9  - Lista de códigos de produtos que um cliente mais comprou num dado mês.\n");
        System.out.print("10 - Lista de códigos de clientes que realizaram compras em todos os meses do   ano.\n");
        System.out.print("11 - Ficheiro CSV contendo número de compras realizadas por mês e número total  de clientes que realizaram tais compras.\n");
        System.out.print("12 - Lista dos N produtos mais vendidos em todo o ano.\n");
        System.out.print("13 - Três produtos que um dado cliente mais comprou durante o ano.\n");
        System.out.print("14 - Número de clientes que não realizaram compras e número de produtos que ninguém comprou.\n");
        System.out.print("0  - Sair.\n");
        System.out.print("Opção: ");

    }


    public static void displayMenuPrincipal() {
        System.out.print("+ + +    Menu Principal    + + +:\n");
        System.out.print("1  - Consultas estatisticas.\n");
        System.out.print("2  - Consultas interativas.\n");
        System.out.print("0  - Sair.\n");
        System.out.print("Opção: ");
    }



    public static void displayMenuConsultasEstatisticas() {
        System.out.print("+ + +    Menu Consultas Estatisticas    + + +:\n");
        System.out.print("1  - Consultas estatisticas.\n");
        System.out.print("2  - Consultas interativas.\n");
        System.out.print("0  - Sair.\n");
        System.out.print("Opção: ");
    }

    public static void displayMenuFicheiros() {
        System.out.print("+ + +    Menu de Ficheiros    + + +:\n");

        if (ficheirosLidos[0] == 1) System.out.print("1 - Ficheiro Produtos [LIDO]\n");
        else System.out.print("1 - Ficheiro Produtos [NÃO LIDO]\n");

        if (ficheirosLidos[1] == 1) System.out.print("2 - Ficheiro Clientes [LIDO]\n");
        else System.out.print("2 - Ficheiro Clientes [NÃO LIDO]\n");

        if (ficheirosLidos[2] == 1) System.out.print("3 - Ficheiro Compras [LIDO]\n");
        else System.out.print("3 - Ficheiro Compras [NÃO LIDO]\n");
    
        System.out.print("0 - Sair\n");
        System.out.print("Opção: ");
    }

    public static void esperarEnter() {
        System.out.print("\n\t\t     < primir 'ENTER' para continuar... > ");
        limparBuffer();
        System.out.print("\f");
    
    }


    public static void limparBuffer() {
     Scanner input = new Scanner(System.in);
     String c;
     c = input.nextLine();
    }


    public static boolean produtoValido(String codProd) {
        if (codProd.length() > 6) return false;
        char c1 = codProd.charAt(0);
        char c2 = codProd.charAt(1);
        char c3 = codProd.charAt(2);
        char c4 = codProd.charAt(3);
        char c5 = codProd.charAt(4);
        char c6 = codProd.charAt(5);

        if ('A'<=c1 && c1<= 'Z' && 'A'<=c2 && c2 <= 'Z' && '0'<=c3 && c3<= '9' && 
            '0'<=c4 && c4<= '9' && '0'<=c5 && c5<= '9' && '0'<=c6 && c6<= '9')
            return true;
        return false;
    }



    public static void ficheiroProdutos() {
        BufferedReader br = null;
        Scanner input = new Scanner(System.in);
        String file;
        System.out.println("Nome do ficheiro de Produtos: ");
        file = input.nextLine();
        file.replace("\n","");
        if(ficheirosLidos[0] == 1){
            System.out.print("A apagar dados anteriores...\n ");
            catProd.cleanCatalogo();
        }
        try {
        System.out.print("Lendo...\n");
        String line;
        br = new BufferedReader(new FileReader(file));
            while ((line = br.readLine()) != null) {
                line.replace("\n","");
                //StringTokenizer stringTokenizer = new StringTokenizer(line, "\n");
                /*Vai ler a linha até ao \n**/
                if (produtoValido(line))
                    catProd.addProduto(line);
                }
        System.out.println(file + " lido com sucesso! " + catProd.getNumProd() + " produtos lidos e válidos\n");
        ficheirosLidos[0] = 1;
        }catch (IOException e) {
            System.out.println("ERRO! Ficheiro inexistente!\n ");
        } finally {
            try {
                if (br != null)
                    br.close();
            } catch (IOException ex) {
                System.out.println("ERRO! Memória insuficiente!!");
            }
        }
   }



    public static boolean clienteValido(String codClie) {
        if (codClie.length() > 6) return false;
        char c1 = codClie.charAt(0);
        char c2 = codClie.charAt(1);
        char c3 = codClie.charAt(2);
        char c4 = codClie.charAt(3);
        char c5 = codClie.charAt(4);

        if ('A'<=c1 && c1<= 'Z' && 'A'<=c2 && c2 <= 'Z' && '0'<=c3 && c3<= '9' && 
            '0'<=c4 && c4<= '9' && '0'<=c5 && c5<= '9')
            return true;
        return false;
    }



    public static void ficheiroClientes() {
        BufferedReader br = null;
        Scanner input = new Scanner(System.in);
        String file;
        System.out.println("Nome do ficheiro de Clientes: ");
        file = input.nextLine();
        file.replace("\n","");
        if(ficheirosLidos[1] == 1){
            System.out.print("A apagar dados anteriores...\n ");
            catProd.cleanCatalogo();
        }
        try {
        System.out.print("Lendo...\n");
        String line;
        br = new BufferedReader(new FileReader(file));
        while ((line = br.readLine()) != null) {
           line.replace("\n","");
           //StringTokenizer stringTokenizer = new StringTokenizer(line, "\n");
           /*Vai ler a linha até ao \n**/
            if (clienteValido(line))
                catClie.addCliente(line);
        }
        System.out.println(file + " lido com sucesso! " + catClie.getNumClie() + " clientes lidos e válidos\n");
        ficheirosLidos[1] = 1;
        } catch (IOException e) {
        System.out.println("ERRO! Ficheiro inexistente!\n ");
        } finally {
            try {
                if (br != null)
                    br.close();
            } catch (IOException ex) {
                System.out.println("ERRO! Memória insuficiente!!");
            }
        }
    }




     public static boolean compraValida(Codigo codProd, double preco, int unid, 
        char modo, Codigo codCli, int mes) {
        if ((catProd.existeProduto(codProd)) && (preco >= 0) && 
            (unid > 0) && (modo == 'N' || modo == 'P') && 
            (catClie.existeCliente(codCli) ) && (mes > 0 && mes <= 12))
            return true;
        return false;
    
    }



    public static void ficheiroCompras(){

        BufferedReader br = null;
        Scanner input = new Scanner(System.in);
        String file;
        Codigo produto = new Codigo() ,cliente  = new Codigo();
        String temp;
        int mes =0 , quant=  0;
        double preco = 0;
        char modo = 'a';

        System.out.println("Nome do ficheiro de Compras: ");
        file = input.nextLine();
        file.replace("\n","");
        if (ficheirosLidos[0] == 0 || ficheirosLidos[1] == 0) {
            System.out.print("Resolvendo dependências...\n");
            if (ficheirosLidos[0] == 0)
                ficheiroProdutos();
            if (ficheirosLidos[1] == 0)
            ficheiroClientes();
        }
        if (ficheirosLidos[0] ==1 && ficheirosLidos[1] == 1){
            if (ficheirosLidos[2]==1) {
                System.out.print("A apagar dados anteriores...\n");
                if (contabilidade != null)
                    contabilidade = new Contabilidade();
                if (compras != null)
                    compras = new Compras();
             ficheirosLidos[2] = 0;
            }
    
            
            try {

                String line;
                br = new BufferedReader(new FileReader(file));
                //contabilidade.iniciaContabilidade(catProd.getCatalogo(), catClie.getCatalogo());
                //compras.iniciaCompras(catProd.getCatalogo(), catClie.getCatalogo());
                System.out.print("Lendo " + file +"...\n");
                while ((line = br.readLine()) != null) {
                    line.replace("\n","");
                    StringTokenizer st = new StringTokenizer(line);
                    produto = new Codigo(st.nextToken());
                    if (st.hasMoreTokens()) {
                        preco = Double.parseDouble(st.nextToken());
                    }
                    if (st.hasMoreTokens()) {
                        quant = Integer.parseInt(st.nextToken());
                    }
                    if (st.hasMoreTokens()) {
                        temp = st.nextToken();
                        modo = temp.charAt(0);
                    }
                    if (st.hasMoreTokens()) {
                        cliente = new Codigo (st.nextToken());
                    }
                    if (st.hasMoreTokens()) {
                        mes = Integer.parseInt(st.nextToken());
                    }

                    if (compraValida(produto,preco,quant,modo,cliente,mes)){
                        contabilidade.addConta(produto,preco,quant,modo,cliente,mes);
                        compras.addCompra(produto,preco,quant,modo,cliente,mes);}
                }
                System.out.println(file + " lido com sucesso! " + compras.getNumCompras() + " compras lidas e válidas\n");
                
                ficheirosLidos[2] = 1;
            } catch (IOException e) {
                System.out.println("ERRO! Ficheiro inexistente!\n ");
            } finally {
                try {
                    if (br != null)
                        br.close();
                    } catch (IOException ex) {
                        System.out.println("ERRO! Memória insuficiente!!");
                    }
                }
                }
    }
    

    


    public static void lerFicheiros() {
        Scanner input = new Scanner(System.in);
        int opcao = 20;
        boolean status = true,teste = true;

        do {
        
            
            displayMenuFicheiros();
            teste = true;

            do{
                try {
                    opcao = input.nextInt();
                    teste = false;
                }catch(InputMismatchException ex){
                    System.out.print("\f");
                    System.out.print("Insira um número inteiro!!\n");
                    displayMenuFicheiros();
                    teste = false;
                }
            }while (teste);



            System.out.print("\f");
            switch(opcao) {
                case 1: ficheiroProdutos();
                        esperarEnter();
                        System.out.print("\f");
                        break;
                case 2: ficheiroClientes();
                        esperarEnter();
                        System.out.print("\f");
                        break;
                case 3: ficheiroCompras();
                        esperarEnter();
                        System.out.print("\f");
                        break;
                case 0: status = false;
                        break;
                default:System.out.print("\f"); 
                        System.out.print("ERRO: Opção inválida!\n");
            }

        } while (status == true);
    }











    public static void menuApresentacaoSimples(ArrayList<String> lista, int tamanho)
    {
        Scanner input = new Scanner(System.in);
        int i = 0, j = 0, op, pg;
       for (i = 0; i * 10 < tamanho; i++) {
        System.out.print("\n");
        /* devolver conteúdo da lista */
        for (j = 0; (j < 10) && (i * 10 + j < tamanho); j++)
            System.out.print(lista.get(i*10+j) +  "\n");
        /* página */
        System.out.print("\n");
        if (tamanho % 10 != 0) System.out.print("Página " + i + 1 + " de " + ((tamanho/10) + 1) + "\n\n");
        else System.out.print("Página " + (i + 1) + " de " + (tamanho/10) + "\n\n");
        /* opções */
        System.out.print("1 - Próxima página\n");
        System.out.print("2 - Página anterior\n");
        System.out.print("3 - Escolher página\n");
        System.out.print("0 - Sair\n");
        System.out.print("Opção: ");
        /* escolha de navegação */
        if((op = input.nextInt())==1){  
            limparBuffer();
            if (op >= 0 && op < 4) {
                if (op == 1) {      
                    if (tamanho % 10 != 0) {
                        if (i + 1 == (tamanho / 10) + 1) { /* para o caso de estarmos na ultima página e se fizer seguinte */
                            System.out.print("\f");
                            System.out.print("ERRO: Não existe página seguinte!\n");
                            i--;
                        } else {
                            System.out.print("\f"); /* quando se faz seguinte não é preciso fazer-se mais nada porque estamos dentro de um for, o i++ ja faz o pretendido */
                        }
                    } else {
                        if (i + 1 == (tamanho / 10) ) { /* para o caso de estarmos na ultima página e se fizer seguinte */
                            System.out.print("\f");
                            System.out.print("ERRO: Não existe página seguinte!\n");
                            i--;
                        } else {
                            System.out.print("\f"); /* quando se faz seguinte não é preciso fazer-se mais nada porque estamos dentro de um for, o i++ ja faz o pretendido */
                        }
                    }
                } else if (op == 2) {
                    if (i + 1 >= 2) {
                        i -= 2;
                        System.out.print("\f");
                    } else { /* para o caso de estarmos na página 1 e se fizer anterior */
                        System.out.print("\f");
                        System.out.print("ERRO: Não existe página anterior!\n");
                        i--;
                    }
                } else if (op == 3) {
                    System.out.print("Página número: ");
                    if ((pg = input.nextInt()) == 1){   
                        limparBuffer();
                        if (pg > 0 && pg <= (tamanho / 10) + 1) {
                            i = (pg - 2);
                            System.out.print("\f");
                        } else { /* para o caso de a página não existir */
                            System.out.print("\f");
                            System.out.print("ERRO: A página " + pg + " não existe!\n");
                            i--;
                        }
                    } else {
                        limparBuffer();
                        System.out.print("\f");
                        System.out.print("ERRO: Página inválida!\n");
                        i--;
                    }
                } else if (op == 0) {
                    System.out.print("\f");
                    break;
                }
            } else {
                System.out.print("\f");
                System.out.print("ERRO: Opção inválida!\n");
                i--;
            }
        } else {
            limparBuffer();
            System.out.print("\f");
            System.out.print("ERRO: Opção inválida!\n");
            i--;
        }
      }
    
    }
    public static void menuApresentacao(ArrayList<String> lista, int tamanho)
    {   
        Scanner input = new Scanner(System.in);
        int i = 0, j = 0, op, pg;
      for (i = 0; i * 60 < tamanho; i++) {
        System.out.print("\n");
        /* devolver conteúdo da lista */
        for (j = 0; (j < 60) && (i * 60 + j < tamanho); j += 6) {
            if ( (i * 60 + j + 1 < tamanho) && (i * 60 + j + 2 < tamanho) && (i * 60 + j + 3 < tamanho) && (i * 60 + j + 4 < tamanho) && (i * 60 + j + 5 < tamanho) )
                System.out.print(lista.get(i * 60 + j) + "    " + lista.get(i * 60 + j + 1) + "    " + lista.get(i * 60 + j + 2) + "    " + lista.get(i * 60 + j + 3) + "    " + lista.get(i * 60 + j + 4) + "    " + lista.get(i * 60 + j + 5) + "\n" );
            else if ( (i * 60 + j + 1 < tamanho) && (i * 60 + j + 2 < tamanho) && (i * 60 + j + 3 < tamanho) && (i * 60 + j + 4 < tamanho) && (i * 60 + j + 5 >= tamanho) )
                System.out.print(lista.get(i * 60 + j) + "    " + lista.get(i * 60 + j + 1) + "    " + lista.get(i * 60 + j + 2) + "    " + lista.get(i * 60 + j + 3) + "    " + lista.get(i * 60 + j + 4) + "\n");     
            else if ( (i * 60 + j + 1 < tamanho) && (i * 60 + j + 2 < tamanho) && (i * 60 + j + 3 < tamanho) && (i * 60 + j + 4 >= tamanho) && (i * 60 + j + 5 >= tamanho) )
                System.out.print(lista.get(i * 60 + j) + "    " + lista.get(i * 60 + j + 1) + "    " + lista.get(i * 60 + j + 2) + "    " + lista.get(i * 60 + j + 3) + "\n");      
            else if ( (i * 60 + j + 1 < tamanho) && (i * 60 + j + 2 < tamanho) && (i * 60 + j + 3 >= tamanho) && (i * 60 + j + 4 >= tamanho) && (i * 60 + j + 5 >= tamanho) )
                System.out.print(lista.get(i * 60 + j) + "    " + lista.get(i * 60 + j + 1) + "    " + lista.get(i * 60 + j + 2) + "\n");
            else if ( (i * 60 + j + 1 < tamanho) && (i * 60 + j + 2 >= tamanho) && (i * 60 + j + 3 >= tamanho) && (i * 60 + j + 4 >= tamanho) && (i * 60 + j + 5 >= tamanho) )
                System.out.print(lista.get(i * 60 + j) + "    " + lista.get(i * 60 + j + 1) + "\n" );
            else if ( (i * 60 + j + 1 >= tamanho) && (i * 60 + j + 2 >= tamanho) && (i * 60 + j + 3 >= tamanho) && (i * 60 + j + 4 >= tamanho) && (i * 60 + j + 5 >= tamanho) )
                System.out.print(lista.get(i * 60 + j) + "\n");
        }
        /* página */
        System.out.print("\n");
        if (tamanho % 60 != 0) System.out.print("Página " + (i + 1) + " de " + ((tamanho / 60) + 1) + "\n\n");
        else System.out.print("Página " + (i + 1) + " de " + ((tamanho / 60)) + "\n\n");
        /* opções */
        System.out.print("1 - Próxima página\n");
        System.out.print("2 - Página anterior\n");
        System.out.print("3 - Escolher página\n");
        System.out.print("0 - Sair\n");
        System.out.print("Opção: ");
        /* escolha de navegação */
        if ((op = input.nextInt()) == 1) {
            limparBuffer();
            if (op >= 0 && op < 4) {
                if (op == 1) {      
                    if (tamanho % 60 != 0) {
                        if (i + 1 == (tamanho / 60) + 1) { /* para o caso de estarmos na ultima página e se fizer seguinte */
                            System.out.print("\f");
                            System.out.print("ERRO: Não existe página seguinte!\n");
                            i--;
                        } else {
                            System.out.print("\f"); /* quando se faz seguinte não é preciso fazer-se mais nada porque estamos dentro de um for, o i++ ja faz o pretendido */
                        }
                    } else {
                        if (i + 1 == (tamanho / 60) ) { /* para o caso de estarmos na ultima página e se fizer seguinte */
                            System.out.print("\f");
                            System.out.print("ERRO: Não existe página seguinte!\n");
                            i--;
                        } else {
                            System.out.print("\f"); /* quando se faz seguinte não é preciso fazer-se mais nada porque estamos dentro de um for, o i++ ja faz o pretendido */
                        }
                    }
                } else if (op == 2) {
                    if (i + 1 >= 2) {
                        i -= 2;
                        System.out.print("\f");
                    } else { /* para o caso de estarmos na página 1 e se fizer anterior */
                        System.out.print("\f");
                        System.out.print("ERRO: Não existe página anterior!\n");
                        i--;
                    }
                } else if (op == 3) {
                    System.out.print("Página número: ");
                    if ((pg = input.nextInt()) == 1) {
                        limparBuffer();
                        if (pg > 0 && pg <= (tamanho / 60) + 1) {
                            i = (pg - 2);
                            System.out.print("\f");
                        } else { /* para o caso de a página não existir */
                            System.out.print("\f");
                            System.out.print("ERRO: A página "+ pg + " não existe!\n");
                            i--;
                        }
                    } else {
                        limparBuffer();
                        System.out.print("\f");
                        System.out.print("ERRO: Página inválida!\n");
                        i--;
                    }
                } else if (op == 0) {
                    System.out.print("\f");
                    break;
                }
            } else {
                System.out.print("\f");
                System.out.print("ERRO: Opção inválida!\n");
                i--;
            }
        } else {
            limparBuffer();
            System.out.print("\f");
            System.out.print("ERRO: Opção inválida!\n");
            i--;
        }
      }
    }

    
  

    public static boolean ficheirosNecessariosLidos() {
        if (ficheirosLidos[0] == 1 && ficheirosLidos[1] == 1 && ficheirosLidos[2] == 1)
            return true;
        return false;
    }




  public static void main(String[] args) throws IOException  {
        Scanner input = new Scanner(System.in);
        int opcao=-1;
        boolean status = true, statusss = true, teste = true;

        System.out.print("\f");
        System.out.print("\n\n\n\n\n\t\t\t   BEM-VINDO AO GESTHIPER!\n");
        System.out.print("\n\n\t\t\t Aplicação desenvolvida por:\n");
        System.out.print("\t\t\t    A71580 Rafael Barbosa\n");
        System.out.print("\t\t\t     A71751 André Pinto\n");
        System.out.print("\t\t\t    A70500 Bruno Azevedo\n");
        System.out.print("\n\n\n\n\t\t     < primir 'ENTER' para continuar... > ");
        limparBuffer();
        System.out.print("\f");


        catProd = new CatalogoProdutos();
        catClie = new CatalogoClientes();
        contabilidade = new Contabilidade();
        compras = new Compras();
        ficheirosLidos = new int[3];
         

        do{
            teste=true;
            displayMenuPrincipal();
               do{
                try {
                    opcao = input.nextInt();
                    teste=false;
                }catch(InputMismatchException ex){
                    System.out.print("\f");
                    System.out.print("Insira um número inteiro!!\n");
                    displayMenuPrincipal();
                }
                input.nextLine();
                }while(teste);
            
                System.out.print("\f");
                switch(opcao) {
            
                    case 1:{

                        
                                statusss = true;
                                do{
                                    teste = true;
                                    displayMenuConsultasEstatisticas();
                                    do{
                                        try {
                                            opcao = input.nextInt();
                                            teste = false;
                                        }catch(InputMismatchException ex){
                                            System.out.print("\f");
                                            System.out.print("Insira um número inteiro!!\n");
                                            displayMenuConsultasEstatisticas();
                                        }
                                        input.nextLine();
                                    }while(teste);
                                        
                                    System.out.print("\f");
                                    switch(opcao) {
                                

                                        case 1: System.out.print("Menu estatisticas\n") ;
                                            break;
                                        case 0: statusss = false;
                                                break;
                                        default: System.out.print("ERRO: Opção inválida!\n");
                                }
                            
                           } while (statusss == true);
                    }
                        break;
                    
                    case 2:{

                                statusss = true;
                                do{     
                                    
                                    displayMenuConsultasInterativas();
                                    teste=true;
                                   do{
                                       try {
                                           opcao = input.nextInt();
                                           teste=false;
                                        }catch(InputMismatchException ex){
                                            System.out.print("\f");
                                            System.out.print("Insira um número inteiro!!\n");
                                            displayMenuConsultasInterativas();
                                        }
                                        input.nextLine();
                                   }while(teste);

                                    
                                    switch(opcao) {
                                

                                        case 1: System.out.print("\f");
                                                lerFicheiros();
                                                break;
                                        case 2: if (ficheirosNecessariosLidos() == true){System.out.print("\f"); System.out.print("Query 2\n");}
                                            else {System.out.print("\f");System.out.print("AVISO: Necessário ler os ficheiros!\n");}
                                            break;
                                        case 3: if (ficheirosNecessariosLidos() == true){System.out.print("\f"); System.out.print("Query 3\n");}
                                            else{System.out.print("\f"); System.out.print("AVISO: Necessário ler os ficheiros!\n");}
                                            break;
                                        case 4: if (ficheirosNecessariosLidos() == true){System.out.print("\f"); System.out.print("Query 4\n");}
                                            else {System.out.print("\f");System.out.print("AVISO: Necessário ler os ficheiros!\n");}
                                            break;
                                        case 5: if (ficheirosNecessariosLidos() == true) {System.out.print("\f");System.out.print("Query 5\n");}
                                            else {System.out.print("AVISO: Necessário ler os ficheiros!\n");}
                                            break;
                                        case 6: if (ficheirosNecessariosLidos() == true) {System.out.print("\f");System.out.print("Query 6\n");}
                                            else {System.out.print("\f");System.out.print("AVISO: Necessário ler os ficheiros!\n");}
                                            break;
                                        case 7: if (ficheirosNecessariosLidos() == true) {System.out.print("\f");System.out.print("Query 7\n");}
                                            else {System.out.print("\f");System.out.print("AVISO: Necessário ler os ficheiros!\n");}
                                            break;
                                        case 8: if (ficheirosNecessariosLidos() == true) {System.out.print("\f");System.out.print("Query 8\n");}
                                            else {System.out.print("\f");System.out.print("AVISO: Necessário ler os ficheiros!\n");}
                                            break;
                                        case 9: if (ficheirosNecessariosLidos() == true){ System.out.print("\f");System.out.print("Query 9\n");}
                                            else {System.out.print("\f");System.out.print("AVISO: Necessário ler os ficheiros!\n");}
                                            break;
                                        case 10: if (ficheirosNecessariosLidos() == true) {System.out.print("\f");System.out.print("Query 10\n");}
                                            else {System.out.print("\f");System.out.print("AVISO: Necessário ler os ficheiros!\n");}
                                            break;
                                        case 11: if (ficheirosNecessariosLidos() == true) {System.out.print("\f");System.out.print("Query 11\n");}
                                            else {System.out.print("\f");System.out.print("AVISO: Necessário ler os ficheiros!\n");}
                                            break;
                                        case 12: if (ficheirosNecessariosLidos() == true) {System.out.print("\f");System.out.print("Query 12\n");}
                                            else {System.out.print("\f");System.out.print("AVISO: Necessário ler os ficheiros!\n") ;}
                                            break;
                                        case 13: if (ficheirosNecessariosLidos() == true) {System.out.print("\f");System.out.print("Query 13\n");}
                                            else {System.out.print("\f");System.out.print("AVISO: Necessário ler os ficheiros!\n");}
                                            break;
                                        case 14: if (ficheirosNecessariosLidos() == true) {System.out.print("\f");System.out.print("Query 14\n");}
                                            else {System.out.print("\f");System.out.print("AVISO: Necessário ler os ficheiros!\n") ;}
                                            break;
                                        case 0: statusss = false;
                                                break;
                                        case -1: {System.out.print("\f");System.out.print("ERRO:Insira um número inteiro!\n");break;}
                                        default: {System.out.print("\f");System.out.print("ERRO: Opção inválida!\n");}
                                }
                            
                             } while (statusss == true);
                           }
                            System.out.print("\f");
                            break;
                    case 0: status = false;
                            break;
                    default:{System.out.print("\f"); System.out.print("ERRO: Opção inválida!\n");}
                
         } 
        
        
       } while (status);


 
    }
}