package com.sharkBytesLab.modernMirchiRadio;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import com.ismaeldivita.chipnavigation.ChipNavigationBar;
import com.sharkBytesLab.modernMirchiRadio.Fragments.HomeFragment;
import com.sharkBytesLab.modernMirchiRadio.Fragments.SettingFragment;
import com.sharkBytesLab.modernMirchiRadio.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    public static ChipNavigationBar chipNavigationBar;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        chipNavigationBar = findViewById(R.id.bottom_nav);

        if(savedInstanceState == null)
        {
            binding.bottomNav.setItemSelected(R.id.home, true);
            fragmentManager = getSupportFragmentManager();
            HomeFragment homeFragment = new HomeFragment();
            fragmentManager.beginTransaction().replace(R.id.fragment_container, homeFragment).commit();
        }

        binding.bottomNav.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int i) {

                Fragment fragment = null;

                switch(i)
                {
                    case R.id.home:
                        fragment = new HomeFragment();
                        break;

                    case R.id.settings:
                        fragment = new SettingFragment();
                        break;
                }

                if(fragment!=null)
                {
                    fragmentManager = getSupportFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.fragment_container, fragment).commit();
                }

            }
        });

    }
}