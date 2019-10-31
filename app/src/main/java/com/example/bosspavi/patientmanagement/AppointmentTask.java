package com.example.bosspavi.patientmanagement;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class AppointmentTask {

    Context context;
    String ID;
    ArrayList<Appointment> arrayList = new ArrayList<>();
    String json_url;

    public AppointmentTask(Context context,String id){

        this.context=context;
        ID=id;
        json_url="http://192.168.43.55/hospital/checkAppointment.php?id="+ID;
    }

    public ArrayList<Appointment> getList(){
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, json_url, (String)null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                int count=0;
                if(response.length()!=0) {
                    while (count < response.length()) {
                        try {
                            JSONObject jsonObject = response.getJSONObject(count);

                            Appointment appointment = new Appointment(jsonObject.getString("Name"), jsonObject.getString("Surname"), jsonObject.getString("Phone"), jsonObject.getString("Date"));
                            arrayList.add(appointment);
                            count++;

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }else{
                    Toast.makeText(context,"There is not appointment...",Toast.LENGTH_SHORT).show();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context,"Error...",Toast.LENGTH_SHORT).show();
                error.printStackTrace();
            }
        });
        MySingleton.getInstance(context).addToRequestque(jsonArrayRequest);

    return arrayList;
    }
}
