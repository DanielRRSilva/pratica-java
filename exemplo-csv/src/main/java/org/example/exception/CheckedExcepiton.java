package org.example.exception;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class CheckedExcepiton {
    public static void main(String[] args) {
        try {
            lerArquivo();
        }catch(FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void lerArquivo() throws FileNotFoundException {
            FileReader fr = new FileReader("pessoa.csv");
    }
}
