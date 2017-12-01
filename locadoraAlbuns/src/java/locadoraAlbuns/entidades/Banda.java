package locadoraAlbuns.entidades;

/**
 *
 * @author nathipg
 */
public class Banda {
    private int id;
    private String nome;
    private String foto;
    private String data_formacao;
    private String descricao;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getData_formacao() {
        return data_formacao;
    }

    public void setData_formacao(String data_formacao) {
        this.data_formacao = data_formacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
}
