package com.example.mvvmarch;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Toast;

public class AddNoteActivity extends AppCompatActivity {

    public static final String EXTRA_TITLE = "com.example.mvvmarch.EXTRA_TITLE";
    public static final String EXTRA_DESCRIPTION = "com.example.mvvmarch.EXTRA_DESCRIPTION";
    public static final String EXTRA_PRIORITY = "com.example.mvvmarch.EXTRA_PRIORITY";
    private EditText title, description;
    private NumberPicker numberPicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        title = findViewById(R.id.edit_title);
        description = findViewById(R.id.edit_description);
        numberPicker = findViewById(R.id.numberPiker);

        numberPicker.setMinValue(1);
        numberPicker.setMaxValue(10);

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close);
        setTitle("Add Note");
    }
    private void saveNote(){
        String n_title = title.getText().toString();
        String n_description = description.getText().toString();
        int priority = numberPicker.getValue();

        if(n_title.trim().isEmpty()||n_description.trim().isEmpty()){
            Toast.makeText(this, "Please insert the title and description", Toast.LENGTH_SHORT).show();
            return;
        }
        Intent data = new Intent();
        data.putExtra(EXTRA_TITLE, n_title);
        data.putExtra(EXTRA_DESCRIPTION, n_description);
        data.putExtra(EXTRA_PRIORITY, priority);

        setResult(RESULT_OK,data);
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.add_note_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.save_note:
                saveNote();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}