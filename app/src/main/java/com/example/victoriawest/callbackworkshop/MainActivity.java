package com.example.victoriawest.callbackworkshop;

import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements callbackFragment.CallbackClass {

    @BindView(R.id.callback_message_textview)
    protected TextView callbackMessageTextview;

    @BindView(R.id.activity_layout)
    protected ConstraintLayout activityLayout;

    private callbackFragment callbackFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.fragment_launcher_button)
    protected void fragmentLauncherButtonClicked(){

        callbackFragment = callbackFragment.newInstance();

        callbackFragment.attachParent(MainActivity.this);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_holder_frameLayout, callbackFragment).commit();
    }

    @Override
    public void showToast() {
        Toast.makeText(this,"The main activity is Toasting the Fragment", Toast.LENGTH_LONG).show();

    }

    @Override
    public void changeTextview() {
        callbackMessageTextview.setText("Callback Recieved");

    }

    @Override
    public void changeBackgroundColor() {

        activityLayout.setBackgroundColor(Color.CYAN);

    }

    @Override
    public void removeFragment() {
        getSupportFragmentManager().beginTransaction().remove(callbackFragment).commit();

    }
}
