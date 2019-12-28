package com.marki.mipan;

import java.util.ArrayList;
import java.util.List;

public class Constants {

    public static List<String> getTypes=new ArrayList<>();

    /*
    *
    *  mUser.getDbRef().child("prizenstacampaigns")
                    .child(selectedId)
                    .setValue(createdCampaign);
                    *
                    *
            mUser.getDbRef().child("gildausers")
                    .child(mUser.getUserID())
                    .child("campaigns")
                    .child(selectedId)
                    .updateChildren(createdCampaign);
    *
    * */


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
}
