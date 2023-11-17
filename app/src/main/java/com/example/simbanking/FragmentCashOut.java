package com.example.simbanking;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Spinner;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.simbanking.Agent.FragmentAgent;
import com.example.simbanking.Cards.FragmentCards;
import com.google.android.material.tabs.TabLayout;

public class FragmentCashOut extends Fragment {
    TabLayout mTabs;
    View mIndicator;
    ViewPager mViewPager;
    private SharedPreferences sharedPreferences;

    private int indicatorWidth;


    private int selectedTabNumber=1;

    private Spinner spinner;

    public FragmentCashOut() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cashout, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mTabs = view.findViewById(R.id.tab);
        mIndicator = view.findViewById(R.id.indicator);
        mViewPager = view.findViewById(R.id.viewpager);


        sharedPreferences = getActivity().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);

        // Set up the view pager and fragments
        TabFragmentAdapter adapter = new TabFragmentAdapter(getChildFragmentManager());
        adapter.addFragment(FragmentAgent.newInstance(), "Agent/Branch");
        adapter.addFragment(FragmentCards.newInstance(), "ATM");
        mViewPager.setAdapter(adapter);
        mTabs.setupWithViewPager(mViewPager);

        // Determine indicator width at runtime
        mTabs.post(new Runnable() {
            @Override
            public void run() {
                indicatorWidth = mTabs.getWidth() / mTabs.getTabCount();

                // Assign new width
                FrameLayout.LayoutParams indicatorParams = (FrameLayout.LayoutParams) mIndicator.getLayoutParams();
                indicatorParams.width = indicatorWidth;
                mIndicator.setLayoutParams(indicatorParams);
            }
        });

        // Get the last selected tab position from SharedPreferences
        int lastSelectedTab = sharedPreferences.getInt("lastSelectedTab", 0);
        int lastIndicatorPosition = sharedPreferences.getInt("lastIndicatorPosition", 0);


        // Set the last selected tab as the current tab
        mViewPager.setCurrentItem(lastSelectedTab);



        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float positionOffset, int positionOffsetPx) {
                FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) mIndicator.getLayoutParams();
                float translationOffset = (positionOffset + i) * indicatorWidth;
                params.leftMargin = (int) translationOffset;
                mIndicator.setLayoutParams(params);
            }

            @Override
            public void onPageSelected(int i) {
                // Save the selected tab position in SharedPreferences
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("lastSelectedTab", i);
                editor.apply();
            }

            @Override
            public void onPageScrollStateChanged(int i) {
            }
        });

    }

}
