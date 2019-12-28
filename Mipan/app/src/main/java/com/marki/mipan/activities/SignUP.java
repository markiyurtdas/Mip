package com.marki.mipan.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.marki.mipan.R;
import com.marki.mipan.model.Member;

import java.util.HashMap;

public class SignUP extends AppCompatActivity {

    EditText etUsername;
    EditText etPassword;
    Button btnSignup;
    Member member = Member.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        setUpUI();
    }



    public void setUpUI(){
        etPassword = findViewById(R.id.et_password);
        etUsername = findViewById(R.id.et_username);
        btnSignup = findViewById(R.id.btn_signup);


        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                member.setHas_username(true);
                if (etUsername.getText().toString().length()>4){
                    member.setUsername(etUsername.getText().toString());
                }
                member.setPassword(etPassword.getText().toString());

                sendToFB();
            }
        });



    }

    private void sendToFB() {
        HashMap<String, Object> sendUser = new HashMap<>();
        sendUser.put("username",member.getUsername());
        sendUser.put("password",member.getPassword());
        sendUser.put("create_date",System.currentTimeMillis()/1000L);





        member.dbRef.child("mip")
                .child("member")
                .child(member.getUsername())
                .setValue(sendUser);

    }
}



/*public void parseData(Context mContext){
        try {
            String jsonLocation = AssetJSONFile("data.json", mContext);
            JSONObject formArray = (new JSONObject(jsonLocation));

            JSONArray jArray = formArray.getJSONArray("users");
            for (int i= 0;i<jArray.length();i++) {
                Gson gson = new Gson();
                JSONObject o = (JSONObject) jArray.get(i);
                User tempUser = gson.fromJson(o.toString(), User.class);
                for (int j = 0; j < o.getJSONArray("create_courses").length(); j++) {
                    Course c = gson.fromJson(o.getJSONArray("create_courses").get(j).toString(), Course.class);
                    tempUser.addToCreateCourses(c);
                    kurslar.put(c.getCourse_name(),c);
                }
                for (int j = 0; j < o.getJSONArray("bougth_courses").length(); j++) {
                    Course c = gson.fromJson(o.getJSONArray("bougth_courses").get(j).toString(), Course.class);
                    tempUser.addToBoughtCourses(c);
                }
                kullanicilar.put(tempUser.getUsername(),tempUser);
            }
        } catch (JSONException e) {
            e.printStackTrace();
            System.out.println("zxcStart error");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/