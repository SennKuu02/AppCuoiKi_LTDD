package com.vothanhhai.baitapgiuaki.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

import com.vothanhhai.baitapgiuaki.Adapter.MenuFoodAdapter;
import com.vothanhhai.baitapgiuaki.DetailsActivity;
import com.vothanhhai.baitapgiuaki.R;
import com.vothanhhai.baitapgiuaki.model.DetailFood;
import com.vothanhhai.baitapgiuaki.model.MenuFood;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    MenuFoodAdapter adapter;
    ArrayList<MenuFood> menuFoodList;
    ListView listView ;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        Addarray();
        adapter = new MenuFoodAdapter(getActivity(),R.layout.menu_food_row_item,menuFoodList);
        listView = view.findViewById(R.id.list_food);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getActivity(),DetailsActivity.class);
                intent.putExtra("food", menuFoodList.get(i));
                startActivity(intent);
            }
        });
        return view;
    }




    private void Addarray(){
        menuFoodList = new ArrayList<>();
        menuFoodList.add(new MenuFood("Bánh Trôi Vietnam","7.00",R.drawable.popularfood1,"4.5"));
        menuFoodList.add(new MenuFood("Đùi Gà","9.00",R.drawable.popularfood2,"5"));
        menuFoodList.add(new MenuFood("Thịt Gà Tikka","9.00",R.drawable.popularfood3,"3.5"));
    }




}
