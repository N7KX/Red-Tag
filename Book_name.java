package SQL_Connector;

import java.sql.Connection;

import java.sql.ResultSet;

import java.sql.Statement;

public class load_bookname 
{
    public static String book_data_load(int ID)
    {
        Connection connection = Connector.connection();
        
        String SQL = "SELECT * FROM BOOKS WHERE BOOK_ID = "+ID+" ";
        
        String message = "SELECTED BOOK IS'T UNDER YOUR ACCOUNT";
        
        try
        {
            Statement stmt = connection.createStatement();
            
            ResultSet rs = stmt.executeQuery(SQL);
            
            while(rs.next())
            {
                String book_name = rs.getString("TITLE_OF_BOOK");
                
                message = book_name;
            }
        }
        catch(Exception ERROR)
        {
            message = "SELECTED BOOK IS'T UNDER YOUR ACCOUNT";
        }
        
        return message;
    }    
}