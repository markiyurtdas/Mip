package com.marki.mipan.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.marki.mipan.R;
import com.marki.mipan.model.Applies;
import com.marki.mipan.model.Company;
import com.marki.mipan.model.Event;
import com.marki.mipan.model.Guest;
import com.marki.mipan.model.JobAds;
import com.marki.mipan.model.Member;
import com.marki.mipan.model.Survey;

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
        sendUser.put("birthdate",member.getBirthdate());
        sendUser.put("city",member.getCity());
        sendUser.put("create_date",System.currentTimeMillis()/1000L);
        sendUser.put("email",member.getEmail());
        sendUser.put("full_name",member.getFull_name());
        sendUser.put("has_usename",member.isHas_username());
        sendUser.put("is_guest",member.isIs_guest());
        sendUser.put("mip_coin",member.getMip_coin());
        sendUser.put("password",member.getPassword());
        sendUser.put("sex",member.getSex());
        sendUser.put("type",member.getType());
        sendUser.put("username",member.getUsername());





        member.dbRef.child("mip")
                .child("member")
                .child(member.getUsername())
                .setValue(sendUser);

    }

    private void sendGuestToFB() {
        Guest guest = new Guest();
        HashMap<String, Object> sendUser = new HashMap<>();
        sendUser.put("create_date",guest.getCreate_date());
        sendUser.put("has_username",guest.isHas_username());
        sendUser.put("is_guest",guest.isIs_guest());
        sendUser.put("open_date",guest.getOpen_date());
        sendUser.put("type",guest.getType());
        sendUser.put("username",guest.getUsername());





        guest.dbRef.child("mip")
                .child("guest")
                .child(guest.getUsername())
                .setValue(sendUser);
    }
    private void sendEventToFB() {
        Event event = new Event();
        HashMap<String, Object> sendUser = new HashMap<>();
        sendUser.put("date",event.getDate());
        sendUser.put("description",event.getDescription());
        sendUser.put("title",event.getTitle());
        sendUser.put("location",event.getLocation());
        sendUser.put("users",event.getUsers());
        sendUser.put("event_id",event.getEvent_id());





        event.dbRef.child("mip")
                .child("event")
                .child(event.getEvent_id())
                .setValue(sendUser);
    }
    private void sendJobAdsToFB() {
        JobAds jobAds = new JobAds();
        HashMap<String, Object> sendUser = new HashMap<>();
        sendUser.put("company",jobAds.getCompany());
        sendUser.put("company_mail",jobAds.getCompany_mail());
        sendUser.put("created_date",jobAds.getCreated_date());
        sendUser.put("description",jobAds.getDescription());
        sendUser.put("end_date",jobAds.getEnd_date());
        sendUser.put("photo_url",jobAds.getPhoto_url());
        sendUser.put("title",jobAds.getTitle());
        sendUser.put("type",jobAds.getType());





        jobAds.dbRef.child("mip")
                .child("job_ad")
                .child(jobAds.getJob_id())
                .setValue(sendUser);
    }
    private void sendSurveyToFB() {
        Survey survey = new Survey();
        HashMap<String, Object> sendUser = new HashMap<>();
        sendUser.put("survey_id",survey.getSurvey_id());
        sendUser.put("company_mail",survey.getCreated_date());
        sendUser.put("created_date",survey.getCreator_username());
        sendUser.put("description",survey.getDescription());
        sendUser.put("end_date",survey.getEnd_date());
        sendUser.put("mip_coin",survey.getPhoto_url());
        sendUser.put("questions",survey.getQuestions());
        sendUser.put("title",survey.getTitle());





        jobAds.dbRef.child("mip")
                .child("survey")
                .child(survey.getSurvey_id())
                .setValue(sendUser);
    }
    private void sendCompanyToFB() {
        Company company = new Company();
        HashMap<String, Object> sendUser = new HashMap<>();
        sendUser.put("address",company.getAddress());
        sendUser.put("company_name",company.getCompany_name());
        sendUser.put("job_list",company.getJob_list());
        sendUser.put("location",company.getLocation());
        sendUser.put("photos",company.getPhotos());





        jobAds.dbRef.child("mip")
                .child("company")
                .child(company.getCompany_id())
                .setValue(sendUser);
    }
    private void sendAppliesToFB() {
        Applies applies = new Applies();
        HashMap<String, Object> sendUser = new HashMap<>();
        sendUser.put("address",applies.getAddress());
        sendUser.put("company_name",applies.getCompany_name());
        sendUser.put("job_list",applies.getJob_list());
        sendUser.put("location",applies.getLocation());
        sendUser.put("photos",applies.getPhotos());





        jobAds.dbRef.child("mip")
                .child("applies")
                .child(applies.getApply_id())
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