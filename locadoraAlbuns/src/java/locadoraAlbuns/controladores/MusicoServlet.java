package locadoraAlbuns.controladores;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import locadoraAlbuns.dao.MusicoDAO;
import locadoraAlbuns.entidades.Musico;

/**
 * Servlet para tratar Musicos.
 *
 * @author nathipg
 */
public class MusicoServlet extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acao = request.getParameter( "acao" );
        MusicoDAO dao = null;
        RequestDispatcher disp = null;

        try {

            dao = new MusicoDAO();

            if ( acao.equals( "criar" ) ) {

                String nome = request.getParameter( "nome" );
                String dataNascimento = request.getParameter( "dataNascimento" );
                String bio = request.getParameter( "bio" );
                
                Musico musico = new Musico();
                musico.setNome( nome );
                musico.setDataNascimento( dataNascimento );
                musico.setBio( bio );

                dao.salvar( musico );

                disp = request.getRequestDispatcher( "/formularios/musicos/listagem.jsp" );

            } else if ( acao.equals( "alterar" ) ) {

                int id = Integer.parseInt( request.getParameter( "id" ) );
                String nome = request.getParameter( "nome" );
                String dataNascimento = request.getParameter( "dataNascimento" );
                String bio = request.getParameter( "bio" );

                Musico musico = new Musico();
                musico.setId( id );
                musico.setNome( nome );
                musico.setDataNascimento( dataNascimento );
                musico.setBio( bio );

                dao.atualizar( musico );

                disp = request.getRequestDispatcher( "/formularios/musicos/listagem.jsp" );

            } else if ( acao.equals( "excluir" ) ) {

                int id = Integer.parseInt( request.getParameter( "id" ) );

                Musico musico = new Musico();
                musico.setId( id );

                dao.excluir( musico );

                disp = request.getRequestDispatcher( "/formularios/musicos/listagem.jsp" );

            } else if ( acao.equals( "prepAlteracao" ) ) {

                int id = Integer.parseInt( request.getParameter( "id" ) );
                Musico musico = dao.obterPorId( id );
                request.setAttribute( "musico", musico );

                disp = request.getRequestDispatcher( "/formularios/musicos/alterar.jsp" );

            } else if ( acao.equals( "prepExclusao" ) ) {

                int id = Integer.parseInt( request.getParameter( "id" ) );
                Musico musico = dao.obterPorId( id );
                request.setAttribute( "musico", musico );

                disp = request.getRequestDispatcher( "/formularios/musicos/excluir.jsp" );

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
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
