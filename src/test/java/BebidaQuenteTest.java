import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class BebidaQuenteTest {

    @Test
    void devePrepararCafeNaOrdemCorretaComComplementos() {
        List<String> etapas = new Cafe().preparar();

        assertEquals(Arrays.asList(
                "Ferver agua", "Coar o cafe", "Servir na xicara",
                "Adicionar acucar e leite"), etapas);
    }

    @Test
    void devePrepararChaComLimaoNaOrdemCorreta() {
        List<String> etapas = new Cha(true).preparar();

        assertEquals(Arrays.asList(
                "Ferver agua", "Fazer a infusao do cha", "Servir na xicara",
                "Adicionar limao"), etapas);
    }

    @Test
    void devePrepararChaSemLimaoNaOrdemCorreta() {
        List<String> etapas = new Cha(false).preparar();

        assertEquals(Arrays.asList(
                "Ferver agua", "Fazer a infusao do cha", "Servir na xicara"), etapas);
    }

    @Test
    void naoDeveExecutarEtapaDeComplementosQuandoHookRetornarFalse() {
        final boolean[] complementoExecutado = {false};
        BebidaQuente bebida = new Cha(false) {
            @Override
            protected String adicionarComplementos() {
                complementoExecutado[0] = true;
                return "Adicionar limao";
            }
        };

        bebida.preparar();

        assertFalse(complementoExecutado[0]);
    }
}
