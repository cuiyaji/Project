import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;
import java.text.MessageFormat;


public class part extends HttpServlet{
    
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    }
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        
        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Part</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<p><h3>Part2:  </h3>");
        Enumeration<String> reqHeadInfos = request.getHeaderNames();
        while (reqHeadInfos.hasMoreElements()) {
            String headName = (String) reqHeadInfos.nextElement();
            String headValue = request.getHeader(headName);
            out.write(headName+":"+headValue);
            out.write("<br/>");
        }
        out.println("</p><p><h3>Part4:   </h3>");
        
        Enumeration<String> paramNames = request.getParameterNames();
        if(paramNames == null){
            out.println("!!!!!!");
        }else{
            out.println("!!323131!!!");
        }
        while (paramNames.hasMoreElements()) {
            String name = paramNames.nextElement();
            String value = request.getParameter(name);
            System.out.println(MessageFormat.format("{0}={1}", name,value));
        }
        
        
        out.println("</p>");
        
        
        out.println("</body>");
        out.println("</html>");
    }
    
}
