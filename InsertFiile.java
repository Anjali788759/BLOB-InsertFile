package SaveFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertFiile {
    public static void main(String[] args) {
        Connection con;
        PreparedStatement pstmt;
        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1ejm10","root","");
            pstmt=con.prepareStatement("insert into temp values(?,?)");
            pstmt.setInt(1,1);
            File file=new File("C:\\Users\\kamla\\Desktop\\demo1.jpg");

            try {
                FileInputStream fin=new FileInputStream(file);
              pstmt.setBlob(2,fin);
           int count =pstmt.executeUpdate();
                System.out.println(count+"data inserted");
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
