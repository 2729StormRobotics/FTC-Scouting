package fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import storm.ftc.stormradar.R;

public class SubmitFragment extends Fragment {
    public static View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Get the view from fragmenttab1.xml
        view = inflater.inflate(R.layout.submit_fragment, container, false);
        return view;
    }


}
