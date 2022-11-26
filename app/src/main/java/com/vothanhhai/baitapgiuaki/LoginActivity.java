package com.vothanhhai.baitapgiuaki;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.vothanhhai.baitapgiuaki.Fragment.HomeFragment;

public class LoginActivity extends AppCompatActivity {

    EditText edtUserName,edtPass;
    TextView tvSigup;
    Button btnLogin;
    DatabaseReference myRef = FirebaseDatabase.getInstance().getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin=findViewById(R.id.btn_login1);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openHome();
            }
        });

        edtUserName=findViewById(R.id.edt_username);
        edtPass=findViewById(R.id.edt_pass);


        tvSigup=findViewById(R.id.tv_signup);
        tvSigup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSignup();
            }
        });

    }

    private void openHome() {
        if(edtUserName.getText().length() != 0 && edtUserName.getText().length() != 0){
            myRef.child("Accounts").addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                    if (dataSnapshot.hasChild(edtUserName.getText().toString()))
                }
                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
            if(edtUserName.getText().toString().equals("thanhhai") && edtPass.getText().toString().equals("123")){
                Toast.makeText(LoginActivity.this, "Bạn đã đăng nhập thành công", Toast.LENGTH_SHORT).show();
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.loginActivity,new HomeFragment()).commit();
            }else {
                Toast.makeText(LoginActivity.this, "Bạn đã đăng nhập sai tài khoản hoặc mật khẩu", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(LoginActivity.this, "Bạn cần nhập đủ thông tin", Toast.LENGTH_SHORT).show();
        }
    }

    private void openSignup() {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);

    }
}