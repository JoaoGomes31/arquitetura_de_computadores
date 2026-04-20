import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        File arquivo = new File("D:\\Teste-01.txt");

        Scanner scanner = null;
        try {
            scanner = new Scanner(arquivo);
            while (scanner.hasNextLine()){
                System.out.println(scanner.nextLine());
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