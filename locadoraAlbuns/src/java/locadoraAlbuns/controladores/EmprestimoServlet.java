package locadoraAlbuns.controladores;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import locadoraAlbuns.dao.UsuarioDAO;
import locadoraAlbuns.dao.EmprestimoDAO;
import locadoraAlbuns.dao.AlbumDAO;
import locadoraAlbuns.dao.TipoEmprestimoDAO;
import locadoraAlbuns.entidades.Usuario;
import locadoraAlbuns.entidades.Emprestimo;
import locadoraAlbuns.entidades.Album;
import locadoraAlbuns.entidades.TipoEmprestimo;

/**
 * Servlet para tratar Emprestimos.
 *
 * @author nathipg
 */
public class EmprestimoServlet extends HttpServlet {

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
        EmprestimoDAO dao = null;
        UsuarioDAO daoUsuario = null;
        AlbumDAO daoAlbum = null;
        RequestDispatcher disp = null;

        try {

            dao = new EmprestimoDAO();
            daoUsuario = new UsuarioDAO();
            daoAlbum = new AlbumDAO();
            daoTipoEmprestimo = new TipoEmprestimoDAO();

            if ( acao.equals( "criar" ) ) {

                String inicio = request.getParameter( "inicio" );
                String fim = request.getParameter( "fim" );
                int idUsuario = Integer.parseInt( request.getParameter( "idUsuario" ) );
                int idAlbum = Integer.parseInt( request.getParameter( "idAlbum" ) );
                int idTipoEmprestimo = Integer.parseInt( request.getParameter( "idTipoEmprestimo" ) );

                Usuario usuario = daoUsuario.obterPorId(idUsuario);
                Album album = daoAlbum.obterPorId(idAlbum);
                TipoEmprestimo tipoEmprestimo = daoTipoEmprestimo.obterPorId(idTipoEmprestimo);

                Emprestimo emprestimo = new Emprestimo();
                emprestimo.setInicio( inicio );
                emprestimo.setFim( fim );
                emprestimo.setUsuario( usuario );
                emprestimo.setAlbum( album );
                emprestimo.setTipoEmprestimo( tipoEmprestimo );

                dao.salvar( emprestimo );

                disp = request.getRequestDispatcher( "/formularios/emprestimos/listagem.jsp" );

            } else if ( acao.equals( "alterar" ) ) {

                int id = Integer.parseInt( request.getParameter( "id" ) );
                String inicio = request.getParameter( "inicio" );
                String fim = request.getParameter( "fim" );
                int idUsuario = Integer.parseInt( request.getParameter( "idUsuario" ) );
                int idAlbum = Integer.parseInt( request.getParameter( "idAlbum" ) );
                int idTipoEmprestimo = Integer.parseInt( request.getParameter( "idTipoEmprestimo" ) );

                Usuario usuario = daoUsuario.obterPorId(idUsuario);
                Album album = daoAlbum.obterPorId(idAlbum);
                TipoEmprestimo tipoEmprestimo = daoTipoEmprestimo.obterPorId(idTipoEmprestimo);

                Emprestimo emprestimo = new Emprestimo();
                emprestimo.setId( id );
                emprestimo.setInicio( inicio );
                emprestimo.setFim( fim );
                emprestimo.setUsuario( usuario );
                emprestimo.setAlbum( album );
                emprestimo.setTipoEmprestimo( tipoEmprestimo );

                dao.atualizar( emprestimo );

                disp = request.getRequestDispatcher( "/formularios/emprestimos/listagem.jsp" );

            } else if ( acao.equals( "excluir" ) ) {

                int id = Integer.parseInt( request.getParameter( "id" ) );

                Emprestimo emprestimo = new Emprestimo();
                emprestimo.setId( id );

                dao.excluir( emprestimo );

                disp = request.getRequestDispatcher( "/formularios/emprestimos/listagem.jsp" );

            } else if ( acao.equals( "prepAlteracao" ) ) {

                int id = Integer.parseInt( request.getParameter( "id" ) );
                Emprestimo emprestimo = dao.obterPorId( id );
                request.setAttribute( "emprestimo", emprestimo );

                disp = request.getRequestDispatcher( "/formularios/emprestimos/alterar.jsp" );

            } else if ( acao.equals( "prepExclusao" ) ) {

                int id = Integer.parseInt( request.getParameter( "id" ) );
                Emprestimo emprestimo = dao.obterPorId( id );
                request.setAttribute( "emprestimo", emprestimo );

                disp = request.getRequestDispatcher( "/formularios/emprestimos/excluir.jsp" );

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
