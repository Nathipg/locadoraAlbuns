package locadoraAlbuns.servicos;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import locadoraAlbuns.dao.MusicoDAO;
import locadoraAlbuns.entidades.Musico;

/**
 *
 * @author nathipg
 */
public class MusicoServices {
    
    public List<Musico> getTodos() {

        List<Musico> lista = new ArrayList<Musico>();
        MusicoDAO dao = null;

        try {
            dao = new MusicoDAO();
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
