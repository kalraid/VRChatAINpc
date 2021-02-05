package com.dnd.project.fund.etc.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.dnd.project.common.baseUtill.CommonApiService;
import com.dnd.project.party.dndapi.service.TimeLineConvertService;

public class EtcApi {

	@Autowired
    private RestTemplate restTemplate;
	
	@Autowired
	public CommonApiService<?> apiService;
	
	@Value("${dnd.fund.test.key}")
	private String testKey;
	
	@Value("${dnd.fund.main.key}")
	private String mainKey;

	@Value("${dnd.fund.test.url}")
	private String TestUrl;
	
	@Value("${dnd.fund.main.url}")
	private String mainUrl;
	
	// https://iexcloud.io/docs/api/#api-reference
	
	// GET /stock/{symbol}/batch
	// GET /data-points/{symbol}
	// GET /stock/{symbol}/advanced-stats/
	// GET /stock/{symbol}/balance-sheet
	// GET /stock/{symbol}/book
	// GET /stock/{symbol}/delayed-quote
	// GET /stock/{symbol}/dividends/{range}
	// GET /stock/{symbol}/fund-ownership
	// GET /stock/{symbol}/chart/{range}/{date}
	// GET /stock/{symbol}/income
	// GET /stock/{symbol}/insider-roster
	// GET /stock/{symbol}/insider-summary
	// GET /stock/{symbol}/insider-transactions
	// GET /stock/{symbol}/intraday-prices
	// GET /stock/{symbol}/stats/{stat?}
	// GET /stock/{symbol}/largest-trades
	// GET /stock/{symbol}/ohlc
	// GET /stock/{symbol}/previous
	// GET /stock/{symbol}/price
	// GET /stock/{symbol}/quote/{field}
	// GET /stock/{symbol}/indicator/{indicator-name}
	
	public void getTestPriceData() {
		String url = TestUrl + "";
		ResponseEntity<?> entity = apiService.get(url);
		
		
		
	}
	
}
