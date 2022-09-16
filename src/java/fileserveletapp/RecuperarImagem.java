package fileserveletapp;

import dao.ImgDAO;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Img;

/**
 *
 * @author smili08
 */
@WebServlet(name = "RecuperarImagem", urlPatterns = {"/RecuperarImagem"})
public class RecuperarImagem extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        try {
                       
            
            int codigoImg = Integer.parseInt(request.getParameter("codigo"));
            
            ImgDAO ImgDAO = new ImgDAO();
            
            //pega o codigo da imagem pesquisa ela a resposta coloca dentro de img e manda para a pagina web
           Img img =(Img) ImgDAO.acharImage(codigoImg);
           request.setAttribute("img", img.getNomeImg());
           
        } catch (SQLException | ClassNotFoundException ex) {
            request.setAttribute("mensagem", ex.getMessage());
        }
        
        request.getRequestDispatcher("ImgView.jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * 
     * чертовски любопытно, это не важно и просто бесполезная пасхалка, помимо того, 
     * что я потратил много времени на этот бесполезный файл или почти и сейчас,
     * как в 3 часа ночи, я делаю эти комментарии, чтобы не забыть и если
     * кто-то хочет использовать код,
     * чтобы понять
     * 
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
