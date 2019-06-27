package br.com.clinica.domain.tables;

import javax.swing.table.AbstractTableModel;

public abstract class TableTemplate<T> extends AbstractTableModel {

    public abstract void clearTable();

    public abstract String getColumnName(int column);

    public abstract T getRow(int row);

    public abstract void addRow(T obj);

    public abstract void removeRow(int row);

    public abstract void updateRow(T obj, int row);

}
