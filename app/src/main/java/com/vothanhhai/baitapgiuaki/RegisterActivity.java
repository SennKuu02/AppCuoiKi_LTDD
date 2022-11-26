package com.vothanhhai.baitapgiuaki;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.vothanhhai.baitapgiuaki.model.Account;

public class RegisterActivity extends LoginActivity {


    EditText edtUserName, edtPass, edtRePass;
    TextView tvLogin;
    Button btnSignup;
    private final DatabaseReference myRef = FirebaseDatabase.getInstance().getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        edtUserName = findViewById(R.id.edt_username);
        edtPass = findViewById(R.id.edt_pass);
        edtRePass = findViewById(R.id.edt_repass);
        btnSignup = findViewById(R.id.btn_sighup1);
        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openHome();
            }
        });

        tvLogin = findViewById(R.id.tv_login);
        tvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLogin();
            }
        });
    }

    private void openHome() {

        if (edtUserName.getText().length() != 0 && edtPass.getText().length() != 0 && edtRePass.getText().length() != 0) {
            if (edtPass.getText() != edtRePass.getText()) {
                Toast.makeText(this, "Mật khẩu không trùng", Toast.LENGTH_SHORT).show();

            } else {
                Account account = new Account(edtUserName.getText().toString(),edtPass.getText().toString());
                myRef.child("Accounts").child(account.getUserName()).setValue(account)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                Toast.makeText(getApplicationContext(), "Đăng kí thành công", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                                startActivity(intent);
                            }
                        }).addOnCanceledListener(new OnCanceledListener() {
                            @Override
                            public void onCanceled() {
                                Toast.makeText(getApplicationContext(), "Đăng kí thất bại", Toast.LENGTH_SHORT).show();
                            }
                        });
            }


        } else {
            Toast.makeText(RegisterActivity.this, "Bạn cần phải nhập đủ thông tin", Toast.LENGTH_SHORT).show();
        }
    }

    private void openLogin() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}