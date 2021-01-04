package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import TableDOA.TableDAO;
import TableDOA.TableDAOImp;
import model.Column;
import model.Enregistremt;
import model.Table;


public class ConrollerTable extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	TableDAO tableDAO;
    
    public ConrollerTable() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
		tableDAO = new TableDAOImp();
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path=request.getServletPath();
		String nameTable;
		Table table = new Table();
		
		//if (path.equals("ConrollerTable/chercher") )
		//{   
			
		    String name=request.getParameter("nameTable");
		    //System.out.print(name);
		    table.setNameTable(name);
			
		//}
		
		List<Column> columns = tableDAO.getColumns(table);
		List<Enregistremt> enregistremts = tableDAO.getEnregistrement(table);
		table.setColumns(columns);
		table.setEnregistremts(enregistremts);
		request.setAttribute("table", table);
		request.getRequestDispatcher("tables.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
	}

}
