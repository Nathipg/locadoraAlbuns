package locadoraAlbuns.entidades;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 *
 * @author nathipg
 */
public class Faixa {
    private int id;
    private String nome;
    private String duracao;
    private Album album;

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

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }
}
