package test.co.cristiangarcia.testapp;

import android.app.ProgressDialog;
import android.content.Context;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class Services {

    ProgressDialog progress=null;

    public void  showMessage(Context context, final TextView responseText){


        progress = new ProgressDialog(context);
        progress.setTitle("Loading");
        progress.setMessage("Wait while loading...");
        progress.setCancelable(false); // disable dismiss by tapping outside of the dialog
        progress.show();


        RequestQueue queue = Volley.newRequestQueue(context);
        String url ="https://alquilerdirecto.com.ar/testresponse";

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONObject obj = new JSONObject(response);
                            progress.dismiss();


                            responseText.setText(obj.getString("response"));

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                responseText.setText("That didn't work! "+error);
            }
        });

// Add the request to the RequestQueue.
        queue.add(stringRequest);


    }
}
