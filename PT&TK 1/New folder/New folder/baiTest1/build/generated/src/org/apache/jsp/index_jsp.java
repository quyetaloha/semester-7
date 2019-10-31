package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.examp.giaima.SanPhamDAO;
import com.examp.giaima.SanPham;
import java.util.ArrayList;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n");
      out.write("        <title>Product Information</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
 ArrayList<SanPham> lst = new SanPhamDAO().getAllProducts(); 
      out.write("\n");
      out.write("       \n");
      out.write("        <h1 align=\"center\">List Book</h1>\n");
      out.write("        <table border=\"1\" width=\"80%\" align=\"center\">\n");
      out.write("            <tr>\n");
      out.write("                <th>Book's ID</th>\n");
      out.write("                <th>Book's Name</th>\n");
      out.write("                <th>Provider</th>\n");
      out.write("                <th>Unit's Price</th>\n");
      out.write("                <th colspan=\"2\"><a href=\"insert.jsp\">Insert New</a></th>\n");
      out.write("            </tr>\n");
      out.write("            ");

                for (SanPham sp : lst) {
                    String editURL = "update.jsp?id=" + sp.getID();
                    String deleteURL = "DeleteServlet?id=" + sp.getID();
            
      out.write("\n");
      out.write("            <tr>\n");
      out.write("                <td>");
      out.print( sp.getID() );
      out.write("</td>\n");
      out.write("                <td>");
      out.print(sp.getName());
      out.write("</td>\n");
      out.write("                <td>");
      out.print(sp.getCompany());
      out.write("</td>\n");
      out.write("                <td>");
      out.print(sp.getPrice());
      out.write("</td>\n");
      out.write("                \n");
      out.write("                <td><a href=\"");
      out.print(editURL);
      out.write("\">Update</a></td>\n");
      out.write("                <td><a href=\"");
      out.print(deleteURL);
      out.write("\">Delete</a></td>\n");
      out.write("            </tr>\n");
      out.write("            ");

                }
            
      out.write("\n");
      out.write("        </table>\n");
      out.write("    </body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
