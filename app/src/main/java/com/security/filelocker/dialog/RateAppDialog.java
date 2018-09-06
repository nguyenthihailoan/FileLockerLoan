package com.security.filelocker.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import com.security.filelocker.R;


/**
 * Created by binhnk on 7/25/2017.
 */

public class RateAppDialog extends Dialog implements View.OnClickListener {
    private Context context;
    private OnButtonClicked onButtonClicked;

    private TextView tvRateApp, tvNotNow;

    public RateAppDialog(@NonNull Context context, OnButtonClicked onButtonClicked) {
        super(context);
        this.context = context;
        this.onButtonClicked = onButtonClicked;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        setContentView(R.layout.dialog_rate_app);

        tvRateApp = (TextView) findViewById(R.id.tv_rate_app);
        tvNotNow = (TextView) findViewById(R.id.tv_not_now);

        tvRateApp.setOnClickListener(this);
        tvNotNow.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_not_now:
                tvNotNow.setTextColor(Color.parseColor("#00a697"));
                dismiss();
                onButtonClicked.onCancelClicked();
                break;

            case R.id.tv_rate_app:
                tvRateApp.setTextColor(Color.parseColor("#00a697"));
                dismiss();
                onButtonClicked.onRateClicked();
                break;

            default:
                dismiss();
                break;
        }
    }

    public interface OnButtonClicked {
        void onRateClicked();

        void onCancelClicked();
    }
}
