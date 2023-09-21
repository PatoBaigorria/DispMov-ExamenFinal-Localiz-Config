package com.patriciasoft.examen.ui.lugaresTuristicos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.patriciasoft.examen.R;
import com.patriciasoft.examen.databinding.FragmentGalleryBinding;
import com.patriciasoft.examen.ui.mapas.HomeViewModel;

import java.util.ArrayList;
import java.util.List;

public class GalleryFragment extends Fragment {
    private GalleryViewModel vm;

    private FragmentGalleryBinding binding;

    private LugaresAdapter adapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        vm = new ViewModelProvider(this).get(GalleryViewModel.class);
        binding = FragmentGalleryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        RecyclerView rv = binding.rvLugares;
        GridLayoutManager glm = new GridLayoutManager(requireContext(), 1, GridLayoutManager.VERTICAL, false);
        rv.setLayoutManager(glm);
        adapter = new LugaresAdapter(new ArrayList<>(), requireContext(), getLayoutInflater());
        rv.setAdapter(adapter);


        vm.getMLugares().observe(getViewLifecycleOwner(), new Observer<List<Lugares>>() {
            @Override
            public void onChanged(List<Lugares> lugares) {
                adapter.setLugares(lugares);
            }
        });


        vm.armarLista();



        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}