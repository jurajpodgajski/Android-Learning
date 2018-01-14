package juraj.podgajski.com.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import juraj.podgajski.com.fragments.R;

public class FirstFragment extends Fragment {

    private EditText etUnos;
    private Button bHello;

    public FirstFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View firstFragment = inflater.inflate(R.layout.fragment_first, container, false);

        etUnos = (EditText) firstFragment.findViewById(R.id.etUnos);
        bHello = (Button) firstFragment.findViewById(R.id.bHello);

        bHello.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Hello from fragment", Toast.LENGTH_SHORT).show();
            }
        });

        return firstFragment;
    }

}
