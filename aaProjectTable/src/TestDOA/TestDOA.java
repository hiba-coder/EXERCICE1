package TestDOA;

import java.util.List;

import TableDOA.TableDAOImp;
import model.Column;
import model.Enregistremt;
import model.Table;

public class TestDOA {

	public static void main(String[] args) {
		TableDAOImp tableDAOImp = new TableDAOImp();
		//Column column = aticleDAOimp.save(new Article("hiba","etudiante"));
		Table t = new Table("Domain");
		List<Enregistremt> er = tableDAOImp.getEnregistrement(t);
		List<Column> columns = tableDAOImp.getColumns(t);
		for(Column c : columns) {
			System.out.println(c);
		}
		for(Enregistremt c : er) {
			System.out.println(c);
		}
	}
}
