import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ListagemEstatica listagemEstatica = new ListagemEstatica(2);
        listagemEstatica.add(1);
        listagemEstatica.add(2);
        listagemEstatica.show();
        System.out.println(listagemEstatica.find(2));
        listagemEstatica.removeByIndex(0);
        listagemEstatica.show();
        listagemEstatica.removeElement(2);
    }
}
