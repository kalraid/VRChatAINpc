package com.dnd.project.party.dndapi.api;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.dnd.common.rest.service.ApiService;
import com.dnd.project.party.dndapi.service.TimeLineConvertService;
import com.dnd.project.party.dndapi.vo.dndResponse;
import com.dnd.project.party.utils.DateUtils;
import com.dnd.project.party.utils.NeopleCode;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class NeopleRest {

	@Autowired
    private RestTemplate restTemplate;
	
	@Autowired
	private TimeLineConvertService timeLineConvertService;
    
	@Autowired
	public ApiService<?> apiService;

	@Value("${dnd.api.key}")
	private String key;

	// 서버정보 : https://api.neople.co.kr/df/servers?apikey

	public ResponseEntity<?> getServerInfo() {
		String url = "https://api.neople.co.kr/df/servers?apikey="+key;
		ResponseEntity<?> entity = apiService.get(url);
		
		return entity;
	}
	
	public ResponseEntity<?> getCharacterInfo() {
		// https://api.neople.co.kr/df/servers/<serverId>/characters?characterName=<characterName>&jobId=<jobId>&jobGrowId=<jobGrowId>&limit=<limit>&wordType=<wordType>&apikey=JNG7yMG1pkxS5OjVYoj73FwfYXTqqAAi
		
//		캐릭터 이미지 URL : https://img-api.neople.co.kr/df/servers/<serverId>/characters/<characterId>?zoom=<zoom>
//			※ zoom 요청 변수를 통해서 1 ~ 3까지 사이즈 조절 가능합니다.
//
//			요청변수	유형	설명	필수여부	기본값	최대값
//			serverId	String	서버 아이디 : 해당 서버군 검색
//			all : 전체 서버군 통합 검색	Y		
//			characterName	String	캐릭터 명칭 (URL 인코딩 필요)	Y		
//			jobId	String	캐릭터 직업 고유 코드			
//			jobGrowId	String	캐릭터 각성 직업 고유 코드 (jobId 필요)			
//			wordType	String	검색타입
//			동일 단어(match), 전문 검색(full)
//			※ full의 경우 최소 2자에서 최대 12자까지 이용 가능		match	
//			limit	Integer	반환 Row 수		10	200

		String url = "https://api.neople.co.kr/df/servers?apikey="+key;
		ResponseEntity<?> entity = apiService.get(url);
		
		return entity;
	}
	
	public ResponseEntity<?> getCharacterBaseInfo(String name, String server) {
		// https://api.neople.co.kr/df/servers/<serverId>/characters/<characterId>?apikey=<apikey>
		// https://api.neople.co.kr/df/servers/bakal/characters?characterName=에반젤앙갚음&apikey=JNG7yMG1pkxS5OjVYoj73FwfYXTqqAAi
//		03. 캐릭터 `기본 정보` 조회/df/servers/:serverId/characters/:characterId 
//		참고 사항
//		캐릭터 이미지 URL : https://img-api.neople.co.kr/df/servers/<serverId>/characters/<characterId>?zoom=<zoom>
//		※ zoom 요청 변수를 통해서 1 ~ 3까지 사이즈 조절 가능합니다.
//
//		요청변수	유형	설명	필수여부	기본값
//		serverId	String	서버 아이디	Y	
//		characterId	String	캐릭터 고유 코드	Y
		
		String url = "https://api.neople.co.kr/df/servers/"+server+"/characters?characterName="+name+"&apikey="+key;
		ResponseEntity<?> entity = apiService.get(url);
		
		return entity;
	}
	
	public ResponseEntity<?> getCharacterTimeLineInfo(String characterId, String name, String serverId, String type) {
//		https://api.neople.co.kr/df/servers/<serverId>/characters/<characterId>/timeline?limit=<limit>&code=<code>&startDate=<startDate>&endDate=<endDate>&next=<next>&apikey=<apikey>
		
//		참고 사항
//		타임라인 코드 다중 입력 시 콤마(,)를 이용해서 구분 처리
//		  ex) /timeline?code=101,102,103
//
//		startDate, endDate 요청 변수 사용 예시
//		  ex) /timeline?startDate=20180901T0000&endDate=20180930T2359
//		          /timeline?startDate=2018-09-01 00:00&endDate=2018-09-30 23:59
//		  ※ 기간 검색 요청 시 하나의 파라미터(startDate, endDate)라도 누락 될 경우 검색이 불가능합니다.
//		  ※ 다양한 Date Type을 지원하지만, 상황에 따라 변경될 수 있으므로 예시 Date Type을 이용 부탁드립니다.
//		  ※ 초 단위 설정의 경우 startDate : 00초, endDate : 59초로 처리됩니다.
//		  ※ 기간 설정은 최대 90일까지 가능합니다.
//
//		next 요청변수 사용 예시
//		  ex) /timeline?next=<next>&apikey=<apikey>
//		  ※ next 사용 시 limit, code, startDate, endDate등 요청변수는 최초 조회 기준으로 적용됩니다.
//		요청변수	유형	설명	필수여부	기본값	최대값
//		serverId	String	서버 아이디	Y		
//		characterId	String	캐릭터 고유 코드	Y		
//		startDate	Date	검색 시작일		현재시간 기준 30일전	
//		endDate	Date	검색 종료일		현재시간	
//		limit	Integer	반환 Row 수		10	100
//		code	String	타임라인 코드			
//		next	String	다음 데이터 조회			
		// &code=<code> &next=<next>
		String startDate = DateUtils.getBeforeThursDay(); 
		String url = "";
		if(NeopleCode.WEEK.getType().equals(type)) {
			url = "https://api.neople.co.kr/df/servers/"+serverId+"/characters/"+characterId+"/timeline?limit=100&startDate="+startDate+"&endDate="+new SimpleDateFormat("yyyy-MM-dd").format(new Date())+"&apikey="+key;
			
		}else if(NeopleCode.EPIC.getType().equals(type)) {
			url = "https://api.neople.co.kr/df/servers/"+serverId+"/characters/"+characterId+"/timeline?code="+NeopleCode.GET_ITEM_HELL+","+NeopleCode.GET_ITEM_DUNGEN+","+NeopleCode.FIND_WAR+","+NeopleCode.RAID+"limit=100&startDate="+startDate+"&endDate="+new SimpleDateFormat("yyyy-MM-dd").format(new Date())+"&apikey="+key;
		}
		dndResponse response = new dndResponse();
		HttpHeaders httpHeaders = new HttpHeaders();
    	httpHeaders.setContentType(MediaType.APPLICATION_JSON);
    	
    	ResponseEntity<? extends dndResponse> entity  = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<>(response, httpHeaders), response.getClass());
    	
    	if(NeopleCode.WEEK.getType().equals(type)) {
    		timeLineConvertService.updateTimeLineToCharacter(entity, characterId);
    		
    	}else if(NeopleCode.EPIC.getType().equals(type)) {
    	}
    	
		return entity;
	}
	
	public ResponseEntity<?> getCharacterStatusInfo() {
		// https://api.neople.co.kr/df/servers/<serverId>/characters/<characterId>/status?apikey=<apikey>
		
//		참고 사항
//		능력치 수치 정보의 경우 최근 인게임 접속 기준으로 제공되며, 캐릭터 접속 상황에 따라서 오차 또는 미제공 될 수 있습니다.
//
//		요청변수	유형	설명	필수여부	기본값
//		serverId	String	서버 아이디	Y	
//		characterId	String	캐릭터 고유 코드	Y	
		
		String url = "https://api.neople.co.kr/df/servers?apikey="+key;
		ResponseEntity<?> entity = apiService.get(url);
		
		return entity;
	}
	
	public ResponseEntity<?> getCharacterEquipInfo() {
		// https://api.neople.co.kr/df/servers/<serverId>/characters/<characterId>/equip/equipment?apikey=<apikey>
		
//		요청변수	유형	설명	필수여부	기본값
//		serverId	String	서버 아이디	Y	
//		characterId	String	캐릭터 고유 코드	Y	
		
		String url = "https://api.neople.co.kr/df/servers?apikey="+key;
		ResponseEntity<?> entity = apiService.get(url);
		
		return entity;
	}
	
	public ResponseEntity<?> getCharacterEquipAvatarInfo() {
		// https://api.neople.co.kr/df/servers/<serverId>/characters/<characterId>/equip/avatar?apikey=<apikey>
		
//		요청변수	유형	설명	필수여부	기본값
//		serverId	String	서버 아이디	Y	
//		characterId	String	캐릭터 고유 코드	Y	
//			
		String url = "https://api.neople.co.kr/df/servers?apikey="+key;
		ResponseEntity<?> entity = apiService.get(url);
		
		return entity;
	}
	
	public ResponseEntity<?> getCharacterEquipCreatureInfo() {
		// https://api.neople.co.kr/df/servers/<serverId>/characters/<characterId>/equip/creature?apikey=<apikey>
		
//		요청변수	유형	설명	필수여부	기본값
//		serverId	String	서버 아이디	Y	
//		characterId	String	캐릭터 고유 코드	Y	
//			
		String url = "https://api.neople.co.kr/df/servers?apikey="+key;
		ResponseEntity<?> entity = apiService.get(url);
		
		return entity;
	}
	
	public ResponseEntity<?> getCharacterEquipFlagInfo() {
		// https://api.neople.co.kr/df/servers/<serverId>/characters/<characterId>/equip/flag?apikey=<apikey>
		
//		요청변수	유형	설명	필수여부	기본값
//		serverId	String	서버 아이디	Y	
//		characterId	String	캐릭터 고유 코드	Y	
//			
		String url = "https://api.neople.co.kr/df/servers?apikey="+key;
		ResponseEntity<?> entity = apiService.get(url);
		
		return entity;
	}
	
	public ResponseEntity<?> getCharacterEquipTalismanInfo() {
		// https://api.neople.co.kr/df/servers/<serverId>/characters/<characterId>/equip/talisman?apikey=<apikey>
		
//		요청변수	유형	설명	필수여부	기본값
//		serverId	String	서버 아이디	Y	
//		characterId	String	캐릭터 고유 코드	Y	
//			
		String url = "https://api.neople.co.kr/df/servers?apikey="+key;
		ResponseEntity<?> entity = apiService.get(url);
		
		return entity;
	}
	
	
	
	public ResponseEntity<?> getCharacterSkilStyleInfo() {
		// https://api.neople.co.kr/df/servers/<serverId>/characters/<characterId>/skill/style?apikey=<apikey>
		
//		요청변수	유형	설명	필수여부	기본값
//		serverId	String	서버 아이디	Y	
//		characterId	String	캐릭터 고유 코드	Y	
//			
		String url = "https://api.neople.co.kr/df/servers?apikey="+key;
		ResponseEntity<?> entity = apiService.get(url);
		
		return entity;
	}
	
	
	public ResponseEntity<?> getCharacterBuffSkilEquipInfo() {
		// https://api.neople.co.kr/df/servers/<serverId>/characters/<characterId>/skill/buff/equip/equipment?apikey=<apikey>
		
//		요청변수	유형	설명	필수여부	기본값
//		serverId	String	서버 아이디	Y	
//		characterId	String	캐릭터 고유 코드	Y	
//			
		String url = "https://api.neople.co.kr/df/servers?apikey="+key;
		ResponseEntity<?> entity = apiService.get(url);
		
		return entity;
	}
	
	public ResponseEntity<?> getCharacterBuffSkilEquipAvaterInfo() {
		//https://api.neople.co.kr/df/servers/<serverId>/characters/<characterId>/skill/buff/equip/avatar?apikey=<apikey>
		
//		요청변수	유형	설명	필수여부	기본값
//		serverId	String	서버 아이디	Y	
//		characterId	String	캐릭터 고유 코드	Y	
//			
		String url = "https://api.neople.co.kr/df/servers?apikey="+key;
		ResponseEntity<?> entity = apiService.get(url);
		
		return entity;
	}
	
	public ResponseEntity<?> getCharacterBuffSkilEquipcreatureInfo() {
		// https://api.neople.co.kr/df/servers/<serverId>/characters/<characterId>/skill/buff/equip/creature?apikey=<apikey>
		
//		요청변수	유형	설명	필수여부	기본값
//		serverId	String	서버 아이디	Y	
//		characterId	String	캐릭터 고유 코드	Y	
//			
		String url = "https://api.neople.co.kr/df/servers?apikey="+key;
		ResponseEntity<?> entity = apiService.get(url);
		
		return entity;
	}
	
	
	public ResponseEntity<?> getAuctionSearch() {
		// https://api.neople.co.kr/df/auction?itemName=<itemName>&q=minLevel:<minLevel>,maxLevel:<maxLevel>,rarity:<rarity>,minReinforce:<minReinforce>,maxReinforce:<maxReinforce>,minRefine:<minRefine>,maxRefine:<maxRefine>&sort=unitPrice:<unitPrice>,reinforce:<reinforce>,auctionNo:<auctionNo>&limit=<limit>&wordType=<wordType>&apikey=<apikey>
		
//		참고 사항
//		검색 변수 : itemId 또는 itemName 둘 중 한가지의 파라미터는 필수로 입력 하셔야 합니다.
//		정렬 : sort가 정의되어 있지 않을 경우 기본적으로 auctionNo에 대해서만 오름차순(asc)으로 정렬됩니다.
//
//		요청변수	하위변수	유형	설명	필수여부	기본값	최대값
//		limit		Integer	반환 Row 수		10	400
//		sort=			정렬 관련 요청변수			
//		unitPrice	String	가격별 정렬
//		오름차순(asc), 내림차순(desc)			
//		reinforce	String	등급별 정렬
//		오름차순(asc), 내림차순(desc)			
//		auctionNo	String	등록순서 정렬
//		오름차순(asc), 내림차순(desc)			
//		itemId		String	아이템 고유 코드	Y		
//		itemName		String	아이템 명칭 (URL 인코딩 필요)	Y		
//		wordType		String	검색타입
//		동일 단어(match), 앞 단어 검색(front), 전문 검색(full)		match	
//		q=			검색 관련 요청변수			
//		minLevel	Integer	최소 장착 레벨			
//		maxLevel	Integer	최대 장착 레벨			
//		rarity	String	아이템 레어리티 (URL 인코딩 필요)			
//		minReinforce	Integer	최소 강화 수치			
//		maxReinforce	Integer	최대 강화 수치			
//		minRefine	Integer	최소 제련 수치			
//		maxRefine	Integer	최대 제련 수치		
//			
		String url = "https://api.neople.co.kr/df/servers?apikey="+key;
		ResponseEntity<?> entity = apiService.get(url);
		
		return entity;
	}
	
	
	public ResponseEntity<?> getAuctionInfo() {
		// https://api.neople.co.kr/df/auction/<auctionNo>?apikey=<apikey>
		
//		요청변수	유형	설명	필수여부	기본값
//		auctionNo	Int	경매장 등록 번호	

		String url = "https://api.neople.co.kr/df/servers?apikey="+key;
		ResponseEntity<?> entity = apiService.get(url);
		
		return entity;
	}
	
	
	
	public ResponseEntity<?> getAvaterMakertInfo() {
		// https://api.neople.co.kr/df/avatar-market/sale?hashtag=<hashtag>&title=<title>&wordType=<wordType>&limit=<limit>&q=jobId:<jobid>,emblemCode:<emblemCode>,avatarSet:<avatarSet>,avatarRarity:<avatarRarity>&sort=price:<price>,goodsNo:<goodsNo>&apikey=<apikey>
		
//		참고 사항
//		hashtag 정보는 "아바타 마켓 해시태그 조회 API"를 통해서 확인 가능합니다.
//
//		요청변수	하위변수	유형	설명	필수여부	기본값	최대값
//		limit		Integer	반환 Row 수		10	50
//		sort=			정렬 관련 요청변수			
//		price	String	가격별 정렬
//		오름차순(asc), 내림차순(desc)			
//		goodsNo	String	등록순서 정렬
//		오름차순(asc), 내림차순(desc)			
//		hashtag		String	해시태그 구분자 (,)로 구성된 문자열(URL 인코딩 필요)			
//		title		String	아바타 마켓 등록 제목 (URL 인코딩 필요)			
//		wordType		String	검색타입
//		동일 단어(match), 앞 단어 검색(front), 전문 검색(full)		match	
//		q=			검색 관련 요청변수			
//		jobId	String	캐릭터 직업 고유 코드			
//		emblemCode	Integer	엠블렘 코드			
//		avatarSet	String	아바타 세트 여부
//		세트(true), 일반(false)			
//		avatarRarity	String	아바타 레어리티
//		상급, 레어, 혼합 (URL 인코딩 필요)			
//		minPrice	Integer	최소 판매 금액			
//		maxPrice	Integer	최대 판매 금액			
//		minAvatarCount	Integer	최소 아바타 장착 갯수			
//		maxAvatarCount	Integer	최대 아바타 장착 갯수
		
		String url = "https://api.neople.co.kr/df/servers?apikey="+key;
		ResponseEntity<?> entity = apiService.get(url);
		
		return entity;
	}
	
	
	
	public ResponseEntity<?> getAvaterMakertGoodInfo() {
		// https://api.neople.co.kr/df/avatar-market/sale/<goodsNo>?apikey=<apikey>
		
//		참고 사항
//		요청변수	하위변수	유형	설명	필수여부	기본값	최대값
//		goodsNo		Integer	아바타 마켓 등록 번호	Y		
		
		String url = "https://api.neople.co.kr/df/servers?apikey="+key;
		ResponseEntity<?> entity = apiService.get(url);
		
		return entity;
	}
	
	
	
	public ResponseEntity<?> getAvaterMakertSoldInfo() {
		// https://api.neople.co.kr/df/avatar-market/sold?hashtag=<hashtag>&title=<title>&wordType=<wordType>&limit=<limit>&q=jobId:<jobid>,emblemCode:<emblemCode>,avatarSet:<avatarSet>,avatarRarity:<avatarRarity>&sort=price:<price>,goodsNo:<goodsNo>&apikey=<apikey>
		
//		요청변수	하위변수	유형	설명	필수여부	기본값	최대값
//		limit		Integer	반환 Row 수		10	50
//		sort=			정렬 관련 요청변수			
//		price	String	가격별 정렬
//		오름차순(asc), 내림차순(desc)			
//		goodsNo	String	등록순서 정렬
//		오름차순(asc), 내림차순(desc)			
//		hashtag		String	해시태그 구분자 (,)로 구성된 문자열(URL 인코딩 필요)			
//		title		String	아바타 마켓 등록 제목 (URL 인코딩 필요)			
//		wordType		String	검색타입
//		동일 단어(match), 앞 단어 검색(front), 전문 검색(full)		match	
//		q=			검색 관련 요청변수			
//		jobId	String	캐릭터 직업 고유 코드			
//		emblemCode	Integer	엠블렘 코드			
//		avatarSet	String	아바타 세트 여부
//		세트(true), 일반(false)			
//		avatarRarity	String	아바타 레어리티
//		상급, 레어, 혼합 (URL 인코딩 필요)			
//		minPrice	Integer	최소 판매 금액			
//		maxPrice	Integer	최대 판매 금액			
//		minAvatarCount	Integer	최소 아바타 장착 갯수			
//		maxAvatarCount	Integer	최대 아바타 장착 갯수
		
		String url = "https://api.neople.co.kr/df/servers?apikey="+key;
		ResponseEntity<?> entity = apiService.get(url);
		
		return entity;
	}
	
	
	
	public ResponseEntity<?> getAvaterMakertSoldGoodsInfo() {
		// https://api.neople.co.kr/df/avatar-market/sold/<goodsNo>?apikey=<apikey>
		
//		요청변수	하위변수	유형	설명	필수여부	기본값	최대값
//		goodsNo		Integer	아바타 마켓 등록 번호	Y		
		
		String url = "https://api.neople.co.kr/df/servers?apikey="+key;
		ResponseEntity<?> entity = apiService.get(url);
		
		return entity;
	}
	
	
	
	
	
	public ResponseEntity<?> getItemsInfo() {
		// https://api.neople.co.kr/df/items?itemName=<itemName>&q=minLevel:<minLevel>,maxLevel:<maxLevel>,rarity:<rarity>,trade:<trade>&limit=<limit>&wordType=<wordType>&apikey=<apikey>

		//		참고 사항
//		현재 인게임에서 획득 가능한 아이템의 경우만 검색 가능합니다.
//		아이템 이미지 URL : https://img-api.neople.co.kr/df/items/<itemId>
//
//		요청변수	하위변수	유형	설명	필수여부	기본값	최대값
//		limit		Integer	반환 Row 수		10	30
//		itemName		String	아이템 명칭, URL 인코딩 하여 사용한다	Y		
//		wordType		String	검색타입
//		동일 단어(match), 앞 단어 검색(front), 전문 검색(full)
//		※ full의 경우 최소 2자에서 최대 12자까지 이용 가능		match	
//		q=						
//		minLevel	Integer	최소 장착 레벨			
//		maxLevel	Integer	최대 장착 레벨			
//		rarity	String	아이템 레어리티 (URL 인코딩 필요)			
//		trade	Boolean	거래(경매장 등록) 가능 아이템만 조회(true)		false	
		
		
		String url = "https://api.neople.co.kr/df/servers?apikey="+key;
		ResponseEntity<?> entity = apiService.get(url);
		
		return entity;
	}
	
	
	
	public ResponseEntity<?> getItemsDetailInfo() {
		// https://api.neople.co.kr/df/items/<itemId>?apikey=<apikey>

//		참고 사항
//		장비 스탯의 경우, 최상급 100% 기준으로 표시됩니다.
//		예외적으로 칭호의 경우, 중급 평균 수치로 표시됩니다.
//		아이템 이미지 URL : https://img-api.neople.co.kr/df/items/<itemId>
//
//		talismanInfo buff 컬럼 정보 안내
//		  - buff 컬럼의 경우 크루세이더(남) "성령의 메이스 스킬의 습득 여부"에 따른 버프 옵션 정보입니다.
//		  - 크루세이더(여), 인챈트리스의 경우 explain / explainDetail에 포함됩니다.
//
//		요청변수	유형	설명	필수여부	기본값
//		itemId	String	아이템 고유 코드	Y	
		
		
		String url = "https://api.neople.co.kr/df/servers?apikey="+key;
		ResponseEntity<?> entity = apiService.get(url);
		
		return entity;
	}
	
	
	public ResponseEntity<?> getItemsShopInfo() {
		// https://api.neople.co.kr/df/items/<itemId>/shop?apikey=<apikey>
		
//		참고 사항
//		인게임 백과사전 기준의 상점 판매 95레벨 에픽, 100레벨 유니크, 100레벨 레전더리 장비만 조회 가능 합니다.
//
//		요청변수	유형	설명	필수여부	기본값
//		itemId	String	아이템 고유 코드	Y		
		
		
		String url = "https://api.neople.co.kr/df/servers?apikey="+key;
		ResponseEntity<?> entity = apiService.get(url);
		
		return entity;
	}
	
	
	public ResponseEntity<?> getMultiItemsInfo() {
		// https://api.neople.co.kr/df/multi/items?itemIds=<itemId>,<itemId>,<itemId>&apikey=<apikey>
		
//		참고 사항
//		아이템 최대 15개 조회 가능합니다.
//		중복된 아이템 ID 요청 시 중복된 항목은 제거 됩니다.
//		예시) https://api.neople.co.kr/df/multi/items?itemIds=6ed94ca4a1c10af06f5c79969a1d30e8,2dfaf59a126c85104771d33ecf099e6f
//
//		요청변수	하위변수	유형	설명	필수여부	기본값
//		itemIds		String	아이템 고유 코드
//		쉼표(,)를 통한 구분 값 처리	Y	
		
		
		String url = "https://api.neople.co.kr/df/servers?apikey="+key;
		ResponseEntity<?> entity = apiService.get(url);
		
		return entity;
	}
	
	
	public ResponseEntity<?> getSettItemsInfo() {
		// https://api.neople.co.kr/df/setitems?setItemName=<setItemName>&limit=<limit>&wordType=<wordType>&apikey=<apikey>
		
//		요청변수	하위변수	유형	설명	필수여부	기본값	최대값
//		setItemName		String	세트 아이템 명칭, URL 인코딩 하여 사용한다	Y		
//		limit		Integer	반환 Row 수		10	100
//		wordType		String	검색타입
//		동일 단어(match), 앞 단어 검색(front), 전문 검색(full)
//		※ full의 경우 최소 2자에서 최대 12자까지 이용 가능		match
		
		
		String url = "https://api.neople.co.kr/df/servers?apikey="+key;
		ResponseEntity<?> entity = apiService.get(url);
		
		return entity;
	}
	
	
	
	public ResponseEntity<?> getSettItemsDetailInfo() {
		// https://api.neople.co.kr/df/setitems/<setItemId>?apikey=<apikey>
		
//		요청변수	유형	설명	필수여부	기본값
//		setItemId	String	세트 아이템 고유 코드	Y	
		
		String url = "https://api.neople.co.kr/df/servers?apikey="+key;
		ResponseEntity<?> entity = apiService.get(url);
		
		return entity;
	}
	
	
	public ResponseEntity<?> getMultiSettItemsDetailInfo() {
		// https://api.neople.co.kr/df/multi/setitems?setItemIds=<setItemId>,<setItemId>,<setItemId>&apikey=<apikey>
		
//		요청변수	유형	설명	필수여부	기본값
//		setItemId	String	세트 아이템 고유 코드	Y	
		
		String url = "https://api.neople.co.kr/df/servers?apikey="+key;
		ResponseEntity<?> entity = apiService.get(url);
		
		return entity;
	}
	
	
	
	public ResponseEntity<?> getMultiSettItemsEquipInfo() {
		// https://api.neople.co.kr/df/custom/equipment/setitems?itemIds=<itemId>,<itemId>,<itemId>&apikey=<apikey>
		
//		참고 사항
//		임의 장착 장비 아이템ID를 이용해 세트 활성화 정보 조회 할 수 있습니다.
//		아이템ID는 최대 12개 요청 가능합니다.
//		중복된 장착 부위 요청 시 중복 항목은 제거 됩니다.
//		예시) https://api.neople.co.kr/df/custom/equipment/setitems?itemIds=e1e12366bb4e3d171c308fa539ede0d5,74d036a7d6227d43ea6b9aa65611d408
//
//		요청변수	하위변수	유형	설명	필수여부	기본값
//		itemIds		String	아이템 고유 코드
//		쉼표(,)를 통한 구분 값 처리	Y	
		
		String url = "https://api.neople.co.kr/df/servers?apikey="+key;
		ResponseEntity<?> entity = apiService.get(url);
		
		return entity;
	}
	
	
	
	public ResponseEntity<?> getJobInfo() {
		// https://api.neople.co.kr/df/jobs?apikey=<apikey>
		
//		참고 사항
//		임의 장착 장비 아이템ID를 이용해 세트 활성화 정보 조회 할 수 있습니다.
//		아이템ID는 최대 12개 요청 가능합니다.
//		중복된 장착 부위 요청 시 중복 항목은 제거 됩니다.
//		예시) https://api.neople.co.kr/df/custom/equipment/setitems?itemIds=e1e12366bb4e3d171c308fa539ede0d5,74d036a7d6227d43ea6b9aa65611d408
//
//		요청변수	하위변수	유형	설명	필수여부	기본값
//		itemIds		String	아이템 고유 코드
//		쉼표(,)를 통한 구분 값 처리	Y	
		
		String url = "https://api.neople.co.kr/df/jobs?apikey="+key;
		ResponseEntity<?> entity = apiService.get(url);
		
		return entity;
	}
	
	
	public ResponseEntity<?> getJobSkilsInfo() {
		// https://api.neople.co.kr/df/skills/<jobId>?jobGrowId=<jobGrowId>&apikey=<apikey>
		
//		요청변수	유형	설명	필수여부
//		jobId	String	캐릭터 직업 고유 코드	Y
//		jobGrowId	String	캐릭터 각성 직업 고유 코드	Y	
		
		String url = "https://api.neople.co.kr/df/jobs?apikey="+key;
		ResponseEntity<?> entity = apiService.get(url);
		
		return entity;
	}
	
	
	
	public ResponseEntity<?> getJobSkilsDetailInfo() {
		// https://api.neople.co.kr/df/skills/<jobId>/<skillId>?apikey=<apikey>
		
//		요청변수	유형	설명	필수여부
//		jobId	String	캐릭터 직업 고유 코드	Y
//		skillId	String	스킬 고유 코드	Y	
		
		String url = "https://api.neople.co.kr/df/jobs?apikey="+key;
		ResponseEntity<?> entity = apiService.get(url);
		
		return entity;
	}
	
	
	
	
	
}
