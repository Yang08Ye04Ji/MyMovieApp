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


public class CustomerServiceFragment_1 extends Fragment {

    private RecyclerView recyclerview;

    private Context mContext;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        LinearLayout layout = (LinearLayout)inflater.inflate(R.layout.fragment_customer_service_fragment_1, container, false);

        mContext = getContext();
        recyclerview = layout.findViewById(R.id.recyclerview);


        recyclerview.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false));
        List<CustomerServiceListAdapter.Item> data = new ArrayList<>();


        CustomerServiceListAdapter.Item places = new CustomerServiceListAdapter.Item(CustomerServiceListAdapter.HEADER, "이미 예매한 내역의 결제수단을 변경하고 싶어요.");
        places.invisibleChildren = new ArrayList<>();
        places.invisibleChildren.add(new CustomerServiceListAdapter.Item(CustomerServiceListAdapter.CHILD, "예매 건 취소 후 재결제 진행해 주셔야 하며, 부분 변경은 불가합니다."));

        CustomerServiceListAdapter.Item places1 = new CustomerServiceListAdapter.Item(CustomerServiceListAdapter.HEADER, "할인되는 카드는 어떤게 있나요?.");
        places1.invisibleChildren = new ArrayList<>();
        places1.invisibleChildren.add(new CustomerServiceListAdapter.Item(CustomerServiceListAdapter.CHILD, "신용카드 및 체크카드 할인\n" +
                                                                                                            "- 400여종 이상의 다양한 할인 카드가 준비되어 있습니다."));

        CustomerServiceListAdapter.Item places2 = new CustomerServiceListAdapter.Item(CustomerServiceListAdapter.HEADER, "어린이 할인은 어떻게 받을 수 있나요?");
        places2.invisibleChildren = new ArrayList<>();
        places2.invisibleChildren.add(new CustomerServiceListAdapter.Item(CustomerServiceListAdapter.CHILD, "어린이 (만 48개월 이상) 관람의 경우, 청소년과 동일한 요금이 적용됩니다."));

        CustomerServiceListAdapter.Item places3 = new CustomerServiceListAdapter.Item(CustomerServiceListAdapter.HEADER, "소방공무원할인은 어떻게 되나요?");
        places3.invisibleChildren = new ArrayList<>();
        places3.invisibleChildren.add(new CustomerServiceListAdapter.Item(CustomerServiceListAdapter.CHILD, "소방 공무원 본인 및 동반 2인\n " +
                                                                                                            "일반영화(2D) 7천원/입체영화(3D) 8천원 관람 가능합니다."));


        CustomerServiceListAdapter.Item places4 = new CustomerServiceListAdapter.Item(CustomerServiceListAdapter.HEADER, "예매 취소를 하였는데 환불이 안된것 같아요");
        places4.invisibleChildren = new ArrayList<>();
        places4.invisibleChildren.add(new CustomerServiceListAdapter.Item(CustomerServiceListAdapter.CHILD, "신용카드사로 전표가 매입처리 된 이후, 취소가 진행이 되면 환불까지 3일 ~ 10일 소요됩니다.\n" +
                                                                                                          "취소 전표 처리 이전에는 카드사를 통한 확인이 불가하며, 환불 기간 이후 카드사를 통한 취소내역 확인이 가능합니다."));

        data.add(places);
        data.add(places1);
        data.add(places2);
        data.add(places3);
        data.add(places4);

        recyclerview.setAdapter(new CustomerServiceListAdapter(data));


        return layout;
    }

}
