import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datamodel.Costumer;
import util.Info;
import util.UtilDBAlhartthi;

@WebServlet("/SimpleSearchHB")
public class SimpleSearchHB extends HttpServlet implements Info {
   private static final long serialVersionUID = 1L;

   public SimpleSearchHB() {
      super();
   }

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String keyword = request.getParameter("keyword").trim();

      response.setContentType("text/html");
      PrintWriter out = response.getWriter();
      String title = "Search Result";
      String docType = "<!doctype html public \"-//w3c//dtd html 4.0 transitional//en\">\n"; //
      out.println(docType + //
            "<html>\n" + //
            "<head><title>" + title + "</title></head>\n" + //
            "<body bgcolor=\"#f0f0f0\">\n" + //
            "<h1 align=\"center\">" + title + "</h1>\n");
      out.println("<ul>");

      List<Costumer> listCostumers = null;
      if (keyword != null && !keyword.isEmpty()) {
         listCostumers = UtilDBAlhartthi.listCostumers(keyword);
      } else {
         listCostumers = UtilDBAlhartthi.listCostumers();
      }
      display(listCostumers, out);
      out.println("</ul>");
      out.println("<a href=/" + projectName + "/" + searchWebName + ">Search Data</a> <br>");
      out.println("</body></html>");
   }

   void display(List<Costumer> listCostumers, PrintWriter out) {
       out.println(
      		 "<html>"+
      		 "<head>"+
      		 "<style>"+
      		 "table {"+
      		   "font-family: arial, sans-serif;"+
      		   "border-collapse: collapse;"+
      		   "table-layout: fixed;" + 
      		   "width: 100%;"+
      		 "}"+
      		"table.fixed { table-layout:fixed; }"+
      		 "table.fixed td { overflow: hidden; }"+
      		 "td, th {"+
      		   "border: 1px solid #dddddd;"+
      		   "text-align: left;"+
      		   "overflow: hidden;"+
      		   "padding: 8px;"+
      		 "}"+

      		 "tr:nth-child(even) {"+
      		   "background-color: #dddddd;"+
      		 "}"+
      		 "</style>"+
      		 "</head>"+
      		 "<body>"+


      		 "<table>"+
      		   "<tr>"+
      		     "<th style = \"width: 20px\">ID</th>"+
      		     "<th>Name</th>"+
      		     "<th>Phone</th>"+
      		     "<th>License</th>"+
      		     "<th style = \"width: 50px\">Car</th>"+
      		     "<th>Start</th>"+
      		     "<th>Finish</th>");
	   for (Costumer costumer : listCostumers) {
         System.out.println("[DBG] "
        		 + costumer.getName() + ", " //
                 + costumer.getPhone() + ", "
                 + costumer.getLicense() + ", "
                 + costumer.getCar() + ", "
                 + costumer.getStart() + ", "
                 + costumer.getFinish());

         out.println(
        		 "<html>"+
        		 "<head>"+
        		 "<style>"+
        		 "table {"+
        		   "table-layout: fixed;"+
        		   "font-family: arial, sans-serif;"+
        		   "border-collapse: collapse;"+
        		   "width: 100%;"+
        		 "}"+

        		 "td, th {"+
        		   "overflow: hidden;"+
        		   "border: 1px solid #dddddd;"+
        		   "text-align: left;"+
        		   "padding: 8px;"+
        		 "}"+

        		 "tr:nth-child(even) {"+
        		   "background-color: #dddddd;"+
        		 "}"+
        		 "</style>"+
        		 "</head>"+
        		 "<body>"+


        		 "<table>"+
        		 
        		   "<tr>"+
        		   "<td style = \"width: 20px\">" + costumer.getId() + "</td>"+
        		     "<td>" + costumer.getName() + "</td>"+
        		     "<td>" + costumer.getPhone() + "</td>"+
        		     "<td>" + costumer.getLicense() + "</td>"+
        		     "<td style = \"width: 50px\">" + costumer.getCar() + "</td>"+
        		     "<td>" + costumer.getStart() + "</td>"+
        		     "<td>" + costumer.getFinish() + "</td>"+
        		   "</tr>"+
        		 "</table>"+

        		 "</body>"+
        		 "</html>");
      }
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request, response);
   }
}
