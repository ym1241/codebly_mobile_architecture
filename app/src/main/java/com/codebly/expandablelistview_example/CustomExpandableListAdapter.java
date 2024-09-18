package com.codebly.expandablelistview_example;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

public class CustomExpandableListAdapter extends BaseExpandableListAdapter {
    // 어댑터가 속한 액티비티의 컨텍스트.
    private Context context;
    //부모 리스트 항목들.
    private List<String> listDataHeader;
    // 부모와 자식 리스트를 매핑한 데이터 구조.
    private HashMap<String, List<String>> listHashMap;
    public CustomExpandableListAdapter(Context context, List<String>listDataHeader,
                                       HashMap<String, List<String>>listHashMap){
        this.context = context;
        this.listDataHeader = listDataHeader;
        this.listHashMap = listHashMap;
    }
    //부모 항목의 개수를 반환
    @Override
    public int getGroupCount() {
        return listDataHeader.size();
    }
    //특정 부모할목에 속한 자식 항목의 개수를 반환
    @Override
    public int getChildrenCount(int groupPosition) {
        return listHashMap.get(listDataHeader.get(groupPosition)).size();
    }

    //부모 항목을 반환
    @Override
    public Object getGroup(int groupPosition) {
        return listDataHeader.get(groupPosition);
    }
    //특정 부모 항목에 속한 자식 항목을 반환
    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return listHashMap.get(listDataHeader.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }
    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }
    // getGroupView() : 부모 항목의 레이아웃을 정의
    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        // headerTitle : 현재 부모 항목의 이름.
        String headerTitle = (String) getGroup(groupPosition);
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            // convertiew : 리스트 아이템이 재사용되도록 하는 뷰 객체,
            //null 일때만 새로운 뷰를 생성함.
            convertView = inflater.inflate(android.R.layout.simple_expandable_list_item_1, null);
        }
        TextView textView = convertView.findViewById(android.R.id.text1);
        // 부모 항목의 텍스트를 설정합니다.
        textView.setText(headerTitle);
        return convertView;
    }


    //자식항목의 레이아웃을 정의.
    // 부모 항목을 확장했을때, 보여지는 자식 항목의 레이아웃.
    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        // childText : 자식 항목의 텍스트 데이터를 가져옴.
        final String childText = (String) getChild(groupPosition, childPosition);

        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(android.R.layout.simple_expandable_list_item_1, null);
        }

        TextView textView = convertView.findViewById(android.R.id.text2);
        // textView.setText(childText); 자식 항목의 텍스트를 설정합니다.
        textView.setText(childText);
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
