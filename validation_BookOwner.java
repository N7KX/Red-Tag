package SQL_Connector;

import java.sql.Connection;

import java.sql.ResultSet;

import java.sql.Statement;

public class Validation_Bookowner 
{
    public static int book_data_load(int ID,int UID)
    {
        Connection connection = Connector.connection();
        
        String SQL = "SELECT * FROM LEND_TABLE WHERE BOOK_ID = "+ID+" AND USER_ID = "+UID+";";
        
        int value = 0;
        
        try
        {
            Statement stmt = connection.createStatement();
            
            ResultSet rs = stmt.executeQuery(SQL);
            
            if(!rs.next())
            {
                value = 0;
            }
            else
            {
                value = 1;
            }
        }
        catch(Exception ERROR)
        {
            
        }
        
        return value;
    }  

    
}