package locadoraAlbuns.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import locadoraAlbuns.entidades.TipoEmprestimo;

public class TipoEmprestimoDAO extends DAO<TipoEmprestimo> {
    
    public TipoEmprestimoDAO() throws SQLException {
    }

    @Override
    public void salvar(TipoEmprestimo obj) throws SQLException {
        PreparedStatement stmt = getConnection().prepareStatement(
                "INSERT INTO "
                + "tipo_emprestimo( nome, estado_id ) "
                + "VALUES( ?, ? );" );

        stmt.setInt( 2, obj.getDiasDuracao() );
        stmt.setDouble( 3, obj.getValor() );

        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public void atualizar(TipoEmprestimo obj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluir(TipoEmprestimo obj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<TipoEmprestimo> listarTodos() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public TipoEmprestimo obterPorId(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
