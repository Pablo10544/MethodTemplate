public class Cha extends BebidaQuente {
    private final boolean comLimao;

    public Cha(boolean comLimao) {
        this.comLimao = comLimao;
    }

    @Override
    protected String prepararIngrediente() {
        return "Fazer a infusao do cha";
    }

    @Override
    protected String adicionarComplementos() {
        return "Adicionar limao";
    }

    @Override
    protected boolean desejaComplementos() {
        return comLimao;
    }
}
