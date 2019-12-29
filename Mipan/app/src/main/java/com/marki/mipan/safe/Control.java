package com.marki.mipan.safe;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import com.marki.mipan.Interface.JsonPlaceHoldeApi;
import com.marki.mipan.ModelRest.Model;
import com.marki.mipan.ModelRest.Restaurant;
import com.marki.mipan.R;
import com.marki.mipan.activities.Chat;
import com.marki.mipan.model.AnswerList;
import com.marki.mipan.model.Applies;
import com.marki.mipan.model.Company;
import com.marki.mipan.model.Event;
import com.marki.mipan.model.FoodMenuWeek;
import com.marki.mipan.model.JobAds;
import com.marki.mipan.model.Member;
import com.marki.mipan.ui.FragmentMainActivity;
import java.util.ArrayList;
import com.marki.mipan.model.Survey;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Control extends AppCompatActivity {
    public static ArrayList<Event> eventList = new ArrayList<>();
    public static ArrayList<JobAds> jobList = new ArrayList<>();
    public static ArrayList<Applies> appliesList = new ArrayList<>();
    public static ArrayList<Company> companyList = new ArrayList<>();
    public static ArrayList<Survey> surveyList = new ArrayList<>();
    public static ArrayList<Member> memberList = new ArrayList<>();
    public static ArrayList<String> messageUsers = new ArrayList<>();
    public static ArrayList<FoodMenuWeek> foodMenuList = new ArrayList<>();
    private static List<Restaurant> restList;





    Member member = Member.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control);
        Intent i = getIntent();
        member.setUsername(i.getStringExtra("username"));

        synUser();

        startActivity(new Intent(Control.this,FragmentMainActivity.class));
    }

    private void synUser() {
        getFoodMenu();
        getEvents();
        getJobAds();
        getApplies();
        getCompanies();
        getSurvey();
        getRestaurants();
        getMember();
    }

    public void getFoodMenu(){
        member.dbRef.child("mip")
                .child("food_menu_week")
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        for (DataSnapshot postSnapShot : dataSnapshot.getChildren()) {
                            FoodMenuWeek myj = postSnapShot.getValue(FoodMenuWeek.class);
                            foodMenuList.add(myj);
                        }
                        System.out.println("bbc" + foodMenuList.toString());
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

        startActivity(new Intent(Control.this, FragmentMainActivity.class));

    }

    public void getEvents(){

        member.dbRef.child("mip")
                .child("event")
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        for (DataSnapshot postSnapShot : dataSnapshot.getChildren()) {
                            Event myj = postSnapShot.getValue(Event.class);
                            eventList.add(myj);
                            System.out.println("bbc" + eventList.toString());
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });


    }
    public void getJobAds() {


        member.dbRef.child("mip")
                .child("job_ad")
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        for (DataSnapshot postSnapShot : dataSnapshot.getChildren()) {
                            JobAds myj = postSnapShot.getValue(JobAds.class);
                            jobList.add(myj);

                        }
                        System.out.println(jobList.toString());
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

    }
    public void getApplies() {
        member.dbRef.child("mip")
                .child("applies")
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        for (DataSnapshot postSnapShot : dataSnapshot.getChildren()) {
                            Applies myj = postSnapShot.getValue(Applies.class);
                            appliesList.add(myj);
                            System.out.println(appliesList.toString());
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

    }
    public void getCompanies() {
        member.dbRef.child("mip")
                .child("company")
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        for (DataSnapshot postSnapShot : dataSnapshot.getChildren()) {
                            Company myj = postSnapShot.getValue(Company.class);
                            companyList.add(myj);
                            System.out.println("compan" + companyList.toString());
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

    }
    public void getSurvey() {
        member.dbRef.child("mip")
                .child("survey")
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        for (DataSnapshot postSnapShot : dataSnapshot.getChildren()) {
                            Survey myj = postSnapShot.getValue(Survey.class);
                            surveyList.add(myj);

                        }
                        System.out.println("surveyList" + surveyList.toString());
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

    }
    public void getMember(){

        member.dbRef.child("mip")
                .child("member")
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        for (DataSnapshot postSnapShot : dataSnapshot.getChildren()) {
                            Member myj = postSnapShot.getValue(Member.class);
                            memberList.add(myj);
                            try {
                                if (member.getUsername().equals(member.getUsername())){
                                    member=myj;
                                }
                            }catch (NullPointerException npExc){
                                npExc.printStackTrace();
                            }

                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });


    }

    public void getRestaurants(){
        //Generate Retrofit object
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://developers.zomato.com/api/v2.1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        //Retrofit create method with Json Api
        JsonPlaceHoldeApi jsonPlaceHoldeApi = retrofit.create(JsonPlaceHoldeApi.class);
        //restaurant search with call
        Call <Model> call = jsonPlaceHoldeApi.getPosts(5,35,27,10000,"real_distance","asc");
        //take response
        call.enqueue(new Callback<Model>() {

            @Override
            public void onResponse(Call <Model> call, Response<Model> response) {
                //if response is not successful
                if(!response.isSuccessful()){


                }
                //bind response with Model object
                Model model = response.body();
                //bind restaurants list with resList
                restList = model.restaurants;
                for(int i = 0;i<restList.size();i++) {
                    System.out.println("baba" + restList.get(i).restaurant.name.toString());
                }
            }

            @Override
            // if response fail
            public void onFailure(Call<Model> call, Throwable t) {

            }

        });
    }


}

