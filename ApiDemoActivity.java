package com.example.jayhind.lecture_app.apidemo;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.jayhind.lecture_app.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ApiDemoActivity extends AppCompatActivity implements MyAsyncTask.OnPublicListener {
    String url="https://newsapi.org/v2/top-headlines?country=us&category=business&apiKey=0c2367225d2440619d16b78342b56ab6";
    private Context context;
    ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_api_demo);
        context=this;
        listview=findViewById(R.id.dispdata);
        MyAsyncTask myasc=new MyAsyncTask(context,this);
        myasc.execute(url);
    }

    @Override
    public void onRespone(String result) {
        try {
            JSONObject js=new JSONObject(result);//this is main obj
            //status is one of the paramters of maain object which indicates full response data(json data).
            String status=js.getString("status");

            ArrayList<Articles> as=new ArrayList<>();
            ArrayList<String> as1=new ArrayList<>();
            if (status.equals("ok")) {
                JSONArray ary= js.getJSONArray("articles");
                for(int i=0;i<ary.length();i++)
                {
                    Articles a=new Articles();
                    JSONObject subobj=ary.getJSONObject(i);
                    a.setAuthor(subobj.getString("author"));
                    a.setTitle(subobj.getString("title"));
                    as.add(a);
                    as1.add(subobj.getString("author"));
                }
                ArrayAdapter<Articles> adapter=new ArrayAdapter<>(context,android.R.layout.simple_list_item_1,as);
                listview.setAdapter(adapter);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }


    }
}
