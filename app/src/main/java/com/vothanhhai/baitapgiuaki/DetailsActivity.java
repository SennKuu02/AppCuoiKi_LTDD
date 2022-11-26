package com.vothanhhai.baitapgiuaki;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.vothanhhai.baitapgiuaki.model.DetailFood;
import com.vothanhhai.baitapgiuaki.model.MenuFood;


public class DetailsActivity extends MenuActivity {

    private ImageView imgFood;
    private TextView tvName, tvRating, tvDes, tvPrice;
    private DetailFood object;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        initview();
        if(getIntent() != null && getIntent().hasExtra("food")) {
            DetailFood food = (DetailFood) getIntent().getSerializableExtra("food");
            imgFood.setImageResource(food.getImageURL());
            tvName.setText(food.getName());
            tvRating.setText(food.getRating());
            tvPrice.setText(food.getPrice());
            tvDes.setText(food.getDescription());
        }
}
    private void initview() {
        imgFood= findViewById(R.id.img_food);
        tvName = findViewById(R.id.tv_name);
        tvDes= findViewById(R.id.tv_description);
        tvPrice =findViewById(R.id.tc_price);
        tvRating=findViewById(R.id.tv_rating1);
    }
}
