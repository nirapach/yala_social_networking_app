package com.application.classes;

import java.sql.Connection;

import com.application.connection.DBConnection;

public class Groups implements ScreenClass {

	@Override
	public void getDetails() {
		// TODO Auto-generated method stub
		Connection con = DBConnection.getConnection();
		
		
	}

}
