package locadoraAlbuns.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import locadoraAlbuns.entidades.Album;
import locadoraAlbuns.entidades.Emprestimo;
import locadoraAlbuns.entidades.TipoEmprestimo;
import locadoraAlbuns.entidades.Usuario;

/**
 *
 * @author nathipg
 */
public class EmprestimoDAO extends DAO<Emprestimo> {

    public EmprestimoDAO() throws SQLException {
    }

    @Override
    public void salvar(Emprestimo obj) throws SQLException {
        PreparedStatement stmt = getConnection().prepareStatement(
                "INSERT INTO emprestimo "
                + "( inicio, fim, id_usuario, id_album, id_tipo_emprestimo ) "
                + "VALUES( ?, ?, ?, ?, ? );" );

        stmt.setString( 1, obj.getInicio() );
        stmt.setString( 2, obj.getFim() );
        stmt.setInt( 3, obj.getUsuario().getId() );
        stmt.setInt( 4, obj.getAlbum().getId() );
        stmt.setInt( 5, obj.getTipoEmprestimo().getId() );

        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public void atualizar(Emprestimo obj) throws SQLException {
        PreparedStatement stmt = getConnection().prepareStatement(
                "UPDATE emprestimo "
                + "SET"
                + "    inicio = ?, "
                + "    fim = ?, "
                + "    id_usuario = ?, "
                + "    id_album = ?, "
                + "    id_tipo_emprestimo = ? "
                + "WHERE"
                + "    id = ?;" );

        stmt.setString( 1, obj.getInicio() );
        stmt.setString( 2, obj.getFim() );
        stmt.setInt( 3, obj.getUsuario().getId() );
        stmt.setInt( 4, obj.getAlbum().getId() );
        stmt.setInt( 5, obj.getTipoEmprestimo().getId() );
        stmt.setInt( 6, obj.getId() );

        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public void excluir(Emprestimo obj) throws SQLException {
        PreparedStatement stmt = getConnection().prepareStatement(
                "DELETE FROM emprestimo "
                + "WHERE"
                + "    id = ?;" );

        stmt.setInt( 1, obj.getId() );

        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public List<Emprestimo> listarTodos() throws SQLException {
        List<Emprestimo> lista = new ArrayList<Emprestimo>();

        PreparedStatement stmt = getConnection().prepareStatement(
                "SELECT "
                + "    emprestimo.id, "
                + "    emprestimo.inicio, "
                + "    emprestimo.fim, "
                + "    emprestimo.id_usuario, "
                + "    emprestimo.id_album, "
                + "    emprestimo.id_tipo_emprestimo, "
                + "    usuario.nome, "
                + "    usuario.cpf, "
                + "    usuario.email, "
                + "    usuario.endereco, "
                + "    album.nome, "
                + "    album.foto, "
                + "    album.data_lancamento, "
                + "    tipo_emprestimo.dias_duracao, "
                + "    tipo_emprestimo.valor "
                + "FROM emprestimo"
                        + " INNER JOIN usuario "
                        + "         ON usuario.id = emprestimo.id_usuario "
                        + " INNER JOIN album "
                        + "         ON album.id = emprestimo.id_album "
                        + " INNER JOIN tipo_emprestimo "
                        + "         ON tipo_emprestimo.id = emprestimo.id_tipo_emprestimo ");

        ResultSet rs = stmt.executeQuery();

        while ( rs.next() ) {
            Emprestimo emprestimo = new Emprestimo();
            Usuario usuario = new Usuario();
            Album album = new Album();
            TipoEmprestimo tipoEmprestimo = new TipoEmprestimo();
            
            usuario.setId( rs.getInt( "id_usuario" ) );
            usuario.setNome( rs.getString( "nome" ) );
            usuario.setCpf( rs.getString( "cpf" ) );
            usuario.setEmail( rs.getString( "email" ) );
            usuario.setEndereco( rs.getString( "endereco" ) );
            
            album.setId( rs.getInt( "id_album" ) );
            album.setNome( rs.getString( "nome" ) );
            album.setFoto( rs.getString( "foto" ) );
            album.setDataLancamento( rs.getString( "data_lancamento" ) );
            
            tipoEmprestimo.setId( rs.getInt( "id_tipo_emprestimo" ) );
            tipoEmprestimo.setDiasDuracao( rs.getInt( "dias_duracao" ) );
            tipoEmprestimo.setValor( rs.getDouble( "valor" ) );

            emprestimo.setId( rs.getInt( "id" ) );
            emprestimo.setInicio( rs.getString( "inicio" ) );
            emprestimo.setFim( rs.getString( "fim" ) );
            emprestimo.setUsuario( usuario );
            emprestimo.setAlbum( album );
            emprestimo.setTipoEmprestimo( tipoEmprestimo );

            lista.add( emprestimo );

        }

        rs.close();
        stmt.close();

        return lista;
    }

    @Override
    public Emprestimo obterPorId(int id) throws SQLException {
        Emprestimo emprestimo = null;
        
        PreparedStatement stmt = getConnection().prepareStatement(
                "SELECT "
                + "    emprestimo.id, "
                + "    emprestimo.inicio, "
                + "    emprestimo.fim, "
                + "    emprestimo.id_usuario, "
                + "    emprestimo.id_album, "
                + "    emprestimo.id_tipo_emprestimo, "
                + "    usuario.nome, "
                + "    usuario.cpf, "
                + "    usuario.email, "
                + "    usuario.endereco, "
                + "    album.nome, "
                + "    album.foto, "
                + "    album.data_lancamento, "
                + "    tipo_emprestimo.dias_duracao, "
                + "    tipo_emprestimo.valor "
                + "FROM emprestimo"
                        + " INNER JOIN usuario "
                        + "         ON usuario.id = emprestimo.id_usuario "
                        + " INNER JOIN album "
                        + "         ON album.id = emprestimo.id_album "
                        + " INNER JOIN tipo_emprestimo "
                        + "         ON tipo_emprestimo.id = emprestimo.id_tipo_emprestimo "
                + "WHERE emprestimo.id = ?;");
        
        stmt.setInt( 1, id );

        ResultSet rs = stmt.executeQuery();

        if ( rs.next() ) {
            emprestimo = new Emprestimo();
            Usuario usuario = new Usuario();
            Album album = new Album();
            TipoEmprestimo tipoEmprestimo = new TipoEmprestimo();
            
            usuario.setId( rs.getInt( "id_usuario" ) );
            usuario.setNome( rs.getString( "nome" ) );
            usuario.setCpf( rs.getString( "cpf" ) );
            usuario.setEmail( rs.getString( "email" ) );
            usuario.setEndereco( rs.getString( "endereco" ) );
            
            album.setId( rs.getInt( "id_album" ) );
            album.setNome( rs.getString( "nome" ) );
            album.setFoto( rs.getString( "foto" ) );
            album.setDataLancamento( rs.getString( "data_lancamento" ) );
            
            tipoEmprestimo.setId( rs.getInt( "id_tipo_emprestimo" ) );
            tipoEmprestimo.setDiasDuracao( rs.getInt( "dias_duracao" ) );
            tipoEmprestimo.setValor( rs.getDouble( "valor" ) );

            emprestimo.setId( rs.getInt( "id" ) );
            emprestimo.setInicio( rs.getString( "inicio" ) );
            emprestimo.setFim( rs.getString( "fim" ) );
            emprestimo.setUsuario( usuario );
            emprestimo.setAlbum( album );
            emprestimo.setTipoEmprestimo( tipoEmprestimo );
        }

        rs.close();
        stmt.close();

        return emprestimo;
    }
}
