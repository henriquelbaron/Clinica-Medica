package br.com.clinica.domain.tables;

import javax.swing.table.AbstractTableModel;


public abstract class TableTemplate<T> extends AbstractTableModel {

	abstract void clearTable() ;

	abstract T getRow(int row) ;

	abstract void addRow(T obj) ;

	abstract void removeRow(int row) ;

	abstract void updateRow(T obj, int row) ;


}
