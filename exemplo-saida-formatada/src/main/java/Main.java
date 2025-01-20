import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Aluno> alunos = new ArrayList<>();
        Aluno al01 = new Aluno(234, "Bob", 8.4, 3);
        Aluno al02 = new Aluno(235, "Amanda", 6.7, 1);
        Aluno al03 = new Aluno(236, "Sim", 2.3, 7);
        alunos.add(al01);
        alunos.add(al02);
        alunos.add(al03);
        System.out.printf("|%-6S|%-15S|%6S|%6S|","ra", "nome", "nota", "faltas");
        for (Aluno aluno : alunos) {
            System.out.printf("\n|%-6d|%-15s|%6.2f|%6d|", aluno.getRa(), aluno.getNome(), aluno.getNotaFinal(), aluno.getQtdFaltas());
        }
    }
}
