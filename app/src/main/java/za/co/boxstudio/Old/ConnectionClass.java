package za.co.boxstudio.Old;

import android.app.Activity;
import android.os.StrictMode;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionClass {

    String ip = "local";
    String Classs = "";
    String db = "boxstudio";
    String un = "TAFADZWA-PC";
    String pwd = "";

    public Connection con(){
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        Connection conn = null;
        String ConnURL = null;
        try{
            Class.forName(Classs);
            ConnURL = "jdbc:jtds:sqlserver://" + ip + ";" + "databaseName" + db + ";user=" + un + ";pwd=" + pwd + ";";
            conn = DriverManager.getConnection(ConnURL);

        } catch (SQLException se) {
            Log.e("Error", se.getMessage());
        } catch (ClassNotFoundException e) {
            Log.e("Error", e.getMessage());
        }catch(Exception e){
            Log.e("Error", e.getMessage());
        }
        return conn;
    }
}
