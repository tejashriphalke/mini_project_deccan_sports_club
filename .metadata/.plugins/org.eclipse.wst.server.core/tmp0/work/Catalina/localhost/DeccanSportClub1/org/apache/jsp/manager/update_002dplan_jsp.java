/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.45
 * Generated at: 2020-11-24 10:55:24 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.manager;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class update_002dplan_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(3);
    _jspx_dependants.put("jar:file:/C:/Users/Administrator/Desktop/Java/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/DeccanSportClub/WEB-INF/lib/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153365282000L));
    _jspx_dependants.put("/manager/manager-header.jsp", Long.valueOf(1606214353580L));
    _jspx_dependants.put("/WEB-INF/lib/jstl-1.2.jar", Long.valueOf(1605861995634L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


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

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("<title>G-2 Project</title>\r\n");
      out.write("<link defer rel=\"stylesheet\" href=\"assets/css/member-home.css\">\r\n");
      out.write("<link defer rel=\"stylesheet\" href=\"assets/css/form-style.css\">\r\n");
      out.write("<link defer rel=\"stylesheet\" href=\"assets/css/styles.css\">\r\n");
      out.write("<style>\r\n");
      out.write("body {\r\n");
      out.write("\tmargin: 0;\r\n");
      out.write("\tpadding: 0;\r\n");
      out.write("\tbackground-image: linear-gradient(rgb(12, 103, 145), rgb(163, 169, 223));\r\n");
      out.write("\theight: 100vh;\r\n");
      out.write("\twidth: 100%;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("ul {\r\n");
      out.write("\tlist-style-type: none;\r\n");
      out.write("\tmargin: 10px;\r\n");
      out.write("\tpadding: 10px;\r\n");
      out.write("\tcolor: white;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("li {\r\n");
      out.write("\tdisplay: inline;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("li a, tr a {\r\n");
      out.write("\tcolor: white;\r\n");
      out.write("\tpadding: 0.1em 1em;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("nav {\r\n");
      out.write("\tdisplay: flex;\r\n");
      out.write("\tbackground-image: linear-gradient(rgb(163, 169, 223), rgb(12, 103, 145));\r\n");
      out.write("\tborder-radius: 20px;\r\n");
      out.write("\tmargin: 17px;\r\n");
      out.write("\twidth: 100%;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("li a {\r\n");
      out.write("\tcolor: white;\r\n");
      out.write("\tpadding: 0.1em 1em;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#footer {\r\n");
      out.write("\tposition: absolute;\r\n");
      out.write("\tbottom: 0;\r\n");
      out.write("\twidth: 100%;\r\n");
      out.write("\theight: 2.5rem; /* Footer height */\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".page-footer {\r\n");
      out.write("\tbackground-image: linear-gradient(rgb(163, 169, 223), rgb(12, 103, 145));\r\n");
      out.write("\tpadding: 30px 30px;\r\n");
      out.write("\tmargin-top: 20px;\r\n");
      out.write("\tcolor: #800040;\r\n");
      out.write("\ttext-align: center;\r\n");
      out.write("\tborder-radius: 20px;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body id=\"body-main\">\r\n");
      out.write("\r\n");
      out.write("\t");
HttpSession session1=request.getSession();
	session1.setAttribute("username",request.getRemoteUser());
      out.write("\r\n");
      out.write("\t<nav class=\"navbar \">\r\n");
      out.write("\t\t<ul>\r\n");
      out.write("\t\t\t\t <li><a href=\"");
      out.print(request.getContextPath());
      out.write("/AppServlet\">Home</a></li> \r\n");
      out.write("\t\t\t\t<li><a href=\"");
      out.print(request.getContextPath());
      out.write("/ManagerServlet/listbatch\">Batch management</a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"");
      out.print(request.getContextPath());
      out.write("/ManagerServlet/managerprofile\">View Profile</a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"");
      out.print(request.getContextPath());
      out.write("/ManagerServlet/listenrolledmembers\">Enroll Member</a></li>\t\t\t\r\n");
      out.write("\t\t\t\t\t<li><a href=\"");
      out.print(request.getContextPath());
      out.write("/ManagerServlet/enrolledstatus\">Enrollment Status</a></li>\t\t\t\r\n");
      out.write("\t\t\t<li ><a href=\"");
      out.print(request.getContextPath());
      out.write("/ManagerServlet/listplan\">Plan Management</a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"");
      out.print(request.getContextPath());
      out.write("/logout.jsp\">Logout</a></li>\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\t</nav>\r\n");
      out.write("\n");
      out.write("<div id=\"login\">\n");
      out.write("\n");
      out.write("\t<div class=\"container\">\n");
      out.write("\t\t<div id=\"login-row\"\n");
      out.write("\t\t\tclass=\"row justify-content-center align-items-center\">\n");
      out.write("\t\t\t<div id=\"login-column\" class=\"col-md-6\">\n");
      out.write("\t\t\t\t<div id=\"login-box\" class=\"col-md-12\">\n");
      out.write("\t\t\t\t\t<form id=\"update-form\" class=\"form\"\n");
      out.write("\t\t\t\t\t\taction=\"");
      out.print(request.getContextPath());
      out.write("/ManagerServlet/updateplan\"\n");
      out.write("\t\t\t\t\t\tmethod=\"post\">\n");
      out.write("\n");
      out.write("\t\t\t\t\t\t<div class=\"form-group\">\n");
      out.write("\t\t\t\t\t\t\t<label for=\"username\" class=\"text-info\">Plan Id</label><br>\n");
      out.write("\t\t\t\t\t\t\t<input type=\"Number\" name=\"planId\" class=\"form-control\"\n");
      out.write("\t\t\t\t\t\t\t\trequired=\"required\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${plans.planId}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" readonly=\"readonly\">\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t<div class=\"form-group\">\n");
      out.write("\t\t\t\t\t\t\t<label for=\"password\" class=\"text-info\">Plan Name</label><br>\n");
      out.write("\t\t\t\t\t\t\t<input type=\"text\" name=\"planName\" class=\"form-control\"\n");
      out.write("\t\t\t\t\t\t\t\trequired=\"required\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${plans.planName}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\n");
      out.write("\t\t\t\t\t\t<div class=\"form-group\">\n");
      out.write("\t\t\t\t\t\t\t<label for=\"role\" class=\"text-info\">Fees</label><br> <input\n");
      out.write("\t\t\t\t\t\t\t\ttype=\"Number\" name=\"fees\" class=\"form-control\"\n");
      out.write("\t\t\t\t\t\t\t\trequired=\"required\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${plans.fees}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t<div class=\"form-group\">\n");
      out.write("\t\t\t\t\t\t\t<label for=\"address\" class=\"text-info\">Duration</label><br>\n");
      out.write("\t\t\t\t\t\t\t<input type=\"number\" name=\"duration\" class=\"form-control\"\n");
      out.write("\t\t\t\t\t\t\t\trequired=\"required\" min=\"1\" max=\"12\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${plans.duration}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\n");
      out.write("\t\t\t\t\t\t<div class=\"form-group\">\n");
      out.write("\t\t\t\t\t\t\t<input type=\"submit\" name=\"submit\" class=\"btn btn-success\"\n");
      out.write("\t\t\t\t\t\t\t\tvalue=\"Update Plan\">\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\n");
      out.write("\t\t\t\t\t</form>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("\n");
      out.write("</html>\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
