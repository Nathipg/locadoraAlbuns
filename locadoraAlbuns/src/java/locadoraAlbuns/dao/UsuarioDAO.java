package locadoraAlbuns.dao;

import com.mysql.jdbc.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import locadoraAlbuns.entidades.Usuario;

/**
 *
 * @author cauesj
 */
public class UsuarioDAO extends DAO<Usuario> {

    public UsuarioDAO() throws SQLException {
    }
    
    @Override
    public void salvar(Usuario obj) throws SQLException {
        PreparedStatement stmt = getConnection().prepareStatement(
                "INSERT INTO usuario "
                + "( nome, "
                + "  cpf, "
                + "  email, "
                + "  telefone_fixo, "
                + "  telefone_celular, "
                + "  endereco ) "
                + "VALUES( ?, ?, ?, ?, ?, ? );" );

        stmt.setString( 1, obj.getNome() );
        stmt.setString( 2, obj.getCpf() );
        stmt.setString( 3, obj.getEmail() );
        stmt.setString( 4, obj.getTelefoneFixo() );
        stmt.setString( 5, obj.getTelefoneCelular() );
        stmt.setString( 6, obj.getEndereco() );

        stmt.executeUpdate();        
        stmt.close();
        
    }

    @Override
    public void atualizar(Usuario obj) throws SQLException {
        PreparedStatement stmt = getConnection().prepareStatement(
                "UPDATE usuario "
                + "SET "
                + "    nome = ?, "
                + "    cpf = ?, "
                + "    email = ?, "
                + "    telefone_fixo = ?, "
                + "    telefone_celular = ?, "
                + "    endereco = ? "
                + "WHERE "
                + "    id = ?;" );

        stmt.setString( 1, obj.getNome() );
        stmt.setString( 2, obj.getCpf() );
        stmt.setString( 3, obj.getEmail() );
        stmt.setString( 4, obj.getTelefoneFixo() );
        stmt.setString( 5, obj.getTelefoneCelular() );
        stmt.setString( 6, obj.getEndereco() );
        stmt.setInt( 7, obj.getId() );

        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public void excluir(Usuario obj) throws SQLException {
        PreparedStatement stmt = getConnection().prepareStatement(
                "DELETE FROM usuario "
                + "WHERE usuario.id = ?;" );

        stmt.setInt( 1, obj.getId() );

        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public List<Usuario> listarTodos() throws SQLException {
        List<Usuario> lista = new ArrayList<Usuario>();

        PreparedStatement stmt = getConnection().prepareStatement(
                "SELECT "
                + "    usuario.id, "
                + "    usuario.nome, "
                + "    usuario.cpf, "
                + "    usuario.email, "
                + "    usuario.telefone_fixo, "
                + "    usuario.telefone_celular, "
                + "    usuario.endereco "
                + "FROM usuario;" );
        
        ResultSet rs = stmt.executeQuery();

        while ( rs.next() ) {
            
            Usuario usuario = new Usuario();

            usuario.setId( rs.getInt( "id" ) );
            usuario.setNome( rs.getString( "nome" ) );
            usuario.setCpf( rs.getString( "cpf" ) );
            usuario.setEmail( rs.getString( "email" ) );
            usuario.setTelefoneFixo( rs.getString( "telefone_fixo" ) );
            usuario.setTelefoneCelular( rs.getString( "telefone_celular" ) );
            usuario.setEndereco( rs.getString( "endereco" ) );

            lista.add( usuario );

        }

        rs.close();
        stmt.close();

        return lista;
    }

    @Override
    public Usuario obterPorId(int id) throws SQLException {
        
        Usuario usuario = null;

        PreparedStatement stmt = getConnection().prepareStatement(
                "SELECT "
                + "    usuario.id, "
                + "    usuario.nome, "
                + "    usuario.cpf, "
                + "    usuario.email, "
                + "    usuario.telefone_fixo, "
                + "    usuario.telefone_celular, "
                + "    usuario.endereco "
                + "FROM usuario "
                + "WHERE usuario.id = ?;" );

        stmt.setInt( 1, id );

        ResultSet rs = stmt.executeQuery();

        if ( rs.next() ) {
            usuario = new Usuario();

            usuario.setId( rs.getInt( "id" ) );
            usuario.setNome( rs.getString( "nome" ) );
            usuario.setCpf( rs.getString( "cpf" ) );
            usuario.setEmail( rs.getString( "email" ) );
            usuario.setTelefoneFixo( rs.getString( "telefone_fixo" ) );
            usuario.setTelefoneCelular( rs.getString( "telefone_celular" ) );
            usuario.setEndereco( rs.getString( "endereco" ) );
        }

        rs.close();
        stmt.close();

        return usuario;
    }
    
}