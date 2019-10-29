package com.example.mymoveleview.CustomerService;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.mymoveleview.R;

import java.util.ArrayList;
import java.util.List;


public class CustomerServiceFragment_4 extends Fragment {

    private RecyclerView recyclerview;
    private Context mContext;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        LinearLayout layout = (LinearLayout) inflater.inflate(R.layout.fragment_customer_service_fragment_4, container, false);

        mContext = getContext();
        recyclerview = layout.findViewById(R.id.recyclerview);

        recyclerview.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false));
        List<CustomerServiceListAdapter.Item> data = new ArrayList<>();


        CustomerServiceListAdapter.Item places = new CustomerServiceListAdapter.Item(CustomerServiceListAdapter.HEADER, "VIP 선정이 월별로 진행되면 매월 VIP가 되는 건가요?");
        places.invisibleChildren = new ArrayList<>();
        places.invisibleChildren.add(new CustomerServiceListAdapter.Item(CustomerServiceListAdapter.CHILD, "아닙니다 선정 시점이 매월로 변경될 뿐 선정이 되고 나서 VIP 유지 기간은 1년으로 동일합니다\n" +
                "일반등급의 고객님에 한해 매월 구매 누적 포인트를 집계하고 VIP 고객님에 대해서는 VIP 등급을 획득하신 시점부터\n" +
                "다시 선정 포인트를 집계하게 됩니다"));

        CustomerServiceListAdapter.Item places1 = new CustomerServiceListAdapter.Item(CustomerServiceListAdapter.HEADER, "일반 고객의 VIP 선정 최근 1년의 정확한 날짜 기준이 궁금합니다");
        places1.invisibleChildren = new ArrayList<>();
        places1.invisibleChildren.add(new CustomerServiceListAdapter.Item(CustomerServiceListAdapter.CHILD, "일반고객의 선정 시점은 최근 1년 월별 선정이며 만약 17년 4월 VIP 이면 \n"+
                "16년 4월 1일~17년 3월 31일까지의 선정 포인트 기준으로 집계합니다"));

        CustomerServiceListAdapter.Item places2 = new CustomerServiceListAdapter.Item(CustomerServiceListAdapter.HEADER, "VIP 선정 포인트 기준을 알고 싶어요");
        places2.invisibleChildren = new ArrayList<>();
        places2.invisibleChildren.add(new CustomerServiceListAdapter.Item(CustomerServiceListAdapter.CHILD, "CGV에서 구매한 누적포인트를 기준으로 기존과 동일하게 영화관람(5%), 매점이용(2%), 씨네샵이용(2%) 입니다.\n" +
                "추가적으로 일반적인 이벤트 등을 통해서 적립한 포인트는 제외됩니다"));

        CustomerServiceListAdapter.Item places3 = new CustomerServiceListAdapter.Item(CustomerServiceListAdapter.HEADER, "VIP 선정 포인트는 VIP가 되고 나서 유지 되나요?");
        places3.invisibleChildren = new ArrayList<>();
        places3.invisibleChildren.add(new CustomerServiceListAdapter.Item(CustomerServiceListAdapter.CHILD, " VIP가 선정된 이후 선정 포인트는 0으로 리셋되며 선정된 달부터 다시 선정 포인트가 누적 됩니다 "));


        CustomerServiceListAdapter.Item places4 = new CustomerServiceListAdapter.Item(CustomerServiceListAdapter.HEADER, "일반 고객이 RVIP나 VVIP(SVIP)로 바로 승급될 수 있는 방법은 없나요?");
        places4.invisibleChildren = new ArrayList<>();
        places4.invisibleChildren.add(new CustomerServiceListAdapter.Item(CustomerServiceListAdapter.CHILD, "일반 고객님은 최근 1년 누적 포인트 14,000점을 달성하시어 VIP로 먼저 승급하신 이후\n" +
                "순차적으로 높은 등급으로 승급하실 수 있습니다."));

        CustomerServiceListAdapter.Item places5 = new CustomerServiceListAdapter.Item(CustomerServiceListAdapter.HEADER, "VIP 선정 이후에 VIP 혜택은 언제 받게 되나요?");
        places5.invisibleChildren = new ArrayList<>();
        places5.invisibleChildren.add(new CustomerServiceListAdapter.Item(CustomerServiceListAdapter.CHILD, "VIP 선정 이후 VIP 온라인 쿠폰북, 반값할인, 더블적립 등 다양한 VIP 혜택은 바로 이용이 가능합니다"));

        data.add(places);
        data.add(places1);
        data.add(places2);
        data.add(places3);
        data.add(places4);
        data.add(places5);

        recyclerview.setAdapter(new CustomerServiceListAdapter(data));



        return layout;
    }

}
