

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AndroidText")
public class AndroidText extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		// ��û�� �������� Ȯ�� �� �� �ִ� ��¹� �����
//		System.out.println("������ ��û�� ���Խ��ϴ�!");
//		
//		// ���ڵ� ���� �ذ��ϱ�
//		response.setCharacterEncoding("EUC-KR");
//		
//		// App�� ������ ���ڵ� �۾� ����
//		response.setContentType("EUC-KR");
//		
//		// �� �������� ����� ���� �ۼ�
//		PrintWriter out = response.getWriter();
//		
////		out.print("���� ����!");
//		
//		// JSON Ÿ���� ���䰪 �����
//		out.print("{\"name\":\"��μ�\"}");
		
		String data = request.getParameter("data");
		System.out.println("���� ���� ������ : " + data);
		
	}

}
