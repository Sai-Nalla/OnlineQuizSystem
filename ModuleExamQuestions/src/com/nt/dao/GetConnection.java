package com.nt.dao;

import java.sql.Connection;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class GetConnection {
	
	public Connection  getPooledJdbcConnection() throws Exception {
	    InitialContext ic=null;
	    DataSource ds=null;
	    Connection con=null;
	    //create InitialContext object
	    ic=new InitialContext();
	    //get DataSource object from jndi registry
	    ds=(DataSource)ic.lookup("java:/comp/env/DsJndi");
	    //get Pooled jdbc connection
	    con= ds.getConnection();
	    return con;
}


}
