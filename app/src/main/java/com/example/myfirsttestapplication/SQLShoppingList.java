package com.example.myfirsttestapplication;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedHashMap;
import java.util.Map;

public class SQLShoppingList extends AppCompatActivity {

    SQLItemAdapter itemAdapter;
    Context thisContext;
    ListView myListView;
    TextView progressTextView;
    Map<String, Double> fruitMap = new LinkedHashMap<String, Double>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlshopping_list);

        myListView = (ListView) findViewById(R.id.mySQLListView);
        progressTextView = (TextView) findViewById(R.id.progressTextView);
        thisContext = this;

        progressTextView.setText("");
        Button getDataButton = (Button) findViewById(R.id.getDataButton);
        getDataButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GetData retrieveData = new GetData();
                retrieveData.execute("");
            }
        });
    }

    private class GetData extends AsyncTask<String, String, String>{

        String message = "";
        // JDBC Driver Name and Database URL
        static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";

        static final String DB_URL = "jdbc:mysql://" +
                DBStrings.DATABASE_URL + "/" +
                DBStrings.DATABASE_NAME;

        @Override
        protected void onPreExecute(){
            progressTextView.setText("Connecting to Database...");
        }

        @Override
        protected String doInBackground(String... strings) {

            Connection connection = null;
            Statement statement = null;

            try{
                Class.forName(JDBC_DRIVER);
                connection = DriverManager.getConnection(DB_URL, DBStrings.USERNAME, DBStrings.PASSWORD);
                statement = connection.createStatement();

                String sql = "SELECT * FROM Fruits";

                ResultSet rs = statement.executeQuery(sql);

                while (rs.next()){
                    String name = rs.getString("FruitName");
                    Double price = rs.getDouble("Price");

                    fruitMap.put(name, price);
                }

                message = "Process complete.";
                progressTextView.setText(message);
                rs.close();
                statement.close();
                connection.close();
            }

            catch(SQLException connError){
                message = "An Exception was thrown for JDBC";
                progressTextView.setText("Sorry, an error occurred.");
                connError.printStackTrace();
            }

            catch (ClassNotFoundException e) {
                e.printStackTrace();
                message = "A Class not Found Exception was thrown";
                progressTextView.setText("Sorry, an error occurred.");
            }

            // finally block to close open ressources in case exception is thrown.
            finally {
                try {
                    if (statement != null) {
                        statement.close();
                    }

                } catch (SQLException e) {
                    e.printStackTrace();
                }
                try {
                    if (connection != null) {
                        connection.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            return null;
        }

        @Override
        public void onPostExecute(String message){
            progressTextView.setText(this.message);

            if(fruitMap.size()>0){
                itemAdapter = new SQLItemAdapter(thisContext, fruitMap);
                myListView.setAdapter(itemAdapter);

            }
        }
    }

    // DNC end of class
}
