package com.sharkBytesLab.modernMirchiRadio.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.sharkBytesLab.modernMirchiRadio.Adapters.HorizontalAdapter;
import com.sharkBytesLab.modernMirchiRadio.MainActivity;
import com.sharkBytesLab.modernMirchiRadio.R;
import com.sothree.slidinguppanel.SlidingUpPanelLayout;
import com.takusemba.multisnaprecyclerview.MultiSnapRecyclerView;


public class HomeFragment extends Fragment {


    private ImageView smallImageView, playPauseButton, closeButton;
    private TextView radioName;
    private SlidingUpPanelLayout slidingUpPanelLayout;
    private View divider;
    private int[] radioImagesFirst = {R.drawable.radiomirchi};
    private int[] radioImagesSecond = {R.drawable.bigfm, R.drawable.vividhbharati, R.drawable.airfmgold, R.drawable.airfmrainbow, R.drawable.radiocity};

    public HomeFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        smallImageView = view.findViewById(R.id.smallImageView);
        closeButton = view.findViewById(R.id.closeWindow);
        playPauseButton = view.findViewById(R.id.playPause);
        radioName = view.findViewById(R.id.radioName);
        slidingUpPanelLayout = view.findViewById(R.id.sliding_layout);
        divider = view.findViewById(R.id.divider);

        HorizontalAdapter firstAdapter = new HorizontalAdapter(radioImagesFirst);
        MultiSnapRecyclerView firstRecyclerView = view.findViewById(R.id.first_recycler_view);
        LinearLayoutManager firstManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        firstRecyclerView.setLayoutManager(firstManager);
        firstRecyclerView.setAdapter(firstAdapter);

        HorizontalAdapter secondAdapter = new HorizontalAdapter(radioImagesSecond);
        MultiSnapRecyclerView secondRecyclerView = view.findViewById(R.id.second_recycler_view);
        LinearLayoutManager secondManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        secondRecyclerView.setLayoutManager(secondManager);
        secondRecyclerView.setAdapter(secondAdapter);

        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                slidingUpPanelLayout.setPanelState(SlidingUpPanelLayout.PanelState.COLLAPSED);
                closeButton.setVisibility(View.INVISIBLE);

            }
        });

        slidingUpPanelLayout.addPanelSlideListener(new SlidingUpPanelLayout.PanelSlideListener() {
            @Override
            public void onPanelSlide(View panel, float slideOffset) {



            }

            @Override
            public void onPanelStateChanged(View panel, SlidingUpPanelLayout.PanelState previousState, SlidingUpPanelLayout.PanelState newState) {

                if(newState.toString().equals("EXPANDED"))
                {
                    slidingUpPanelLayout.setTouchEnabled(false);
                    divider.setVisibility(View.INVISIBLE);
                    MainActivity.chipNavigationBar.setVisibility(View.INVISIBLE);
                }

            }
        });

        return view;
    }
}