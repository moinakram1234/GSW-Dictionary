package tests;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.Test;
import org.junit.jupiter.api.Order;

import java.sql.Connection;
import java.sql.SQLException;

import DataBase.DataBaseConnection;
import DataBase.DataBaseConnectionForFvrt;
import DataBase.FeedBackConnection;




public class Dbtest {

	@Order(1)
	@Test
	public void test1() throws SQLException {
		FeedBackConnection obj1=new FeedBackConnection();
		Connection conn=obj1.getConnection();
		
		assertEquals(conn,obj1.feedbackconnection());
		
		
	}
	
	@Order(2)
	@Test
	public void test2() throws SQLException{
		
		DataBaseConnectionForFvrt obj2=new DataBaseConnectionForFvrt();
		Connection conn=obj2.getConnection();
		
		assertEquals(conn,obj2.getConnection());
		
	}
	
	
	@Order(3)
	@Test
	public void test3() throws SQLException{
		
		DataBaseConnection obj3=new DataBaseConnection();
		Connection conn=obj3.getconnector();
		
		assertEquals(conn,obj3.getconnector());
		
	}
	
	
	
	

}
