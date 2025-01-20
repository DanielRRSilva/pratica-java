import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void gerarMapa(int[] mapa) {
        for (int i = 0; i < mapa.length; i++) {
            int objeto = ThreadLocalRandom.current().nextInt(0,3);
            mapa[i] = objeto;
        }
    }

    public static void main(String[] args) {
        System.out.println("Bem Vindo a Caça ao Tesouro!!");
        Scanner leitor = new Scanner(System.in);
        int[] mapa = new int[15];
        Jogador[] jogadores = {new Jogador("Jogador 1"), new Jogador("Jogador 2") , new Jogador("Jogador 3")};
        int posicaoEscolhida = 0;
        int tesouros = 0;
        gerarMapa(mapa);
        for (int i = 0; i < mapa.length; i++) {
            if (mapa[i] == 1) {
                tesouros++;
            }
        }
        for (Jogador jogador : jogadores) {
            while (jogador.getAtivo() && tesouros > 0) {
                System.out.println("\n🎮 Vez do " + jogador.getNome() + " 🎮");
                System.out.println("\nMapa: 🗺️");
                for (int i = 0; i < mapa.length; i++) {
                    if (mapa[i] != 3) {
                        System.out.print(i +1 + " ");
                    }
                }
                System.out.println("\n\nEscolha uma das posições: ");
                posicaoEscolhida = leitor.nextInt();
                if(posicaoEscolhida <= 0 || posicaoEscolhida > mapa.length) {
                    System.out.println("Posição inválida!");
                }else {
                    posicaoEscolhida = posicaoEscolhida -1;

                    if(mapa[posicaoEscolhida] == 0) {
                        System.out.println("Você encontrou um campo vazio!");
                    } else if (mapa[posicaoEscolhida] == 1) {
                        System.out.println("Você encontrou um tesouro!");
                        tesouros--;
                        jogador.addTesouro();
                    }else if (mapa[posicaoEscolhida] == 2) {
                        System.out.println("Você caiu em uma armadilha. FIM DE JOGO!");
                        jogador.inativar();
                    } else {
                        System.out.println("CAMPO JÁ ESCAVADO");
                    }

                    mapa[posicaoEscolhida] = 3;
                }
            }
        }
        System.out.println("Placar do jogo:");
        for (Jogador jogador : jogadores) {
            System.out.println(jogador);
        }

    }
}
