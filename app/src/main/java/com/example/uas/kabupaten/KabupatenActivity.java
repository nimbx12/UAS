package com.example.uas.kabupaten;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONArrayRequestListener;
import com.example.uas.R;
import com.example.uas.network.ApiServices;
import com.example.uas.utils.Constant;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/*
    NIM     : 10122914
    Nama    : Dwi Nurcahyo
    Kelas   : AKB IF-10
 */
public class KabupatenActivity extends AppCompatActivity {

    Toolbar toolbar;
    RecyclerView rvDaftarKabupaten;
    List<ModelKabupaten> modelKabupatenList = new ArrayList<>();
    KabupatenAdapter kabupatenAdapter;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kabupaten);

        toolbar = findViewById(R.id.toolbar);
        rvDaftarKabupaten = findViewById(R.id.rvDaftarKabupaten);

        setSupportActionBar(toolbar);
        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Provinsi " + Constant.provinsiName);

        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Mohon Tunggu...");
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Sedang menampilkan data");

        kabupatenAdapter = new KabupatenAdapter(this, modelKabupatenList);
        rvDaftarKabupaten.setLayoutManager(new LinearLayoutManager(this));
        rvDaftarKabupaten.setHasFixedSize(true);
        rvDaftarKabupaten.setAdapter(kabupatenAdapter);

        getListKabupaten(Constant.provinsiId);
    }

    private void getListKabupaten(String strIdProv) {
        progressDialog.show();
        AndroidNetworking.get(ApiServices.BASEURL_KAB)
                .addPathParameter("id_provinsi", strIdProv)
                .setPriority(Priority.HIGH)
                .build()
                .getAsJSONArray(new JSONArrayRequestListener() {
                    @Override
                    public void onResponse(JSONArray response) {
                        progressDialog.dismiss();
                        try {
                            for (int i = 0; i < response.length(); i++) {
                                JSONObject object = response.getJSONObject(i);
                                ModelKabupaten dataApi = new ModelKabupaten();

                                dataApi.setId(object.getString("id"));
                                dataApi.setNama(object.getString("nama"));
                                modelKabupatenList.add(dataApi);
                            }
                            kabupatenAdapter.notifyDataSetChanged();
                        } catch (JSONException e) {
                            Toast.makeText(KabupatenActivity.this, "Ups, tidak ada data!",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onError(ANError anError) {
                        progressDialog.dismiss();
                        Toast.makeText(KabupatenActivity.this,
                                "Oops, ada yang tidak beres. Coba ulangi beberapa saat lagi.",
                                Toast.LENGTH_SHORT).show();
                    }
                });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}