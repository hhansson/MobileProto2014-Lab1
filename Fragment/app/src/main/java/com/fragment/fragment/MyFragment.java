package com.fragment.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by user on 9/11/14.
 */
public class MyFragment extends Fragment {

    public MyFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_frag, container, false);
        final Button myButton = (Button) rootView.findViewById(R.id.new_but);
        final TextView textView = (TextView) rootView.findViewById(R.id.hello_world);
        final ListView myListView = (ListView) rootView.findViewById(R.id.my_list_view);
        final EditText editText = (EditText) rootView.findViewById(R.id.add_text);
        final ArrayList<String> allStrings = new ArrayList<String>();

        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(R.string.hello_world);
                String newText = editText.getText().toString();
                if (!newText.equals("")){
                    allStrings.add(newText);
                    editText.setText("");
                    myListView.setAdapter(new ChatAdapter(getActivity(), R.layout.chat_item, allStrings));
                }
            }
        });

        myListView.setAdapter(new ChatAdapter(getActivity(), R.layout.chat_item, allStrings));
        return rootView;
    }

    public void clearText(){
        final ListView myListView = (ListView) getView().findViewById(R.id.my_list_view);
        final ArrayList<String> allStrings = new ArrayList<String>();
        myListView.setAdapter(new ChatAdapter(getActivity(), R.layout.chat_item, allStrings));
    }
}
