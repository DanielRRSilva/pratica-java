package org.example;

import java.util.Scanner;

public class Main {

    public static void exibirMatriz(int[][] matriz) {
        for (int linha = 0; linha < matriz.length; linha++) {
            for (int coluna = 0; coluna < matriz[linha].length; coluna++) {
                System.out.printf("%d ", matriz[linha][coluna]);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] matriz = new int[3][4];

        int[][] matriz2 = {{10,15,20,25},{30,35,40,45},{50,55,60,65}};

        int[][] matrizDoida = {{10,15},{30,35,40,45},{50,55,60}};

//        for (int linha = 0; linha < matriz.length; linha++) {
//            for (int coluna = 0; coluna < matriz[linha].length; coluna++) {
//                System.out.printf("Digite o valor de [%d][%d]: \n", linha, coluna);
//                matriz[linha][coluna] = sc.nextInt();
//            }
//        }

        System.out.println("Exibindo dados da matriz:");
//        exibirMatriz(matriz);
        exibirMatriz(matriz2);
        exibirMatriz(matrizDoida);
    }
}