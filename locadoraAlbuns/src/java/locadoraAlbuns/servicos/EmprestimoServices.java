package locadoraAlbuns.servicos;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import locadoraAlbuns.dao.EmprestimoDAO;
import locadoraAlbuns.entidades.Emprestimo;

/**
 *
 * @author nathipg
 */
public class EmprestimoServices {
    
    public List<Emprestimo> getTodos() {

        List<Emprestimo> lista = new ArrayList<Emprestimo>();
        EmprestimoDAO dao = null;

        try {
            dao = new EmprestimoDAO();
            lista = dao.listarTodos();
        } catch ( SQLException exc ) {
            exc.printStackTrace();
        } finally {
            if ( dao != null ) {
                try {
                    dao.fecharConexao();
                } catch ( SQLException exc ) {
                    exc.printStackTrace();
                }
            }
        }

        return lista;

    }
    
}
