package com.example.sample;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MyCustomDialogFragment extends DialogFragment {
    private static  OnItemClick sOnItemClick;
    private String[] mDate = {"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Manoj"};

    public static MyCustomDialogFragment getInstance(OnItemClick onItemClick){
        sOnItemClick = onItemClick;
        return new MyCustomDialogFragment();
    }

    @Override
 public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
 }
 
 @Override
 public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_see_more_dialog, container, false);
     RecyclerView rvContacts = (RecyclerView) v.findViewById(R.id.rvContacts);
     ContactsAdapter adapter = new ContactsAdapter(this, mDate,sOnItemClick);
     rvContacts.setAdapter(adapter);
     rvContacts.setLayoutManager(new LinearLayoutManager(getActivity()));
        return v;
    } 
}