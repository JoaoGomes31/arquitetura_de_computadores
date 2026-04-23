import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;
public class Main {
    public static void main(String[] args) {
        File arquivo = new File("E:\\teste01.txt");
        String linha;    
        Scanner scanner = null;
        try {
            scanner = new Scanner(arquivo);
            while (scanner.hasNextLine()){
                linha = (scanner.nextLine());
                //Separando cada parte do mneumônico
                StringTokenizer separador = new StringTokenizer(linha);
                int indice = 0;
                String comandos[] = new String[4];
                while (separador.hasMoreTokens()) {
                    
                    comandos[indice] = separador.nextToken();
                    indice++;
                }
                //Verificando tipo de instrução
                String tipoDeInstrucao = "";
                String binarioFinal = "";
                tipoDeInstrucao = (comandos[0].equals("add") || comandos[0].equals("sub")|| comandos[0].equals("and")||comandos[0].equals("or") ||comandos[0].equals("xor"))?"R": (comandos[0].equals("srl") || (comandos[0].equals("sll")))?"Rd":(comandos[0].equals("addi") || comandos[0].equals("andi") || comandos[0].equals("ori") || comandos[0].equals("xori") || comandos[0].equals("liu"))?"I":(comandos[0].equals("beq")||comandos[0].equals("bne")||comandos[0].equals("blez")||comandos[0].equals("bgtz"))?"Id":(comandos[0].equals("j"))?"J":(comandos[0].equals("jr"))?"Jr":"Comando não identificado";
                if (tipoDeInstrucao.equals("R")){
                    String opCode="000000";
                    String rs = Identificar.registrador(comandos[2]);
                    String rt = Identificar.registrador(comandos[3]);
                    String rd = Identificar.registrador(comandos[1]);

                    binarioFinal = binarioFinal + opCode + rs + rt + rd;

                } else if (tipoDeInstrucao.equals("Rd")){
                    

                } else if (tipoDeInstrucao.equals("I")){

                } else if (tipoDeInstrucao.equals("Id")){

                } else if (tipoDeInstrucao.equals("J")){

                } else if (tipoDeInstrucao.equals("Jr")){

                } else {
                    System.out.println(tipoDeInstrucao);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Erro"+ e.getMessage());
        } finally {
            if (scanner!= null){
                scanner.close();
            }
        }
    }
}
