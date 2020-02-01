package com.example.sample;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ContactsAdapter extends
    RecyclerView.Adapter<ContactsAdapter.ViewHolder> {
    private static OnItemClick sItemClickListener;
    private String[] mList;
    private MyCustomDialogFragment mDialog;
    public ContactsAdapter(MyCustomDialogFragment myCustomDialogFragment, String[] mDate, OnItemClick sOnItemClick) {
        mList = mDate;
        sItemClickListener = sOnItemClick;
        mDialog = myCustomDialogFragment;
    }
    @Override
    public ContactsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View contactView = inflater.inflate(R.layout.list_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ContactsAdapter.ViewHolder viewHolder, int position) {
        TextView textView = viewHolder.nameTextView;
        textView.setText(mList[position]);
    }

    @Override
    public int getItemCount() {
        return mList.length;
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView nameTextView;
        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            nameTextView = (TextView) itemView.findViewById(R.id.person_name);
        }
        @Override
        public void onClick(View view) {
            int position = getAdapterPosition(); // gets item position
            if (position != RecyclerView.NO_POSITION) { // Check if an item was deleted, but the user clicked it before the UI removed it
                sItemClickListener.onItemClicked(mList[position]);
                mDialog.dismiss();
            }
        }
    }
}