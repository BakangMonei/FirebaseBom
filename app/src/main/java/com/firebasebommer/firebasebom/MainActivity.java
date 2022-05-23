package com.firebasebommer.firebasebom;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText edit_name = (EditText) findViewById(R.id.edit_name);
        final EditText edit_position = (EditText) findViewById(R.id.edit_position);
        Button btn = (Button) findViewById(R.id.btn_submit);
        Button btn_update = (Button) findViewById(R.id.btn_update);
        Button btn_delete = (Button) findViewById(R.id.btn_delete);

        DAOEmployee dao = new DAOEmployee();

        // Adding button
        btn.setOnClickListener(v->{
            Employee emp = new Employee(edit_name.getText().toString(), edit_position.getText().toString());
            dao.add(emp).addOnSuccessListener(suc->{
                Toast.makeText(this, "Record is added", Toast.LENGTH_SHORT).show();
            }).addOnFailureListener(er->{
                Toast.makeText(this, "" + er.getMessage(), Toast.LENGTH_SHORT).show();
            });
        });

        // Update Button
        btn_update.setOnClickListener(v-> {
            HashMap <String, Object> hashMap = new HashMap<>();
            hashMap.put("name", edit_name.getText().toString());
            hashMap.put("position", edit_position.getText().toString());
            dao.update("-N2arZeyeND0_mtwGxPs", hashMap).addOnSuccessListener(suc->{
                Toast.makeText(this, "Record is updated", Toast.LENGTH_SHORT).show();
            }).addOnFailureListener(er->{
                Toast.makeText(this, "" + er.getMessage(), Toast.LENGTH_SHORT).show();
            });
        });

        // Delete button
        btn_delete.setOnClickListener(v->{
            dao.remove("-N2arZeyeND0_mtwGxPs").addOnSuccessListener(suc->{
                Toast.makeText(this, "Record is Deleted", Toast.LENGTH_SHORT).show();
            }).addOnFailureListener(er->{
                Toast.makeText(this, "" + er.getMessage(), Toast.LENGTH_SHORT).show();
            });
        });
    }
}