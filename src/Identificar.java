public class Identificar{

    public String registrador(String x){
        String registrador = "";
        if (x.equals("$r0")|| x.equals("$zero")){
            registrador = registrador + "00000"; //R0 = 0
        } else if (x.equals("$at")){ 
            registrador = registrador + "00001"; // R1 = 1
        } else if (x.equals("$v0")){ 
            registrador = registrador + "00010"; // R2 = 2
        } else if (x.equals("$v1")){ 
            registrador = registrador + "00011"; // R3 = 3
        } else if (x.equals("$a0")){ 
            registrador = registrador + "00100"; // R4 = 4
        } else if (x.equals("$a1")){ 
            registrador = registrador + "00101"; // R5 = 5
        } else if (x.equals("$a2")){ 
            registrador = registrador + "00110"; // R6 = 6
        } else if (x.equals("$a3")){ 
            registrador = registrador + "00111"; // R7 = 7
        } else if (x.equals("$t0")){ 
            registrador = registrador + "01000"; // R8 = 8
        } else if (x.equals("$t1")){ 
            registrador = registrador + "01001"; // R9 = 9
        } else if (x.equals("$t2")){ 
            registrador = registrador + "01010"; // R10 = 10
        } else if (x.equals("$t3")){ 
            registrador = registrador + "01011"; // R11 = 11
        } else if (x.equals("$t4")){ 
            registrador = registrador + "01100"; // R12 = 12
        } else if (x.equals("$t5")){ 
            registrador = registrador + "01101"; // R13= 13
        } else if (x.equals("$t6")){ 
            registrador = registrador + "01110"; // R14 = 14
        } else if (x.equals("$t7")){ 
            registrador = registrador + "01111"; // R15 = 15
        } else if (x.equals("$s0")){ 
            registrador = registrador + "10000"; // R16 = 16
        } else if (x.equals("$s1")){ 
            registrador = registrador + "10001"; // R17 = 17
        } else if (x.equals("$s2")){ 
            registrador = registrador + "10010"; // R18 = 18
        } else if (x.equals("$s3")){ 
            registrador = registrador + "10011"; // R19 = 19
        } else if (x.equals("$s4")){ 
            registrador = registrador + "10100"; // R20 = 20
        } else if (x.equals("$s5")){ 
            registrador = registrador + "10101"; // R21 = 21
        } else if (x.equals("$s6")){ 
            registrador = registrador + "10110"; // R22 = 22
        } else if (x.equals("$s7")){ 
            registrador = registrador + "10111"; // R23 = 23
        } else if (x.equals("$t8")){ 
            registrador = registrador + "11000"; // R24 = 24
        } else if (x.equals("$t9")){ 
            registrador = registrador + "11001"; // R25 = 25
        } else if (x.equals("$k0")){ 
            registrador = registrador + "11010"; // R26 = 26
        } else if (x.equals("$k1")){ 
            registrador = registrador + "11011"; // R27 = 27
        } else if (x.equals("$gp")){ 
            registrador = registrador + "11100"; // R28 = 28
        } else if (x.equals("$sp")){ 
            registrador = registrador + "11101"; // R29 = 29
        } else if (x.equals("$s8")){ 
            registrador = registrador + "11110"; // R30 = 30
        } else if (x.equals("$ra")){ 
            registrador = registrador + "11111"; // R31 = 31
        } else [
            registrador = registrador + "Não listado"; // erro
        ]
        return registrador;
    }

    public String imediato(String y, int qntdBits){
        int numero = Integer.parseInt(y);
        String resultado = "";
        if (numero<0){
            resultado += String.format("%" + qntdBits + "s",
            Integer.toBinaryString(numero)).replace(' ', '1');
        } else {
            resultado += String.format("%" + qntdBits + "s",
            Integer.toBinaryString(numero)).replace(' ', '0');
        }
        return resultado;
    }

}