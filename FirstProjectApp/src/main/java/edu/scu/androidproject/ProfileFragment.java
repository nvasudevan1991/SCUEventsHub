package edu.scu.androidproject;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


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
            stringValue = (String) bundle.getString("user_email");
            // String myString = bundle.containsKey("user_email") ? bundle.getString("user_email") : "hi, cannot find me";
            TextView myAwesomeTextView = (TextView)getActivity().findViewById(R.id.textView2);
         //   myAwesomeTextView.setText(stringValue);
        }

    }
}
