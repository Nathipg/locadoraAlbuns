package locadoraAlbuns.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import locadoraAlbuns.entidades.Telefone;
import locadoraAlbuns.entidades.Usuario;

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

        stmt.setString( 1, obj.getTelefone() );
        stmt.setInt( 2, obj.getUsuario().getId() );
        stmt.setInt( 3, obj.getId() );

        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public void excluir(Telefone obj) throws SQLException {
        PreparedStatement stmt = getConnection().prepareStatement(
                "DELETE FROM telefone "
                + "WHERE"
                + "    id = ?;" );

        stmt.setInt( 1, obj.getId() );

        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public List<Telefone> listarTodos() throws SQLException {
        List<Telefone> lista = new ArrayList<Telefone>();

        PreparedStatement stmt = getConnection().prepareStatement(
                "SELECT "
                + "    telefone.id, "
                + "    telefone.telefone, "
                + "    telefone.id_usuario, "
                + "    usuario.nome, "
                + "    usuario.cpf, "
                + "    usuario.email, "
                + "    usuario.endereco "
                + "FROM telefone"
                        + " INNER JOIN usuario "
                        + "         ON usuario.id = telefone.id_usuario;" );

        ResultSet rs = stmt.executeQuery();

        while ( rs.next() ) {
            
            Telefone telefone = new Telefone();
            Usuario usuario = new Usuario();
            
            usuario.setId( rs.getInt( "id" ) );
            usuario.setNome( rs.getString( "nome" ) );
            usuario.setCpf( rs.getString( "cpf" ) );
            usuario.setEmail( rs.getString( "email" ) );
            usuario.setEndereco( rs.getString( "endereco" ) );

            telefone.setId( rs.getInt( "id" ) );
            telefone.setTelefone( rs.getString( "telefone" ) );
            telefone.setUsuario( usuario );

            lista.add( telefone );

        }

        rs.close();
        stmt.close();

        return lista;
    }

    @Override
    public Telefone obterPorId(int id) throws SQLException {
        Telefone telefone = null;
        
        PreparedStatement stmt = getConnection().prepareStatement(
                "SELECT "
                + "    telefone.id, "
                + "    telefone.telefone, "
                + "    telefone.usuario_id, "
                + "    usuario.nome, "
                + "    usuario.cpf, "
                + "    usuario.email, "
                + "    usuario.endereco "
                + "FROM telefone"
                        + " INNER JOIN usuario "
                        + "         ON usuario.id = telefone.id_usuario "
                + "WHERE telefone.id = ?;");

        stmt.setInt( 1, id );

        ResultSet rs = stmt.executeQuery();

        if ( rs.next() ) {
            telefone = new Telefone();
            Usuario usuario = new Usuario();
            
            usuario.setId( rs.getInt( "id" ) );
            usuario.setNome( rs.getString( "nome" ) );
            usuario.setCpf( rs.getString( "cpf" ) );
            usuario.setEmail( rs.getString( "email" ) );
            usuario.setEndereco( rs.getString( "endereco" ) );

            telefone.setId( rs.getInt( "id" ) );
            telefone.setTelefone( rs.getString( "telefone" ) );
            telefone.setUsuario( usuario );
        }

        rs.close();
        stmt.close();

        return telefone;
    }
    
}
