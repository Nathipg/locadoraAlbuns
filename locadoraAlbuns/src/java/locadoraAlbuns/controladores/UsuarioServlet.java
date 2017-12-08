/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locadoraAlbuns.controladores;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import locadoraAlbuns.dao.UsuarioDAO;
import locadoraAlbuns.entidades.Usuario;

/**
 *
 * @author CaueSJ
 */
public class UsuarioServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        String acao = request.getParameter( "acao" );
        UsuarioDAO dao = null;
        RequestDispatcher disp = null;
        
        try {

            dao = new UsuarioDAO();

            if ( acao.equals( "criar" ) ) {

                String nome = request.getParameter( "nome" );
                String cpf = request.getParameter( "cpf" );
                String email = request.getParameter( "email" );
                String endereco = request.getParameter( "endereco" );
                String telefoneFixo = request.getParameter( "telefoneFixo" );
                String telefonecelular = request.getParameter( "telefoneCelular" );
                
                Usuario usuario = new Usuario();

                usuario.setNome( nome );
                usuario.setCpf( cpf );
                usuario.setEmail( email );
                usuario.setTelefoneFixo( telefoneFixo );
                usuario.setTelefoneCelular( telefonecelular );
                usuario.setEndereco( endereco );               
                
                dao.salvar( usuario );
                
                disp = request.getRequestDispatcher("/formularios/usuarios/listagem.jsp" );

            } else if ( acao.equals( "alterar" ) ) {

                int id = Integer.parseInt( request.getParameter( "id" ) );
                String nome = request.getParameter( "nome" );
                String cpf = request.getParameter( "cpf" );
                String email = request.getParameter( "email" );
                String endereco = request.getParameter( "endereco" );                
                String telefoneFixo = request.getParameter( "telefoneFixo" );
                String telefoneCelular = request.getParameter( "telefoneCelular" );

                Usuario usuario = new Usuario();
                usuario.setId( id );
                usuario.setNome( nome );
                usuario.setCpf( cpf );
                usuario.setEmail( email );
                usuario.setTelefoneFixo( telefoneFixo );
                usuario.setTelefoneCelular( telefoneCelular );                
                usuario.setEndereco( endereco );
                
                dao.atualizar( usuario );

                disp = request.getRequestDispatcher("/formularios/usuarios/listagem.jsp" );

            } else if ( acao.equals( "excluir" ) ) {

                int id = Integer.parseInt( request.getParameter( "id" ) );

                Usuario usuario = new Usuario();
                usuario.setId( id );

                dao.excluir( usuario );

                disp = request.getRequestDispatcher("/formularios/usuarios/listagem.jsp" );

            } else if ( acao.equals( "prepAlteracao" ) ) {

                int id = Integer.parseInt( request.getParameter( "id" ) );
                Usuario usuario = dao.obterPorId( id );
                request.setAttribute( "usuario", usuario );

                disp = request.getRequestDispatcher("/formularios/usuarios/alterar.jsp" );

            } else if ( acao.equals( "prepExclusao" ) ) {

                int id = Integer.parseInt( request.getParameter( "id" ) );
                Usuario usuario = dao.obterPorId( id );
                request.setAttribute( "usuario", usuario );

                disp = request.getRequestDispatcher("/formularios/usuarios/excluir.jsp" );                
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
        processRequest(request, response);
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
        processRequest(request, response);
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
