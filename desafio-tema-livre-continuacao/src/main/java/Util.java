import java.io.*;
import java.util.Scanner;

public class Util {
    public static int somarTemporadas(Lista<Programa> lista, int index) {
        if (index == lista.size()) return 0;
        int numeroTemporadas = lista.get(index).getNumeroDeTemporadas();
        return numeroTemporadas += somarTemporadas(lista, index+1);
    }

    public static int acharMaisAntigo(Lista<Programa> lista) {
        Programa programa = lista.get(0);
        int posicaoAntigo = 0;
        for (int i = 1; i < lista.size(); i++) {
            if (lista.get(i).getNumeroDeTemporadas() > programa.getNumeroDeTemporadas()) {
                programa = lista.get(i);
                posicaoAntigo = i;
            }
        }
        return posicaoAntigo;
    }

    public static void exibirProgramas(Lista<Programa> lista) {
        System.out.printf("\n|%5S|%25S|%25S|%25S|%25S|%25S|", "id", "nome", "genero", "audiencia media", "numero de temporadas", "ano de lancamento");
        for (int i = 0; i < lista.size(); i++) {
            System.out.printf("\n|%5d|%25s|%25s|%25.1f|%25d|%25d|",
                    lista.get(i).getId(),
                    lista.get(i).getNome(),
                    lista.get(i).getGenero(),
                    lista.get(i).getAudienciaMedia(),
                    lista.get(i).getNumeroDeTemporadas(),
                    lista.get(i).getAnoDeLancamento());
        }
    }

    public static void exportar(Lista<Programa> lista) {
        try(
                OutputStream file = new FileOutputStream("programas.csv");
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(file));
                ){

            String pattern = "\n%d;%s;%s;%.2f;%d;%d";
            for (int i = 0; i < lista.size(); i++) {
                bufferedWriter.write(pattern.formatted(
                        lista.get(i).getId(),
                        lista.get(i).getNome(),
                        lista.get(i).getGenero(),
                        lista.get(i).getAudienciaMedia(),
                        lista.get(i).getNumeroDeTemporadas(),
                        lista.get(i).getAnoDeLancamento())
                );
            }

        }catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Erro ao exportar programas");
        }
        catch (IOException e) {
            e.printStackTrace();
            System.out.println("Erro ao exportar programas");
        }
    }

    public static void importar(Lista<Programa> lista) {
        try(
            InputStream file = new FileInputStream("novos-dados.csv");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(file));
            Scanner scanner = new Scanner(bufferedReader);
                ) {

            scanner.useDelimiter("[;\\n]");
            while (scanner.hasNextLine()) {
                Integer id = scanner.nextInt();
                String nome = scanner.next();
                String genero = scanner.next();
                Double audienciaMedia = scanner.nextDouble();
                Integer numeroDeTemporadas = scanner.nextInt();
                Integer anoDeLancamento = scanner.nextInt();

                Programa programa = new Programa(id, nome, genero, audienciaMedia,numeroDeTemporadas,anoDeLancamento);
                lista.add(programa);
            }

        }catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Erro ao importar novos dados");
        }catch (IOException e) {
            e.printStackTrace();
            System.out.println("Erro ao importar novos dados");
        }
    }
}