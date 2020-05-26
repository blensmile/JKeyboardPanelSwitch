package cn.dreamtobe.kpswitch.demo.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import java.util.ArrayList;
import java.util.List;

import cn.dreamtobe.kpswitch.demo.R;
import cn.dreamtobe.kpswitch.util.KeyboardUtil;

public class PagerFragmentDialog extends DialogFragment {


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(STYLE_NORMAL,R.style.dialog_live);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        AndroidBug5497Workaround.assistActivity(getActivity());
        return inflater.inflate(R.layout.fragment_pager,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        ViewPager vpPager = view.findViewById(R.id.vpPager);
        final List<Fragment> list = new ArrayList<>();
        list.add(new LiveFragment());
        list.add(new Fragment());
        vpPager.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {

            @Override
            public Fragment getItem(int position) {
                return list.get(position);
            }

            @Override
            public int getCount() {
                return list.size();
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        getDialog().setCanceledOnTouchOutside(false);
        getDialog().setOnKeyListener((dialog, keyCode, event) -> {
            if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_UP) {
                getActivity().onBackPressed();
                return true;
            }
            return false;
        });
        Window window = getDialog().getWindow();
        if (window != null) {
            window.setBackgroundDrawableResource(android.R.color.transparent);
//            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS |WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS );
            WindowManager.LayoutParams windowParams = window.getAttributes();
            windowParams.width = ViewGroup.LayoutParams.MATCH_PARENT;
            windowParams.height = ViewGroup.LayoutParams.MATCH_PARENT;
            windowParams.dimAmount = 0.0f;
            window.setAttributes(windowParams);
        }
    }
}
