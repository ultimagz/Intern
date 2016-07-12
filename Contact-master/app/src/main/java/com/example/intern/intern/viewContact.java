package com.example.intern.intern;

import android.content.Context;
import android.content.SearchRecentSuggestionsProvider;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.List;

public class viewContact extends AppCompatActivity {
    SQLiteDatabase mDb;
    DatabaseHelper mHelper;

    ContactData contact ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_contact);
        TextView name = (TextView) findViewById(R.id.name);
        TextView job = (TextView) findViewById(R.id.job);
        TextView phone = (TextView) findViewById(R.id.phoneNumber_1);
        TextView workPhone = (TextView) findViewById(R.id.phoneNumber_2);
        TextView mail = (TextView) findViewById(R.id.mail);
        TextView idLine = (TextView) findViewById(R.id.idLine);

        ImageView back = (ImageView)findViewById(R.id.backArrow);

        //contact = Parcels.unwrap();
        ContactData selectedData = Parcels.unwrap(getIntent().getParcelableExtra("selectedData"));

       // String id = getIntent().getExtras().getString("id");
        name.setText(selectedData.getFistName_EN()+" "+selectedData.getLastName_EN()+" ( "+ selectedData.getNickName_EN()+")");

        job.setText(selectedData.getPosition());
        phone.setText(selectedData.getMobile());
        workPhone.setText(selectedData.getWorkphone());
        mail.setText(selectedData.getEmail());
        idLine.setText(selectedData.getLine());








    }

    public void backPage(View v) {
        finish();
    }


}
