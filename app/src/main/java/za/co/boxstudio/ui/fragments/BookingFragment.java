package za.co.boxstudio.ui.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import za.co.boxstudio.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class BookingFragment extends Fragment {


    public BookingFragment() {
        // Required empty public constructor
    }

    private static final String ARG_POSITION = "position";

    public static BookingFragment newInstance(int position) {
        BookingFragment f = new BookingFragment();
        Bundle b = new Bundle();
        b.putInt(ARG_POSITION, position);
        f.setArguments(b);

        return f;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_booking, container, false);
    }

}
