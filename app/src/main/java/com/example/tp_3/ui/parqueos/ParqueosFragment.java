package com.example.tp_3.ui.parqueos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.tp_3.databinding.FragmentParqueosBinding;

public class ParqueosFragment extends Fragment {

    private ParqueosViewModel parqueosViewModel;
    private FragmentParqueosBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        parqueosViewModel =
                new ViewModelProvider(this).get(ParqueosViewModel.class);

        binding = FragmentParqueosBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.txtParqueos;
        parqueosViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}