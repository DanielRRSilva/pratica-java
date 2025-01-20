public class Ordenar {
    public static void insertionSortGenero(Lista<Programa> lista) {
        int j;
        Programa aux;
        for (int i = 1; i < lista.size(); i++) {
            aux = lista.get(i);
            j = i-1;
            while (j >= 0 && lista.get(j).getGenero().compareTo(aux.getGenero()) > 0) {
                lista.add(j+1, lista.get(j));
                j = j-1;
            }
            lista.add(j+1, aux);
        }
        Main.menu();
    }

    public static void insertionSortNome(Lista<Programa> lista) {
        int j;
        Programa aux;
        for (int i = 1; i < lista.size(); i++) {
            aux = lista.get(i);
            j = i-1;
            while (j >= 0 && lista.get(j).getNome().compareTo(aux.getNome()) > 0) {
                lista.add(j+1, lista.get(j));
                j = j-1;
            }
            lista.add(j+1, aux);
        }
    }

    public static void selectionSortAudiencia(Lista<Programa> lista) {
        for (int i = 0; i < lista.size() -1; i++) {
            int posicao = i;
            Programa aux;
            for (int j = i + 1; j < lista.size(); j++) {
                if (lista.get(j).getAudienciaMedia() < lista.get(posicao).getAudienciaMedia()) {
                    posicao = j;
                }
            }
            aux = lista.get(i);
            lista.add(i, lista.get(posicao));
            lista.add(posicao, aux);
        }
        Main.menu();
    }

    public static void mergeSortNumeroTemporada(int indInicio, int indFim, Lista<Programa> lista) {
        if (indInicio < indFim-1) {
            int indMeio = (indInicio+indFim) /2;
            mergeSortNumeroTemporada(indInicio, indMeio ,lista);
            mergeSortNumeroTemporada(indMeio, indFim,lista);
            intercalarNumeroTemporada(indInicio, indMeio, indFim, lista);
        }
    }

    public static void intercalarNumeroTemporada(int indInicio, int indMeio, int indFim, Lista<Programa> lista) {
        int inicio, meio, fim;
        Lista<Programa> listaAux = new Lista<>(lista.size());
        inicio = indInicio;
        meio = indMeio;
        fim = 0;

        while (inicio < indMeio && meio < indFim) {
            if (lista.get(inicio).getNumeroDeTemporadas() <= lista.get(meio).getNumeroDeTemporadas()) {
                listaAux.add(fim++, lista.get(inicio++));
            }else {
                listaAux.add(fim++, lista.get(meio++));
            }
        }

        while (inicio < indMeio) {
            listaAux.add(fim++, lista.get(inicio++));
        }

        while (meio < indFim) {
            listaAux.add(fim++, lista.get(meio++));
        }

        for (inicio = indInicio; inicio < indFim; inicio++) {
            lista.add(inicio, listaAux.get(inicio-indInicio));
        }
    }

    public static void quickSortAnoLancamento(Lista<Programa> lista, int indInicio, int indFim) {
        int i = indInicio;
        int j = indFim;
        int pivo = lista.get((indInicio + indFim) / 2).getAnoDeLancamento();

        while (i <= j) {

            while (i < indFim && lista.get(i).getAnoDeLancamento() < pivo) {
                i = i + 1;
            }

            while (j > indInicio && lista.get(j).getAnoDeLancamento() > pivo) {
                j = j - 1;
            }

            if (i <= j) {
                Programa aux = lista.get(i);
                lista.add(i, lista.get(j));
                lista.add(j, aux);
                i = i + 1;
                j = j - 1;
            }
        }

        if (indInicio < j) {
            quickSortAnoLancamento(lista,indInicio, j);
        }
        if (i < indFim) {
            quickSortAnoLancamento(lista, i, indFim);
        }
    }

    public static int binarySearchNome(Lista<Programa> lista, String nome) {
        int indexInicio = 0;
        int indexFim = lista.size() - 1;
        while (indexInicio <= indexFim) {
            int meio = (indexInicio + indexFim)/2;
            if (nome.equals(lista.get(meio).getNome())) {
                return meio;
            }else if (nome.compareTo(lista.get(meio).getNome()) < 0) {
                indexFim = meio - 1;
            }else {
                indexInicio = meio + 1;
            }
        }
        return -1;
    }
}
