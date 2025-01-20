package school.sptech.arquivo;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.List;

public class Escritor {

    public static List<Produto> produtos = new ArrayList<>(List.of(
          new Produto(100, "Potes", "Cozinha", 5, 10.65, 67),
          new Produto(101, "Sabão em Pó", "Limpeza", 2, 9.99, 8),
          new Produto(102, "Mouse", "Eletronicos", 5, 80.50, 10),
          new Produto(103, "Teclado", "Eletronicos", 1, 150.93, 5),
          new Produto(104, "Pão Francês", "Padaria", 3, 5.33, 23),
          new Produto(105, "Brigadeiro", "Padaria", 4, 4.10, 130)));

    public static void escreverArquivo(List<Produto> lista, String nomeArq) {
        FileWriter arq = null;
        Formatter saida = null;
        Boolean deuRuim = false;

        nomeArq += ".csv";

        try {
            arq = new FileWriter(nomeArq);
            saida = new Formatter(arq);
        } catch (IOException erro) {
            System.out.println("Erro ao abrir o arquivo");
            erro.printStackTrace();
            System.exit(1);
        }

        try {
            // NÂO ALTERE ESSA LINHA
            saida.format("%s;%s;%s;%s;%s;%s\n",
                  "id", "nome", "categoria", "pontuacao", "preco", "quantidadeEstoque");

            // [COMPLETAR CÓDIGO ABAIXO]
            // Escrevendo corpo (dados): complete a linha abaixo trocando "x" pelo código necessário por gravar o corpo do csv
            // Lembre-se de percorrer a lista para escrever um produto por vez
            // saida.format("x");
            String pattern = "%d;%s;%s;%d;%.2f;%d\n";
            for (Produto produto : lista) {
                saida.format(pattern.formatted(
                        produto.getId(),
                        produto.getNome(),
                        produto.getCategoria(),
                        produto.getPontuacao(),
                        produto.getPreco(),
                        produto.getQuantidadeEstoque()
                ));
            }

        } catch (FormatterClosedException erro) {
            System.out.println("Erro ao gravar o arquivo");
            erro.printStackTrace();
            deuRuim = true;
        } finally {
            saida.close();
            try {
                arq.close();
            } catch (IOException erro) {
                System.out.println("Erro ao fechar o arquivo");
                deuRuim = true;
            }
            if (deuRuim) {
                System.exit(1);
            }
        }
    }

    public static void main(String[] args) {
        // Rode esse main caso queira testar a escrita do arquivo além dos testes automátizados:
        escreverArquivo(produtos, "produtos");
    }
}
