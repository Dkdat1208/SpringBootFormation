package com.mycompany.invoise;

import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

@SpringBootApplication
public class InvoiseWebApplication {

	public static void main(String[] args) {

		SpringApplication.run(InvoiseWebApplication.class,args);
/*
    ApplicationContext context =  SpringApplication.run(InvoiseWebApplication.class, args);
		DataSource ds = context.getBean(DataSource.class);
		Connection connection = null ;
		try {
			connection =  ds.getConnection();
			System.out.println("succes");
			ResultSet rs  = connection.createStatement().executeQuery("SELECT INVOICE_NUMBER, CUSTOMER_NAME  FROM   INVOICE");
			while(rs.next()){
				System.out.println(rs.getLong("INVOICE_NUMBER")+" | "+ rs.getString("CUSTOMER_NAME"));
			}

		} catch (SQLException e){
			e.printStackTrace();;
		}
		finally {
			try{
				if(connection != null) {
					connection.close();
				}
			}catch(SQLException e){
				e.printStackTrace();
			}
		}*/
	}

	@Bean
	public Hibernate5Module datatypeHibernateModule(){
		return  new Hibernate5Module();
	}

}
