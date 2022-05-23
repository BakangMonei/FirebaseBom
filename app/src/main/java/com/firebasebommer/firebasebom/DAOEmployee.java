package com.firebasebommer.firebasebom;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class DAOEmployee {
    private DatabaseReference databaseReference;
    public DAOEmployee(){
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        databaseReference = db.getReference(Employee.class.getSimpleName());
    }

    // For adding new member
    public Task <Void> add(Employee emp){
        return databaseReference.push().setValue(emp);
    }

    // Update
    public Task <Void> update(String key, HashMap<String, Object> hashMap){
        return databaseReference.child(key).updateChildren(hashMap);
    }

    // Delete
    public Task <Void> remove(String key){
        return databaseReference.child(key).removeValue();
    }
}
