package com.dnd.project.party.dndapi.vo;

import java.util.ArrayList;

import lombok.Data;

@Data
public class dndTimeline {
//    "date": {
//        "start": "2020-08-06 19:41",
//        "end": "2020-09-05 19:41"
//    },
//    "next": "504343e3a1bf1bad00747fcfd5635efe7e1e5c3607a4902755995668cdb4b3a985b6cb887dcd077af12214ae386e4a8402be5d2c05636c4474ab9fc4e7f1a149d602464d3127d988fa7f54df9dd71c78",
//    "rows": [
//        {
//            "code": 513,
//            "name": "아이템 획득(던전)",
//            "date": "2020-09-05 17:29",
//            "data": {
//                "itemId": "44becbbee44c861cdf8df571d4fd2aed",
//                "itemName": "암흑술사의 정수",
//                "itemRarity": "에픽",
//                "dungeonName": "고통의 지하실"
//            }
//        },
//        {
//            "code": 201,
//            "name": "레이드",
//            "date": "2020-09-05 15:23",
//            "data": {
//                "guide": false,
//                "raidName": "프레이-이시스"
//            }
//        },
//        {
//            "code": 207,
//            "name": "핀드워 클리어",
//            "date": "2020-09-05 12:52",
//            "data": {
//                "guide": false
//            }
//        },
//        {
//            "code": 201,
//            "name": "레이드",
//            "date": "2020-09-05 12:42",
//            "data": {
//                "raidName": "무형의 시로코",
//                "phaseName": "토벌"
//            }
//        },
//        {
//            "code": 201,
//            "name": "레이드",
//            "date": "2020-09-05 12:32",
//            "data": {
//                "raidName": "무형의 시로코",
//                "phaseName": "추적"
//            }
//        },
//        {
//            "code": 505,
//            "name": "아이템 획득(지옥 파티)",
//            "date": "2020-09-04 20:02",
//            "data": {
//                "itemId": "e144cccd61f9aabd7d23d3bc5124ff87",
//                "itemName": "전장의 열정 : 앵거바딜",
//                "itemRarity": "에픽",
//                "channelName": "할렘",
//                "channelNo": 19,
//                "dungeonName": "고통의 지하실"
//            }
//        },
//        {
//            "code": 505,
//            "name": "아이템 획득(지옥 파티)",
//            "date": "2020-09-03 21:02",
//            "data": {
//                "itemId": "ea7619426683f2edbcc6b2651d438d79",
//                "itemName": "전장의 매",
//                "itemRarity": "에픽",
//                "channelName": "심연에 잠긴 하늘성",
//                "channelNo": 8,
//                "dungeonName": "검은 신전"
//            }
//        },
//        {
//            "code": 513,
//            "name": "아이템 획득(던전)",
//            "date": "2020-09-02 21:12",
//            "data": {
//                "itemId": "12074c5cadd3387f79def00bdfb7404c",
//                "itemName": "구속의 퀴스",
//                "itemRarity": "에픽",
//                "dungeonName": "검은 신전"
//            }
//        },
//        {
//            "code": 511,
//            "name": "아이템 획득(업그레이드)",
//            "date": "2020-09-01 22:31",
//            "data": {
//                "itemId": "0a38b10489060cf42f6805961832e4f1",
//                "itemName": "눈부신 영광",
//                "itemRarity": "에픽"
//            }
//        },
//        {
//            "code": 201,
//            "name": "레이드",
//            "date": "2020-09-01 22:24",
//            "data": {
//                "raidName": "무형의 시로코",
//                "phaseName": "토벌"
//            }
//        }
//    ]
	
	dndTimelineDate date;
	String next;
	
	ArrayList<timeLine> rows;
	
	
	@Data
	public static class dndTimelineDate{
		String start;
		String end;
	}

	@Data
	public static class timeLine{
		String code;
		String name;
		String date;
		timeLineData data;
	}
	
	@Data
	public static class timeLineData{
		String raidName;
		String phaseName;
		String itemId;
		String itemName;
		String itemRarity;
		String channelName;
		String channelNo;
		String dungeonName;
	}
}
