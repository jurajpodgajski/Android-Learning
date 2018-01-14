package juraj.podgajski.com.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

public class SecondFragment extends Fragment {

    private EditText etIme;

    public SecondFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View secondFragment = inflater.inflate(R.layout.fragment_second, container, false);

        etIme = (EditText) secondFragment.findViewById(R.id.etIme);

        etIme.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(getActivity(), etIme.getText().toString(), Toast.LENGTH_SHORT).show();
                return true;
            }
        });

        return secondFragment;
    }

}
