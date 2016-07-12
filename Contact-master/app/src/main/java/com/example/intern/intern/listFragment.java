package com.example.intern.intern;


import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;

import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import org.parceler.Parcels;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import java.util.zip.Inflater;

import java.util.concurrent.ExecutionException;

public class listFragment extends Fragment implements View.OnClickListener {


    ArrayList<ContactData> contactData;
    Map<String, Integer> mapIndex;
    ListView listView;
    View rootView;
    EditText search;
    listViewAdapter adapter;
    String[] alphabet = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    listViewAdapter click;


    DatabaseHelper mHelper;
    SQLiteDatabase mDb;


    List<ContactData> listDataContact = new ArrayList<>();


    public listFragment() {
        // Required empty public constructor
    }

    /*public ArrayList<ContactData> section(List<ContactData> strName) {
        listDataContact = strName;

        ContactData data;

        String prev = "";
        ArrayList<ContactData> contactDataList = new ArrayList<>();


        for (ContactData contact : strName) {
            String name = contact.getFistName_EN();
            String alpha = name.substring(0, 1).toUpperCase();

            if (!alpha.equalsIgnoreCase(prev)) {
                prev = alpha;
                Parcelable wrapped = Parcels.wrap(contact);

                contactDataList.add(new ContactData(alpha, true));


            }

            //contactDataList.add(new ContactData(alpha, false,name));
            data = contact;
            contactDataList.add(contact);


        }


       *//* Iterator itr = hSetData.iterator();
        while(itr.hasNext()) {
            listDataContact.add((String) itr.next());
        }
        Collections.sort(listDataContact);
*//*


        return contactDataList;
    }*/


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

//
//                String url = "http://192.168.86.97:3030/api/user/list";
//
//
//
//            OkHttpHandler handler = new OkHttpHandler();
//            String result = null;
//            try {
//                result = handler.execute(url).get();
//            } catch (InterruptedException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            } catch (ExecutionException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            }
//
//        Log.e("Str",result);


        String result = "[{\"_id\":\"5774cf8e6c3612b13394eb32\",\"th_fname\":\"พิษณุ\",\"th_lname\":\"กิตติพิทยากร\",\"th_nickname\":\"ก้อง\",\"en_fname\":\"Pitsanu\",\"en_lname\":\"Kittipittayakorn\",\"en_nickname\":\"Gong\",\"position\":\"Android Dev.\",\"email\":\"pitsanu.k@appman.co.th\",\"mobile\":\"0830639432\",\"workphone\":null,\"line\":\"gz.tar.gz\",\"avatar\":\"/images/avatar/94b0471d0560ff3bbd05e64f7ee2b5c1\",\"update\":\"2016-06-30T07:51:42.806Z\"},{\"_id\":\"5774cf8e6c3612b13394eb30\",\"th_fname\":\"ณัฐนลิน\",\"th_lname\":\"สมไพบูลย์\",\"th_nickname\":\"แจน\",\"en_fname\":\"Natnalin\",\"en_lname\":\"Sompaiboon\",\"en_nickname\":\"Jan\",\"position\":\"Graphic Designer\",\"email\":\"natnalin.s@appman.co.th\",\"mobile\":\"0826848947\",\"workphone\":null,\"line\":\"_whitesmile_\",\"update\":\"2016-06-30T07:51:42.806Z\"},{\"_id\":\"5774cf8e6c3612b13394eb33\",\"th_fname\":\"กิตติพงศ์\",\"th_lname\":\"ปานแย้ม\",\"th_nickname\":\"หนึ่ง\",\"en_fname\":\"Kittipong\",\"en_lname\":\"Panyaem\",\"en_nickname\":\"Nueng\",\"position\":\"Senior Graphic Designer\",\"email\":\"kittipong.p@appman.co.th\",\"mobile\":\"0953843896\",\"workphone\":null,\"line\":\"ndsign\",\"update\":\"2016-06-30T07:51:42.806Z\"},{\"_id\":\"5774cf8e6c3612b13394eb31\",\"th_fname\":\"อานันท์\",\"th_lname\":\"สุระเรืองชัย\",\"th_nickname\":\"อาร์ม\",\"en_fname\":\"Anand\",\"en_lname\":\"Suraruangchai\",\"en_nickname\":\"Arm\",\"position\":\"Frontend Developer\",\"email\":\"anand.s@appman.co.th\",\"mobile\":\"0865994491\",\"workphone\":null,\"line\":\"arm.kungs\",\"update\":\"2016-06-30T07:51:42.806Z\"},{\"_id\":\"5774cf8e6c3612b13394eb2f\",\"th_fname\":\"ชมนภา \",\"th_lname\":\"เรืองวัฒนา\",\"th_nickname\":\"ปุ๊ก\",\"en_fname\":\"Chomnapha\",\"en_lname\":\"Ruengwattana\",\"en_nickname\":\"pook\",\"position\":\"Graphic designer\",\"email\":\"chomnapha.r@appman.co.th\",\"mobile\":\"0818654587\",\"workphone\":null,\"line\":\"boopbippookpik\",\"update\":\"2016-06-30T07:51:42.806Z\"},{\"_id\":\"5774cf8e6c3612b13394eb34\",\"th_fname\":\"ณัฐพล\",\"th_lname\":\"คงกิติมานนท์\",\"th_nickname\":\"นัท\",\"en_fname\":\"Nuttapon\",\"en_lname\":\"Kongkitimanon\",\"en_nickname\":\"Nut\",\"position\":\"\",\"email\":\"nuttapon.k@appman.co.th\",\"mobile\":\"0904029856\",\"workphone\":null,\"line\":\"nutkong\",\"update\":\"2016-06-30T07:51:42.806Z\"},{\"_id\":\"5774cf8e6c3612b13394eb35\",\"th_fname\":\"สุริยา\",\"th_lname\":\"เกิดสำราญ\",\"th_nickname\":\"ยา\",\"en_fname\":\"Suriya\",\"en_lname\":\"Kerdsamran\",\"en_nickname\":\"Ya\",\"position\":\"Backend Developer\",\"email\":\"suriya.k@appman.co.th\",\"mobile\":\"0861764290\",\"workphone\":null,\"line\":\"kerd3ran\",\"update\":\"2016-06-30T07:51:42.806Z\"}]";


        ContactData data = new ContactData();

        Gson gson = new GsonBuilder().serializeNulls().create();
        String json = gson.toJson(data);
        Type listType = new TypeToken<List<ContactData>>() {
        }.getType();
        List<ContactData> ls = new Gson().fromJson(result, listType);

        checkDatabase();
        mHelper = new DatabaseHelper(getActivity());

        mDb = mHelper.getWritableDatabase();

        Cursor mCursor = mDb.rawQuery("SELECT * FROM " + DatabaseHelper.DBTABLE, null);

        if (mCursor.getCount() == 0) {
            for (ContactData a : ls) {

                mDb.execSQL("INSERT INTO " + DatabaseHelper.DBTABLE + " ("
                        + DatabaseHelper.contactID + ", " + DatabaseHelper.th_fname
                        + ", " + DatabaseHelper.th_lname
                        + ", " + DatabaseHelper.th_nickname
                        + ", " + DatabaseHelper.en_fname
                        + ", " + DatabaseHelper.en_lname
                        + ", " + DatabaseHelper.en_nickname
                        + ", " + DatabaseHelper.position
                        + ", " + DatabaseHelper.email
                        + ", " + DatabaseHelper.mobile
                        + ", " + DatabaseHelper.workphone
                        + ", " + DatabaseHelper.line
                        + ", " + DatabaseHelper.updateTime
                        + ") VALUES ('" + a.get_id()
                        + "', '" + a.getFistName_TH()
                        + "', '" + a.getLastName_TH()
                        + "', '" + a.getNickName_TH()
                        + "', '" + a.getFistName_EN()
                        + "', '" + a.getLastName_EN()
                        + "', '" + a.getNickName_EN()
                        + "', '" + a.getPosition()
                        + "', '" + a.getEmail()
                        + "', '" + a.getMobile()
                        + "', '" + a.getWorkphone()
                        + "', '" + a.getLine()
                        + "', '" + a.getUpdateTime()
                        + "');");

            }
            Log.e("suss", "full");


        } else {
            Log.e("suss", "yes");
        }


        ArrayList<ContactData> listName = selectName();

        //contactData = section(listName);
        Log.i("contactData",contactData+"");
        rootView = inflater.inflate(R.layout.fragment_list, container, false);
        adapter = new listViewAdapter(getActivity(), listName);
        listView = (ListView) rootView.findViewById(R.id.listView);
        listView.setAdapter(adapter);
        search = (EditText)rootView.findViewById(R.id.search);


//        getIndexList();
        displayIndex();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {

                Intent goContactView = new Intent(getActivity() , viewContact.class);
                Log.i("click",position+"");
                ContactData selectedData = adapter.getItem(position);
                Parcelable wrapped = Parcels.wrap(selectedData);
                goContactView.putExtra("selectedData", wrapped);
                startActivity(goContactView);
            }
        });


        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                adapter.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        return rootView;
    }

    public ArrayList<ContactData> selectName() {

        ArrayList<String> list = new ArrayList<>();
        mHelper = new DatabaseHelper(getActivity());

        mDb = mHelper.getReadableDatabase();
        ContactData contact = new ContactData();
        ArrayList<ContactData> contactList = new ArrayList<>();


        Cursor mCursor = mDb.query(DatabaseHelper.DBTABLE, new String[]{"_id", "fistName_TH", "lastName_TH",
                "nickName_TH", "fistName_EN", "lastName_EN", "nickName_EN", "position", "email",
                "mobile", "workphone", "line"}, null, null, null, null, "fistName_EN ASC");


        mCursor.moveToFirst();


        while (!mCursor.isAfterLast()) {
            //contact = new ContactData(mCursor.getString(0), mCursor.getString(1), mCursor.getString(2), mCursor.getString(3), mCursor.getString(4), mCursor.getString(5), mCursor.getString(mCursor.getColumnIndex()), mCursor.getString(7), mCursor.getString(8), mCursor.getString(9), mCursor.getString(10), mCursor.getString(11));
            contact = new ContactData();
            contact.set_id(mCursor.getString(mCursor.getColumnIndexOrThrow(DatabaseHelper.contactID)));
            contact.setFistName_TH(mCursor.getString(mCursor.getColumnIndex(DatabaseHelper.th_fname)));
            contact.setLastName_TH(mCursor.getString(mCursor.getColumnIndex(DatabaseHelper.th_lname)));
            contact.setNickName_TH(mCursor.getString(mCursor.getColumnIndex(DatabaseHelper.th_nickname)));
            contact.setFistName_EN(mCursor.getString(mCursor.getColumnIndex(DatabaseHelper.en_fname)));
            contact.setLastName_EN(mCursor.getString(mCursor.getColumnIndex(DatabaseHelper.en_lname)));
            contact.setNickName_EN(mCursor.getString(mCursor.getColumnIndex(DatabaseHelper.en_nickname)));
            contact.setPosition(mCursor.getString(mCursor.getColumnIndex(DatabaseHelper.position)));
            contact.setEmail(mCursor.getString(mCursor.getColumnIndex(DatabaseHelper.email)));
            contact.setMobile(mCursor.getString(mCursor.getColumnIndex(DatabaseHelper.mobile)));
            contact.setWorkphone(mCursor.getString(mCursor.getColumnIndex(DatabaseHelper.workphone)));
            contact.setLine(mCursor.getString(mCursor.getColumnIndex(DatabaseHelper.line)));





            contactList.add(contact);
            mCursor.moveToNext();

            //Parcelable wrapped = Parcels.wrap(contact);

        }






        mCursor.close();





        return contactList;
    }


    public void checkDatabase() {
        String url = "/data/data/" + "com.example.intern.intern" + "/databases/DB_Contact";
        File f = new File(url);
        if (!f.exists()) {
            try {
                mHelper = new DatabaseHelper(getActivity());
                mDb = mHelper.getWritableDatabase();
                mDb.close();
                mHelper.close();
                InputStream in = getActivity().openFileInput("DB_Contact");
                OutputStream out = new FileOutputStream(url);
                byte[] buffer = new byte[in.available()];
                in.read(buffer);
                out.write(buffer, 0, buffer.length);
                in.close();
                out.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

   /* private void getIndexList() {
        mapIndex = new LinkedHashMap<String, Integer>();

        for (String anAlphabet : alphabet) {
           // Log.e("size_content", contactData.size() + "");
            for (int j = 0; j < contactData.size(); j++) {
                //Log.e("wrap_content", contactData.get(j).getValue());
                if (anAlphabet.equals(contactData.get(j).getValue())) {
                    mapIndex.put(contactData.get(j).getValue(), j);

                }

                if (mapIndex.get(anAlphabet) == null) {
                    mapIndex.put(anAlphabet, null);
                }
            }}
    }
*/
    private void displayIndex() {
        LinearLayout indexLayout = (LinearLayout) rootView.findViewById(R.id.side_index);
        TextView textView;
        List<String> indexList = new ArrayList<String>(Arrays.asList(alphabet));
        for (String index : indexList) {
            textView = (TextView) getActivity().getLayoutInflater().inflate(
                    R.layout.side_index_item, null);
            textView.setText(index);
            textView.setOnClickListener(this);
            indexLayout.addView(textView);
        }
    }

    public void onClick(View view) {
        TextView textView = (TextView) view;
        String key = textView.getText().toString();
        //if (mapIndex.get(selectedIndex.getText()) != null) {
            listView.setSelection(adapter.getMapIndex(key));
       // }
        //listView.mapIndex.get(selectedIndex.getText());

        //Log.i("Pang", mapIndex.get(selectedIndex.getText()) + "");
        //Log.i("Pang",mapIndex.get(selectedIndex.getText())+"");
    }


    public boolean onCreateOptionsMenu(Menu menu) {
        getActivity().getMenuInflater().inflate(R.menu.menu_tab, menu);
        return true;
    }


}





