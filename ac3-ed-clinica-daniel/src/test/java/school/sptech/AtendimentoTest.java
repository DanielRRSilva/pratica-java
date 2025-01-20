package school.sptech;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Atendimento")
public class AtendimentoTest {

    @Test
    @DisplayName("Método salvar - Deve adicionar corretamente os recursos na lista")
    public void salvarRecursoTest() {
        GestaoClinica gestao = new GestaoClinica();

        gestao.salvar(new Recurso(1, "Veterinário", 5));
        gestao.salvar(new Recurso(2, "Raio X", 2));

        assertEquals(2, gestao.getLista().size());
        assertEquals("Veterinário", gestao.getLista().get(0).getNome());
        assertEquals(2, gestao.getLista().get(1).getQuantidade());
    }

    @Test
    @DisplayName("Método diminuiRecurso - Deve diminuir corretamente a quantidade dos recursos e empilhar na pilhaDesfazer")
    public void diminuiRecursoTest() {
        GestaoClinica gestao = new GestaoClinica();
        gestao.salvar(new Recurso(1, "Veterinário", 10));
        gestao.salvar(new Recurso(2, "Raio X", 5));

        gestao.diminuiRecurso(2);

        assertEquals(8, gestao.getLista().get(0).getQuantidade());
        assertEquals(3, gestao.getLista().get(1).getQuantidade());
        assertFalse(gestao.getPilhaDesfazer().isEmpty());
        assertEquals(2, gestao.getPilhaDesfazer().peek());
    }

    @Test
    @DisplayName("Método desfazer - Deve desfazer a última diminuição de recurso")
    public void desfazerTest() {
        GestaoClinica gestao = new GestaoClinica();
        gestao.salvar(new Recurso(1, "Veterinário", 10));
        gestao.diminuiRecurso(3);

        gestao.desfazer();

        assertEquals(10, gestao.getLista().get(0).getQuantidade());
        assertFalse(gestao.getPilhaRefazer().isEmpty());
        assertEquals(3, gestao.getPilhaRefazer().peek());
    }

    @Test
    @DisplayName("Método refazer - Deve refazer a última diminuição de recurso")
    public void refazerTest() {
        GestaoClinica gestao = new GestaoClinica();
        gestao.salvar(new Recurso(1, "Veterinário", 10));
        gestao.diminuiRecurso(3);
        gestao.desfazer();

        gestao.refazer();

        assertEquals(7, gestao.getLista().get(0).getQuantidade());
        assertFalse(gestao.getPilhaDesfazer().isEmpty());
        assertEquals(3, gestao.getPilhaDesfazer().peek());
    }

    @Test
    @DisplayName("Método triagem - Deve inserir corretamente os pets nas filas")
    public void triagemTest() {
        Atendimento atendimento = new Atendimento();

        atendimento.triagem(new Pet(1, "Bob", "Labrador", "Dor de cabeça"));
        atendimento.triagem(new Pet(2, "Luna", "Beagle", "Hemorragia"));

        assertEquals(1, atendimento.getFilaNormal().getTamanho());
        assertEquals(1, atendimento.getFilaPrioritaria().getTamanho());
        assertEquals("Bob", atendimento.getFilaNormal().peek().getNome());
        assertEquals("Luna", atendimento.getFilaPrioritaria().peek().getNome());
    }

    @Test
    @DisplayName("Método atender - Deve atender corretamente os pets respeitando a prioridade")
    public void atenderTest() {
        Atendimento atendimento = new Atendimento();
        atendimento.triagem(new Pet(1, "Bob", "Labrador", "Dor de cabeça"));
        atendimento.triagem(new Pet(2, "Luna", "Beagle", "Hemorragia"));
        atendimento.triagem(new Pet(3, "Max", "Poodle", "Envenenamento"));

        Pet[] atendidos = atendimento.atender(2);

        assertEquals(0, atendimento.getFilaPrioritaria().getTamanho());
        assertEquals(1, atendimento.getFilaNormal().getTamanho());
        assertEquals("Luna", atendidos[0].getNome());
        assertEquals("Max", atendidos[1].getNome());
    }

    @Test
    @DisplayName("Método atender - Deve lançar exceção para fila vazia")
    public void atenderFilaVaziaTest() {
        Atendimento atendimento = new Atendimento();

        assertThrows(IllegalStateException.class, () -> atendimento.atender(1));
    }

    @Test
    @DisplayName("Método atender - Deve lançar exceção para argumentos inválidos")
    public void atenderArgumentosInvalidosTest() {
        Atendimento atendimento = new Atendimento();
        atendimento.triagem(new Pet(1, "Bob", "Labrador", "Dor de cabeça"));

        assertThrows(IllegalArgumentException.class, () -> atendimento.atender(0));
        assertThrows(IllegalArgumentException.class, () -> atendimento.atender(-1));
        assertThrows(IllegalArgumentException.class, () -> atendimento.atender(2));
    }
}
