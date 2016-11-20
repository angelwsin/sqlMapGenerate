package com.db.connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import com.db.db.table.TableColum;

public class MySqlSearchTableMetaAdpter extends SearchTableMetaAdpter{

	 private  final static String SELECT="select column_name ,data_type,column_comment  from information_schema.columns where table_name =?  and table_schema =?";
	public List<TableColum> getTableMeta(final String tableName,final Properties prop) {
		 return   this.executor.query(new DBService<List<TableColum>>() {

				public List<TableColum> execute(Connection conn) {
					try {
			      PreparedStatement st =  	conn.prepareStatement(SELECT);
			        st.setString(1,tableName);
			       String url = prop.getProperty(Const.DBURL);
			        int start =  url.lastIndexOf('/');
			        int end  =   url.indexOf('?');
			        String  table_schema = url.substring(start+1);
			        if(end>0){
			        	table_schema = url.substring(start+1, end);
			        }
			         st.setString(2,table_schema );
			         ResultSet result =  st.executeQuery();
			         while(result.next()){
			        	 
			        	 System.out.println(result.getObject("column_name"));
			        	String  columnName =  result.getString(1);
			        	
			         }
			        
					} catch (SQLException e) {
						
						e.printStackTrace();
					}
					return null;
				}
			});
		
	}
	

}
