package com.db.connection;

import java.util.List;
import java.util.Properties;

import com.db.db.table.TableColum;

public  abstract class SearchTableMetaAdpter {
	
	          protected  static DBExecutor  executor = new DBExecutorImp();
	
	        public abstract List<TableColum>      getTableMeta(String tableName,Properties prop);
	  
}
