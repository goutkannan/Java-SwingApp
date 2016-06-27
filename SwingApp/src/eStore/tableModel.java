package eStore;

import javax.swing.Icon;
import javax.swing.table.AbstractTableModel;

public class tableModel extends AbstractTableModel
{
	private String[] columns;
	private Object[][] rows; 
	
	public tableModel() {}

	public tableModel(Object[][] data,String[] columnName) {
		this.columns = columnName;
		this.rows = data;
		
	}
	@SuppressWarnings("unchecked")
	public Class getColumnClass(int column)
	{
	
			return getValueAt(0,column).getClass();
	}
		
	
	@Override
	public int getColumnCount() {
		
		return this.columns.length;
	}

	@Override
	public int getRowCount() {
		
		return this.rows.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int colIndex) {
		// TODO Auto-generated method stub
		return this.rows[rowIndex][colIndex];
	}
	public String getColumnName(int col)
	{
		return this.columns[col];
	}
	public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex > 4;
	}
	

}
