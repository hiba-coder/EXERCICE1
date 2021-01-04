package TableDOA;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Singleton.SingConnection;
import model.Column;
import model.Enregistremt;
import model.Table;

public class TableDAOImp implements TableDAO{

	@Override
	public List<Column> getColumns(Table table) {
		List<Column> columns = new ArrayList<>();
		Connection connection=SingConnection.getConnection();

		try {
			Statement stat=connection.createStatement();
			ResultSet rsC = stat.executeQuery( " show columns from "+table.getNameTable()+";" );
			/*PreparedStatement ps = connection.prepareStatement("SELECT * FROM Article");
			ResultSet rs = ps.executeQuery();*/
			while(rsC.next()) {
				Column column = new Column();
				column.setNameColumn(rsC.getString("Field"));
				columns.add(column);
				
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return columns;
	}

	@Override
	public List<Enregistremt> getEnregistrement(Table table) {
		List<Enregistremt> enregistremts = new ArrayList<>();
		Connection connection=SingConnection.getConnection();

		try {
			Statement stat=connection.createStatement();
			ResultSet rs = stat.executeQuery( "SELECT * FROM "+table.getNameTable()+";" );
			/*PreparedStatement ps = connection.prepareStatement("SELECT * FROM Article");
			ResultSet rs = ps.executeQuery();*/
			while(rs.next()) {
				Enregistremt enregistremt = new Enregistremt();
				List<Column> columns = getColumns(table);
				int nbdesEnreg = columns.size();
				String[] enreg = new String[nbdesEnreg];
				int i = 0 ;
					for(Column c : columns) {
						enreg[i] = rs.getString(c.getNameColumn());
						i++;	
					}
					enregistremt.setEnreg(enreg);
				enregistremts.add(enregistremt);
			}

		}catch(SQLException e) {
			e.printStackTrace();
		}
		return enregistremts;
	}
	
	
}
