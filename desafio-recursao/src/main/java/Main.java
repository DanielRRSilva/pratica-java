public class Main {
    public static int buscarQuantidadeVendas(int[] precos, int i) {
        if (i == precos.length) return i;
        return buscarQuantidadeVendas(precos, i+1);
    }

    public static int somarVendas(int[] vendas, int i) {
        if (i == vendas.length) return 0;
        return vendas[i] += somarVendas(vendas, i+1);
    }

    public static boolean buscarPreco(int[] precos, int valor, int i) {
        if (i == precos.length) {
            return false;
        } else if (precos[i] == valor) {
            return true;
        }
        return buscarPreco(precos, valor, i+1);
    }

    public static int buscarMaiorPreco(int[] precos, int valor, int i) {
        if (i == precos.length) return valor;
        if (precos[i] > valor) valor = precos[i];
        return buscarMaiorPreco(precos,valor , i+1);
    }

    public static int buscarMenorPreco(int[] precos, int valor, int i) {
        if (i == precos.length) return valor;
        if (precos[i] < valor) valor = precos[i];
        return buscarMenorPreco(precos,valor , i+1);
    }

    public static int[] buscarPorPrecoMinimo(int[] precos, int posicao, int filtro, int[] precosFiltrados) {
        if (precos.length == posicao) return precosFiltrados;

        if (precos[posicao] >= filtro) {
            int[] listaTemporaria = new int[precosFiltrados.length + 1];
            listaTemporaria[0] = precos[posicao];

            for (int i = 0; i < listaTemporaria.length - 1; i++) {
                listaTemporaria[i + 1] = precosFiltrados[i];
            }

            return buscarPorPrecoMinimo(precos, posicao + 1, filtro, listaTemporaria);
        }
        return buscarPorPrecoMinimo(precos, posicao + 1, filtro, precosFiltrados);
    }
    public static void main(String[] args) {
        int[] precos = {3,2,3,4,5,6,7,8,1};
        System.out.println(buscarQuantidadeVendas(precos, 0));
        System.out.println(somarVendas(precos, 0));
        System.out.println(buscarPreco(precos, 2, 0));
        System.out.println(buscarMenorPreco(precos,precos[0],0));
    }
}
