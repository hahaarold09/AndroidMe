package com.hyperdev.androidme.activities;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.hyperdev.androidme.R;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class BodyPartsFragments extends Fragment {


    private List<Integer> NumParts;
    private int mPosition;
    private static final String PARTS_LIST = "parts_list";
    private static final String PARTS_NUMBER = "parts_number";

    public BodyPartsFragments() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        if (savedInstanceState != null) {
            NumParts = savedInstanceState.getIntegerArrayList(PARTS_LIST);
            mPosition = savedInstanceState.getInt(PARTS_NUMBER);
        }
        View rootView = inflater.inflate(R.layout.fragment_body_parts_fragments, container, false);

        final ImageView imageView = (ImageView) rootView.findViewById(R.id.imageFrag);
        if (NumParts != null) {
            imageView.setImageResource(NumParts.get(mPosition));

            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mPosition < NumParts.size() - 1) {
                        mPosition++;
                    } else {
                        mPosition = 0;
                    }
                    imageView.setImageResource(NumParts.get(mPosition));
                }
            });
        }
        return rootView;
    }


    public void setPartList(List<Integer> partList) {

        this.NumParts = partList;
    }

    public void setListPosition(int mListPosition) {

        this.mPosition = mListPosition;
    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putIntegerArrayList(PARTS_LIST, (ArrayList<Integer>) NumParts);
        outState.putInt(PARTS_NUMBER, mPosition);
    }
}