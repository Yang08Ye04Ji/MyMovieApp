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


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CustomerServiceFragment_3.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link CustomerServiceFragment_3#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CustomerServiceFragment_3 extends Fragment {

    private RecyclerView recyclerview;
    private Context mContext;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        LinearLayout layout = (LinearLayout) inflater.inflate(R.layout.fragment_customer_service_fragment_3, container, false);


        mContext = getContext();
        recyclerview = layout.findViewById(R.id.recyclerview);



        recyclerview.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false));
        List<CustomerServiceListAdapter.Item> data = new ArrayList<>();


        CustomerServiceListAdapter.Item places = new CustomerServiceListAdapter.Item(CustomerServiceListAdapter.HEADER, "할인되는 카드는 어떤게 있나요?");
        places.invisibleChildren = new ArrayList<>();
        places.invisibleChildren.add(new CustomerServiceListAdapter.Item(CustomerServiceListAdapter.CHILD, "신용카드 및 체크카드 할인\n" +
                "- 400여종 이상의 다양한 할인 카드가 준비되어 있습니다."));

        CustomerServiceListAdapter.Item places1 = new CustomerServiceListAdapter.Item(CustomerServiceListAdapter.HEADER, "통신사(SKT, KT, LGU+) 할인은 어떻게 되나요?");
        places1.invisibleChildren = new ArrayList<>();
        places1.invisibleChildren.add(new CustomerServiceListAdapter.Item(CustomerServiceListAdapter.CHILD, "■ SKT 할인\n" +
                "- SKT VIP 할인의 경우, 월 1회 (연 6회) 일반 영화(2D) 무료예매, 입체 영화(3D) 5,000원으로 관람 가능 (6회 소진 후 일반 영화(2D) 1천 원 할인)\n" +
                "- T 멤버십 홈페이지 예약시 할인 적용가능하며, 할인금액 상당 멤버십 한도 차감 (한도 부족시 미적용)※ 할인 적용시 포인트 차감\n" +
                "※ 일반상영관에 한해 제공되며, 특화관은 제외됩니다. (특화관 : IMAX, Sweet Box, 4DX 등)\n" +
                "※ 예매 및 자세한 내용은 T멤버십 홈페이지 (http://tmembership.tworld.co.kr) 참고\n" +
                "\n" +
                "■ KT 할인\n" +
                "  - KT VIP 할인의 경우, KT 멤버십 홈페이지 예약시 할인 적용가능하며 월 1회 (연 최대 12회) 일반 영화(2D) 무료 적용 가능\n" +
                "  - KT VIP 할인은 본인에 한해 적용되며 동반 1인은 9천 원이상 티켓에 한해 최대 3천 5백원 할인\n" +
                "  - KT 더블 할인의 경우, KT 멤버십 홈페이지 예약시 할인 적용가능하며 9천 원이상 티켓에 한해 월 1회 본인 및 동반 1인 최대 4천 원 할인 적용 가능\n" +
                "  - KT 전고객 할인의 경우, KT 멤버십 홈페이지 예약시 할인 적용가능하며 9천 원이상 티켓에 한해 월 1회 본인 및 동반 1인 최대 3천 5백원 할인\n" +
                "  - KT 현장 할인의 경우, 현장 매표소에서 KT 멤버십 카드 제시시 9천 원이상 티켓에 한해 월 1회 2천 원 할인\n" +
                "\n" +
                "※ 할인 적용시 할인금액 상당 포인트 차감\n" +
                "※ 2D(일반상영관)에 한해 제공되며, 특화관은 제외됩니다. (특화관 : IMAX, Sweet Box, 3D, 4D 등)\n" +
                "※ 예매 및 자세한 내용은 KT멤버십 홈페이지 (https://membership.kt.com/) 참고\n" +
                "\n" +
                "■ LG U+ 할인\n" +
                "  - LG U+ VIP 할인의 경우, LG U+ 멤버십 홈페이지 예약시 할인 적용가능하며 월 1회 (연 최대 12회) 일반 영화(2D) 무료 적용 가능\n" +
                "\n" +
                "※ 할인 적용시 포인트 차감\n" +
                "※ 멤버십 나만의 콕을 \"영화\"로 선택하신 후 적용가능\n" +
                "※ 2D(일반상영관)에 한해 제공되며, 특화관은 제외됩니다. (특화관 : IMAX, Sweet Box, 3D, 4D 등)\n" +
                "※ 예매 및 자세한 내용은 LG U+ 홈페이지 (http://www.uplus.co.kr/) 참고\n" +
                "\n"));

        CustomerServiceListAdapter.Item places2 = new CustomerServiceListAdapter.Item(CustomerServiceListAdapter.HEADER, "어린이 할인은 어떻게 받을 수 있나요?");
        places2.invisibleChildren = new ArrayList<>();
        places2.invisibleChildren.add(new CustomerServiceListAdapter.Item(CustomerServiceListAdapter.CHILD, "어린이(만 48개월 이상) 관람의 경우, 청소년과 동일한 요금이 적용됩니다."));

        CustomerServiceListAdapter.Item places3 = new CustomerServiceListAdapter.Item(CustomerServiceListAdapter.HEADER, "군장병(군인) 할인은 어떻게 되나요?");
        places3.invisibleChildren = new ArrayList<>();
        places3.invisibleChildren.add(new CustomerServiceListAdapter.Item(CustomerServiceListAdapter.CHILD, " ■ 군장병(군인) 할인\n" +
                "  - 현역장병(직업군인포함), 20년 이상 복무 전역 예비역, 주한미군, 한국전 참전 군인, 사회복무요원,\n" +
                "    사관생도/사관후보생/부사관 후보생, 상근예비역, 방사청, 군인공제회, 국방기술품질원, 병무청, 방위산업기술센터,\n" +
                "    국방과학연구소, 한국국방연구원, 병역명문가 병역이행가 및 가족 본인 및 동반 3인 일반 영화(2D) 7천 원 / 입체영화(3D) 8천 원 관람 가능 \n" +
                "    (국방부 공무원 , 군무원의 경우 온라인 예매만 가능)\n" +
                "\n" +
                "  - 매점 오징어 콤보(고소팝콘 大 1개 + 탄산음료 中 2개 + 완제 오징어 1개) 6천원 구매 가능\n" +
                "    (팝콘 맛 및 타 스낵으로 변경, 음료 사이즈 업그레이드 가능하나 추가 금액 발생, 일부 지점 메뉴구성 상이)"));


        CustomerServiceListAdapter.Item places4 = new CustomerServiceListAdapter.Item(CustomerServiceListAdapter.HEADER, "경로/장애인/국가유공자 할인은 어떻게 되나요?");
        places4.invisibleChildren = new ArrayList<>();
        places4.invisibleChildren.add(new CustomerServiceListAdapter.Item(CustomerServiceListAdapter.CHILD, "■ 경로 우대 할인\n" +
                "  - 만 65세 이상 고객 (본인 限), 신분증 제시 시 일반 영화(2D) 5천원 / 입체영화(3D) 8천원 관람 가능\n" +
                "\n" +
                "■ 장애인 할인\n" +
                "  - 장애의 정도가 심한 장애인 : 복지카드 제시 시, 본인 및 동반 1인 일반 영화(2D) 5천원 / 입체영화(3D) 8천원 관람 가능 \n" +
                "\n" +
                "  - 장애의 정도가 심하지 않은 장애인 : 복지카드 제시 시, 본인 限 일반 영화(2D) 5천원 / 입체영화(3D) 8천원 관람 가능"));


        data.add(places);
        data.add(places1);
        data.add(places2);
        data.add(places3);
        data.add(places4);


        recyclerview.setAdapter(new CustomerServiceListAdapter(data));

        return layout;
    }

}
