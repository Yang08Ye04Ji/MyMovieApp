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


public class CustomerServiceFragment_2 extends Fragment {

    private RecyclerView recyclerview;

    private Context mContext;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        LinearLayout layout = (LinearLayout) inflater.inflate(R.layout.fragment_customer_service_fragment_2, container, false);


        mContext = getContext();
        recyclerview = layout.findViewById(R.id.recyclerview);


        recyclerview.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false));
        List<CustomerServiceListAdapter.Item> data = new ArrayList<>();


        CustomerServiceListAdapter.Item places = new CustomerServiceListAdapter.Item(CustomerServiceListAdapter.HEADER, "기프트콘 구매 시 카드할인 적용 가능한가요?");
        places.invisibleChildren = new ArrayList<>();
        places.invisibleChildren.add(new CustomerServiceListAdapter.Item(CustomerServiceListAdapter.CHILD, "카드할인의 경우, 영화 예매 시에만 적용되기 때문에\n" +
                "기프트콘 구매 시에는 카드할인 적용이 어렵습니다."));

        CustomerServiceListAdapter.Item places1 = new CustomerServiceListAdapter.Item(CustomerServiceListAdapter.HEADER, "영화관람/매점상품 기프트콘은 적립이 가능한가요?");
        places1.invisibleChildren = new ArrayList<>();
        places1.invisibleChildren.add(new CustomerServiceListAdapter.Item(CustomerServiceListAdapter.CHILD, "- 영화관람 기프트콘 : 적립 불가\n" +
                "  매점상품 기프트콘 : 적립 가능"));

        CustomerServiceListAdapter.Item places2 = new CustomerServiceListAdapter.Item(CustomerServiceListAdapter.HEADER, "영화관람/매점상품 기프트콘은 어디서 환불하나요?");
        places2.invisibleChildren = new ArrayList<>();
        places2.invisibleChildren.add(new CustomerServiceListAdapter.Item(CustomerServiceListAdapter.CHILD, "• 구매자는 최초 유효기간 이내에 결제금액의 100%에 대해 결제취소/환불이 가능하며, 최초 유효기간 만료 후에는 수신자가 결제금액의 90%에 대해 환불 요청 가능합니다.\n" +
                "• 단, 이미 사용된 기프트콘에 대해서는 결제취소/환불 신청이 불가합니다.\n" +
                "• 결제취소/환불 방법\n" +
                " 결제취소는 모바일App,웹 > MY > 결제내역조회 > 스토어 or 홈페이지 > My CGV > 스토어 > 결제내역의 해당 주문 상세내역에서 가능합니다.\n" +
                " (기프트콘은 구매일로부터 60일 이내 결제취소 가능하며, 카드 결제취소 가능 기간이 경과하였을 경우, 고객센터로 연락주시면 됩니다)\n" +
                "환불은 모바일App,웹 > MY > 기프트콘 or 홈페이지 > My CGV > 스토어 > 내 기프트콘에서 환불을 원하는 기프트콘 등록 후 진행 가능하며, 비회원의 경우 고객센터로 신청 가능합니다.\n" +
                "단 이 때, 본인 확인 및 계좌 확인 절차가 진행됩니다.\n" +
                "• 수신자는 선물받은 기프트콘의 수신거절을 요청할 수 있으며, 이 경우 구매자에게 취소 및 환불에 대한 안내가 이루어집니다.\n" +
                "• 결제취소 가능 기간이 경과한 후 수신자가 수신거절을 요청할 경우 구매자에게 기프트콘이 재발송됩니다.\n" +
                "• 본 상품은 패키지 상품으로 전체 취소만 가능하며, 일부 상품을 사용하신 경우 환불이 불가합니다.(즉, 일부 상품 이용시 부분 취소 및 환불 불가)\n" +
                "• 미성년자인 고객께서 계약을 체결하시는 경우 법정대리인이 그 계약에 동의하지 아니하면 미성년자 본인 또는 법정대리인이 그 계약을 취소할 수 있습니다.\n" +
                "• 분쟁해결\n" +
                "① 회사는 이용자가 제기하는 정당한 의견이나 불만을 반영하고 그 피해의 보상 등에 관한 처리를 위하여 CGV고객센터(1544-1122)를 설치·운영하고 있습니다.\n" +
                "② 회사는 고객센터를 통하여 이용자로부터 제출되는 불만사항 및 의견을 처리합니다.  다만, 신속한 처리가 곤란한 경우에는 이용자에게 그 사유와 처리일정을 즉시 통보합니다.\n" +
                "③ 전자상거래 분쟁(청약철회등)과 관련한 이용자의 피해구제는 이용약관 및 전자상거래법 등 관련 법령에 따릅니다."));

        CustomerServiceListAdapter.Item places3 = new CustomerServiceListAdapter.Item(CustomerServiceListAdapter.HEADER, "기프트콘은 하루에 몇 회까지 구매할 수 있나요?");
        places3.invisibleChildren = new ArrayList<>();
        places3.invisibleChildren.add(new CustomerServiceListAdapter.Item(CustomerServiceListAdapter.CHILD, "기프트콘 일일 구매횟수 제한은 별도로 없습니다.\n" +
                "경로별 1회 구매 수량은 아래와 같습니다.\n" +
                "홈페이지 - 최대 5명(휴대폰 번호 기준) / 수량 1~5매 선택가능\n" +
                "모바일 APP - 최대 1명(휴대폰 번호 기준) / 수량 1~5매 선택가능"));


        CustomerServiceListAdapter.Item places4 = new CustomerServiceListAdapter.Item(CustomerServiceListAdapter.HEADER, "기프트콘의 유효기간은 얼마나 되나요?");
        places4.invisibleChildren = new ArrayList<>();
        places4.invisibleChildren.add(new CustomerServiceListAdapter.Item(CustomerServiceListAdapter.CHILD, " ■ 영화관람권 기프트콘\n" +
                "  - 유효기간 : 구매 후 2년 이내 (MMS에 유효기간 명시)\n" +
                "   - 명시된 유효기간 내에 상영하는 영화에 한해 관람이 가능합니다.\n" +
                "   - 유효기간 내에 사용하지 않으신 경우, 교환 효력이 상실됩니다.\n" +
                "\n" +
                "■ 매점상품 기프트콘\n" +
                "  - 유효기간 : 구매 후 6개월 이내 (MMS에 유효기간이 명시)\n" +
                "   - 명시된 유효기간 내에 각 영화관에서 실제 상품으로 교환하실 수 있습니다.\n" +
                "   - 유효기간 내에 사용하지 않으신 경우, 교환 효력이 상실됩니다.\n" +
                "\n" +
                "※ 유효기간 내 미 사용 시, 교환 효력 상실\n" +
                "   단, 이벤트 상품 등의 경우, 별도 공지하는 유효기간으로 적용\n" +
                "\n" +
                "\n" +
                "기프트콘 구매 시 결제 방법은 어떻게 되나요?\n" +
                "ㄴ영화관람권/매점상품 기프트콘 구매는 신용카드 및 카카오페이 결제만 가능합니다.\n" +
                "\n" +
                "단, 결제 시스템 상황에 따라 일부 결제가 노출되지 않을 수 있습니다.\n"));


        data.add(places);
        data.add(places1);
        data.add(places2);
        data.add(places3);
        data.add(places4);


        recyclerview.setAdapter(new CustomerServiceListAdapter(data));


        return layout;
    }


}
