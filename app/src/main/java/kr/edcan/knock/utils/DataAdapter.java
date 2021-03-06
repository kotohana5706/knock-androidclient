package kr.edcan.knock.utils;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import kr.edcan.knock.R;


/**
 * Created by kimok_000 on 2015-10-13.
 */
public class DataAdapter extends ArrayAdapter<ListData> {
    // 레이아웃 XML을 읽어들이기 위한 객체
    private LayoutInflater mInflater;

    public DataAdapter(Context context, ArrayList<ListData> object) {
        // 상위 클래스의 초기화 과정
        // context, 0, 자료구조
        super(context, 0, object);
        mInflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    // 보여지는 스타일을 자신이 만든 xml로 보이기 위한 구문
    @Override
    public View getView(int position, View v, ViewGroup parent) {
        View view = null;
        // 현재 리스트의 하나의 항목에 보일 컨트롤 얻기
        if (v == null) {
            // XML 레이아웃을 직접 읽어서 리스트뷰에 넣음
            view = mInflater.inflate(R.layout.list_content, null);
        } else {
            view = v;
        }
        // 자료를 받는다.
        final ListData data = this.getItem(position);
        if (data != null) {
            TextView text = (TextView) view.findViewById(R.id.title);
            text.setText(data.title);
        }
        return view;
    }
}
