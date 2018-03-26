package com.example.victoriawest.callbackworkshop;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.zip.Inflater;

import butterknife.ButterKnife;
import butterknife.OnClick;

/***
 * Created by victoriawest on 3/26/18.
 */

public class callbackFragment extends Fragment {

    private CallbackClass callback;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_controller, container, false);
        ButterKnife.bind(this, view);
        return view;
    }


    @OnClick(R.id.callback_toast_button)
    protected void showToastButtonClicked(){
        callback.showToast();
    }

    @OnClick(R.id.callback_change_textview_button)
    protected void changeTextviewButtonClicked(){
        callback.changeTextview();
    }

    @OnClick(R.id.callback_change_background_color_button)
    protected void changeBackgroundColorClicked(){
callback.changeBackgroundColor();
    }

    @OnClick(R.id.callback_remove_fragment_button)
    protected void removeFragmentButtonClicked(){
        callback.removeFragment();

    }

    public void attachParent(CallbackClass callback) {
        this.callback = callback;
    }

    public static callbackFragment newInstance(){
        Bundle args = new Bundle();

        callbackFragment fragment = new callbackFragment();
        fragment.setArguments(args);
        return fragment;
        //new and tab to create ^^
    }

    public interface CallbackClass {
        void showToast();
        void changeTextview();
        void changeBackgroundColor();
        void removeFragment();
    }
}




