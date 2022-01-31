package com.mycompany.invoise.core.entity.repository.database;

import com.mycompany.invoise.core.entity.Invoice;
import com.mycompany.invoise.core.entity.repository.InvoiceRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.security.Key;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

@Repository
public class InvoiceRepositoryDatabase implements InvoiceRepositoryInterface {
    @Autowired
    private JdbcTemplate jdbcTemplate;


    public Invoice create(Invoice invoice){
        KeyHolder kh  =  new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement preparedStatement =  connection.prepareStatement("INSERT INTO INVOICE (CUSTOMER_NAME, ORDER_NUMBER) VALUES (?, ?)",
                    Statement.RETURN_GENERATED_KEYS);
                    preparedStatement.setString(1,invoice.getCustomerName());
                    preparedStatement.setString(2,invoice.getOrderNumber());

                    return  preparedStatement;
        },kh);
    invoice.setNumber( kh.getKey().toString());
    return  invoice;
    }

    @Override
    public List<Invoice> list() {
     return  jdbcTemplate.query("SELECT  INVOICE_NUMBER, CUSTOMER_NAME FROM INVOICE",
             (rs, rowNum) -> new Invoice(String.valueOf( rs .getLong("INVOICE_NUMBER")) ,rs.getString("CUSTOMER_NAME")));
    }
  @Override
    public Invoice getById(String number) {
        String sql= "SELECT  INVOICE_NUMBER, CUSTOMER_NAME, ORDER_NUMBER  FROM INVOICE WHERE INVOICE_ NUMBER=";
       return  jdbcTemplate.queryForObject( sql,

               new Object []{number},
               (rs, rowNum) -> new Invoice(String.valueOf( rs .getLong("INVOICE_NUMBER")) ,
                       rs.getString("CUSTOMER_NAME"), rs.getString("ORDER_NUMBER")  ) );
    }


}
