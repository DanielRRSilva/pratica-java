package school.sptech;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("GestaoClinica")
public class GestaoClinicaTest {
    @Test
    @DisplayName("Método salvar - Salva corretamente os recursos")
    public void salvarTest() {
        GestaoClinica gestao = new GestaoClinica();
        gestao.salvar(new Recurso(101, "Veterinário", 5));
        gestao.salvar(new Recurso(102, "Aparelho Raio-X", 2));
        gestao.salvar(new Recurso(103, "Enfermeiro", 10));

        List<Recurso> lista = gestao.getLista();
        assertEquals(3, lista.size());
        assertEquals("Veterinário", lista.get(0).getNome());
        assertEquals(5, lista.get(0).getQuantidade());
        assertEquals("Aparelho Raio-X", lista.get(1).getNome());
        assertEquals(2, lista.get(1).getQuantidade());
        assertEquals("Enfermeiro", lista.get(2).getNome());
        assertEquals(10, lista.get(2).getQuantidade());
    }

    @Test
    @DisplayName("Método diminuiRecurso - Diminui corretamente a quantidade de recursos e empilha")
    public void diminuiRecursoTest() {
        GestaoClinica gestao = new GestaoClinica();
        gestao.salvar(new Recurso(101, "Veterinário", 20));
        gestao.salvar(new Recurso(102, "Aparelho Raio-X", 10));

        gestao.diminuiRecurso(5);
        List<Recurso> lista = gestao.getLista();
        assertEquals(15, lista.get(0).getQuantidade());
        assertEquals(5, lista.get(1).getQuantidade());

        assertFalse(gestao.getPilhaDesfazer().isEmpty());
        assertEquals(5, gestao.getPilhaDesfazer().peek());
    }

    @Test
    @DisplayName("Método aumentaRecurso - Aumenta corretamente a quantidade de recursos")
    public void aumentaRecursoTest() {
        GestaoClinica gestao = new GestaoClinica();
        gestao.salvar(new Recurso(101, "Veterinário", 10));
        gestao.salvar(new Recurso(102, "Aparelho Raio-X", 5));

        gestao.aumentaRecurso(5);
        List<Recurso> lista = gestao.getLista();
        assertEquals(15, lista.get(0).getQuantidade());
        assertEquals(10, lista.get(1).getQuantidade());
    }

    @Test
    @DisplayName("Método desfazer - Desfaz corretamente a última diminuição")
    public void desfazerTest() {
        GestaoClinica gestao = new GestaoClinica();
        gestao.salvar(new Recurso(101, "Veterinário", 20));
        gestao.salvar(new Recurso(102, "Aparelho Raio-X", 10));

        gestao.diminuiRecurso(5);
        gestao.desfazer();
        List<Recurso> lista = gestao.getLista();
        assertEquals(20, lista.get(0).getQuantidade());
        assertEquals(10, lista.get(1).getQuantidade());

        assertFalse(gestao.getPilhaRefazer().isEmpty());
        assertEquals(5, gestao.getPilhaRefazer().peek());
    }

    @Test
    @DisplayName("Método refazer - Refaz corretamente a última diminuição desfeita")
    public void refazerTest() {
        GestaoClinica gestao = new GestaoClinica();
        gestao.salvar(new Recurso(101, "Veterinário", 20));
        gestao.salvar(new Recurso(102, "Aparelho Raio-X", 10));

        gestao.diminuiRecurso(5);
        gestao.desfazer();
        gestao.refazer();
        List<Recurso> lista = gestao.getLista();
        assertEquals(15, lista.get(0).getQuantidade());
        assertEquals(5, lista.get(1).getQuantidade());
    }

}
