package locadoraAlbuns.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import locadoraAlbuns.entidades.Telefone;

/**
 *
 * @author nathipg
 */
public class TelefoneDAO extends DAO<Telefone> {

    public TelefoneDAO() throws SQLException {
    }

    @Override
    public void salvar(Telefone obj) throws SQLException {
        PreparedStatement stmt = getConnection().prepareStatement(
                "INSERT INTO telefone "
                + "( telefone, id_usuario ) "
                + "VALUES( ?, ? );" );

        stmt.setString( 1, obj.getTelefone() );
        stmt.setInt( 2, obj.getUsuario().getId() );

        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public void atualizar(Telefone obj) throws SQLException {
        PreparedStatement stmt = getConnection().prepareStatement(
                "UPDATE telefone "
                + "SET"
                + "    telefone = ?, "
                + "    id_usuario = ? "
                + "WHERE"
                + "    id = ?;" );

        stmt.setString( 1, obj.getNome() );
        stmt.setInt( 2, obj.getId() );

        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public void excluir(Genero obj) throws SQLException {
        PreparedStatement stmt = getConnection().prepareStatement(
                "DELETE FROM genero "
                + "WHERE"
                + "    id = ?;" );

        stmt.setInt( 1, obj.getId() );

        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public List<Genero> listarTodos() throws SQLException {
        List<Genero> lista = new ArrayList<Genero>();

        PreparedStatement stmt = getConnection().prepareStatement(
                "SELECT "
                + "    genero.id, "
                + "    genero.nome "
                + "FROM genero" );

        ResultSet rs = stmt.executeQuery();

        while ( rs.next() ) {
            
            Genero genero = new Genero();

            genero.setId( rs.getInt( "id" ) );
            genero.setNome( rs.getString( "nome" ) );

            lista.add( genero );

        }

        rs.close();
        stmt.close();

        return lista;
    }

    @Override
    public Genero obterPorId(int id) throws SQLException {
        
        Genero genero = null;

        PreparedStatement stmt = getConnection().prepareStatement(
                "SELECT "
                + "    genero.id, "
                + "    genero.nome "
                + "FROM genero "
                + "WHERE genero.id = ?;");

        stmt.setInt( 1, id );

        ResultSet rs = stmt.executeQuery();

        if ( rs.next() ) {
            genero = new Genero();

            genero.setId( rs.getInt( "id" ) );
            genero.setNome( rs.getString( "nome" ) );
        }

        rs.close();
        stmt.close();

        return genero;
    }
    
}
