package com.example.sample;

import android.support.design.chip.Chip;
import android.support.design.chip.ChipGroup;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private ChipGroup mChipGrop;
    private TextView mSeeMore;

    //private String[] mDate = {"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Manoj"};

    private OnItemClick onItemClick = new OnItemClick() {
        @Override
        public void onItemClicked(String name) {
            Chip chip = new Chip(MainActivity.this);
            chip.setText(name);
            chip.setCloseIconEnabled(false);
            chip.setChipBackgroundColorResource(R.color.colorBackground);
            chip.setTextAppearanceResource(R.style.ChipTextStyle);
            mChipGrop.addView(chip);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mChipGrop = findViewById(R.id.chipgroup);
        mSeeMore = findViewById(R.id.tv_see_more);
        mSeeMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                android.support.v4.app.FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                android.support.v4.app.Fragment prev = getSupportFragmentManager().findFragmentByTag("dialog");
                if (prev != null) {
                    ft.remove(prev);
                }
                ft.addToBackStack(null);

                DialogFragment dialogFragment =  MyCustomDialogFragment.getInstance(onItemClick);
                dialogFragment.show(ft, "dialog");
            }
        });
//        for (String data : mDate) {
//            Chip chip = new Chip(this);
//            chip.setText(data);
//            chip.setCloseIconEnabled(false);
//            chip.setChipBackgroundColorResource(R.color.colorBackground);
//            chip.setTextAppearanceResource(R.style.ChipTextStyle);
//            mChipGrop.addView(chip);
//        }
    }

}


