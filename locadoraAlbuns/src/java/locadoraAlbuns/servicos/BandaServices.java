/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locadoraAlbuns.servicos;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import locadoraAlbuns.dao.BandaDAO;
import locadoraAlbuns.entidades.Banda;

/**
 *
 * @author CaueSJ
 */
public class BandaServices {
    
    public List<Banda> getTodos() {

        List<Banda> lista = new ArrayList<Banda>();
        BandaDAO dao = null;

        try {
            dao = new BandaDAO();
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
