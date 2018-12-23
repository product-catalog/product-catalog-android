package com.pcatalog.productcatalog.views.productslist;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.pcatalog.productcatalog.R;
import com.pcatalog.productcatalog.models.Product;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.ProductViewHolder> {
    private List<Product> mProducts;
    private OnProductClickListener mOnProductClickListener;

    @Inject
    public ProductsAdapter() {
        mProducts = new ArrayList<>();
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.product_item, parent, false);
        int height = parent.getMeasuredHeight() / 3;
        ViewGroup.LayoutParams lp = view.getLayoutParams();
        lp.height = height;
        view.setLayoutParams(lp);
        view.setMinimumHeight(height);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        holder.setOnClickListener(mOnProductClickListener);
        holder.bind(mProducts.get(position));
    }

    @Override
    public int getItemCount() {
        return mProducts.size();
    }

    public Product getItem(int position) {
        return mProducts.get(position);
    }

    public void clear() {
        mProducts.clear();
    }

    public void addAll(List<Product> products) {
        mProducts.addAll(products);
    }

    public void setOnProductClickListener(OnProductClickListener onProductClickListener) {
        this.mOnProductClickListener = onProductClickListener;
    }

    public static class ProductViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_name)
        TextView mNameTextView;

        @BindView(R.id.iv_product)
        ImageView mProductImageView;
        private OnProductClickListener mOnClickListener;
        private Product mProduct;

        ProductViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        void bind(Product product) {
            mNameTextView.setText(product.getName());
            Picasso.get()
                    .load("http://idrawproart.com/CapOneSuperhero.jpg")
                    .into(mProductImageView);
            mProduct = product;
        }

        @OnClick
        public void onClick() {
            mOnClickListener.onClick(mProduct);
        }

        public void setOnClickListener(OnProductClickListener onClickListener) {
            mOnClickListener = onClickListener;
        }
    }

    interface OnProductClickListener {
        void onClick(Product product);
    }
}

