package com.dcodepages.material.navigationdrawer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.Toast;

/**
 * Created by d-codepages on 11/11/2014.
 */
public class MainActivity extends ActionBarActivity implements DrawerCallbacks {

    private Toolbar mToolbar;

    private Nav_DrawerFragment mNavigationNavDrawerFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mToolbar = (Toolbar) findViewById(R.id.toolbar_actionbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        mNavigationNavDrawerFragment = (Nav_DrawerFragment) getFragmentManager().findFragmentById(R.id.fragment_drawer);
        mNavigationNavDrawerFragment.setup(R.id.fragment_drawer, (DrawerLayout) findViewById(R.id.drawer), mToolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        Toast.makeText(this, "item no: " + position + "-Selected", Toast.LENGTH_SHORT).show();

        switch (position){

            case 0:
                Intent intent = new Intent(MainActivity.this,Next.class);
                startActivity(intent);
                break;

            case 1:
                Intent a = new Intent(MainActivity.this,Next.class);
                startActivity(a);
                break;

        }

    }

    @Override
    public void onBackPressed() {
        if (mNavigationNavDrawerFragment.isDrawerOpen())
            mNavigationNavDrawerFragment.closeDrawer();
        else
            super.onBackPressed();
    }
}
