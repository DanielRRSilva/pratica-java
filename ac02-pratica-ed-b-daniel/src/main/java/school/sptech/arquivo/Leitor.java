package school.sptech.arquivo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Leitor {

    public static List<Produto> lerProdutos(String nomeArq) {

        List<Produto> novosProdutos = new ArrayList<>();

        FileReader arq = null;
        Scanner entrada = null;
        Boolean deuRuim = false;

        nomeArq += ".csv";

        try {
            arq = new FileReader(nomeArq);
            entrada = new Scanner(arq).useDelimiter(";|\\n");
        } catch (FileNotFoundException erro) {
            System.out.println("Erro ao abrir o arquivo");
            erro.printStackTrace();
            System.exit(1);
        }

        try {
            // NÂO ALTERE ESSA LINHA
            entrada.nextLine();

            while (entrada.hasNextLine()) {
                // [COMPLETAR CÓDIGO ABAIXO]
                // Altere as linhas abaixo para preencher as variáveis com as informações lidas do arquivo:
                Integer idLido = entrada.nextInt();
                String nomeLido = entrada.next();
                String categoriaLida = entrada.next();
                Integer pontuacaoLida = entrada.nextInt();
                Double precoLido = entrada.nextDouble();
                Integer quantidadeEstoqueLida = entrada.nextInt();

                // [COMPLETAR CÓDIGO ABAIXO]
                // Na linha abaixo desse comentário, crie um objeto de Produto com as informações lidas
                // adicione o produto criado na lista chamdada novosProdutos (criada na linha 11 dessa classe)
                Produto novoProduto = new Produto(idLido, nomeLido, categoriaLida, pontuacaoLida, precoLido, quantidadeEstoqueLida);
                novosProdutos.add(novoProduto);
            }
        } catch (NoSuchElementException erro) {
            System.out.println("Arquivo com problemas");
            erro.printStackTrace();
            deuRuim = true;
        } catch (IllegalStateException erro) {
            System.out.println("Erro na leitura do arquivo");
            erro.printStackTrace();
            deuRuim = true;
        } finally {
            entrada.close();
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
        return novosProdutos;
    }

    public static void main(String[] args) {
        //Rode esse main caso queira testar a leitura do arquivo além dos testes automatizados:
        List<Produto> produtosLidos = lerProdutos("novos-produtos");

        System.out.println("Exibindo lista de produtos lidos:");
        for (int i = 0; i < produtosLidos.size(); i++) {
            System.out.println(produtosLidos.get(i));
        }
    }
}
