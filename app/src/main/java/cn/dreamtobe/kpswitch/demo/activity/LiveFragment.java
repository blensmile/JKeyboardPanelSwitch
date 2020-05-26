package cn.dreamtobe.kpswitch.demo.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cn.dreamtobe.kpswitch.demo.R;
import cn.dreamtobe.kpswitch.util.KPSwitchConflictUtil;
import cn.dreamtobe.kpswitch.util.KeyboardUtil;

public class LiveFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_live,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

//        KeyboardUtil.attach(getActivity(), view.findViewById(R.id.llPannel));
//        KPSwitchConflictUtil.attach(view.findViewById(R.id.llInput), view.findViewById(R.id.tvSend), view.findViewById(R.id.etComment));
    }
}
