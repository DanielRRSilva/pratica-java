import java.util.Arrays;

public class Main {
    public static void mergeSort(int p, int r, int[] v) {
        if (p < r-1) {
            int q = (p+r) /2;
            mergeSort(p, q ,v);
            mergeSort(q, r,v);
            intercalar(p, q, r, v);
        }
    }

    public static void intercalar(int p, int q, int r, int[] v) {
        int i, j, k, w[];
        i = p;
        j = q;
        k = 0;
        w = new int[r-p];

        while (i < q && j < r) {
            if (v[i] <= v[j]) {
                w[k++] = v[i++];
            }else {
                w[k++] = v[j++];
            }
        }

        while (i < q) {
            w[k++] = v[i++];
        }

        while (j < r) {
            w[k++] = v[j++];
        }

        for (i = p; i < r; i++) {
            v[i] = w[i-p];
        }
    }

    public static void quickSort(int[] v, int indInicio, int indFim) {
        int i, j, pivo;
        i = indInicio;
        j= indFim;
        pivo = v[(indInicio+indFim)/2];
        while (i <= j) {
            while (i < indFim && v[i] < pivo) {
                i = i+1;
            }

            while (j > indInicio && v[j] > pivo) {
                j = j-1;
            }
            if (i <= j) {
                int aux = v[i];
                v[i] = v[j];
                v[j] = aux;
                i = i+1;
                j= j-1;
            }
            if (indInicio < j) quickSort(v,indInicio, j);
            if (i < indFim) quickSort(v, i, indFim);
        }
    }

    public static void main(String[] args) {
        int[] teste= {1,2,6,814,52,1234,32,45};
        mergeSort(0, teste.length, teste);
//        quickSort(teste,0,teste.length-1);
        System.out.println(Arrays.toString(teste));
    }
}
