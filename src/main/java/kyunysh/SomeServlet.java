package kyunysh;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SomeServlet
 */
@WebServlet("/SomeServlet")
public class SomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Numbers itsNumberWriter = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SomeServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(final HttpServletRequest request, final HttpServletResponse response)
			throws ServletException, IOException {
		final String n1 = request.getParameter("n1");
		final String n2 = request.getParameter("n2");
		if (n1 != null && n2 != null) {
			final int first = Integer.parseInt(n1);
			final int second = Integer.parseInt(n2);
			itsNumberWriter.setNumbers(first, second);
		}
		final PrintWriter writer = response.getWriter();
		writer.append("<body>");
		writer.append("<p>");
		FileReader fileReader;
		BufferedReader reader;
		String line;
		File file = new File("positiveNumbers.txt");
		if (file.exists()) {
			fileReader = new FileReader(file);
			reader = new BufferedReader(fileReader);
			writer.append("stored positive numbers:");
			while ((line = reader.readLine()) != null) {
				writer.append("<p>");
				writer.append(line);
				writer.append("</p>");
			}
		}
		writer.append("</p>");
		writer.append("<p>");
		file = new File("negativeNumbers.txt");
		if (file.exists()) {
			fileReader = new FileReader(file);
			reader = new BufferedReader(fileReader);
			writer.append("stored negative numbers:");
			while ((line = reader.readLine()) != null) {
				writer.append("<p>");
				writer.append(line);
				writer.append("</p>");
			}
		}
		writer.append("</p>");
		writer.append("</body>");
	}

	@Override
	public void init(final ServletConfig config) throws ServletException {
		super.init(config);
		itsNumberWriter = new Numbers();
		itsNumberWriter.addListener(new PositiveWriter());
		itsNumberWriter.addListener(new NegativeWriter());
	}

	@Override
	public void destroy() {
		File file = new File("positiveNumbers.txt");
		file.delete();
		file = new File("negativeNumbers.txt");
		file.delete();
		super.destroy();
	}

}
