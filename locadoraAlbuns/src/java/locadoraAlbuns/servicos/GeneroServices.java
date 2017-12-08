package locadoraAlbuns.servicos;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import locadoraAlbuns.dao.GeneroDAO;
import locadoraAlbuns.entidades.Genero;

/**
 *
 * @author nathipg
 */
public class GeneroServices {
    
    public List<Genero> getTodos() {

        List<Genero> lista = new ArrayList<Genero>();
        GeneroDAO dao = null;

        try {
            dao = new GeneroDAO();
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
