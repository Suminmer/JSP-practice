/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.58
 * Generated at: 2022-04-24 08:10:14 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp._09PagingBoard;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import utils.BoardPage;
import model1.board.BoardDTO;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import model1.board.BoardDAO;

public final class List_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("java.util.List");
    _jspx_imports_classes.add("model1.board.BoardDTO");
    _jspx_imports_classes.add("java.util.Map");
    _jspx_imports_classes.add("java.util.HashMap");
    _jspx_imports_classes.add("model1.board.BoardDAO");
    _jspx_imports_classes.add("utils.BoardPage");
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

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
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
      response.setContentType("text/html; charset=UTF-8");
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

BoardDAO dao = new BoardDAO(application);

Map<String, Object> param = new HashMap<String, Object>();

String searchField = request.getParameter("searchField");
String searchWord = request.getParameter("searchWord");
if (searchWord!=null) {
	param.put("searchField", searchField);
	param.put("searchWord", searchWord);
}

int totalCount = dao.selectCount(param);

/* 페이지 처리 start */
//전체 페이지 수 계산
int pageSize = Integer.parseInt(application.getInitParameter("POSTS_PER_PAGE"));
int blockSize = Integer.parseInt(application.getInitParameter("PAGES_PER_BLOCK"));
int totalPage = (int)Math.ceil((double)totalCount/pageSize); //전체 페이지 수 (11)

//현재 페이지 확인
int pageNum = 1; //기본값
String pageTemp = request.getParameter("pageNum");
if (pageTemp!=null && !pageTemp.equals("")) {
	pageNum = Integer.parseInt(pageTemp); //요청받은 페이지로 수정
}

//목록에 출력할 게시물 범위 계산
int start = (pageNum - 1) * pageSize + 1; //첫 게시물 번호
int end = pageNum * pageSize; //마지막 게시물 번호
param.put("start", start);
param.put("end", end);
/* 페이지 처리 end */

List<BoardDTO> boardLists = dao.selectListPage(param);
dao.close();

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>회원제 게시판</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("	");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../Common/Link.jsp", out, false);
      out.write("\r\n");
      out.write("	<h2>목록 보기(List) - 현재 페이지 : ");
      out.print(pageNum);
      out.write(" (전체 : ");
      out.print(totalPage);
      out.write(")</h2>\r\n");
      out.write("	<!-- 검색 폼 -->\r\n");
      out.write("	<form method=\"get\">\r\n");
      out.write("		<table border=\"1\" width=\"90%\">\r\n");
      out.write("			<tr>\r\n");
      out.write("				<td align=\"center\">\r\n");
      out.write("					<select name=\"searchField\">\r\n");
      out.write("						<option value=\"title\">제목</option>\r\n");
      out.write("						<option value=\"content\">내용</option>\r\n");
      out.write("					</select>\r\n");
      out.write("					<input type=\"text\" name=\"searchWord\"/>\r\n");
      out.write("					<input type=\"submit\" value=\"검색하기\"/>\r\n");
      out.write("			</tr>\r\n");
      out.write("		</table>\r\n");
      out.write("	</form>\r\n");
      out.write("	<!-- 게시물 목록 테이블(표) -->\r\n");
      out.write("	<table border=\"1\" width=\"90%\">\r\n");
      out.write("		<!-- 각 컬럼의 이름 -->\r\n");
      out.write("		<tr>\r\n");
      out.write("			<th width=\"10%\">번호</th>\r\n");
      out.write("			<th width=\"50%\">제목</th>\r\n");
      out.write("			<th width=\"15%\">작성자</th>\r\n");
      out.write("			<th width=\"10%\">조회수</th>\r\n");
      out.write("			<th width=\"15%\">작성일</th>\r\n");
      out.write("		</tr>\r\n");
      out.write("		<!-- 목록의 내용 -->\r\n");
      out.write("	");

	if (boardLists.isEmpty()) {
	
      out.write("	\r\n");
      out.write("		<tr>\r\n");
      out.write("			<td colspan=\"5\" align=\"center\">\r\n");
      out.write("				등록된 게시물이 없습니다. >_<*\r\n");
      out.write("			</td>\r\n");
      out.write("		</tr>\r\n");
      out.write("	");
	
	} else {
		int virtualNum = 0; //화면상 게시물 번호
		int countNum = 0;
		for (BoardDTO dto : boardLists) {
			//virtualNum = totalCount--;
			virtualNum = totalCount - (((pageNum - 1)*pageSize) + countNum++);
		
      out.write("\r\n");
      out.write("			<tr align=\"center\">\r\n");
      out.write("				<td>");
      out.print(virtualNum);
      out.write("</td>\r\n");
      out.write("				<td align=\"left\">\r\n");
      out.write("					<a href=\"View.jsp?num=");
      out.print(dto.getNum());
      out.write('"');
      out.write('>');
      out.print(dto.getTitle());
      out.write("</a>\r\n");
      out.write("				</td>\r\n");
      out.write("				<td align=\"center\">");
      out.print(dto.getId());
      out.write("</td>\r\n");
      out.write("				<td align=\"center\">");
      out.print(dto.getVisitcount());
      out.write("</td>\r\n");
      out.write("				<td align=\"center\">");
      out.print(dto.getPostdate());
      out.write("</td>\r\n");
      out.write("			</tr>\r\n");
      out.write("		");
	
		}
	}
	
      out.write("\r\n");
      out.write("	</table>\r\n");
      out.write("	<!-- 목록 하단의 [글쓰기] 버튼 -->\r\n");
      out.write("	<table border=\"1\" width=\"90%\">\r\n");
      out.write("		<tr align=\"center\">\r\n");
      out.write("			<!-- 페이징 처리 -->\r\n");
      out.write("			<td>\r\n");
      out.write("				");
      out.print(BoardPage.pagingStr(totalCount, pageSize, blockSize, pageNum, request.getRequestURI()));
      out.write("\r\n");
      out.write("			</td>\r\n");
      out.write("			<!-- 글쓰기 버튼 -->\r\n");
      out.write("			<td><button type=\"button\" onclick=\"location.href='Write.jsp';\">글쓰기</button></td>\r\n");
      out.write("		</tr>\r\n");
      out.write("	</table>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
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
