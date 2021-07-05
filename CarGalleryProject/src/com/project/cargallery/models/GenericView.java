package com.project.cargallery.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.project.cargallery.interfaces.ModelInterface;

public class GenericView implements ModelInterface<GenericView> {
	String viewName;
	String viewRow;
	
	public GenericView(String viewName){
		this.viewName=viewName;
	}
	
	public String getViewName() {
		return viewName;
	}

	public void setViewName(String viewName) {
		this.viewName = viewName;
	}

	@Override
	public GenericView exportTableInstance(ResultSet rs) throws SQLException {
		return null;
	}

	@Override
	public String getSelectQuery(int id) {
		return null;
	}

	@Override
	public String getSelectAllQuery() {
		return "SELECT * FROM "+viewName;
	}

	@Override
	public String getDeleteQuery(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDeleteAllQuery() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getInsertQuery(GenericView object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUpdateQuery(GenericView object, int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
