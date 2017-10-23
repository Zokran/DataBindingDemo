package com.brotherd.databinddemo.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.databinding.library.baseAdapters.BR;
import com.brotherd.databinddemo.R;
import com.brotherd.databinddemo.databinding.ItemRvBinding;
import com.brotherd.databinddemo.handler.EventHandler;
import com.brotherd.databinddemo.model.User;

import java.util.List;

/**
 * Created by dumingwei on 2017/5/19.
 */
public class RvAdapter extends RecyclerView.Adapter<BindingViewHolder> {

    private List<User> userList;
    private Context context;

    public RvAdapter(List<User> userList, Context context) {
        this.userList = userList;
        this.context = context;
    }

    @Override
    public BindingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemRvBinding binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.item_rv, parent, false);
        BindingViewHolder<ItemRvBinding> viewHolder = new BindingViewHolder<>(binding);
        //BindingHolder holder = new BindingHolder(binding.getRoot());
        //holder.setBinding(binding);
        binding.setClickHandler(new EventHandler(context));
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(BindingViewHolder holder, int position) {
        holder.getBinding().setVariable(BR.item, userList.get(position));
        holder.getBinding().executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class BindingHolder extends RecyclerView.ViewHolder {

        private ItemRvBinding binding;

        public BindingHolder(View itemView) {
            super(itemView);
        }

        public ItemRvBinding getBinding() {
            return binding;
        }

        public void setBinding(ItemRvBinding binding) {
            this.binding = binding;
        }
    }
}
