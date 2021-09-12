package com.example.tp_3.ui.micuenta;

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

import com.example.tp_3.databinding.FragmentMiCuentaBinding;

public class MiCuentaFragment extends Fragment {

    private MiCuentaViewModel miCuentaViewModel;
    private FragmentMiCuentaBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        miCuentaViewModel =
                new ViewModelProvider(this).get(MiCuentaViewModel.class);

        binding = FragmentMiCuentaBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.txtMicuenta;
        miCuentaViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
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