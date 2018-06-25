package com.example.jayhind.lecture_app.apidemo;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Jay Hind on 4/25/2018.
 */

public class MyAsyncTask extends AsyncTask <String,Integer,String>{
    ProgressDialog pd;
    private Context context;
    HashMap<String,String> hm;
    OnPublicListener listener;

    public HashMap<String, String> getHm() {
        return hm;
    }

    public void setHm(HashMap<String, String> hm) {
        this.hm = hm;
    }
    public MyAsyncTask(Context context,OnPublicListener Listener) {
        this.context = context;
        this.listener=Listener;
    }

    @Override
   protected String doInBackground(String... strings) {
        OkHttpClient okhttp=new OkHttpClient();
      //Request r=new Request.Builder().url(strings[0]).build();//for get method // remove comment for execute api ativity
        Request.Builder b=new Request.Builder().url(strings[0]);
        if(hm!=null)
        {
            FormBody.Builder fb=new FormBody.Builder();
            for (Map.Entry<String,String> entry : hm.entrySet()) {
                fb.add(entry.getKey(),entry.getValue());
            }
            b.post(fb.build());

        }
        Request r=b.build();
        try {
            Response rs=okhttp.newCall(r).execute();
            String result=rs.body().string();
            return result;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPreExecute() {
        pd= ProgressDialog.show(context,"wait","loading");
        super.onPreExecute();
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(String s) {
        //s is result of responde data............
        super.onPostExecute(s);
        pd.dismiss();
        listener.onRespone(s);
    }



    public interface OnPublicListener
    {
        public void onRespone(String result);
    }
}
