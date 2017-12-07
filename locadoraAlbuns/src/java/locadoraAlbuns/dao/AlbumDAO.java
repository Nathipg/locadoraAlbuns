package locadoraAlbuns.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import locadoraAlbuns.entidades.Album;
import locadoraAlbuns.entidades.Banda;
import locadoraAlbuns.entidades.Genero;
import locadoraAlbuns.entidades.Musico;

/**
 *
 * @author nathipg
 */
public class AlbumDAO extends DAO<Album> {
    
    public AlbumDAO() throws SQLException {
    }

    @Override
    public void salvar(Album obj) throws SQLException {
        PreparedStatement stmt = getConnection().prepareStatement(
                "INSERT INTO album "
                + "( nome, foto, data_lancamento, id_genero, id_banda, id_musico ) "
                + "VALUES( ?, ?, ?, ?, ?, ? );" );

        stmt.setString( 1, obj.getNome() );
        stmt.setString( 2, obj.getFoto() );
        stmt.setString( 3, obj.getDataLancamento() );
        stmt.setInt( 4, obj.getGenero().getId() );
        stmt.setInt( 5, obj.getBanda().getId() );
        stmt.setInt( 6, obj.getMusico().getId() );

        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public void atualizar(Album obj) throws SQLException {
        PreparedStatement stmt = getConnection().prepareStatement(
                "UPDATE album "
                + "SET"
                + "    nome = ?, "
                + "    foto = ?, "
                + "    data_lancamento = ?, "
                + "    id_genero = ?, "
                + "    id_banda = ?, "
                + "    id_musico = ? "
                + "WHERE"
                + "    id = ?;" );

        stmt.setString( 1, obj.getNome() );
        stmt.setString( 2, obj.getFoto() );
        stmt.setString( 3, obj.getDataLancamento() );
        stmt.setInt( 4, obj.getGenero().getId() );
        stmt.setInt( 5, obj.getBanda().getId() );
        stmt.setInt( 6, obj.getMusico().getId() );
        stmt.setInt( 7, obj.getId() );

        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public void excluir(Album obj) throws SQLException {
        PreparedStatement stmt = getConnection().prepareStatement(
                "DELETE FROM album "
                + "WHERE"
                + "    id = ?;" );

        stmt.setInt( 1, obj.getId() );

        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public List<Album> listarTodos() throws SQLException {
        List<Album> lista = new ArrayList<Album>();

        PreparedStatement stmt = getConnection().prepareStatement(
                "SELECT "
                + "    album.id, "
                + "    album.nome, "
                + "    album.foto, "
                + "    album.data_lancamento, "
                + "    album.id_genero, "
                + "    album.id_banda, "
                + "    album.id_musico, "
                + "    genero.nome, "
                + "    banda.nome, "
                + "    musico.nome "
                + "FROM album"
                        + " INNER JOIN genero "
                        + "         ON genero.id = album.id_genero"
                + " INNER JOIN banda "
                        + "         ON banda.id = album.id_banda"
                + " INNER JOIN musico "
                        + "         ON musico.id = album.id_musico");

        ResultSet rs = stmt.executeQuery();

        while ( rs.next() ) {
            Album album = new Album();
            Genero genero = new Genero();
            Banda banda = new Banda();
            Musico musico = new Musico();
            
            genero.setId( rs.getInt( "id_genero" ) );
            genero.setNome( rs.getString( "nome" ) );
            
            if( !rs.getString( "id_banda" ).equals("") ) {
                banda.setId( rs.getInt( "id_banda" ) );
                banda.setNome( rs.getString( "nome" ) );
            } else {
                banda.setId( 0 );
                banda.setNome( null );
            }
            
            if( !rs.getString( "id_musico" ).equals("") ) {
                musico.setId( rs.getInt( "id_musico" ) );
                musico.setNome( rs.getString( "nome" ) );
            } else {
                musico.setId( 0 );
                musico.setNome( null );
            }
            
            album.setId( rs.getInt( "id" ) );
            album.setNome( rs.getString( "id" ) );
            album.setFoto( rs.getString( "id" ) );
            album.setDataLancamento( rs.getString( "id" ) );
            album.setGenero( genero );
            album.setBanda( banda );
            album.setMusico( musico );

            lista.add( album );

        }

        rs.close();
        stmt.close();

        return lista;
    }

    @Override
    public Album obterPorId(int id) throws SQLException {
        Album album = null;
        
        PreparedStatement stmt = getConnection().prepareStatement(
                "SELECT "
                + "    album.id, "
                + "    album.nome, "
                + "    album.foto, "
                + "    album.data_lancamento, "
                + "    album.id_genero, "
                + "    album.id_banda, "
                + "    album.id_musico, "
                + "    genero.nome, "
                + "    banda.nome, "
                + "    musico.nome "
                + "FROM album"
                        + " INNER JOIN genero "
                        + "         ON genero.id = album.id_genero"
                + " INNER JOIN banda "
                        + "         ON banda.id = album.id_banda"
                + " INNER JOIN musico "
                        + "         ON musico.id = album.id_musico"
                + "WHERE album.id = ?;");
        
        stmt.setInt( 1, id );

        ResultSet rs = stmt.executeQuery();

        if ( rs.next() ) {
            album = new Album();
            Genero genero = new Genero();
            Banda banda = new Banda();
            Musico musico = new Musico();
            
            genero.setId( rs.getInt( "id_genero" ) );
            genero.setNome( rs.getString( "nome" ) );
            
            if( !rs.getString( "id_banda" ).equals("") ) {
                banda.setId( rs.getInt( "id_banda" ) );
                banda.setNome( rs.getString( "nome" ) );
            } else {
                banda.setId( 0 );
                banda.setNome( null );
            }
            
            if( !rs.getString( "id_musico" ).equals("") ) {
                musico.setId( rs.getInt( "id_musico" ) );
                musico.setNome( rs.getString( "nome" ) );
            } else {
                musico.setId( 0 );
                musico.setNome( null );
            }
            
            album.setId( rs.getInt( "id" ) );
            album.setNome( rs.getString( "id" ) );
            album.setFoto( rs.getString( "id" ) );
            album.setDataLancamento( rs.getString( "id" ) );
            album.setGenero( genero );
            album.setBanda( banda );
            album.setMusico( musico );
        }

        rs.close();
        stmt.close();

        return album;
    }
}
