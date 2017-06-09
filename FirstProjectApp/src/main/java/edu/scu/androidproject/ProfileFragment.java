package edu.scu.androidproject;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {
    String stringValue = null;

    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        Bundle bundle = getArguments();

        if(bundle != null){
            List<String> result = new ArrayList<>();
            stringValue = (String) bundle.getString("user_email");
            DbHelper db = new DbHelper(getActivity());
            result = db.Select(stringValue);
            String str = result.get(0);
            String str2 = result.get(1);
            String str3 = result.get(2);
            String str4 = result.get(3);

            Toast.makeText(getActivity(), str4 ,Toast.LENGTH_LONG).show();
            // String myString = bundle.containsKey("user_email") ? bundle.getString("user_email") : "hi, cannot find me";
         //   TextView myAwesomeTextView = (TextView)getActivity().findViewById(R.id.textView2);
         //   myAwesomeTextView.setText(stringValue);
        }

    }
}
