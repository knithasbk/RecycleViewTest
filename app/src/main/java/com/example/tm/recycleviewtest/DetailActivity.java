package com.example.tm.recycleviewtest;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.tm.recycleviewtest.AdapterDetailsForeCast.DetailsForecastFragment;
import com.example.tm.recycleviewtest.SQLiteDatabase.WeatherCreateDatabaseHelper;
import com.example.tm.recycleviewtest.SQLiteDatabase.WeatherListData;

import java.util.ArrayList;

/**
 * Created by TM on 10/10/2016.
 */

public class DetailActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private Context mContext;
    ArrayDataTest arrayDataTest;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Bundle bundle = getIntent().getExtras();
        int position = bundle.getInt("POSITION");
        Log.i("TEST_TRACE", "Position at DetailActivity.class: " + String.valueOf(position));
        DetailsForecastFragment detailsForecastFragment = new DetailsForecastFragment();
        detailsForecastFragment.setPosition(position);
        Log.i("TEST_TRACE", "Start OnCreate DetailActivity.class");



        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_activity);
        Log.i("TEST_TRACE", "Verify step Details layout");

/* Handle toolbar for DetailsActivity.class */
        mToolbar = (Toolbar) findViewById(R.id.details_layout_menu);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        mContext = getApplicationContext();
        mToolbar.setTitle(null);
        Log.i("TEST_TRACE", "Verify step toolbar");

/*Using Data list position from RecycleView click to get Data for Details Layout*/
     //   arrayDataTest = new ArrayDataTest();
    //    weatherListDataArrayList = arrayDataTest.buildDataTest();

/*Get bundle data (int Position) from previous Activity  */


/*Add fragment to activity*/


        Log.i("TEST_TRACE", "Step 1");
        FragmentManager fragmentManager = getSupportFragmentManager();
        Log.i("TEST_TRACE", "Step 2");
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Log.i("TEST_TRACE", "Step 3");
        fragmentTransaction.add(R.id.details_fragment_id, detailsForecastFragment);
        Log.i("TEST_TRACE", "Step 4");
        fragmentTransaction.commit();
        Log.i("TEST_TRACE", "Verify step Details Layout data");



/* Handle click action for Navigation button back to MainActivity.class */
        mToolbar.setNavigationIcon(ContextCompat.getDrawable(mContext, R.drawable.ic_chevron_left_black_24dp));
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickDrawableDetails(v);
            }
        });
        Log.i("TEST_TRACE", "Verify set Navigation button ");
        Log.i("TEST_TRACE", "End OnCreate DetailActivity.class");
    }

    /*Create and infalte menu layout for Detaisl Layout*/
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        Log.d("TEST_TRACE", "Start onCreateOptionsMenu DetailActivity.class");

        getMenuInflater().inflate(R.menu.details_layout, menu);
        Log.d("TEST_TRACE", "End onCreateOptionsMenu DetailActivity.class");

        return super.onCreateOptionsMenu(menu);


    }

    /* Handle settings click actions */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Log.d("TEST_TRACE", "Start onOptionsItemSelected DetailActivity.class");

        Intent intent;
        int id = item.getItemId();
        if (id == R.id.details_layout_action_setting) {
            intent = new Intent(this, SettingsActivity.class);
            startActivity(intent);
        }
        Log.d("TEST_TRACE", "End onOptionsItemSelected DetailActivity.class");
        return super.onOptionsItemSelected(item);


    }

    /*Function will be called when a Navigation button clicked event*/
    public void onClickDrawableDetails(View v) {
        Log.d("TEST_TRACE", "Start onClickDrawableDetails DetailActivity.class");
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        Log.d("TEST_TRACE", "End onClickDrawableDetails DetailActivity.class");

    }


    /*Handle getDrawable for others android version - NOT USE */
       /*     public Drawable getDrawableNavigate() {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    return getResources().getDrawable(R.drawable.ic_chevron_left_black_24dp, this.getTheme());
                } else {
                    return getResources().getDrawable(R.drawable.ic_chevron_left_black_24dp);
                }
            }
       */
}
