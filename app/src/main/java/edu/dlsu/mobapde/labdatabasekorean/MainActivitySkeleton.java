package edu.dlsu.mobapde.labdatabasekorean;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

public class MainActivitySkeleton extends AppCompatActivity {

    RecyclerView recyclerView;
    Button tvAdd;
    DatabaseHelper dbHelper;
    KoreansAdapter koreansAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initialize views
        recyclerView = (RecyclerView) findViewById(R.id.rv);
        tvAdd = (Button) findViewById(R.id.button_add);

        // initialize items to the database
        dbHelper = new DatabaseHelper(getBaseContext());

        koreansAdapter
                = new KoreansAdapter(getBaseContext(),
                    dbHelper.getAllKoreansCursor());

        recyclerView.setAdapter(koreansAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext()));

        tvAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO lead the user to the activity to create a new record
                Intent intent = ;
                // Note: make sure to pass an extra that we want to add and not edit


                // END

                startActivity(intent);
            }
        });

        koreansAdapter.setOnItemClickListener(new KoreansAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(long id) {
                // TODO lead the user to the activity to view the clicked item
                Intent intent = ;
                // Note: make sure to pass an extra that we want to edit and not add

                //       also pass the id of the selected item

                // END
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        koreansAdapter.changeCursor(dbHelper.getAllKoreansCursor());
    }
}
