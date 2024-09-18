package com.codebly.expandablelistview_example;

import android.os.Bundle;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    //xml에서 정의된 ExpandableListView.
    ExpandableListView expandableListView;
    //데이터를 ExpandableListView에 바인딩하는 어댑터.
    ExpandableListAdapter expandableListAdapter;
    //부모 항목 데이터를 저장하는 리스트.
    List<String> listDataHeader;
    //부모 항목과 해당 자식 항목 데이터를 저장하는 해시맵, 각 부모 항목에 대해 여러 자식 항목을 매핑.
    HashMap<String, List<String>> listHashMap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //xml에서 ExpandableListView를 가져옴.
        expandableListView = findViewById(R.id.expandableListView);
        //아래에 정의한게 있음.
        initData();
        //다른 패키지에 정의한게 있음.
        expandableListAdapter = new CustomExpandableListAdapter(this, listDataHeader, listHashMap);
        //어댑터를 ExpandableListView에 설정하여 데이터가 표시되도록 함.
        expandableListView.setAdapter(expandableListAdapter);

    }
    /*리스트에 들어갈 데이터를 초기화.
     * 부모 리스트와 그에 대응하는 자식 리스트를 설정하는 함수.
     */
    private void initData(){
        //부모 항목 데이터를 추가.
        listDataHeader = new ArrayList<>();
        listHashMap = new HashMap<>();
        listDataHeader.add("Fruits");
        listDataHeader.add("Vegetables");
        listDataHeader.add("Dairy");
        listDataHeader.add("질문2");

        List<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");

        List<String> vegetables = new ArrayList<>();
        vegetables.add("Carrot");
        vegetables.add("Brocoli");
        vegetables.add("Spinach");

        List<String> dairy = new ArrayList<>();
        dairy.add("Milk");
        dairy.add("Cheese");
        dairy.add("Yogurt");

        List<String> question2 = new ArrayList<>();
        question2.add(String.valueOf((R.string.question2)));

        //부모 항목과 자식 항목을 연결 : fruits항목은 fruits 리스트와 연결됨.
        listHashMap.put(listDataHeader.get(0), fruits);
        listHashMap.put(listDataHeader.get(0), vegetables);
        listHashMap.put(listDataHeader.get(0), dairy);
        listHashMap.put(listDataHeader.get(0), question2);
    }
}