package upload;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Collection;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet(
    urlPatterns = "/upload",
    initParams = @WebInitParam(name = "dirToSaveFiles", value = "C:\\Users\\apatrin\\Desktop\\Server")
)
@MultipartConfig(
    location = "C:\\Windows\\Temp", //Abs. Path, wo der Container die Dateien zwischenspeichern kann
    maxFileSize = -1L,
    maxRequestSize = -1L,
    fileSizeThreshold = 0
)
public class ServletUpload extends HttpServlet {

    private Path dirToSaveFiles;
    
    @Override
    public void init() throws ServletException {
        String dirName = getInitParameter("dirToSaveFiles");
        dirToSaveFiles = Paths.get(dirName);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletUpload</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>ServletUpload</h1>");
            
//            Part part1 = request.getPart("file1");
            Collection<Part> parts = request.getParts();
            for (Part part : parts) {
                save(part, out);
            }
            
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    private void save(Part part, PrintWriter out) {
     
        String partName = part.getName();
        if( part.getSize()==0 ) {
            out.println("Keine Datei mit dem Part '" + partName + "' erhalten<br/>");
            return;
        }
        
        String fileName = part.getSubmittedFileName();
        Path file = dirToSaveFiles.resolve(fileName);
        
        try(InputStream in = part.getInputStream()) {
            Files.copy(in, file, StandardCopyOption.REPLACE_EXISTING);
            out.println("Die Datei " + fileName + " gespeichert.<br/>");
        } catch(IOException e) {
            out.println("Die Datei " + fileName 
                    + " konnte nicht gespeichert werden: " + e.getMessage() + "<br/>");
        }
        
    }

}
