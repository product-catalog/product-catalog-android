package com.pcatalog.productcatalog.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.pcatalog.productcatalog.R;
import com.pcatalog.productcatalog.http.OkHttpHttpRequester;
import com.pcatalog.productcatalog.models.LoginDto;
import com.pcatalog.productcatalog.models.PhotoDto;
import com.pcatalog.productcatalog.models.Product;
import com.pcatalog.productcatalog.models.ProductDto;
import com.pcatalog.productcatalog.views.addproduct.AddProductActivity;
import com.pcatalog.productcatalog.views.login.LoginActivity;
import com.pcatalog.productcatalog.views.productdetails.ProductDetailsActivity;
import com.pcatalog.productcatalog.views.productslist.ProductsListActivity;
import com.pcatalog.productcatalog.views.welcomemenu.WelcomeMenuActivity;

import java.io.IOException;

import butterknife.BindView;
import dagger.android.support.DaggerAppCompatActivity;

public abstract class BaseDrawerActivity extends DaggerAppCompatActivity {

    @BindView(R.id.drawer_toolbar)
    Toolbar mToolbar;

    public BaseDrawerActivity() {

    }

    public void setupDrawer() {
        PrimaryDrawerItem addProduct = new PrimaryDrawerItem()
                .withIdentifier(AddProductActivity.IDENTIFIER)
                .withName("Add Product");

        PrimaryDrawerItem logout = new PrimaryDrawerItem()
                .withIdentifier(WelcomeMenuActivity.IDENTIFIER)
                .withName("Logout");

        PrimaryDrawerItem products = new PrimaryDrawerItem()
                .withIdentifier(ProductsListActivity.IDENTIFIER)
                .withName("Products");

        Drawer drawer = new DrawerBuilder()
                .withActivity(this)
                .withToolbar(mToolbar)
                .addDrawerItems(
                        addProduct,
                        new DividerDrawerItem(),
                        products,
                        new DividerDrawerItem(),
                        logout
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
            Intent intent = new Intent(this, AddProductActivity.class);
            intent.putExtra("token", getIntent().getExtras().get("token").toString());
            if (new OkHttpHttpRequester().isAdmin(getIntent().getExtras().get("token").toString())){
                startActivity(intent);
                finish();
            }
            else {
                Toast.makeText(this, "You are not admin to create new product", Toast.LENGTH_SHORT).show();
            }
        } else if (identifier == WelcomeMenuActivity.IDENTIFIER) {
            Intent intent = new Intent(this, WelcomeMenuActivity.class);
            startActivity(intent);
            finish();
        } else if (identifier == ProductsListActivity.IDENTIFIER) {
            Intent intent = new Intent(this, ProductsListActivity.class);
            intent.putExtra("token", getIntent().getExtras().get("token").toString());
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
