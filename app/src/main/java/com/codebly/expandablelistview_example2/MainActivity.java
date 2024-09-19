package com.codebly.expandablelistview_example2;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.os.Bundle;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ExpandableListView expandableListView;
    ExpandableListAdapter expandableListAdapter;
    List<String> listDataHeader;
    HashMap<String, List<String>> listHashMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        expandableListView = findViewById(R.id.expandableListView);
        initData();
        expandableListAdapter = new CustomExpandableListAdapter(this, listDataHeader, listHashMap);
        expandableListView.setAdapter(expandableListAdapter);
    }
    private void initData() {
        listDataHeader = new ArrayList<>();
        listHashMap = new HashMap<>();

        listDataHeader.add("Fruits");
        listDataHeader.add("Vegetables");
        listDataHeader.add("Dairy");
        //추가해본것 : 추가한게 문제가 있었던것. 다음에는 잠시라도 못하게 하자
        listDataHeader.add("question2");

        List<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orangeㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇ");

        List<String> vegetables = new ArrayList<>();
        vegetables.add("Carrot");
        vegetables.add("Broccoli");
        vegetables.add("Spinach");

        List<String> dairy = new ArrayList<>();
        dairy.add("Milk");
        dairy.add("Cheese");
        dairy.add("Yogurt");

        List<String> question2 = new ArrayList<>();
        question2.add("ㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇ"); //아니 이럼 키값이 되어버리잖아 그래서 숫자만 나온거 아녀
        question2.add("question2");
        question2.add("question2");

        listHashMap.put(listDataHeader.get(0), fruits);
        listHashMap.put(listDataHeader.get(1), vegetables); //이걸 0으로 넣었었음. 씨발 이걸 어케 기억하냐
        listHashMap.put(listDataHeader.get(2), dairy);
        listHashMap.put(listDataHeader.get(3), question2);

        /*
        앞으로 리스트가 추가된다면 여기에 상속해서 재사용하면됩니다.
        public void initData(){
            listDataHeader.add("question2");

            List<String> question2 = new ArrayList<>();
            question2.add("");

            listHashMap.put(listDataHeader.get(3), question2);
        }
         */
    }
}