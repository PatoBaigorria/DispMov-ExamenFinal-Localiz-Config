package com.patriciasoft.examen.ui.mapas;

import android.location.Location;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.patriciasoft.examen.R;

import com.patriciasoft.examen.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private HomeViewModel vm;

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        vm = new ViewModelProvider(this).get(HomeViewModel.class);



        vm.getMMapa().observe(getViewLifecycleOwner(), new Observer<HomeViewModel.MapaActual>() {
            @Override
            public void onChanged(HomeViewModel.MapaActual mapaActual) {
                SupportMapFragment smf = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.tvMostrar);
                smf.getMapAsync(mapaActual);
            }
        });

        vm.getMLocation().observe(getViewLifecycleOwner(), new Observer<Location>() {
            @Override
            public void onChanged(Location location) {
                //binding.tvMostrar.setText(location.getLatitude()+" "+ location.getLongitude());
                vm.VILLAMERCEDES = new LatLng(location.getLatitude(), location.getLongitude());
                vm.obtenerMapa();
            }
        });
        vm.obtenerUltimaUbicacion();
        //vm.lecturaPermanente();

        return root;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}