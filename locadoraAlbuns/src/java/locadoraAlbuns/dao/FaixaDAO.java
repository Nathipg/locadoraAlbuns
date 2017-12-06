package locadoraAlbuns.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import locadoraAlbuns.entidades.Faixa;

/**
 *
 * @author cauesj
 */
public class FaixaDAO extends DAO<Faixa> {

    public FaixaDAO() throws SQLException {
    }
    
    @Override
    public void salvar(Faixa obj) throws SQLException {
        PreparedStatement stmt = getConnection().prepareStatement(
                "INSERT INTO faixa"
                + "( nome,"
                + "  duracao,"
                + "  id_album ) "
                + "VALUES( ?, ?, ? );" );

        stmt.setString( 1, obj.getNome() );
        stmt.setString( 2, obj.getDuracao() );
        stmt.setInt( 3, obj.getAlbum().getId() );

        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public void atualizar(Faixa obj) throws SQLException {
        PreparedStatement stmt = getConnection().prepareStatement(
                "UPDATE faixa "
                + "SET"
                + "    nome = ?,"
                + "    duracao = ?,"
                + "    id_album = ?"
                + "WHERE"
                + "    id = ?;" );

        stmt.setString( 1, obj.getNome() );
        stmt.setString( 2, obj.getDuracao() );
        stmt.setInt( 3, obj.getAlbum().getId() );
        stmt.setInt( 4, obj.getId() );

        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public void excluir(Faixa obj) throws SQLException {
        PreparedStatement stmt = getConnection().prepareStatement(
                "DELETE FROM faixa "
                + "WHERE faixa.id = ?" );

        stmt.setInt( 1, obj.getId() );

        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public List<Faixa> listarTodos() throws SQLException {
        List<Faixa> lista = new ArrayList<Faixa>();

        PreparedStatement stmt = getConnection().prepareStatement(
                "SELECT "
                + "    faixa.id,"
                + "    faixa.nome,"
                + "    faixa.duracao,"
                + "    faixa.id_album"
                + "FROM faixa;" );

        ResultSet rs = stmt.executeQuery();

        while ( rs.next() ) {
            
            Faixa faixa = new Faixa();

            faixa.setId( rs.getInt( "id" ) );
            faixa.setNome( rs.getString( "nome" ) );

            lista.add( faixa );

        }

        rs.close();
        stmt.close();

        return lista;
    }

    @Override
    public Faixa obterPorId(int id) throws SQLException {
        
        Faixa faixa = null;

        PreparedStatement stmt = getConnection().prepareStatement(
                "SELECT "
                + "    faixa.id, "
                + "    faixa.nome,"
                + "    faixa.duracao,"
                + "    faixa.id_album"
                + "FROM faixa "
                + "WHERE faixa.id = ?; ");

        stmt.setInt( 1, id );

        ResultSet rs = stmt.executeQuery();

        if ( rs.next() ) {
            faixa = new Faixa();

            faixa.setId( rs.getInt( "id" ) );
            faixa.setNome( rs.getString( "nome" ) );
        }

        rs.close();
        stmt.close();

        return faixa;
    }
    
}