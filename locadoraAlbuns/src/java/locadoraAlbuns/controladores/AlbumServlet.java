package locadoraAlbuns.controladores;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import locadoraAlbuns.dao.BandaDAO;
import locadoraAlbuns.dao.AlbumDAO;
import locadoraAlbuns.dao.MusicoDAO;
import locadoraAlbuns.dao.GeneroDAO;
import locadoraAlbuns.entidades.Banda;
import locadoraAlbuns.entidades.Album;
import locadoraAlbuns.entidades.Musico;
import locadoraAlbuns.entidades.Genero;

/**
 * Servlet para tratar Albums.
 *
 * @author nathipg
 */
public class AlbumServlet extends HttpServlet {

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
        AlbumDAO dao = null;
        BandaDAO daoBanda = null;
        MusicoDAO daoMusico = null;
        GeneroDAO daoGenero = null;
        RequestDispatcher disp = null;

        try {

            dao = new AlbumDAO();
            daoBanda = new BandaDAO();
            daoMusico = new MusicoDAO();
            daoGenero = new GeneroDAO();

            if ( acao.equals( "criar" ) ) {

                String inicio = request.getParameter( "inicio" );
                String fim = request.getParameter( "fim" );
                int idBanda = Integer.parseInt( request.getParameter( "idBanda" ) );
                int idMusico = Integer.parseInt( request.getParameter( "idMusico" ) );
                int idGenero = Integer.parseInt( request.getParameter( "idGenero" ) );

                Banda banda = daoBanda.obterPorId(idBanda);
                Musico musico = daoMusico.obterPorId(idMusico);
                Genero genero = daoGenero.obterPorId(idGenero);

                Album album = new Album();
                album.setInicio( inicio );
                album.setFim( fim );
                album.setBanda( banda );
                album.setMusico( musico );
                album.setGenero( genero );

                dao.salvar( album );

                disp = request.getRequestDispatcher( "/formularios/albums/listagem.jsp" );

            } else if ( acao.equals( "alterar" ) ) {

                int id = Integer.parseInt( request.getParameter( "id" ) );
                String inicio = request.getParameter( "inicio" );
                String fim = request.getParameter( "fim" );
                int idBanda = Integer.parseInt( request.getParameter( "idBanda" ) );
                int idMusico = Integer.parseInt( request.getParameter( "idMusico" ) );
                nt idGenero = Integer.parseInt( request.getParameter( "idGenero" ) );

                Banda banda = daoBanda.obterPorId(idBanda);
                Musico musico = daoMusico.obterPorId(idMusico);
                Genero genero = daoGenero.obterPorId(idGenero);

                Album album = new Album();
                album.setId( id );
                album.setInicio( inicio );
                album.setFim( fim );
                album.setBanda( banda );
                album.setMusico( musico );
                album.setGenero( genero );

                dao.atualizar( album );

                disp = request.getRequestDispatcher( "/formularios/albums/listagem.jsp" );

            } else if ( acao.equals( "excluir" ) ) {

                int id = Integer.parseInt( request.getParameter( "id" ) );

                Album album = new Album();
                album.setId( id );

                dao.excluir( album );

                disp = request.getRequestDispatcher( "/formularios/albums/listagem.jsp" );

            } else if ( acao.equals( "prepAlteracao" ) ) {

                int id = Integer.parseInt( request.getParameter( "id" ) );
                Album album = dao.obterPorId( id );
                request.setAttribute( "album", album );

                disp = request.getRequestDispatcher( "/formularios/albums/alterar.jsp" );

            } else if ( acao.equals( "prepExclusao" ) ) {

                int id = Integer.parseInt( request.getParameter( "id" ) );
                Album album = dao.obterPorId( id );
                request.setAttribute( "album", album );

                disp = request.getRequestDispatcher( "/formularios/albums/excluir.jsp" );

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
