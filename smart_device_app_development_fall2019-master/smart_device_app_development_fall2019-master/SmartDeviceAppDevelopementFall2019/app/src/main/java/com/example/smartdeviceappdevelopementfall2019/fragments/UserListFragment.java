package com.example.smartdeviceappdevelopementfall2019.fragments;


import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.smartdeviceappdevelopementfall2019.LoginActivity;
import com.example.smartdeviceappdevelopementfall2019.R;
import com.example.smartdeviceappdevelopementfall2019.adapters.Adapter_class;
import com.example.smartdeviceappdevelopementfall2019.entity.Employee;
import com.example.smartdeviceappdevelopementfall2019.entity.EmployeeRoot;
import com.example.smartdeviceappdevelopementfall2019.models.Adapter_data_models;
import com.example.smartdeviceappdevelopementfall2019.util.CommonConstant;
import com.google.gson.Gson;
import com.squareup.okhttp.OkHttpClient;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.ExecutionException;

/**
 * A simple {@link Fragment} subclass.
 */
public class UserListFragment extends Fragment {

    private ArrayList<Adapter_data_models> mylist=new ArrayList<>();
    private RecyclerView recyclerView;
    private ProgressDialog progressDialog;
    private ArrayList<Employee> employees ;
    private EmployeeRoot employeeRoot;



    public UserListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_user_list, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recyclerViewId);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }
    /*private void intilization(){
        mylist.add(new Adapter_data_models("Joniyed",1234));
        mylist.add(new Adapter_data_models("Joniyed",123,true));
        mylist.add(new Adapter_data_models("Joniyed",12,true));
        mylist.add(new Adapter_data_models("Joniyed",1,true));
        mylist.add(new Adapter_data_models("Joniyed",1234,true));
        mylist.add(new Adapter_data_models("Joniyed",1234,true));        mylist.add(new Adapter_data_models("Joniyed",1234));
        mylist.add(new Adapter_data_models("Joniyed",123,true));
        mylist.add(new Adapter_data_models("Joniyed",12,true));
        mylist.add(new Adapter_data_models("Joniyed",1,true));
        mylist.add(new Adapter_data_models("Joniyed",1234,true));
        mylist.add(new Adapter_data_models("Joniyed",1234,true));        mylist.add(new Adapter_data_models("Joniyed",1234));
        mylist.add(new Adapter_data_models("Joniyed",123,true));
        mylist.add(new Adapter_data_models("Joniyed",12,true));
        mylist.add(new Adapter_data_models("Joniyed",1,true));
        mylist.add(new Adapter_data_models("Joniyed",1234,true));
        mylist.add(new Adapter_data_models("Joniyed",1234,true));        mylist.add(new Adapter_data_models("Joniyed",1234));
        mylist.add(new Adapter_data_models("Joniyed",123,true));
        mylist.add(new Adapter_data_models("Joniyed",12,true));
        mylist.add(new Adapter_data_models("Joniyed",1,true));
        mylist.add(new Adapter_data_models("Joniyed",1234,true));
        mylist.add(new Adapter_data_models("Joniyed",1234,true));
    }*/

    @Override
    public void onResume() {
        super.onResume();
        //new WebAPI().execute();

        callServerForData();
    }

    /*class WebAPI extends AsyncTask<Void,Void, JSONArray>{

        @Override
        protected void onPreExecute() {
            progressDialog = new ProgressDialog(getActivity());
            progressDialog.setMessage("Loading...");
            progressDialog.setCancelable(false);
            progressDialog.show();
        }

        @Override
        protected JSONArray doInBackground(Void... voids) {

            try {
                OkHttpClient client = new OkHttpClient();
                Request request = new Request.Builder()
                        .url(CommonConstant.EMPLOYEE_LIST)
                        .build();
                Response response = client.newCall(request).execute();
                if(response.isSuccessful()){
                    return new JSONArray(response.body().string());
                }
            }catch (Exception e){
                Log.e(CommonConstant.TAG,e.toString());
            }



            return null;
        }

        @Override
        protected void onPostExecute(JSONArray jsonArray) {
            progressDialog.dismiss();
            try {
                if (jsonArray != null) {
                    employees = new ArrayList<>();

                    for (int i = 0; i < jsonArray.length(); i++) {
                        Employee employee = new Employee();
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        employee.setId(Integer.parseInt(jsonObject.getString("id")));
                        employee.setAge(jsonObject.getString("employee_age"));
                        employee.setName(jsonObject.getString("employee_name"));
                        employee.setProfilepicture(jsonObject.getString("profile_image"));
                        employee.setSalary(jsonObject.getString("employee_salary"));


                        employees.add(employee);
                    }

                    recyclerView.setAdapter(new Adapter_class(employees,getActivity()));
                }
            }catch (Exception e){
                Log.e(CommonConstant.TAG,e.toString());
            }
        }*/



    private  void callServerForData(){
        try {
            progressDialog = new ProgressDialog(getActivity());
            progressDialog.setMessage("Loading...");
            progressDialog.setCancelable(false);

            RequestQueue requestQueue = Volley.newRequestQueue(Objects.requireNonNull(getActivity()));
            JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET,
                    CommonConstant.EMPLOYEE_LIST,
                    null,
                    new Response.Listener<JSONArray>() {
                        @Override
                        public void onResponse(JSONArray response) {
                            try {
                                employeeRoot = new EmployeeRoot();
                                for (int i = 0; i < response.length(); i++) {
                                    Employee employee = new Gson().
                                            fromJson(response.get(i).toString(), Employee.class);
                                    employeeRoot.employees.add(employee);
                                    recyclerView.setAdapter(new Adapter_class(employeeRoot.employees, getActivity()));
                                    progressDialog.dismiss();
                                }
                            } catch (Exception e) {
                                Log.d("jb", e.toString());
                            }
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                        }
                    }
            );
            requestQueue.add(jsonArrayRequest);
            progressDialog.show();
        }catch (Exception e){
            Log.d("jb",e.toString());
        }
    }
}