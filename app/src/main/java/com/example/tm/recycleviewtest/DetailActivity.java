package com.example.tm.recycleviewtest;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

/**
 * Created by TM on 10/10/2016.
 */

public class DetailActivity extends AppCompatActivity {


    Toolbar mToolbar;
    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_layout);
        mToolbar = (Toolbar) findViewById(R.id.details_layout_menu);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        mContext = getApplicationContext();
        mToolbar.setTitle(null);
        mToolbar.setNavigationIcon(ContextCompat.getDrawable(mContext, R.drawable.ic_chevron_left_black_24dp));
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickDrawableDetails(v);
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.details_layout, menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        int id = item.getItemId();
        if (id == R.id.details_layout_action_setting) {
            intent = new Intent(this, SettingsActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    public Drawable getDrawableNavigate() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            return getResources().getDrawable(R.drawable.ic_chevron_left_black_24dp, this.getTheme());
        } else {
            return getResources().getDrawable(R.drawable.ic_chevron_left_black_24dp);
        }
    }

    public void onClickDrawableDetails(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
