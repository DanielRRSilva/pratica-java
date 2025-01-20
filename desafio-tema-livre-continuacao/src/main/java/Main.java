import java.util.ArrayList;
import java.util.Scanner;

public class Main {
   private static Lista<Programa> programas = new Lista<>();
   private static final Scanner leitoNumero = new Scanner(System.in);
   private static final Scanner leitorTexto = new Scanner(System.in);

    public static void menu() {
        int escolha;
        System.out.println("""
                \n
                1 - Cadastrar novo Programa
                2 - Ordenar por genero(Insertion Sort)
                3 - Ordenar por audiencia(Selection Sort)
                4 - Ordenar por numero de temporadas(Merge Sort)
                5 - Ordenar por ano lançamento(Quick Sort)
                6 - Pesquisa Binária por Nome
                7 - Somar numero de temporadas dos programas
                8 - Buscar programa mais antigo
                9 - Ver vetor
                10 - Exportar Dados
                11 - Importar Dados
                12 - Sair
                """);

        escolha = leitoNumero.nextInt();
        switch (escolha) {
            case 1:
                adicionarPrograma();
                break;
            case 2:
                Ordenar.insertionSortGenero(programas);
                break;
            case 3:
                Ordenar.selectionSortAudiencia(programas);
                break;
            case 4:
                Ordenar.mergeSortNumeroTemporada(0, programas.size(), programas);
                menu();
                break;
            case 5:
                Ordenar.quickSortAnoLancamento(programas,0, programas.size()-1);
                menu();
                break;
            case 6:
                Ordenar.insertionSortNome(programas);
                System.out.println("Qual o nome do programa?");
                String nome = leitorTexto.nextLine();
                System.out.println(Ordenar.binarySearchNome(programas, nome));
                break;
            case 7:
                System.out.println(Util.somarTemporadas(programas, 0));
                menu();
                break;
            case 8:
                System.out.println(Util.acharMaisAntigo(programas));
                menu();
                break;
            case 9:
                Util.exibirProgramas(programas);
                menu();
                break;
            case 10:
                Util.exportar(programas);
                menu();
                break;
            case 11:
                Util.importar(programas);
                menu();
                break;
            case 12:
                sair();
                break;
            default:
                menu();
                break;
        }
    }

    public static void adicionarPrograma() {
        String nome, genero;
        double audienciaMedia;
        int numeroTemporadas, anoLancamento;
        System.out.print("Insira o nome do Programa:");
        nome = leitorTexto.nextLine();
        System.out.print("Insira o genero do Programa:");
        genero = leitorTexto.nextLine();
        System.out.print("Insiara a audiencia média do Programa:");
        audienciaMedia = leitoNumero.nextDouble();
        System.out.print("Insira o numero de temporadas do Programa:");
        numeroTemporadas = leitoNumero.nextInt();
        System.out.print("Insira o ano de lançamento do Programa:");
        anoLancamento = leitoNumero.nextInt();
        programas.add(new Programa(programas.size()+1, nome, genero, audienciaMedia, numeroTemporadas, anoLancamento));
        menu();
    }

    public static void sair() {
        System.out.println("Obrigado por utilizar este sistema, até a próxima!");
    }

    public static void main(String[] args) {
        programas.add(new Programa(1, "Breaking Bad", "Drama", 9.5, 5, 2008));
        programas.add(new Programa(2, "Friends", "Comédia", 8.9, 10, 1994));
        programas.add(new Programa(3, "Game of Thrones", "Fantasia", 9.3, 8, 2011));
        programas.add(new Programa(4, "Stranger Things", "Ficção Científica", 8.7, 4, 2016));
        programas.add(new Programa(5, "The Office", "Comédia", 8.8, 9, 2005));
        programas.add(new Programa(6, "The Mandalorian", "Ação", 8.8, 3, 2019));
        programas.add(new Programa(7, "The Crown", "História", 8.7, 6, 2016));
        programas.add(new Programa(8, "Sherlock", "Mistério", 9.1, 4, 2010));
        menu();
    }
}
