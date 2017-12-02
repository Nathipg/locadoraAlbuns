package locadoraAlbuns.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import locadoraAlbuns.entidades.Genero;

/**
 *
 * @author nathipg
 */
public class GeneroDAO extends DAO<Genero> {

    public GeneroDAO() throws SQLException {
    }
    
    @Override
    public void salvar(Genero obj) throws SQLException {
        PreparedStatement stmt = getConnection().prepareStatement(
                "INSERT INTO genero"
                + "( nome ) "
                + "VALUES( ? );" );

        stmt.setString( 1, obj.getNome() );

        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public void atualizar(Genero obj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluir(Genero obj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Genero> listarTodos() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Genero obterPorId(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
