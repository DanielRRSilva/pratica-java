public class ListaLigada {

    private Node head;

    public ListaLigada() {
        head = new Node(0);
    }

    public void insereNode(int valor) {
        Node novo = new Node(valor);
        novo.setNext(head.getNext());
        head.setNext(novo);
    }

    public void exibe() {
        Node atual = head.getNext();
        while (atual != null) {
            System.out.println(atual.getInfo());
            atual.getNext();
        }
    }

    public Node buscaNode(int valor) {
        Node atual = head.getNext();
        
    }

}
