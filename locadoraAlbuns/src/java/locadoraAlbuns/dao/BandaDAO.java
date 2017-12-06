package locadoraAlbuns.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import locadoraAlbuns.entidades.Banda;

/**
 *
 * @author nathipg
 */
public class BandaDAO extends DAO<Banda> {

    public BandaDAO() throws SQLException {
    }
    
    @Override
    public void salvar(Banda obj) throws SQLException {
        PreparedStatement stmt = getConnection().prepareStatement(
                "INSERT INTO banda"
                + "( nome, foto, data_formacao, descricao ) "
                + "VALUES( ?, ?, ?, ? );" );

        stmt.setString( 1, obj.getNome() );
        stmt.setString( 2, obj.getFoto() );
        stmt.setString( 3, obj.getDataFormacao() );
        stmt.setString( 4, obj.getDescricao() );

        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public void atualizar(Banda obj) throws SQLException {
        PreparedStatement stmt = getConnection().prepareStatement(
                "UPDATE banda "
                + "SET"
                + "    nome = ?, "
                + "    foto = ?, "
                + "    data_formacao = ?, "
                + "    descricao = ? "
                + "WHERE"
                + "    id = ?;" );

        stmt.setString( 1, obj.getNome() );
        stmt.setString( 2, obj.getFoto() );
        stmt.setString( 3, obj.getDataFormacao() );
        stmt.setString( 4, obj.getDescricao() );
        stmt.setInt( 5, obj.getId() );

        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public void excluir(Banda obj) throws SQLException {
        PreparedStatement stmt = getConnection().prepareStatement(
                "DELETE FROM banda "
                + "WHERE"
                + "    id = ?;" );

        stmt.setInt( 1, obj.getId() );

        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public List<Banda> listarTodos() throws SQLException {
        List<Banda> lista = new ArrayList<Banda>();

        PreparedStatement stmt = getConnection().prepareStatement(
                "SELECT "
                + "    banda.id, "
                + "    banda.nome, "
                + "    banda.foto, "
                + "    banda.data_formacao, "
                + "    banda.descricao "
                + "FROM banda;" );

        ResultSet rs = stmt.executeQuery();

        while ( rs.next() ) {
            
            Banda banda = new Banda();

            banda.setId( rs.getInt( "id" ) );
            banda.setNome( rs.getString( "nome" ) );
            banda.setFoto( rs.getString( "foto" ) );
            banda.setDataFormacao( rs.getString( "data_formacao" ) );
            banda.setDescricao( rs.getString( "descricao" ) );

            lista.add( banda );

        }

        rs.close();
        stmt.close();

        return lista;
    }

    @Override
    public Banda obterPorId(int id) throws SQLException {
        
        Banda banda = null;
        
        PreparedStatement stmt = getConnection().prepareStatement(
                "SELECT "
                + "    banda.id, "
                + "    banda.nome, "
                + "    banda.foto, "
                + "    banda.data_formacao, "
                + "    banda.descricao "
                + "FROM banda "
                + "WHERE banda.id = ?;");

        stmt.setInt( 1, id );

        ResultSet rs = stmt.executeQuery();

        if ( rs.next() ) {
            banda = new Banda();

            banda.setId( rs.getInt( "id" ) );
            banda.setNome( rs.getString( "nome" ) );
            banda.setFoto( rs.getString( "foto" ) );
            banda.setDataFormacao( rs.getString( "data_formacao" ) );
            banda.setDescricao( rs.getString( "descricao" ) );
        }

        rs.close();
        stmt.close();

        return banda;
    }
}
