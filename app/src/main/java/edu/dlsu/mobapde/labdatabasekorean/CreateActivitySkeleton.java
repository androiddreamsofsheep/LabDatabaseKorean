package edu.dlsu.mobapde.labdatabasekorean;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CreateActivitySkeleton extends AppCompatActivity {

    EditText etName, etAge, etGroup;
    Button buttonDone;
    long id = -1;
    boolean add = false;
    DatabaseHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        etName = (EditText) findViewById(R.id.et_name);
        etAge = (EditText) findViewById(R.id.et_age);
        etGroup = (EditText) findViewById(R.id.et_group);
        buttonDone = (Button) findViewById(R.id.button_done);

        // TODO initialize dbHelper
        dbHelper = new DatabaseHelper(getBaseContext());

        // This activity should be able to handle both creating and editing the record
        // We will know based on which activity called this instance

        // In MainActivity (buttonAdd) -> extra should be add: true
        // In ViewActivity (buttonEdit) -> extra should be add:false
        // TODO check previous activity's extra to know whether to add or edit

        add = ;

        // if user wants to edit, we should load the current values of the db record
        if(!add){
            // get id from extras
            id = ;
            // TODO call databasehelper and find db record given id
            Korean record = ;

            if(record!=null){
                // TODO load record details to editTexts
            }
        }

        // Question : Do we really need the add boolean, or can we do with fewer variables?


        buttonDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Korean korean = new Korean();
                // TODO get the user's input and set them as record's properties
                

                // insert/edit
                if(add){
                    // TODO call databasehelper to add

                }else{
                    // TODO call databasehelper to edit record

                }
                finish();
            }
        });
    }
}
