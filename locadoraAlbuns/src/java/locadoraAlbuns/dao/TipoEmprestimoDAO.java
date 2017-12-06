package locadoraAlbuns.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import locadoraAlbuns.entidades.TipoEmprestimo;

public class TipoEmprestimoDAO extends DAO<TipoEmprestimo> {
    
    public TipoEmprestimoDAO() throws SQLException {
    }

    @Override
    public void salvar(TipoEmprestimo obj) throws SQLException {
        PreparedStatement stmt = getConnection().prepareStatement(
                "INSERT INTO tipo_emprestimo "
                + " ( dias_duracao, valor ) "
                + "VALUES( ?, ? );" );

        stmt.setInt( 1, obj.getDiasDuracao() );
        stmt.setDouble( 2, obj.getValor() );

        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public void atualizar(TipoEmprestimo obj) throws SQLException {
        PreparedStatement stmt = getConnection().prepareStatement(
                "UPDATE tipo_emprestimo "
                + "SET"
                + "    dias_duracao = ?,"
                        + "valor = ?"
                + "WHERE"
                + "    id = ?;" );

        stmt.setInt( 1, obj.getDiasDuracao() );
        stmt.setDouble( 2, obj.getValor() );
        stmt.setInt( 3, obj.getId() );

        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public void excluir(TipoEmprestimo obj) throws SQLException {
        PreparedStatement stmt = getConnection().prepareStatement(
                "DELETE FROM tipo_emprestimo "
                + "WHERE"
                + "    id = ?;" );

        stmt.setInt( 1, obj.getId() );

        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public List<TipoEmprestimo> listarTodos() throws SQLException {
        List<TipoEmprestimo> lista = new ArrayList<TipoEmprestimo>();

        PreparedStatement stmt = getConnection().prepareStatement(
                "SELECT "
                + "    tipo_emprestimo.id, "
                + "    tipo_emprestimo.dias_duracao, "
                + "    tipo_emprestimo.valor "
                + "FROM tipo_emprestimo" );

        ResultSet rs = stmt.executeQuery();

        while ( rs.next() ) {
            
            TipoEmprestimo tipoEmprestimo = new TipoEmprestimo();

            tipoEmprestimo.setId( rs.getInt( "id" ) );
            tipoEmprestimo.setDiasDuracao( rs.getInt( "dias_duracao" ) );
            tipoEmprestimo.setValor( rs.getDouble( "valor" ) );

            lista.add( tipoEmprestimo );

        }

        rs.close();
        stmt.close();

        return lista;
    }

    @Override
    public TipoEmprestimo obterPorId(int id) throws SQLException {
        TipoEmprestimo tipoEmprestimo = null;

        PreparedStatement stmt = getConnection().prepareStatement(
                "SELECT "
                + "    tipo_emprestimo.id, "
                + "    tipo_emprestimo.dias_duracao, "
                + "    tipo_emprestimo.valor "
                + "FROM tipo_emprestimo "
                + "WHERE tipo_emprestimo.id = ?;");

        stmt.setInt( 1, id );

        ResultSet rs = stmt.executeQuery();

        if ( rs.next() ) {
            tipoEmprestimo = new TipoEmprestimo();

            tipoEmprestimo.setId( rs.getInt( "id" ) );
            tipoEmprestimo.setDiasDuracao( rs.getInt( "dias_duracao" ) );
            tipoEmprestimo.setValor( rs.getDouble( "valor" ) );
        }

        rs.close();
        stmt.close();

        return tipoEmprestimo;
    }
    
}
