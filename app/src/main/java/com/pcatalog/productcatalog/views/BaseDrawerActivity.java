package com.pcatalog.productcatalog.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.pcatalog.productcatalog.R;
import com.pcatalog.productcatalog.views.addproduct.AddProductActivity;

import butterknife.BindView;
import dagger.android.support.DaggerAppCompatActivity;

public abstract class BaseDrawerActivity extends DaggerAppCompatActivity {

    @BindView(R.id.drawer_toolbar)
    Toolbar mToolbar;

    public BaseDrawerActivity() {

    }

    public void setupDrawer() {
        PrimaryDrawerItem settings = new PrimaryDrawerItem()
                .withIdentifier(AddProductActivity.IDENTIFIER)
                .withName("Settings");

        PrimaryDrawerItem myApplications = new PrimaryDrawerItem()
                .withIdentifier(AddProductActivity.IDENTIFIER)
                .withName("My Applications");

//        PrimaryDrawerItem registerItem = new PrimaryDrawerItem()
//                .withIdentifier(RegisterActivity.IDENTIFIER)
//                .withIcon(android.R.drawable.btn_plus)
//                .withName("Create superhero");

        Drawer drawer = new DrawerBuilder()
                .withActivity(this)
                .withToolbar(mToolbar)
                .addDrawerItems(
                        myApplications,
                        new DividerDrawerItem(),
                        settings
                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(
                            View view,
                            int position,
                            IDrawerItem drawerItem) {
                        long identifier = drawerItem.getIdentifier();

                        if (getIdentifier() == identifier) {
                            return false;
                        }

                        Intent intent = getNextIntent(identifier);
                        if (intent == null) {
                            return false;
                        }

                        startActivity(intent);
                        return true;
                    }
                })
                .build();
    }

    private Intent getNextIntent(long identifier) {
        if (identifier == AddProductActivity.IDENTIFIER) {
            return new Intent(this, AddProductActivity.class);
        }
        if (identifier == AddProductActivity.IDENTIFIER) {
            Intent intent = new Intent(this, AddProductActivity.class);
            startActivity(intent);
            finish();
        }
        return null;
    }

    public Toolbar getToolbar() {
        return mToolbar;
    }

    protected abstract long getIdentifier();

    @Override
    protected void onStart() {
        super.onStart();
        setupDrawer();
    }
}
