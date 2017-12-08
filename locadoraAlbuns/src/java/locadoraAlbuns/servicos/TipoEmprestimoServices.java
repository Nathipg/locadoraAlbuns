/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locadoraAlbuns.servicos;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import locadoraAlbuns.dao.TipoEmprestimoDAO;
import locadoraAlbuns.entidades.TipoEmprestimo;

/**
 *
 * @author CaueSJ
 */
public class TipoEmprestimoServices {
    
    public List<TipoEmprestimo> getTodos() {

        List<TipoEmprestimo> lista = new ArrayList<TipoEmprestimo>();
        TipoEmprestimoDAO dao = null;

        try {
            dao = new TipoEmprestimoDAO();
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