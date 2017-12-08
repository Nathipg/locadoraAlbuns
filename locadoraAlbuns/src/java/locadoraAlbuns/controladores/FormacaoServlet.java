package locadoraAlbuns.controladores;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import locadoraAlbuns.dao.BandaDAO;
import locadoraAlbuns.dao.FormacaoDAO;
import locadoraAlbuns.dao.MusicoDAO;
import locadoraAlbuns.entidades.Banda;
import locadoraAlbuns.entidades.Formacao;
import locadoraAlbuns.entidades.Musico;

/**
 * Servlet para tratar Formacaos.
 *
 * @author nathipg
 */
public class FormacaoServlet extends HttpServlet {

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
        FormacaoDAO dao = null;
        BandaDAO daoBanda = null;
        MusicoDAO daoMusico = null;
        RequestDispatcher disp = null;

        try {

            dao = new FormacaoDAO();
            daoBanda = new BandaDAO();
            daoMusico = new MusicoDAO();

            if ( acao.equals( "criar" ) ) {

                String inicio = request.getParameter( "inicio" );
                String fim = request.getParameter( "fim" );
                int idBanda = Integer.parseInt( request.getParameter( "idBanda" ) );
                int idMusico = Integer.parseInt( request.getParameter( "idMusico" ) );

                Banda banda = daoBanda.obterPorId(idBanda);
                Musico musico = daoMusico.obterPorId(idMusico);

                Formacao formacao = new Formacao();
                formacao.setInicio( inicio );
                formacao.setFim( fim );
                formacao.setBanda( banda );
                formacao.setMusico( musico );

                dao.salvar( formacao );

                disp = request.getRequestDispatcher( "/formularios/formacoes/listagem.jsp" );

            } else if ( acao.equals( "alterar" ) ) {

                String inicio = request.getParameter( "inicio" );
                String fim = request.getParameter( "fim" );
                int idBanda = Integer.parseInt( request.getParameter( "idBanda" ) );
                int idMusico = Integer.parseInt( request.getParameter( "idMusico" ) );
                
                Banda banda = daoBanda.obterPorId(idBanda);
                Musico musico = daoMusico.obterPorId(idMusico);

                Formacao formacao = new Formacao();
                formacao.setInicio( inicio );
                formacao.setFim( fim );
                formacao.setBanda( banda );
                formacao.setMusico( musico );

                dao.atualizar( formacao );

                disp = request.getRequestDispatcher( "/formularios/formacoes/listagem.jsp" );

            } else if ( acao.equals( "excluir" ) ) {

                int idBanda = Integer.parseInt( request.getParameter( "idBanda" ) );
                int idMusico = Integer.parseInt( request.getParameter( "idMusico" ) );
                
                Banda banda = daoBanda.obterPorId(idBanda);
                Musico musico = daoMusico.obterPorId(idMusico);

                Formacao formacao = new Formacao();
                formacao.setBanda( banda );
                formacao.setMusico( musico );

                dao.excluir( formacao );

                disp = request.getRequestDispatcher( "/formularios/formacoes/listagem.jsp" );

            } else if ( acao.equals( "prepAlteracao" ) ) {

                int idBanda = Integer.parseInt( request.getParameter( "idBanda" ) );
                int idMusico = Integer.parseInt( request.getParameter( "idMusico" ) );
                Formacao formacao = dao.obterPorId( idBanda, idMusico );
                request.setAttribute( "formacao", formacao );

                disp = request.getRequestDispatcher( "/formularios/formacoes/alterar.jsp" );

            } else if ( acao.equals( "prepExclusao" ) ) {

                int idBanda = Integer.parseInt( request.getParameter( "idBanda" ) );
                int idMusico = Integer.parseInt( request.getParameter( "idMusico" ) );
                Formacao formacao = dao.obterPorId( idBanda, idMusico );
                request.setAttribute( "formacao", formacao );

                disp = request.getRequestDispatcher( "/formularios/formacoes/excluir.jsp" );

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
