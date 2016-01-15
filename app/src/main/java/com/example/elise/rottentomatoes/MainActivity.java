package com.example.elise.rottentomatoes;


import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import java.io.Serializable;


public class MainActivity extends AppCompatActivity implements Serializable {

    private ViewPager pager;
    private TabLayout tabLayout;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.titleImage);
        imageView.setImageResource(R.drawable.title);
        pager = (ViewPager) findViewById(R.id.viewPager);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);

        tabLayout.addTab(tabLayout.newTab().setText("NOW PLAYING"));
        tabLayout.addTab(tabLayout.newTab().setText("UPCOMING"));
        tabLayout.setTabTextColors(Color.BLUE, Color.RED);


        pager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                pager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        RottenTomatoesAsyncTask task = new RottenTomatoesAsyncTask(pager, this);
        task.execute();
    }
}

