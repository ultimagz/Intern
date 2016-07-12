package com.example.intern.intern;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class listViewAdapter extends BaseAdapter  implements Filterable {
    Context mContext;

    ArrayList<ContactData> orgList;
    ArrayList<ContactData> filter;
    ArrayList<ContactData> a;
    private ItemFilter mFilter = new ItemFilter();
    Map<String, Integer> mapIndex;

    public listViewAdapter(Context context, ArrayList<ContactData> strName) {
        this.mContext= context;
        this.orgList = new ArrayList<>(strName);
        //filter = new ArrayList<>(strName);
        filter = section(strName);
        //section(filter);
        getIndexList();
    }

    public int getCount() {
        return filter.size();
    }

    public ContactData getItem(int position) {
        return filter.get(position);
    }

    public long getItemId(int position) {
        return 0;
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater mInflater =
                (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View viewText;
        View viewHead;


           /* view = mInflater.inflate(R.layout.layout_row, parent, false);

        TextView textView = (TextView) view.findViewById(R.id.textView1);
        TextView headView = (TextView) view.findViewById(R.id.headText);
       *//* ImageView img = (ImageView) view.findViewById(R.id.imageView_round);*/

            viewText = mInflater.inflate(R.layout.layout_row, parent, false);
            viewHead = mInflater.inflate(R.layout.header_list, parent, false);

            TextView name = (TextView) viewText.findViewById(R.id.name);
            TextView job = (TextView) viewText.findViewById(R.id.position);
            TextView headView = (TextView) viewHead.findViewById(R.id.headText);


        ContactData dataAtPos = filter.get(position);
            if (dataAtPos.isHeader()) {
                headView.setText(dataAtPos.getValue());
                /*textView.setText(null);*/
                view = viewHead;
            } else {
                name.setText(dataAtPos.getFistName_EN()+"  ("+dataAtPos.getNickName_EN()+")");
                job.setText(dataAtPos.getPosition());
                headView.setText(null);
                view = viewText;
            }

        return view;


    }

    @Override
    public Filter getFilter() {

        return mFilter;
    }


    private class ItemFilter extends Filter {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {

            String filterString = constraint.toString().toLowerCase();

            FilterResults results = new FilterResults();

            int count = orgList.size();
            final ArrayList<ContactData> nlist = new ArrayList<ContactData>(count);

            String filterableString;
            for (ContactData data : orgList) {
                filterableString = data.getFistName_EN();
                Log.i("name",filterableString);

                if (filterableString.toLowerCase().contains(filterString)) {
                    nlist.add(data);
                }
            }

            a = section(nlist);
            getIndexList();
            results.values = a;
            results.count = a.size();

            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            filter.clear();
            filter = (ArrayList<ContactData>) results.values;
            notifyDataSetChanged();
        }
    }

    public ArrayList<ContactData> section(ArrayList<ContactData> strName) {
        //listDataContact = new ArrayList<>(Arrays.asList(strName));
        ContactData data;
        String nameData;
        String prev = "";
        ArrayList<ContactData> all = new ArrayList<>();
        //for (String name : strName) {
        for(int i=0 ; i<strName.size() ; i++){
            nameData = strName.get(i).getFistName_EN();
            String alpha = nameData.substring(0, 1).toUpperCase();
            if (!alpha.equalsIgnoreCase(prev)) {
                prev = alpha;
                all.add(new ContactData(alpha, true));
            }
            all.add(strName.get(i));
        }
        return all;
    }

    private void getIndexList() {
        mapIndex = new LinkedHashMap<String, Integer>();
        String[] alphabet = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

        for (String anAlphabet : alphabet) {
            // Log.e("size_content", contactData.size() + "");
            for (int j = 0; j < filter.size(); j++) {
                //Log.e("wrap_content", contactData.get(j).getValue());
                if (anAlphabet.equals(filter.get(j).getValue())) {
                    mapIndex.put(filter.get(j).getValue(), j);

                }

                if (mapIndex.get(anAlphabet) == null) {
                    mapIndex.put(anAlphabet, null);
                }
            }}
    }

    public int getMapIndex(String key) {
        return mapIndex.get(key);
    }



}