package locadoraAlbuns.servicos;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import locadoraAlbuns.dao.AlbumDAO;
import locadoraAlbuns.entidades.Album;

/**
 *
 * @author nathipg
 */
public class AlbumServices {
    
    public List<Album> getTodos() {

        List<Album> lista = new ArrayList<Album>();
        AlbumDAO dao = null;

        try {
            dao = new AlbumDAO();
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
