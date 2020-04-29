package com.example.instagramclone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.SaveCallback;
import com.shashank.sony.fancytoastlib.FancyToast;

public class SignUp extends AppCompatActivity implements View.OnClickListener {
    private Button btnSave;
    private EditText edtName,edtPunchSpeed,edtPunchPower,edtKickSpeed,edtKickPower;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        btnSave=findViewById(R.id.btnsave);

        edtName=findViewById(R.id.edtName);
        edtKickSpeed=findViewById(R.id.edtKickSpeed);
        edtKickPower=findViewById(R.id.edtKickPower);
        edtPunchSpeed=findViewById(R.id.edtPunchSpeed);
        edtPunchPower=findViewById(R.id.edtPunchPower);


        btnSave.setOnClickListener(SignUp.this);
    }

    @Override
    public void onClick(View v) {



        try {
            final ParseObject Kickboxer = new ParseObject("KickBoxer");
            Kickboxer.put("name", edtName.getText().toString());
            Kickboxer.put("punch_speed", Integer.parseInt(edtPunchSpeed.getText().toString()));
            Kickboxer.put("punch_power", Integer.parseInt(edtPunchPower.getText().toString()));
            Kickboxer.put("kick_speed", Integer.parseInt(edtKickSpeed.getText().toString()));
            Kickboxer.put("kick_power", Integer.parseInt(edtKickPower.getText().toString()));


            Kickboxer.saveInBackground(new SaveCallback() {
                @Override
                public void done(ParseException e) {
                    if (e == null) {
                        FancyToast.makeText(SignUp.this, "successful", FancyToast.LENGTH_LONG, FancyToast.SUCCESS, true).show();
                    } else {

                        FancyToast.makeText(SignUp.this, e.getMessage(), FancyToast.LENGTH_LONG, FancyToast.ERROR, true).show();
                    }

                }
            });
        } catch (Exception e) {
            FancyToast.makeText(SignUp.this, e.getMessage(), FancyToast.LENGTH_LONG, FancyToast.ERROR, true).show();
        }
    }


//    public void HelloWorldTapped(View textView){
//
//
////        ParseObject boxer=new ParseObject("Boxer");
////        boxer.put("punch_speed",200);
////
////        boxer.saveInBackground(new SaveCallback() {
////            @Override
////            public void done(ParseException e) {
////                if (e==null){
////                    Toast.makeText(SignUp.this,"Boxer class Successful",Toast.LENGTH_SHORT).show();
////                }
////            }
////        });
//
//
//
//        }
        }
