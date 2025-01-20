package org.example.io;

import java.io.*;

public class Escritor {
    public static void main(String[] args) {
        try(
                OutputStream out = new FileOutputStream("filme.csv");
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out))
        ) {

            String pattern = "\n%s;%d;%b";
            bw.write("%s;%s;%s".formatted("Nome", "Valor","Bom"));
            bw.write(pattern.formatted("Harry Potter e a Pedra Filosofal",300,true));
            bw.write(pattern.formatted("Interestelar",9000,true));


        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            System.out.println("Erro ao escrever");
            e.printStackTrace();
        }
    }
}
