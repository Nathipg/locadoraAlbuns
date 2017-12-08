package locadoraAlbuns.controladores;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import locadoraAlbuns.dao.TipoEmprestimoDAO;
import locadoraAlbuns.entidades.TipoEmprestimo;

/**
 * Servlet para tratar TipoEmprestimos.
 *
 * @author nathipg
 */
public class TipoEmprestimoServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String acao = request.getParameter( "acao" );
        TipoEmprestimoDAO dao = null;
        RequestDispatcher disp = null;

        try {

            dao = new TipoEmprestimoDAO();

            if ( acao.equals( "criar" ) ) {

                int diasDuracao = Integer.parseInt( request.getParameter( "diasDuracao" ) );
                double valor = Double.parseDouble( request.getParameter( "valor" ) );

                TipoEmprestimo tipoEmprestimo = new TipoEmprestimo();
                tipoEmprestimo.setDiasDuracao( diasDuracao );
                tipoEmprestimo.setValor( valor );

                dao.salvar( tipoEmprestimo );

                disp = request.getRequestDispatcher( "/formularios/tipoEmprestimos/listagem.jsp" );

            } else if ( acao.equals( "alterar" ) ) {

                int id = Integer.parseInt( request.getParameter( "id" ) );
                int diasDuracao = Integer.parseInt( request.getParameter( "diasDuracao" ) );
                double valor = Double.parseDouble( request.getParameter( "valor" ) );

                TipoEmprestimo tipoEmprestimo = new TipoEmprestimo();
                tipoEmprestimo.setId( id );
                tipoEmprestimo.setDiasDuracao( diasDuracao );
                tipoEmprestimo.setValor( valor );

                dao.atualizar( tipoEmprestimo );

                disp = request.getRequestDispatcher( "/formularios/tipoEmprestimos/listagem.jsp" );

            } else if ( acao.equals( "excluir" ) ) {

                int id = Integer.parseInt( request.getParameter( "id" ) );

                TipoEmprestimo tipoEmprestimo = new TipoEmprestimo();
                tipoEmprestimo.setId( id );

                dao.excluir( tipoEmprestimo );

                disp = request.getRequestDispatcher( "/formularios/tipoEmprestimos/listagem.jsp" );

            } else if ( acao.equals( "prepAlteracao" ) ) {

                int id = Integer.parseInt( request.getParameter( "id" ) );
                TipoEmprestimo tipoEmprestimo = dao.obterPorId( id );
                request.setAttribute( "tipoEmprestimo", tipoEmprestimo );

                disp = request.getRequestDispatcher( "/formularios/tipoEmprestimos/alterar.jsp" );

            } else if ( acao.equals( "prepExclusao" ) ) {

                int id = Integer.parseInt( request.getParameter( "id" ) );
                TipoEmprestimo tipoEmprestimo = dao.obterPorId( id );
                request.setAttribute( "tipoEmprestimo", tipoEmprestimo );

                disp = request.getRequestDispatcher( "/formularios/tipoEmprestimos/excluir.jsp" );

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
