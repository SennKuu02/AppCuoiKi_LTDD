package com.vothanhhai.baitapgiuaki.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.vothanhhai.baitapgiuaki.R;
import com.vothanhhai.baitapgiuaki.model.MenuFood;

import java.util.List;

public class MenuFoodAdapter extends BaseAdapter {

    Context context;
    int layout;
    List<MenuFood> menuFoodList;

    public MenuFoodAdapter(Context context, int layout, List<MenuFood> menuFoodList) {
        this.context = context;
        this.layout = layout;
        this.menuFoodList = menuFoodList;
    }

    @Override
    public int getCount() {
        return menuFoodList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }


    public class ViewHolder {
        ImageView foodImage;
        TextView price;
        TextView name;
        TextView rating;
        TextView Des;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout, null);
            holder = new ViewHolder();
            holder.foodImage = view.findViewById(R.id.image_food_item);
            holder.price = view.findViewById(R.id.tvPrice);
            holder.name = view.findViewById(R.id.tv_name_food);
            holder.rating = view.findViewById(R.id.tv_rating);
            holder.Des = view.findViewById(R.id.tv_description);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        holder.foodImage.setImageResource(menuFoodList.get(i).getImageURL());
        holder.name.setText(menuFoodList.get(i).getName());
        holder.price.setText(menuFoodList.get(i).getPrice());
        return view;
    }
}