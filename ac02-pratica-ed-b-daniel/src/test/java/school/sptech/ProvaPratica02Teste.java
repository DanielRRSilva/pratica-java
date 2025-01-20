package school.sptech;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import school.sptech.arquivo.Escritor;
import school.sptech.arquivo.Leitor;
import school.sptech.arquivo.Produto;
import school.sptech.lista.estatica.ListaEstatica;

@DisplayName("Testes Prova Prática 02")
public class ProvaPratica02Teste {

    @Test
    @DisplayName("Método adicionaNoIndice - O elemento deve ser adicionado no indice correto")
    public void adicionaNoIndice_adiciona() {
        ListaEstatica lista = new ListaEstatica(5);
        lista.adiciona(10);
        lista.adiciona(20);
        lista.adiciona(30);
        lista.adiciona(40);

        lista.adicionaNoIndice(2, 42);

        assertEquals(42, lista.getVetor()[2]);
        assertEquals(30, lista.getVetor()[3]);
    }

    @Test
    @DisplayName("Método adicionaNoIndice - O número de elementos deve ser atualizado")
    public void adicionaNoIndice_numElementos() {
        ListaEstatica lista = new ListaEstatica(5);
        lista.adiciona(10);
        lista.adiciona(20);
        lista.adiciona(30);
        lista.adiciona(40);

        lista.adicionaNoIndice(2, 42);

        assertEquals(5, lista.getNroElem());
    }

    @Test
    @DisplayName("Método adicionaNoIndice - Os elementos seguintes devem ser reposicionados")
    public void adicionaNoIndice_reposicionaElementos() {
        ListaEstatica lista = new ListaEstatica(5);
        lista.adiciona(10);
        lista.adiciona(20);
        lista.adiciona(30);
        lista.adiciona(40);

        lista.adicionaNoIndice(2, 42);

        assertEquals(30, lista.getVetor()[3]);
        assertEquals(40, lista.getVetor()[4]);
    }

    @Test
    @DisplayName("Método adicionaNoIndice - Deve lançar IllegalStateException quando a lista estiver cheia")
    public void adicionaNoIndice_validaListaCheia() {
        ListaEstatica lista = new ListaEstatica(5);
        lista.adiciona(10);
        lista.adiciona(20);
        lista.adiciona(30);
        lista.adiciona(40);
        lista.adiciona(40);

        assertThrows(IllegalStateException.class, () -> lista.adicionaNoIndice(2, 42));

    }

    @Test
    @DisplayName("Método adicionaNoIndice - Deve lançar IllegalArgumentException quando o índice for inválido")
    public void adicionaNoIndice_validaIndice() {
        ListaEstatica lista = new ListaEstatica(5);
        lista.adiciona(10);
        lista.adiciona(20);
        lista.adiciona(30);
        lista.adiciona(40);

        assertThrows(IllegalArgumentException.class, () -> lista.adicionaNoIndice(100, 42));
    }

    @Test
    @DisplayName("Método removePares - Devolve a quantidade correta removida")
    public void removePares_retornaQuantidade() {

        ListaEstatica lista = new ListaEstatica(10);
        for (int i = 1; i <= 10; i++) {
            lista.adiciona(i);
        }

        int removidos = lista.removePares();

        assertEquals(5, removidos);

        int[] esperado = {1, 3, 5, 7, 9};
        for (int i = 0; i < lista.getNroElem(); i++) {
            assertEquals(esperado[i], lista.getVetor()[i]);
        }
    }

    @Test
    @DisplayName("Método removePares - Deve remover os pares do vetor")
    public void removePares_remove() {
        ListaEstatica lista = new ListaEstatica(10);
        for (int i = 1; i <= 10; i++) {
            lista.adiciona(i);
        }

        lista.removePares();

        int[] esperado = {1, 3, 5, 7, 9};
        for (int i = 0; i < lista.getNroElem(); i++) {
            assertEquals(esperado[i], lista.getVetor()[i]);
        }
    }

    @Test
    @DisplayName("Método removePares - Deve remover quando houver dois pares seguidos")
    public void removePares_removeSeguidos() {
        ListaEstatica lista = new ListaEstatica(10);
        for (int i = 1; i <= 10; i++) {
            lista.adiciona(i);
        }

        lista = new ListaEstatica(10);
        lista.adiciona(11);
        lista.adiciona(20);
        lista.adiciona(30);
        lista.adiciona(41);
        lista.removePares();

        int[] esperado = {11, 41};
        for (int i = 0; i < lista.getNroElem(); i++) {
            assertEquals(esperado[i], lista.getVetor()[i]);
        }
    }

    @Test
    @DisplayName("Método removePares - Devolve 0 se não houver par")
    public void removePares_semPares() {
        ListaEstatica lista = new ListaEstatica(10);
        for (int i = 1; i <= 10; i++) {
            lista.adiciona(i);
        }

        lista = new ListaEstatica(5);
        lista.adiciona(1);
        lista.adiciona(3);
        lista.adiciona(5);
        lista.adiciona(7);
        lista.adiciona(9);

        int removidos = lista.removePares();

        assertEquals(0, removidos);
    }

    @Test
    @DisplayName("Classe Escritor - Cria arquivo produtos.csv")
    public void escritor_criaArquivo() {
        File arquivo = new File("produtos.csv");
        if (arquivo.exists()) {
            arquivo.delete();
        }
        assertFalse(arquivo.exists());
        Escritor.escreverArquivo(Escritor.produtos, "produtos");
        assertTrue(arquivo.exists());
    }

    @Test
    @DisplayName("Classe Escritor - Cria corpo (dados) corretamente")
    public void escritor_Corpo() {
        Escritor.escreverArquivo(Escritor.produtos, "produtos");

        File arquivo = new File("produtos.csv");
        assertTrue(arquivo.exists());

        try {
            List<String> linhas = Files.readAllLines(Paths.get("produtos.csv"),
                  StandardCharsets.UTF_8);

            String[] produtosEsperados = {
                  "100;Potes;Cozinha;5;10.65;67",
                  "101;Sabão em Pó;Limpeza;2;9.99;8",
                  "102;Mouse;Eletronicos;5;80.50;10",
                  "103;Teclado;Eletronicos;1;150.93;5",
                  "104;Pão Francês;Padaria;3;5.33;23",
                  "105;Brigadeiro;Padaria;4;4.10;130"
            };

            for (int i = 0; i < produtosEsperados.length; i++) {
                String esperadoComPonto = produtosEsperados[i];
                String esperadoComVirgula = produtosEsperados[i].replace(".", ",");

                String linhaGerada = linhas.get(i + 1);
                assertTrue(linhaGerada.equals(esperadoComPonto) || linhaGerada.equals(
                      esperadoComVirgula));
            }

        } catch (IOException e) {
            fail("Erro ao ler o arquivo produtos.csv.");
        }
    }

    @Test
    @DisplayName("Classe Leitor - Retorna lista com produtos lidos do arquivo novos-produtos.csv")
    public void testLerProdutos() {
        List<Produto> produtos = Leitor.lerProdutos("novos-produtos");

        assertNotNull(produtos, "A lista de produtos não deve ser nula.");
        assertFalse(produtos.isEmpty(), "A lista de produtos não deve estar vazia.");

        assertEquals(3, produtos.size(), "O número de produtos lidos do arquivo está incorreto.");

        Produto produto1 = produtos.get(0);
        assertEquals(106, produto1.getId(), "O ID do primeiro produto está incorreto.");
        assertEquals("Cabo USB", produto1.getNome(), "O nome do primeiro produto está incorreto.");
        assertEquals("Eletronicos", produto1.getCategoria(),
              "A categoria do primeiro produto está incorreta.");
        assertEquals(1, produto1.getPontuacao(), "A pontuação do primeiro produto está incorreta.");
        assertEquals(10.95, produto1.getPreco(), 0.01,
              "O preço do primeiro produto está incorreto."); // Permite variação com ponto ou vírgula
        assertEquals(1, produto1.getQuantidadeEstoque(),
              "A quantidade em estoque do primeiro produto está incorreta.");

        Produto produto2 = produtos.get(1);
        assertEquals(107, produto2.getId(), "O ID do segundo produto está incorreto.");
        assertEquals("Sonho", produto2.getNome(), "O nome do segundo produto está incorreto.");
        assertEquals("Padaria", produto2.getCategoria(),
              "A categoria do segundo produto está incorreta.");
        assertEquals(4, produto2.getPontuacao(), "A pontuação do segundo produto está incorreta.");
        assertEquals(7.90, produto2.getPreco(), 0.01,
              "O preço do segundo produto está incorreto."); // Permite variação com ponto ou vírgula
        assertEquals(25, produto2.getQuantidadeEstoque(),
              "A quantidade em estoque do segundo produto está incorreta.");

        Produto produto3 = produtos.get(2);
        assertEquals(108, produto3.getId(), "O ID do terceiro produto está incorreto.");
        assertEquals("Folha", produto3.getNome(), "O nome do terceiro produto está incorreto.");
        assertEquals("Papelaria", produto3.getCategoria(),
              "A categoria do terceiro produto está incorreta.");
        assertEquals(3, produto3.getPontuacao(), "A pontuação do terceiro produto está incorreta.");
        assertEquals(4.50, produto3.getPreco(), 0.01,
              "O preço do terceiro produto está incorreto."); // Permite variação com ponto ou vírgula
        assertEquals(156, produto3.getQuantidadeEstoque(),
              "A quantidade em estoque do terceiro produto está incorreta.");
    }
}
