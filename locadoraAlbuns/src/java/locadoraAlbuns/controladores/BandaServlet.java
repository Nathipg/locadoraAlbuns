/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locadoraAlbuns.controladores;

import locadoraAlbuns.dao.BandaDAO;
import locadoraAlbuns.entidades.Banda;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author CaueSJ
 */
public class BandaServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.sql.SQLException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        
        request.setCharacterEncoding("UTF-8");
        String acao = request.getParameter( "acao" );
        BandaDAO dao = null;
        RequestDispatcher disp = null;
        
        try {
            
            dao = new BandaDAO();
            
            if ( acao.equals( "criar" ) ) {

                String nome = request.getParameter( "nome" );
                String dataFormacao = request.getParameter( "data_formacao" );
                String descricao = request.getParameter( "descricao" );

                Banda banda = new Banda();
                banda.setNome( nome );
                banda.setDataFormacao( dataFormacao );
                banda.setDescricao( descricao );

                dao.salvar( banda );
                
                disp = request.getRequestDispatcher(
                        "/formularios/bandas/listagem.jsp" );

            } else if ( acao.equals( "alterar" ) ) {

                int id = Integer.parseInt( request.getParameter( "id" ) );
                String nome = request.getParameter( "nome" );
                String dataFormacao = request.getParameter( "data_formacao" );
                String descricao = request.getParameter( "descricao" );

                Banda banda = new Banda();
                banda.setId( id );
                banda.setNome( nome );
                banda.setDataFormacao( dataFormacao );
                banda.setDescricao( descricao );

                dao.atualizar( banda );

                disp = request.getRequestDispatcher(
                        "/formularios/bandas/listagem.jsp" );

            } else if ( acao.equals( "excluir" ) ) {

                int id = Integer.parseInt( request.getParameter( "id" ) );

                Banda banda = new Banda();
                banda.setId( id );

                dao.excluir( banda );

                disp = request.getRequestDispatcher(
                        "/formularios/bandas/listagem.jsp" );

            } else if ( acao.equals( "prepAlteracao" ) ) {

                int id = Integer.parseInt( request.getParameter( "id" ) );
                Banda banda = dao.obterPorId( id );
                request.setAttribute( "banda", banda );

                disp = request.getRequestDispatcher(
                        "/formularios/bandas/alterar.jsp" );

            } else if ( acao.equals( "prepExclusao" ) ) {

                int id = Integer.parseInt( request.getParameter( "id" ) );
                Banda banda = dao.obterPorId( id );
                request.setAttribute( "banda", banda );

                disp = request.getRequestDispatcher(
                        "/formularios/bandas/excluir.jsp" );                
            }
        
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
        
        if ( disp != null ) {
            disp.forward( request, response );
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(BandaServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(BandaServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
