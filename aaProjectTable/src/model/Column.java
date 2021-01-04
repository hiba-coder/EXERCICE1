package model;

public class Column {
	
	String nameColumn;

	public Column() {
		
	}

	public String getNameColumn() {
		return nameColumn;
	}

	public void setNameColumn(String nameColumn) {
		this.nameColumn = nameColumn;
	}

	@Override
	public String toString() {
		return "Column [nameColumn=" + nameColumn + "]";
	}
	
}
