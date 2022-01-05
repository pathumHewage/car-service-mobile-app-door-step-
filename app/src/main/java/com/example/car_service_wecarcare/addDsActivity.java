package com.example.car_service_wecarcare;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class addDsActivity extends AppCompatActivity {

    EditText name,phoneNo,location,brand,vModel,vMake,fuelType,date,pck;
    Button btnAdd,btnBack;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_ds);

        name = (EditText) findViewById(R.id.txtName);
        phoneNo = (EditText) findViewById(R.id.txtPhone);
        location = (EditText) findViewById(R.id.txtLocation);
        brand = (EditText) findViewById(R.id.txtbrand);
        vModel = (EditText) findViewById(R.id.txtvMake);
        vMake = (EditText) findViewById(R.id.txtvMake);
        fuelType = (EditText) findViewById(R.id.txtfuelType);
        date = (EditText) findViewById(R.id.txtdate);




       btnAdd = (Button) findViewById(R.id.btnAdd);
       btnBack = (Button) findViewById(R.id.btnBack);



       btnAdd.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {


               insertData();
              

           }
       });

       btnBack.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               finish();
           }
       });



    }

    private void insertData()
    {
        //data validation

        String pname= name.getText().toString().trim();
        String pphoneno = phoneNo.getText().toString().trim();
        String plocation = location.getText().toString().trim();
        String pbrand= brand.getText().toString().trim();
        String pmake= vMake.getText().toString().trim();
        String pmodel = vModel.getText().toString().trim();
        String pfuelType = fuelType.getText().toString().trim();
        String pdata = date.getText().toString().trim();

        if(pname.isEmpty()){
            name.setError("Name is required");
            name.requestFocus();
        }else if(pphoneno.isEmpty()){
            phoneNo.setError("Phone No is required");
            phoneNo.requestFocus();
        }else if (plocation.isEmpty()) {
            location.setError("Location is required");
            location.requestFocus();

        }else if(pbrand.isEmpty()){
            brand.setError("brand is required");
            brand.requestFocus();
        }else if (pmodel.isEmpty()) {
            vModel.setError("Vehicle Model is required");
            vModel.requestFocus();
        }else if(pmake.isEmpty()){
            vMake.setError("Vehicle Make is required");
            vMake.requestFocus();
        }else if (pfuelType.isEmpty()) {
            fuelType.setError("Fuel Type is required");
            fuelType.requestFocus();
        }else if (pdata.isEmpty()) {
            date.setError("Request Date  is required");
            date.requestFocus();

        }else {


            Map<String, Object> map = new HashMap<>();

            map.put("name", name.getText().toString());
            map.put("phoneNo", phoneNo.getText().toString());
            map.put("location", location.getText().toString());
            map.put("brand", brand.getText().toString());
            map.put("vModel", vModel.getText().toString());
            map.put("vMake", vMake.getText().toString());
            map.put("fuelType", fuelType.getText().toString());
            map.put("date", date.getText().toString());


           // insert data to database

            FirebaseDatabase.getInstance("https://carserviceapp-fb926-default-rtdb.firebaseio.com/").getReference().child("request").push()
                    .setValue(map)
                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void unused) {
                            Toast.makeText(addDsActivity.this, "Data insertion Successfully", Toast.LENGTH_SHORT).show();
                            clearAll();
                        }
                    })

                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(Exception e) {
                            Toast.makeText(addDsActivity.this, "Error Data insertion ", Toast.LENGTH_SHORT).show();
                        }
                    });
        }
    }


    private void clearAll()
    {
        name.setText("");
        phoneNo.setText("");
        location.setText("");
        brand.setText("");
        vModel.setText("");
        vMake.setText("");
        fuelType.setText("");
        date.setText("");

    }





}