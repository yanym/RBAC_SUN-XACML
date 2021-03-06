package be.cetic.rbac.man.pip;

import java.sql.SQLException;

import be.cetic.rbac.man.datasource.SqliteManager;
import datasource.StorageManager;
import json.User;
import server.PIP;

public class SqlitePIP implements PIP{
	private StorageManager manager;
	
	public SqlitePIP(){
		manager = new SqliteManager();
	}
	
	public User getUser(String username){
		try{
			return manager.getUser(username);
		}
		catch(SQLException ex){
			return null;
		}
	}

	
	
}
