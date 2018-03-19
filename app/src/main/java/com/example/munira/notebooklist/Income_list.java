package com.example.munira.notebooklist;


import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


public class Income_list extends AppCompatActivity {

    /* step:1 Main page its initial create for object*/
    private EditText IncomeHeadInputET;
    private EditText IncomeAmountInputET;
    private ListView myIncomeWishList;
    private List<Item> IncomeWishList;
    FloatingActionButton floatIncomeListButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_income_list);

        /* step:2 main page to activity.xml page connection and casting*/

        IncomeHeadInputET = (EditText) findViewById(R.id.income_item_input);
        IncomeAmountInputET = (EditText) findViewById(R.id.input_amount_description);
        myIncomeWishList = (ListView) findViewById(R.id.viewB_income_list);
        floatIncomeListButton = findViewById(R.id.fab_income_button);


        /*step:5 database declare collection of  data show by database*/
        final DatabaseHelper helper = new DatabaseHelper(getBaseContext());

        final List<Item> incomeArrayList = helper.getAllData();
        final CustomAdapter adapter = new CustomAdapter(this, incomeArrayList);

       /*step:6 adapter call*/
        myIncomeWishList.setAdapter(adapter);
        adapter.notifyDataSetChanged();



        /*get the ListView and attach the adapter*/
        ListView myIncomeWishList = (ListView) findViewById(R.id.viewB_income_list);
        myIncomeWishList.setAdapter(adapter);


        /* step:5 create array list*/
        final List<Item> IncomeArrayList = new ArrayList<Item>();

        myIncomeWishList.setAdapter(adapter);


        /*step:3 wish add button press*/
        floatIncomeListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               /*step:4 Validating form*/

                String inputTitle = IncomeHeadInputET.getText().toString();
                String inputAmount = IncomeAmountInputET.getText().toString();


                if (!IncomeAmountInputET.getText().toString().equals("") ||
                        !IncomeHeadInputET.getText().toString().equals("")) {


                    Date dateObj = Calendar.getInstance().getTime();

                    String IncomeTitle = IncomeHeadInputET.getText().toString();
                    String finalString = IncomeAmountInputET.getText().toString();
                    String dateString = "";

                    SimpleDateFormat curFormater = new SimpleDateFormat("dd/MM/yyyy  HH:mm:ss ");
                    try {
                        dateObj = curFormater.parse(dateString);

                    } catch (ParseException e) {
                        e.printStackTrace();
                    }


                    dateString = curFormater.format(dateObj);
                    Item item = new Item(0, IncomeTitle, finalString, dateString);
                    incomeArrayList.add(item);

                /*step:14 collection of  data show by database*/
                    item.setWishString("Item:" + IncomeArrayList.size());
                    item.setWishString(IncomeHeadInputET.getText().toString());

                    item.setAmountInteger("Item:" + IncomeArrayList.size());
                    item.setAmountInteger(IncomeAmountInputET.getText().toString());

                    DatabaseHelper helper = new DatabaseHelper(getBaseContext());
                    helper.insertData(IncomeTitle, inputAmount, dateString);
                    IncomeArrayList.add(item);

                    /*new set data notification show*/
                    adapter.notifyDataSetChanged();

                    /*data set and clear*/
                    IncomeHeadInputET.setText("");
                    IncomeAmountInputET.setText("");

                    /* data type end and keyboard hide*/

                    InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    inputMethodManager.hideSoftInputFromWindow(IncomeHeadInputET.getWindowToken(), 0);
                    inputMethodManager.hideSoftInputFromWindow(IncomeAmountInputET.getWindowToken(), 0);

                    /*add and small notification sms show*/
                    Toast.makeText(getBaseContext(), "New Income Addad to List", Toast.LENGTH_SHORT).show();

                } else {

                    if (IncomeHeadInputET.getText().toString().equals("")) {

                        IncomeHeadInputET.setError("Title can't be empty !!!");
                    }

                    if (IncomeAmountInputET.getText().toString().equals("")) {

                        IncomeAmountInputET.setError("Income amount can't be empty !!!");
                    }


                }


            }


        });



                /*step:13 press on data and delete item */
        myIncomeWishList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                //Database data
                DatabaseHelper helper = new DatabaseHelper(getBaseContext());

                /*data delete */

                helper.deleteData(incomeArrayList.get(position).getWishId());
                incomeArrayList.remove(position);
                adapter.notifyDataSetChanged();

                /*adapterChanged();*/
                Toast.makeText(getBaseContext(), "One Item Remove", Toast.LENGTH_SHORT).show();

                return false;
            }
        });


    }


}
