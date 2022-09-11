package fileserveletapp;

/**
 *
 * @author smili08
 */
import dao.ImgDAO;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@MultipartConfig
@WebServlet(name = "FileUploadServlet", urlPatterns = {"/FileUploadServlet"})
public class FileUploadServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try ( PrintWriter out = response.getWriter()) {

            String caminho = "C:/Users/Finall00/Documents/NetBeansProjects/FileUpload/web/images" + "/";

            File diretorio = new File(caminho);
            if (!diretorio.exists()) {
                diretorio.mkdir();
            }

            Part filePart = request.getPart("file");
            String filename = filePart.getSubmittedFileName();

            OutputStream os = null;
            InputStream is = null;

            try {
                File filePath = new File(caminho, filename);

                os = new FileOutputStream(filePath);
                is = filePart.getInputStream();

               
                ImgDAO imgDAO = new ImgDAO();
                //ImgDAO.Cadastra(filePath.getPath(), filename);
                 imgDAO.Cadastra(filePath.getPath(), filePath.getName());
              

                int read = 0;
                while ((read = is.read()) != -1) {
                    os.write(read);

                }
                
                                
                request.getRequestDispatcher("ImgView.jsp").forward(request, response);

            } catch (SQLException | ClassNotFoundException | FileNotFoundException ex) {
                Logger.getLogger(FileUploadServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException e) {
            out.print(e);
        }
           
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
