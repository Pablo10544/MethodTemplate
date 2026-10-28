import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/** Define a ordem de preparo, deixando as variacoes para as subclasses. */
public abstract class BebidaQuente {

    /** Template Method: as subclasses nao podem alterar esta sequencia. */
    public final List<String> preparar() {
        List<String> etapas = new ArrayList<>();
        etapas.add(ferverAgua());
        etapas.add(prepararIngrediente());
        etapas.add(servirNaXicara());
        if (desejaComplementos()) {
            etapas.add(adicionarComplementos());
        }
        return Collections.unmodifiableList(etapas);
    }

    private String ferverAgua() {
        return "Ferver agua";
    }

    protected abstract String prepararIngrediente();

    private String servirNaXicara() {
        return "Servir na xicara";
    }

    protected abstract String adicionarComplementos();

    /** Hook: por padrao, a bebida recebe complementos. */
    protected boolean desejaComplementos() {
        return true;
    }
}
