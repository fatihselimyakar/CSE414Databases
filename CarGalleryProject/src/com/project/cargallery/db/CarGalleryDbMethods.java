package com.project.cargallery.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.project.cargallery.interfaces.ModelInterface;

public class CarGalleryDbMethods<T extends ModelInterface<T>> {
	private T privateObject;
	
	public CarGalleryDbMethods(T object) {
		privateObject=object;
	}
	
	public T getInstance(int id)  {      
        ResultSet rs = null;
        Connection connection = null;
        Statement statement = null; 
         
        String query = privateObject.getSelectQuery(id);
        try {           
            connection = CarGalleryConnection.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(query);
             
            if (rs.next()) {
            	privateObject = privateObject.exportTableInstance(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return privateObject;
    }
	
	public void deleteInstance(int id)  {      
        Connection connection = null;
        Statement statement = null; 
         
        String query = privateObject.getDeleteQuery(id);
        try {           
            connection = CarGalleryConnection.getConnection();
            statement = connection.createStatement();
            statement.executeUpdate(query);
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
	
	public List<T> getAllIntances()  {      
        ResultSet rs = null;
        Connection connection = null;
        Statement statement = null; 
         
        List<T> intanceList = new ArrayList<T>();
        String query = privateObject.getSelectAllQuery();
        try {           
            connection = CarGalleryConnection.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(query);
             
            while (rs.next()) {
            	intanceList.add(privateObject.exportTableInstance(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return intanceList;
    }
	
	public void addInstance(T object)  {      
        Connection connection = null;
        Statement statement = null; 
         
        String query = privateObject.getInsertQuery(object);
        
        try {           
            connection = CarGalleryConnection.getConnection();
            statement = connection.createStatement();
            statement.executeUpdate(query);
             
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
	
	public void deleteAlLInstances()  {      
        Connection connection = null;
        Statement statement = null; 
         
        String query = privateObject.getDeleteAllQuery();
       
        try {           
            connection = CarGalleryConnection.getConnection();
            statement = connection.createStatement();
            statement.executeUpdate(query);
             
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
	
	public void updateInstance(T object,int id)  {      
        Connection connection = null;
        Statement statement = null; 
         
        String query = privateObject.getUpdateQuery(object,id);
        
        try {           
            connection = CarGalleryConnection.getConnection();
            statement = connection.createStatement();
            statement.executeUpdate(query);
             
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
	
	public String getAllIntancesForViews()  {      
        ResultSet rs = null;
        ResultSetMetaData rsmd = null;
        Connection connection = null;
        Statement statement = null; 
        
        StringBuilder retStr=new StringBuilder();
        String query = privateObject.getSelectAllQuery();
        try {           
            connection = CarGalleryConnection.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(query);
            rsmd=rs.getMetaData();
            
            
            while (rs.next()) {
            	StringBuilder str=new StringBuilder();
            	str.append("[");
            	for(int i=1;i<rsmd.getColumnCount()+1;++i) {
            		str.append(rsmd.getColumnName(i));
            		str.append("=");
            		str.append(rs.getString(i));
            		if(i!=rsmd.getColumnCount())
            			str.append(",");
            	}
            	str.append("]");
            	str.append("\n");
            	retStr.append(str);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return retStr.toString();
    }
	
	
	public String getAllIntancesManually(String queryString)  {      
        ResultSet rs = null;
        ResultSetMetaData rsmd = null;
        Connection connection = null;
        Statement statement = null; 
        
        StringBuilder retStr=new StringBuilder();
        String query = privateObject.getSelectAllQuery();
        try {           
            connection = CarGalleryConnection.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(queryString);
            rsmd=rs.getMetaData();
            
            
            while (rs.next()) {
            	StringBuilder str=new StringBuilder();
            	str.append("[");
            	for(int i=1;i<rsmd.getColumnCount()+1;++i) {
            		str.append(rsmd.getColumnName(i));
            		str.append("=");
            		str.append(rs.getString(i));
            		if(i!=rsmd.getColumnCount())
            			str.append(",");
            	}
            	str.append("]");
            	str.append("\n");
            	retStr.append(str);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return retStr.toString();
    }
	
	public void updateManually(String queryString)  {      
        Connection connection = null;
        Statement statement = null; 

        
        try {           
            connection = CarGalleryConnection.getConnection();
            statement = connection.createStatement();
            statement.executeUpdate(queryString);
             
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
	
	/*public void selectAllForGui(ArrayList<String> names,ArrayList<ArrayList<String>> contents)  {      
        ResultSet rs = null;
        ResultSetMetaData rsmd = null;
        Connection connection = null;
        Statement statement = null; 
        
        String query = privateObject.getSelectAllQuery();
        try {           
            connection = CarGalleryConnection.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(query);
            rsmd=rs.getMetaData();
                
            
            for(int i=1;i<rsmd.getColumnCount()+1;++i) {
            	names.add(rsmd.getColumnName(i));
        	}
            while (rs.next()) {
            	ArrayList<String> indexContent = new ArrayList<String>();
            	for(int i=1;i<rsmd.getColumnCount()+1;++i) {
            		indexContent.add(rs.getString(i));
            	}
            	contents.add(indexContent);
            }
            //System.out.print(contents);
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }*/
	

}
