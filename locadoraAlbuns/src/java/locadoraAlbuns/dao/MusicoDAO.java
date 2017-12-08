package locadoraAlbuns.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import locadoraAlbuns.entidades.Musico;

/**
 *
 * @author cauesj
 */
public class MusicoDAO extends DAO<Musico> {

    public MusicoDAO() throws SQLException {
    }
    
    @Override
    public void salvar(Musico obj) throws SQLException {
        PreparedStatement stmt = getConnection().prepareStatement(
                "INSERT INTO musico "
                + "( nome, "
                + "  foto, "
                + "  data_nascimento, "
                + "  bio ) "
                + "VALUES( ?, ?, ?, ? ); " );

        stmt.setString( 1, obj.getNome() );
        stmt.setString( 2, obj.getFoto() );
        stmt.setString( 3, obj.getDataNascimento() );
        stmt.setString( 4, obj.getBio() );

        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public void atualizar(Musico obj) throws SQLException {
        PreparedStatement stmt = getConnection().prepareStatement(
                "UPDATE musico "
                + "SET "
                + "    nome = ?, "
                + "    foto = ?, "
                + "    data_nascimento = ?, "
                + "    bio = ? "
                + "WHERE "
                + "    id = ?;" );

        stmt.setString( 1, obj.getNome() );
        stmt.setString( 2, obj.getFoto() );
        stmt.setString( 3, obj.getDataNascimento() );
        stmt.setString( 4, obj.getBio() );
        stmt.setInt( 5, obj.getId() );

        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public void excluir(Musico obj) throws SQLException {
        PreparedStatement stmt = getConnection().prepareStatement(
                "DELETE FROM musico "
                + "WHERE musico.id = ?;" );

        stmt.setInt( 1, obj.getId() );

        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public List<Musico> listarTodos() throws SQLException {
        List<Musico> lista = new ArrayList<Musico>();

        PreparedStatement stmt = getConnection().prepareStatement(
                "SELECT "
                + "    musico.id, "
                + "    musico.nome, "
                + "    musico.foto, "
                + "    musico.data_nascimento, "
                + "    musico.bio "
                + "FROM musico " );

        ResultSet rs = stmt.executeQuery();

        while ( rs.next() ) {
            
            Musico musico = new Musico();

            musico.setId( rs.getInt( "id" ) );
            musico.setNome( rs.getString( "nome" ) );
            musico.setFoto( rs.getString( "foto" ) );
            musico.setDataNascimento(rs.getString( "data_nascimento" ) );
            musico.setBio(rs.getString( "bio" ) );

            lista.add( musico );

        }

        rs.close();
        stmt.close();

        return lista;
    }

    @Override
    public Musico obterPorId(int id) throws SQLException {
        
        Musico musico = null;

        PreparedStatement stmt = getConnection().prepareStatement(
                "SELECT "
                + "    musico.id, "
                + "    musico.nome, "
                + "    musico.foto, "
                + "    musico.data_nascimento, "
                + "    musico.bio "
                + "FROM musico "
                + "WHERE musico.id = ?;" );

        stmt.setInt( 1, id );

        ResultSet rs = stmt.executeQuery();

        if ( rs.next() ) {
            musico = new Musico();

            musico.setId( rs.getInt( "id" ) );
            musico.setNome( rs.getString( "nome" ) );
            musico.setFoto( rs.getString( "foto" ) );
            musico.setDataNascimento( rs.getString( "data_nascimento" ) );
            musico.setBio( rs.getString( "bio" ) );
        }

        rs.close();
        stmt.close();

        return musico;
    }
    
}