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
                tipoDeInstrucao = (comandos[0].equals("add") || comandos[0].equals("sub")|| comandos[0].equals("and")||comandos[0].equals("or") ||comandos[0].equals("xor"))?"R":(comandos[0].equals("srl") || (comandos[0].equals("sll"))?"Rd":"Comando não identificado";
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
