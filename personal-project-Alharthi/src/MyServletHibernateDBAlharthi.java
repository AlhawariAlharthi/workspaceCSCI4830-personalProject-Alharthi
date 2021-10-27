import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datamodel.Costumer;
import util.UtilDBAlhartthi;

@WebServlet("/MyServletHibernateDBAlharthi")
public class MyServletHibernateDBAlharthi extends HttpServlet {
   private static final long serialVersionUID = 1L;

   public MyServletHibernateDBAlharthi() {
      super();
   }

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      response.setContentType("text/html");

      // #1
      //UtilDBAlhartthi.createCostumers("ali", "4021111111", "aoidjajd65", "toyota", "10/10/2021", "10/20/2021");
      //UtilDBAlhartthi.createCostumers("user4", "44", "402-111-2222");
      
      // #2
      retrieveDisplayData(response.getWriter());
   }

   void retrieveDisplayData(PrintWriter out) {
      String title = "Database Result";
      String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " + //
            "transitional//en\">\n"; //
      out.println(docType + //
            "<html>\n" + //
            "<head><title>" + title + "</title></head>\n" + //
            "<body bgcolor=\"#f0f0f0\">\n" + //
            "<h1 align=\"center\">" + title + "</h1>\n");
      out.println("<ul>");
      List<Costumer> listCostumers = UtilDBAlhartthi.listCostumers();
      for (Costumer costumer : listCostumers) {
         System.out.println("[DBG] "
        	   + costumer.getId() + ", " 
               + costumer.getName() + ", " //
               + costumer.getPhone() + ", "
               + costumer.getLicense() + ", "
               + costumer.getCar() + ", "
               + costumer.getStart() + ", "
               + costumer.getFinish());

         out.println("<li>" //
        		 + costumer.getId() + ", " //
        		 + costumer.getName() + ", " //
                 + costumer.getPhone() + ", "
                 + costumer.getLicense() + ", "
                 + costumer.getCar() + ", "
                 + costumer.getStart() + ", "
                 + costumer.getFinish() + "</li>");
      }
      out.println("</ul>");
      out.println("</body></html>");
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request, response);
   }
}
