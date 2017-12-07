package locadoraAlbuns.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import locadoraAlbuns.entidades.Banda;
import locadoraAlbuns.entidades.Formacao;
import locadoraAlbuns.entidades.Musico;

/**
 *
 * @author cauesj
 */
public class FormacaoDAO extends DAO<Formacao> {

    public FormacaoDAO() throws SQLException {
    }
    
    @Override
    public void salvar(Formacao obj) throws SQLException {
        PreparedStatement stmt = getConnection().prepareStatement(
                "INSERT INTO formacao"
                + "( id_banda,"
                + "  id_musico,"
                + "  inicio,"
                + "  fim ) "
                + "VALUES( ?, ?, ?, ? );" );

        stmt.setInt( 1, obj.getBanda().getId() );
        stmt.setInt( 2, obj.getMusico().getId() );
        stmt.setString( 3, obj.getInicio() );
        stmt.setString( 4, obj.getFim() );

        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public void atualizar(Formacao obj) throws SQLException {
        PreparedStatement stmt = getConnection().prepareStatement(
                "UPDATE formacao "
                + "SET"
                + "    id_banda = ?,"
                + "    id_musico = ?,"
                + "    inicio = ?,"
                + "    fim = ?"
                + "WHERE"
                + "    id_banda = ?"
                + " AND id_musico = ?;" );

        stmt.setInt( 1, obj.getBanda().getId() );
        stmt.setInt( 2, obj.getMusico().getId() );
        stmt.setString( 3, obj.getInicio() );
        stmt.setString( 4, obj.getFim() );
        stmt.setInt( 5, obj.getBanda().getId() );
        stmt.setInt( 6, obj.getMusico().getId() );

        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public void excluir(Formacao obj) throws SQLException {
        PreparedStatement stmt = getConnection().prepareStatement(
                "DELETE FROM formacao "
                + "WHERE formacao.id_banda = ?"
                + "AND formacao.id_musico = ?" );

        stmt.setInt( 1, obj.getBanda().getId() );
        stmt.setInt( 2, obj.getMusico().getId() );

        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public List<Formacao> listarTodos() throws SQLException {
        List<Formacao> lista = new ArrayList<Formacao>();

        PreparedStatement stmt = getConnection().prepareStatement(
                "SELECT "
                + "    banda.nome  AS banda_nome,"
                + "    musico.nome AS musico_nome,"
                + "    formacao.id_banda,"
                + "    formacao.id_musico,"
                + "    formacao.inicio,"
                + "    formacao.fim"
                + "FROM formacao"
                + "     INNER JOIN banda"
                + "             ON banda.id = formacao.id_banda"
                + "     INNER JOIN musico"
                + "             ON musico.id = formacao.id_musico;" );

        ResultSet rs = stmt.executeQuery();

        while ( rs.next() ) {
            
            Formacao formacao = new Formacao();
            Banda banda = new Banda();
            Musico musico = new Musico();
            
            banda.setId( rs.getInt("id_banda") );
            banda.setNome( rs.getString("banda_nome") );
            
            musico.setId( rs.getInt("id_musico") );
            musico.setNome( rs.getString("musico_nome") );
            
            formacao.setBanda( banda );
            formacao.setMusico( musico );
            formacao.setInicio( rs.getString("inicio") );
            formacao.setFim( rs.getString("fim") );
            
            lista.add( formacao );

        }

        rs.close();
        stmt.close();

        return lista;
    }

    public Formacao obterPorId(int id) throws SQLException {
        
        Formacao formacao = null;

        PreparedStatement stmt = getConnection().prepareStatement(
                "SELECT "
                + "    banda.nome  AS banda_nome,"
                + "    musico.nome AS musico_nome,"
                + "    formacao.id_banda,"
                + "    formacao.id_musico,"
                + "    formacao.inicio,"
                + "    formacao.fim"
                + "FROM formacao"
                + "     INNER JOIN banda"
                + "             ON banda.id = formacao.id_banda"
                + "     INNER JOIN musico"
                + "             ON musico.id = formacao.id_musico"
                + "WHERE formacao.id_banda = ?;" );

        stmt.setInt( 1, id );

        ResultSet rs = stmt.executeQuery();

        if ( rs.next() ) {
            
            formacao = new Formacao();
            Banda banda = new Banda();
            Musico musico = new Musico();
            
            banda.setId( rs.getInt("id_banda") );
            banda.setNome( rs.getString("banda_nome") );
            
            musico.setId( rs.getInt("id_musico") );
            musico.setNome( rs.getString("musico_nome") );
            
            formacao.setBanda( banda );
            formacao.setMusico( musico );
            formacao.setInicio( rs.getString("inicio") );
            formacao.setFim( rs.getString("fim") );
        }

        rs.close();
        stmt.close();

        return formacao;
    }
    
}