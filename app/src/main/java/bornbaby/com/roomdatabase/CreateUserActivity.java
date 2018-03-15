package bornbaby.com.roomdatabase;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class CreateUserActivity extends AppCompatActivity {
    private EditText user;
    private EditText email;
    private EditText phone;
    private Button btn_create;
    private LinearLayout ll_parent;
    Snackbar snackbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);
        user = findViewById(R.id.user);
        email = findViewById(R.id.email);
        phone = findViewById(R.id.phone);
        btn_create = findViewById(R.id.btn_create);
        ll_parent = findViewById(R.id.ll_parent);

        snackbar = Snackbar
                .make(ll_parent, "Please enter all fields", Snackbar.LENGTH_SHORT);


        final AppDatabase appDatabase = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "production")
                .allowMainThreadQueries()
                .build();

        btn_create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userNamre = user.getText().toString().trim();
                String emilId = email.getText().toString().trim();
                String phoneNumber = phone.getText().toString().trim();
                if (!TextUtils.isEmpty(userNamre)
                        && TextUtils.isEmpty(emilId) && !TextUtils.isEmpty(phoneNumber)) {
                    appDatabase.userDao().insertAllUser(new User(user.getText().toString(), email.getText().toString(), phone.getText().toString()));
                    startActivity(new Intent(CreateUserActivity.this, MainActivity.class));
                    finish();
                } else {
                    snackbar.show();
                }
            }
        });
    }
}
