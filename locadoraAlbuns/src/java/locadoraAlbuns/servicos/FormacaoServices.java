package locadoraAlbuns.servicos;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import locadoraAlbuns.dao.FormacaoDAO;
import locadoraAlbuns.entidades.Formacao;

/**
 *
 * @author nathipg
 */
public class FormacaoServices {
    
    public List<Formacao> getTodos() {

        List<Formacao> lista = new ArrayList<Formacao>();
        FormacaoDAO dao = null;

        try {
            dao = new FormacaoDAO();
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
