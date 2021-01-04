package TableDOA;

import java.util.List;

import model.*;

public interface TableDAO {

	public List<Column> getColumns(Table table);
	public List<Enregistremt> getEnregistrement(Table table);
}
