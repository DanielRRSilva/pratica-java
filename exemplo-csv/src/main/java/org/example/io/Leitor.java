package org.example.io;

import java.io.*;
import java.util.Scanner;

public class Leitor {
    public static void main(String[] args) {
        try (
                InputStream file = new FileInputStream("filme.csv");
                BufferedReader br = new BufferedReader(new InputStreamReader(file));
                Scanner leitor = new Scanner(br)
            )
        {
            leitor.useDelimiter("[;\\n]");
            leitor.nextLine();
            while (leitor.hasNext()) {
                String nomeFilme = leitor.next();
                Integer valorFilme = leitor.nextInt();
                Boolean filmeBom = leitor.nextBoolean();

                System.out.println("Nome filme: %s Valor Filme: %d Filme Bom: %b".formatted(nomeFilme, valorFilme, filmeBom));
            }
        }catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Não foi possível ler o arquivo");
        }
        catch (IOException e) {
            e.printStackTrace();
            System.out.println("Não foi possível ler o arquivo");
        }
    }
}
