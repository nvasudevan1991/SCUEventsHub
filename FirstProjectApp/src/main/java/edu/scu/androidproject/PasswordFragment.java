package edu.scu.androidproject;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class PasswordFragment extends Fragment {
    String stringValue = null;

    public PasswordFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_password, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        Bundle bundle = getArguments();
        if(bundle != null) {
            stringValue = (String) bundle.getString("user_email");
            //Toast.makeText(getActivity(), stringValue, Toast.LENGTH_SHORT).show();
        }
        Button reset =(Button)getActivity().findViewById(R.id.changereset);
        Button confirm =(Button)getActivity().findViewById(R.id.changeconfirm);
        final EditText current =(EditText)getActivity().findViewById(R.id.currentpassword);
        final EditText newpassword =(EditText)getActivity().findViewById(R.id.newpassword);
        final EditText confirmpassword =(EditText)getActivity().findViewById(R.id.confirmpassword);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getActivity().getApplication(),"Reset Button",Toast.LENGTH_LONG).show();
                current.setText(null);
                newpassword.setText(null);
                confirmpassword.setText(null);
            }
        });
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity().getApplication(),"Password Changed", Toast.LENGTH_LONG).show();
                List<String> result = new ArrayList<>();
                String newpassword1=newpassword.getText().toString();
                DbHelper dbHelper =new DbHelper(getActivity());
                //result = dbHelper.Select(stringValue);

                    dbHelper.changePassword(stringValue,newpassword1);


            }
        });


    }
}