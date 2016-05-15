package com.example.dieuvainmusaghi.viuc.fragment;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.dieuvainmusaghi.viuc.R;
import com.example.dieuvainmusaghi.viuc.model.User;
import com.example.dieuvainmusaghi.viuc.utils.Config;
import com.firebase.client.Firebase;
import com.firebase.ui.FirebaseListAdapter;

/**
 * Created by Mich3lo on 5/11/16.
 */
public class ListUserFragment extends ListFragment{

    private Firebase mFireBaseRef; // Firebase reference
    FirebaseListAdapter<User> mListAdapter;

    public ListUserFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        Firebase.setAndroidContext(getActivity());

        mFireBaseRef=new Firebase(Config.FIREBASE_URL).child(Config.USSD_STRING);

        ViewGroup rootView=(ViewGroup)inflater.inflate(R.layout.fragmentlistuser,container,false);

        final EditText textUsern = (EditText) rootView.findViewById(R.id.text_usern);
        final EditText textPswd = (EditText) rootView.findViewById(R.id.text_pswd);
        final EditText textPhone=(EditText) rootView.findViewById(R.id.text_phonen);
        final EditText textSecret=(EditText)rootView.findViewById(R.id.text_secreth);


        Button sendButton = (Button) rootView.findViewById(R.id.send_button);

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username=textUsern.getText().toString();
                String pasword = textPswd.getText().toString();
                String phoneu=textPhone.getText().toString();
                String secreth=textSecret.getText().toString();

                /*
                // This method is used in case we have not a class model
                Map<String,Object> values=new HashMap<>();
                values.put("name","Code USSD");
                values.put("text",text);
                */

                User theuser = new User(username, pasword,phoneu,secreth);
                mFireBaseRef.push().setValue(theuser);
                textUsern.setText((""));
                textPswd.setText((""));
                textPhone.setText((""));
                textSecret.setText((""));
            }
        });

        mListAdapter = new FirebaseListAdapter<User>(getActivity(), User.class, android.R.layout.two_line_list_item, mFireBaseRef) {
            @Override
            protected void populateView(View v, User model) {
                ((TextView) v.findViewById(android.R.id.text1)).setText(model.getUserName());
                ((TextView) v.findViewById(android.R.id.text2)).setText(model.getPassword());
                ((TextView) v.findViewById(android.R.id.text1)).setText(model.getPhoneNumber());
                ((TextView) v.findViewById(android.R.id.text2)).setText(model.getSecretHint());
            }
        };
        setListAdapter(mListAdapter);

        setRetainInstance(true);
        return rootView;

    }




}
