package bornbaby.com.roomdatabase;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    FloatingActionButton fl_btn;
    RecyclerView recycler_view;
    RecyclerView.LayoutManager layoutManager;
    private List<User>usersList;
    CustomRecylerViewAdapter customRecylerViewAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        fl_btn = findViewById(R.id.fl_btn);
        recycler_view = findViewById(R.id.recycler_view);
        layoutManager = new LinearLayoutManager(getApplicationContext());

        recycler_view.setLayoutManager(layoutManager);

        fl_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, CreateUserActivity.class));

            }
        });

        AppDatabase appDatabase = Room.databaseBuilder(getApplicationContext(),AppDatabase.class,"production")
                .allowMainThreadQueries()
                .build();
        usersList =appDatabase.userDao().getAllUsers();
        customRecylerViewAdapter = new CustomRecylerViewAdapter(usersList,this);
        recycler_view.setAdapter(customRecylerViewAdapter);

    }
}
