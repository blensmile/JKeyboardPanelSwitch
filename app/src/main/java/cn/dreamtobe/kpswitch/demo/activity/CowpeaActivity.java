package cn.dreamtobe.kpswitch.demo.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import cn.dreamtobe.kpswitch.demo.R;

public class CowpeaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cowpea);
        new PagerFragmentDialog().show(getSupportFragmentManager(),"");
    }
}
