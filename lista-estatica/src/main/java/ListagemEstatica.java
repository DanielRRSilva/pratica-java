import java.util.Arrays;
import java.util.NoSuchElementException;

public class ListagemEstatica {
    int[] vetor;
    int nmrElem;

    public ListagemEstatica(int tamanho) {
        this.vetor = new int[tamanho];
        nmrElem = 0;
    }

    public void add(int numero) {
        if (nmrElem == vetor.length) System.out.println("Lista cheia");
        vetor[nmrElem++] = numero;
    }

    public void show() {
        System.out.println(Arrays.toString(vetor));
    }

    public int find(int numero) {
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] == numero) return i;
        }
        throw new NoSuchElementException();
    }

    public boolean removeByIndex(int i) {
        if (i > vetor.length-1) throw new IndexOutOfBoundsException();
        int[] vetorAux = new int[vetor.length];
        for (int j = 0; j < vetor.length; j++) {
            if (j == i){
                vetorAux[j] = vetor[j+1];
                j++;
            }else {
                vetorAux[j] = vetor[j];
            }
        }
        vetor = vetorAux;
        return true;
    }

    public boolean removeElement(int numero) {
        int[] vetorAux = new int[vetor.length];
        for (int j = 0; j < vetor.length; j++) {
            if (vetor[j] == numero) {
                vetorAux[j] = vetor[j+1];
                j++;
            }else {
                vetorAux[j] = vetor[j];
            }
        }
        return true;
    }
}
