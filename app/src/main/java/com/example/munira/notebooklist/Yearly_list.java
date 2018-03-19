package com.example.munira.notebooklist;


import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


public class Yearly_list extends AppCompatActivity {

    /* step:1 Main page its initial create for object*/
    private EditText YearlyHeadInputET;
    private EditText YearlyAmountInputET;
    private ListView myYearlyWishList;
    private List<Item> YearlyWishList;
    FloatingActionButton floatYearlyListButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yearly_list);

        /* step:2 main page to activity.xml page connection and casting*/

        YearlyHeadInputET = (EditText) findViewById(R.id.yearly_title_input);
        YearlyAmountInputET = (EditText) findViewById(R.id.input_yearly_amount);
        myYearlyWishList = (ListView) findViewById(R.id.viewB_yearly_list);
        floatYearlyListButton = findViewById(R.id.fab_yearly_button);


        /*step:5 database declare collection of  data show by database*/
        final DatabaseHelper helper = new DatabaseHelper(getBaseContext());

        final List<Item> argentArrayList = helper.getAllData();
        final CustomAdapter adapter = new CustomAdapter(this, argentArrayList);

       /*step:6 adapter call*/
        myYearlyWishList.setAdapter(adapter);
        adapter.notifyDataSetChanged();



        /*get the ListView and attach the adapter*/
        ListView myYearlyWishList = (ListView) findViewById(R.id.viewB_yearly_list);
        myYearlyWishList.setAdapter(adapter);


        /* step:5 create array list*/
        final List<Item> ArgentArrayList = new ArrayList<Item>();

        myYearlyWishList.setAdapter(adapter);


        /*step:3 wish add button press*/
        floatYearlyListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               /*step:4 Validating form*/

                String inputTitle = YearlyHeadInputET.getText().toString();
                String inputAmount = YearlyAmountInputET.getText().toString();


                if (!YearlyHeadInputET.getText().toString().equals("") ||
                        !YearlyAmountInputET.getText().toString().equals("")) {


                    Date dateObj = Calendar.getInstance().getTime();

                    String yearlyTitle = YearlyHeadInputET.getText().toString();
                    String finalString = YearlyAmountInputET.getText().toString();
                    String dateString = "";

                    SimpleDateFormat curFormater = new SimpleDateFormat("dd/MM/yyyy  HH:mm:ss ");
                    try {
                        dateObj = curFormater.parse(dateString);

                    } catch (ParseException e) {
                        e.printStackTrace();
                    }


                    dateString = curFormater.format(dateObj);
                    Item item = new Item(0, yearlyTitle, finalString, dateString);
                    argentArrayList.add(item);

                /*step:14 collection of  data show by database*/
                    item.setWishString("Item:" + IncomeArrayList.size());
                    item.setWishString(YearlyHeadInputET.getText().toString());

                    item.setAmountInteger("Item:" + IncomeArrayList.size());
                    item.setAmountInteger(YearlyAmountInputET.getText().toString());

                    DatabaseHelper helper = new DatabaseHelper(getBaseContext());
                    helper.insertData(ArgentTitle, inputAmount, dateString);
                    IncomeArrayList.add(item);

                    /*new set data notification show*/
                    adapter.notifyDataSetChanged();

                    /*data set and clear*/
                    YearlyHeadInputET.setText("");
                    YearlyAmountInputET.setText("");

                    /* data type end and keyboard hide*/

                    InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    inputMethodManager.hideSoftInputFromWindow(YearlyHeadInputET.getWindowToken(), 0);
                    inputMethodManager.hideSoftInputFromWindow(YearlyAmountInputET.getWindowToken(), 0);

                    /*add and small notification sms show*/
                    Toast.makeText(getBaseContext(), "New Yearly Addad to List", Toast.LENGTH_SHORT).show();

                } else {

                    if (YearlyHeadInputET.getText().toString().equals("")) {

                        YearlyHeadInputET.setError("Title can't be empty !!!");
                    }

                    if (YearlyAmountInputET.getText().toString().equals("")) {

                        YearlyAmountInputET.setError("Yearly amount can't be empty !!!");
                    }


                }


            }


        });



                /*step:13 press on data and delete item */
        myArgentWishList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
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
