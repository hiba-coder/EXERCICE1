package model;

import java.util.*;

public class Table {
	
	String nameTable;
	List<Column> columns = new ArrayList<>();
	List<Enregistremt> enregistremts = new ArrayList<>();
	public Table() {
		
	}

	public Table(String nameTable) {
		this.nameTable = nameTable;
	}
	
	public List<Column> getColumns(){
		return columns;
	}
	
	public void setColumns(List<Column> columns) {
		this.columns = columns;
	}
	

	public List<Enregistremt> getEnregistremts() {
		return enregistremts;
	}

	public void setEnregistremts(List<Enregistremt> enregistremts) {
		this.enregistremts = enregistremts;
	}

	public String getNameTable() {
		return nameTable;
	}

	public void setNameTable(String nameTable) {
		this.nameTable = nameTable;
	}
	
}
