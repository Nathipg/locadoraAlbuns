package locadoraAlbuns.entidades;

/**
 *
 * @author nathipg
 */
public class TipoEmprestimo {
    private int id;
    private int diasDuracao;
    private double valor;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDiasDuracao() {
        return diasDuracao;
    }

    public void setDiasDuracao(int diasDuracao) {
        this.diasDuracao = diasDuracao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
    
}
