package com.example.plnatsub;

import android.nfc.Tag;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class SearchResult extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    public ArrayList<SearchData> arrayList;
    //private FirebaseDatabase database;
    //private DatabaseReference databaseReference;
    private static final String TAG = SearchResult.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);

        new HttpAsyncTask().execute("http://192.168.10.111:3000/SearchData");

        recyclerView = findViewById(R.id.my_recycler_view);


        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        //arrayList = new HttpAsyncTask().arrayList;
        arrayList = new ArrayList<>();


        // specify an adapter (see also next example)
        adapter = new SearchResultAdapter(arrayList, this);
        recyclerView.setAdapter(adapter);



/* //파이어베이스
        database = FirebaseDatabase.getInstance(); //파이어베이스 데이터베이스 연동
        databaseReference = database.getReference("searchResert"); //DB테이블 연결
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //파이어베이스 데이터 받아오는 곳
                arrayList.clear(); //기존 배열 초기화
                for(DataSnapshot snapshot : dataSnapshot.getChildren()){ //반복문으로 데이터리스트를 추출해냄
                    SearchData searchData = snapshot.getValue(SearchData.class); //만들어 줬던 데이터객체를 담는다.
                    arrayList.add(searchData); //담을 데이터들을 배열에 넣고 리사이클러뷰로 전송할준비
                }
                adapter.notifyDataSetChanged(); //리스트 저장및 새로고침
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.e("MyPlantBook", String.valueOf(databaseError.toException()));
            }
        });

 */

    }
    public static class HttpAsyncTask extends AsyncTask<String, Void, String>{

        OkHttpClient Client = new OkHttpClient();
        ArrayList<SearchData> arrayList = new ArrayList<>();

        @Override
        protected String doInBackground(String... params) {
            String result = null;
            String strUrl = params[0];


            try {
            Request request = new Request.Builder()
                    .url(strUrl)
                    .build();

            Response response = Client.newCall(request).execute();
            Gson gson = new Gson();

            Type listType = new TypeToken<ArrayList<SearchData>>() {}.getType();

            arrayList = gson.fromJson(response.body().string(), listType);

                Log.d(TAG,"doInBackground" +  arrayList.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }

            return result;
        }
        protected void onPostExcute(String str){
            super.onPostExecute(str);
        }
    }

}
