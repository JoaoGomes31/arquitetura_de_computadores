import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.BufferedWriter;

public class Main {
    public static void main(String[] args) {
        for (int i = 1; i <= 2; i++) {
            String endereco = "D:\\Teste-" + i + ".txt";
            String enderecoArquivoCriado = "D:\\ResultadoTeste-" + i + ".txt";
            File arquivo = new File(endereco);
            String linha;
            Scanner scanner = null;
            try {
                scanner = new Scanner(arquivo);
                while (scanner.hasNextLine()) {
                    linha = (scanner.nextLine());
                    // Separando cada parte do mneumônico
                    StringTokenizer separador = new StringTokenizer(linha, " , ()");
                    int indice = 0;
                    String comandos[] = new String[5];
                    while (separador.hasMoreTokens()) {
                        String token = separador.nextToken();
                        comandos[indice] = token;
                        System.out.println(token);
                        indice++;
                    }
                    // Verificando tipo de instrução
                    String tipoDeInstrucao = "";
                    String binarioFinal = "";
                    tipoDeInstrucao = (comandos[0].equals("add") || comandos[0].equals("sub")
                            || comandos[0].equals("and") || comandos[0].equals("or") || comandos[0].equals("xor"))
                                    ? "R"
                                    : (comandos[0].equals("srl") || (comandos[0].equals("sll"))) ? "Rd"
                                            : (comandos[0].equals("addi") || comandos[0].equals("andi")
                                                    || comandos[0].equals("ori") || comandos[0].equals("xori")
                                                    || comandos[0].equals("liu"))
                                                            ? "I"
                                                            : (comandos[0].equals("beq") || comandos[0].equals("bne")
                                                                    || comandos[0].equals("blez")
                                                                    || comandos[0].equals("bgtz"))
                                                                            ? "Id"
                                                                            : (comandos[0].equals("j")) ? "J"
                                                                                    : (comandos[0].equals("jr")) ? "Jr"
                                                                                            : (comandos[0].equals("lb")
                                                                                                    || comandos[0]
                                                                                                            .equals("lw")
                                                                                                    || comandos[0]
                                                                                                            .equals("lh")
                                                                                                    || comandos[0]
                                                                                                            .equals("sh")
                                                                                                    || comandos[0]
                                                                                                            .equals("sw")
                                                                                                    || comandos[0]
                                                                                                            .equals("sb"))
                                                                                                                    ? "Ils"
                                                                                                                    : "Comando não identificado";
                    if (tipoDeInstrucao.equals("R")) {
                        String opCode = "000000";
                        String shamt = "00000";
                        String rs = Identificar.registrador(comandos[2]);
                        String rt = Identificar.registrador(comandos[3]);
                        String rd = Identificar.registrador(comandos[1]);
                        String func = Identificar.function(comandos[0]);
                        binarioFinal = binarioFinal + opCode + rs + rt + rd + shamt + func;

                    } else if (tipoDeInstrucao.equals("Rd")) {
                        String func = "";
                        if (comandos[0].equals("srl")) {
                            func = "000010";
                        }else{
                            func = "000000";
                        }
                        String opCode = "000000";
                        String rs = "00000";
                        String shamt = Identificar.imediato(comandos[3], 5);
                        String rt = Identificar.registrador(comandos[2]);
                        String rd = Identificar.registrador(comandos[1]);  
                        binarioFinal = binarioFinal + opCode + rs + rt + rd + shamt + func;  
                    } else if (tipoDeInstrucao.equals("I")) {
                        if (comandos[0].equals("lui")) {
                            String opCode = Identificar.opcodeTipoI(comandos[0]);
                            String rs = "00000";
                            String imediato = Identificar.imediato(comandos[2], 16);
                            String rd = Identificar.registrador(comandos[1]);
                            binarioFinal = binarioFinal + opCode + rs + rd + imediato;
                        } else {
                            String opCode = Identificar.opcodeTipoI(comandos[0]);
                            String rs = Identificar.registrador(comandos[1]);
                            String rt = Identificar.registrador(comandos[2]);
                            String imediato = Identificar.imediato(comandos[3], 16);
                            binarioFinal = binarioFinal + opCode + rt + rs + imediato;
                        }

                    } else if (tipoDeInstrucao.equals("Id")) {
                        if (comandos[0].equals("bne") || comandos[0].equals("beq")) {
                            String opCode = Identificar.opcodeTipoI(comandos[0]);
                            String rs = Identificar.registrador(comandos[2]);
                            String rt = Identificar.registrador(comandos[1]);
                            String imediato = Identificar.imediato(comandos[3], 16);
                            binarioFinal = binarioFinal + opCode + rs + rt + imediato;
                        } else {
                            String opCode = Identificar.opcodeTipoI(comandos[0]);
                            String rs = Identificar.registrador(comandos[1]);
                            String rt = "00000";
                            String imediato = Identificar.imediato(comandos[2], 16);
                            binarioFinal = binarioFinal + opCode + rs + rt + imediato;
                        }

                    } else if (tipoDeInstrucao.equals("J")) {
                        String opCode = "000010";
                        String imediato = Identificar.imediato(comandos[3], 26);
                        binarioFinal = binarioFinal + opCode + imediato;

                    } else if (tipoDeInstrucao.equals("Jr")) {
                        String opCode = "000000";
                        String rs = Identificar.registrador(comandos[1]);
                        String rt = "00000";
                        String rd = "00000";
                        String shamt = "00000";
                        String funct = "001000";
                        binarioFinal = binarioFinal + opCode + rs + rt + rd + shamt + funct;
                    } else if (tipoDeInstrucao.equals("Ils")) {
                        String opCode = Identificar.opcodeTipoI(comandos[0]);
                        String rs = Identificar.registrador(comandos[3]);
                        String rt = Identificar.registrador(comandos[1]);
                        String imediato = Identificar.imediato(comandos[2], 16);
                        binarioFinal = binarioFinal + opCode + rs + rt + imediato;
                    } else {
                        System.out.println(tipoDeInstrucao);
                    }
                    try (BufferedWriter bw = new BufferedWriter(new FileWriter(enderecoArquivoCriado, true))) {
                        bw.write(binarioFinal);
                        bw.newLine();
                    } catch (IOException e) {
                        System.out.println("Error na escrita do arquivo.");
                    }
                }
            } catch (FileNotFoundException e) {
                System.out.println("Erro" + e.getMessage());
            } finally {
                if (scanner != null) {
                    scanner.close();
                }
            }
        }

    }
}
