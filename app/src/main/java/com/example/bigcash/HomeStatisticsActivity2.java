package com.example.bigcash;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


import java.util.ArrayList;

public class HomeStatisticsActivity2 extends AppCompatActivity {
    private WebView webView;
    private Button btn;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_statistics);
        imageView = findViewById(R.id.imageView);
//        Button btn = findViewById(R.id.btn);
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Bitmap b = Screenshot.takescreenshotOfRootView(imageView);
//                imageView.setImageBitmap(b);
//            }
//        });

        webView = (WebView) findViewById(R.id.webviewStats);
        webView.setWebViewClient(new WebViewClient());

        webView.loadUrl("https://cashstatistics.herokuapp.com/");
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
    }
    @Override
    public void onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
        }

    }
}

//    EditText xValue, yValue;
//    Button insertBtn;
//    LineChart mpLineChart;
//    FirebaseDatabase firebaseDatabase;
//    DatabaseReference Ref;
//    LineDataSet lineDataSet = new LineDataSet(null, null);
//    ArrayList<ILineDataSet> iLineDataSets = new ArrayList<>();
//    LineData lineData;



//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_home_statistics);


//        xValue = findViewById(R.id.x_value);
//        yValue = findViewById(R.id.y_value);
//        insertBtn = findViewById(R.id.btn_insert);
//        mpLineChart = findViewById(R.id.line_chart);
//        firebaseDatabase = FirebaseDatabase.getInstance();
//       Ref = firebaseDatabase.getReference("ChartValues");
//        insertData();
//
//    }
//
//
//        private void insertData() {
//            insertBtn.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    String id = Ref.push().getKey();
//                    int x = Integer.parseInt(xValue.getText().toString());
//                    int y = Integer.parseInt(yValue.getText().toString());
//
//                    DataPoint dataPoint = new DataPoint(x, y);
//                    Ref.child(id).setValue(dataPoint);
//
//                    retrieveData();
//                }
//            });
//
//
//        }
//        private void retrieveData () {
//            Ref.addValueEventListener(new ValueEventListener() {
//                @Override
//                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                    ArrayList<Entry> dataVals = new ArrayList<Entry>();
//
//                    if (dataSnapshot.hasChildren()) {
//                        for (DataSnapshot myDataSnapshot : dataSnapshot.getChildren()) {
//                            DataPoint dataPoint = myDataSnapshot.getValue(DataPoint.class);
//                            dataVals.add(new Entry(dataPoint.getxValue(), dataPoint.getyValue()));
//                        }
//                        showChart(dataVals);
//                    } else {
//                        mpLineChart.clear();
//                        mpLineChart.invalidate();
//                    }
//                }
//
//                @Override
//                public void onCancelled(@NonNull DatabaseError error) {
//
//                }
//            });
//
//        }
//
//        private void showChart(ArrayList < Entry > dataVals) {
//            lineDataSet.setValues(dataVals);
//            lineDataSet.setLabel("The trend of spending over time");
//            iLineDataSets.clear();
//            iLineDataSets.add(lineDataSet);
//            lineData = new LineData(iLineDataSets);
//            mpLineChart.clear();
//            mpLineChart.setData(lineData);
//            mpLineChart.invalidate();
//
//        }
//    }
//

