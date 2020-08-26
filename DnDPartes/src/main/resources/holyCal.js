function holyBuffSet(jobGrowName, holyList) {
	let dom = "";
	
	let current_buff = holyList["customHolyListObj"] != undefined ? holyList["customHolyListObj"] : holyList["holyListObj"];
	
	let buff_icon_type = Array();
	switch (jobGrowName) {
	case "세라핌" :
		buff_icon_type.push("14/icon/084.png");
		buff_icon_type.push("14/icon/262.png");
		buff_icon_type.push("14/icon/260.png");
		break;
	case "세인트" :
		buff_icon_type.push("4/icon/112.png");
		buff_icon_type.push("4/icon/156.png");
		buff_icon_type.push("4/icon/158.png");
		break;
	case "헤카테" :
		buff_icon_type.push("3/icon/719.png");
		buff_icon_type.push("3/icon/755.png");
		buff_icon_type.push("3/icon/757.png");
		break;
	}
	
	let buff_icon = [buff_icon_type[0], buff_icon_type[0], "4/icon/000.png", "4/icon/006.png", "4/icon/470.png", buff_icon_type[1], buff_icon_type[2]];
	
	for (let i = 0; i < current_buff.length; i++) {
		
		dom += 
			'<div class="buffRow" style="border-bottom:1px solid #D8D8D8;padding:10px; width: 100%; display: inline-flex;'+
			'background-color: '+ ( i == current_buff.length-1 ? '#ffc107' : 'white' )+';"'+
			'data-id='+current_buff[i].name+
			'>';
		
		if ( i < 7 ) {
			dom += '<img src="https://d-fighter.dn.nexoncdn.co.kr/samsungdnf/neople/swf/2019/skill/'+
				buff_icon[i]+ '"' +
				'style="margin-top: auto; margin-bottom: auto; width: 35px; height: 35px;">';
		}
		
		dom += 
		'<a style="padding-left: 5px; padding-right: 5px; margin-top: auto; margin-bottom: auto; white-space: nowrap;">'
		+current_buff[i].name+
		'</a>';
		
		dom += 
		'<div style="margin-top: auto; margin-bottom: auto; margin-left: auto;'+
					'display: inline-block; text-align: right; white-space: nowrap;'+
					'font-variant-numeric: tabular-nums; letter-spacing: -0.3px;">';
		
		
		
		if ( holyList["customHolyListObj"] != undefined ) {
			let color = current_buff[i]["add"].indexOf("+") > -1 ? 'green' : 'red' ;
			if ( jobGrowName == '헤카테' ) {
				dom += 
					'<a class="buffLabel" style="display: inline-block; font-weight: bold;">'+current_buff[i].value+'</a>'+
					'<div style="float: right; margin-left: 5px; color: '+color+';">'+
						'<a style="font-size: 15px; margin-top: auto; margin-bottom: auto;">'+current_buff[i].add+'</a><br/>';
				if ( !( i > 4 && i < 7 ) && i != 9  ) {
					dom += '<a style="font-size: 15px; margin-top: auto; margin-bottom: auto; margin-left: 2px;">'+current_buff[i].add2+'</a><br/>';
				}
				if ( jobGrowName == '헤카테' && !( i > 4 && i < 7 ) && i != 9  ) {
					dom +=
						'<a style="font-size: 15px; margin-top: auto; margin-bottom: auto;">'+current_buff[i].add3+'</a><br/>'+
						'<a style="font-size: 15px; margin-top: auto; margin-bottom: auto;">'+current_buff[i].add4+'</a><br/>';
				}
			} else {
				dom += 
					'<a class="buffLabel" style="font-weight: bold;">'+current_buff[i].value+'</a><br/>'+
					'<div style="float: right; margin-left: 5px; display: inline-flex; color: '+color+';">'+
						'<a style="font-size: 15px; margin-top: auto; margin-bottom: auto;">'+current_buff[i].add+'</a><br/>';
				
				if ( jobGrowName == '세라핌' ) {
					if ( !( i > 4 && i < 7 ) && i != 9 ) {
						dom += '<a style="font-size: 15px; margin-top: auto; margin-bottom: auto; margin-left: 2px;">'+current_buff[i].add2+'</a><br/>';
					}
				} else {
					if ( i != 5 && i != 9 ) {
						dom += 
						'<a style="font-size: 15px; margin-top: auto; margin-bottom: auto; margin-left: 2px;">'+current_buff[i].add2+'</a><br/>';
					}
				}
				
			}
			
			dom += '</div>';
		} else {
			dom += '<a class="buffLabel" style="font-weight: bold;">'+current_buff[i].value+'</a><br/>';
		}
		dom += 		
			'</div>'+
		'</div>';
	}
	
	$('.buffRows').prepend(dom);
}

function getHolyList(jobGrowName, char_damages, awaken_args) {

	var result = Object();
    if (char_damages["holyListObj"] != undefined || char_damages["customHolyListObj"] != undefined) {
    	var holyList;
    	var holyListDef;
    	var isCustom = false;
    	if (char_damages["customHolyListObj"] != undefined) {
    		holyList = char_damages["customHolyListObj"];
    		holyListDef = char_damages["holyListObj"];
    		isCustom = true;
    	} else {
    		holyList = char_damages["holyListObj"];
    	}
    	
        var totalStr = [[0,0,0,0],[0,0,0,0]];
        var totalInt = [[0,0,0,0],[0,0,0,0]];

        var buffName = ["영광의 축복(힘)", "영광의 축복(지능)", "영광의 축복(물공)" ,"영광의 축복(마공)" ,"영광의 축복(독공)" , "신념의 오라", "아포칼립스(2각)", "버프력"];
        var buffName2 = ["용맹의 축복(힘)", "용맹의 축복(지능)", "용맹의 축복(물공)" ,"용맹의 축복(마공)" ,"용맹의 축복(독공)" , "신실한 열정", "크럭스 오브 빅토리아", "버프력"];
        var buffName3 = ["금단의 저주(힘)", "금단의 저주(지능)", "금단의 저주(물공)", "금단의 저주(마공)", "금단의 저주(독공)", "소악마", "마리오네트", "버프력"];
        var buffName4 = ["(기본) ", "(퍼펫) ", "(편애) ", "(퍼펫x편애) "];
    	if (jobGrowName == "세라핌") { buffName = buffName2; }
    	else if (jobGrowName == "헤카테") { buffName = buffName3; }
    	var s = ["", ""];
    	if (jobGrowName == "헤카테") {
    		s[0] = "(";
    		s[1] = ")";
    	}

    	var isZero = true;
    	for (var i=0; i<holyList.length; i++) {
    		var hl = holyList[i];
    		hl["name"] = buffName[i];
    		var val1 = parseFloat(hl["val"]) * (hl["awaken"] != undefined ? hl["awaken"][awaken_args] : 1);
    		var val2 = parseFloat(hl["val2"]) * (hl["awaken"] != undefined ? hl["awaken"][awaken_args] : 1);

    		if (jobGrowName == "헤카테") {
    			if ( i < 5 ) {
    				hl["value"] = (buffName4[0] + $.number(val1) + "<br/>"
                    + buffName4[1] + $.number(val2) + "<br/>"
                    + buffName4[2] + $.number(parseFloat(hl["val3"])) + "<br/>"
                    + buffName4[3] + $.number(parseFloat(hl["val4"])));
    			} else {
					hl["value"] = $.number(val1);
    			}
			} else {
				if ( i > 4 && jobGrowName == "세라핌" ) {
					hl["value"] = $.number(val1);
				} else if ( (i == 5 || i == 7) && jobGrowName == "세인트" ) {
					hl["value"] = $.number(val1);
				} else {
					hl["value"] = $.number(val1) + "(" + $.number(val2) + ")";
				}
			}

    		switch (hl["name"]) {
               	case "영광의 축복(힘)":
               	case "용맹의 축복(힘)":
               		totalStr[0][0] += parseInt(val1);
               		totalStr[0][1] += parseInt(val2);
               		break;
               	case "금단의 저주(힘)":
               		totalStr[0][0] += parseInt(val1);
               		totalStr[0][1] += parseInt(val2);
               		totalStr[0][2] += parseInt(parseFloat(hl["val3"]));
               		totalStr[0][3] += parseInt(parseFloat(hl["val4"]));
               		break;
               	case "영광의 축복(지능)":
               	case "용맹의 축복(지능)":
               		totalInt[0][0] += parseInt(val1);
               		totalInt[0][1] += parseInt(val2);
               		break;
               	case "금단의 저주(지능)":
               		totalInt[0][0] += parseInt(val1);
               		totalInt[0][1] += parseInt(val2);
               		totalInt[0][2] += parseInt(parseFloat(hl["val3"]));
               		totalInt[0][3] += parseInt(parseFloat(hl["val4"]));
               		break;
               	case "아포칼립스(2각)":
               	case "크럭스 오브 빅토리아":
               	case "신념의 오라":
               	case "신실한 열정":
               		
					totalStr[0][0] += parseInt(val1);
               		totalStr[0][1] += parseInt(val2);
               		totalInt[0][0] += parseInt(val1);
               		totalInt[0][1] += parseInt(val2);
               		break;
               	case "마리오네트":
               	case "소악마":
       		
               		totalStr[0][0] += parseInt(val1);
                   	totalStr[0][1] += parseInt(val2);
                   	totalStr[0][2] += parseInt(parseFloat(hl["val3"]));
                   	totalStr[0][3] += parseInt(parseFloat(hl["val4"]));

                   	totalInt[0][0] += parseInt(val1);
                   	totalInt[0][1] += parseInt(val2);
                   	totalInt[0][2] += parseInt(parseFloat(hl["val3"]));
                   	totalInt[0][3] += parseInt(parseFloat(hl["val4"]));
               		break;
               	case "버프력":
               		const total_buff = holyRank(holyList, jobGrowName == '헤카테' ? "val4" : "val2", awaken_args);
               		holyList[i].value = $.number(total_buff);
               		break;
    		}

    		if (isCustom) {
                var h2 = holyListDef[i];
                
                var def_val1 = parseFloat(h2["val"]) * (h2["awaken"] != undefined ? h2["awaken"][awaken_args] : 1);
                var def_val2 = parseFloat(h2["val2"]) * (h2["awaken"] != undefined ? h2["awaken"][awaken_args] : 1);
    			switch (i) {
                   	case 0: //영광/용맹의축복(힘)
                   		totalStr[1][0] += parseInt(def_val1);
                   		totalStr[1][1] += parseInt(def_val2);
                   		if (jobGrowName == "헤카테") {
                   			totalStr[1][2] += parseInt(parseFloat(h2["val3"]));
                   			totalStr[1][3] += parseInt(parseFloat(h2["val4"]));
                   		}
                   		break;
                   	case 1: //영광/용맹의축복(지능)
                   		totalInt[1][0] += parseInt(def_val1);
                   		totalInt[1][1] += parseInt(def_val2);
                   		if (jobGrowName == "헤카테") {
                   			totalInt[1][2] += parseInt(parseFloat(h2["val3"]));
                   			totalInt[1][3] += parseInt(parseFloat(h2["val4"]));
                   		}
                   		break;
                   	case 5:
                   	case 6: //아포/크오빅(2각/아리아)
                   		if (jobGrowName == "헤카테") {
                   			totalStr[1][0] += parseInt(def_val1);
                   			totalStr[1][1] += parseInt(def_val2);
                   			totalStr[1][2] += parseInt(parseFloat(h2["val3"]));
                   			totalStr[1][3] += parseInt(parseFloat(h2["val4"]));

                   			totalInt[1][0] += parseInt(def_val1);
                   			totalInt[1][1] += parseInt(def_val2);
                   			totalInt[1][2] += parseInt(parseFloat(h2["val3"]));
                   			totalInt[1][3] += parseInt(parseFloat(h2["val4"]));
                   		} else {
                   			totalStr[1][0] += parseInt(def_val1);
                   			totalStr[1][1] += parseInt(def_val2);
                   			totalInt[1][0] += parseInt(def_val1);
                   			totalInt[1][1] += parseInt(def_val2);
                   		}
                   		break;
    			}

    			var add = "";
    			var add2 = "";
    			
    			if ( i == 7 ) {
    				val1 = holyRank(holyList, jobGrowName == '헤카테' ? "val4" : "val2", awaken_args);
    				def_val1 = holyRank(holyListDef, jobGrowName == '헤카테' ? "val4" : "val2", awaken_args);
    			}
    			
    			
    			if (val1 >= def_val1) {
    				add = s[0] + "+" + $.number(val1 - def_val1) + s[1];
    			} else {
    				add = s[0] + "-" + $.number(def_val1 - val1) + s[1];
				}

    			if (val2 >= def_val2) {
    				add2 = "(+" + $.number(val2 - def_val2) + ")";
    			} else {
    				add2 = "(-" + $.number(def_val2 - val2) + ")";
    			}

    			hl["add"] = add;

    			if (add2 != "") {
                    hl["add2"] = add2;
    			}

    			if (jobGrowName == "헤카테") {
    				var val3 = parseFloat(parseInt(hl["val3"]));
    				var val4 = parseFloat(parseInt(hl["val4"]));

    				var def_val3 = parseFloat(parseInt(h2["val3"]));
    				var def_val4 = parseFloat(parseInt(h2["val4"]));

    				var add3 = "";
    				var add4 = "";

    				if (val3 >= def_val3) {
    					add3 = "(+" + $.number(val3 - def_val3) + ")";
    				} else {
    					add3 = "(-" + $.number(def_val3 - val3) + ")";
    				}
    				if (val4 >= def_val4) {
    					add4 = "(+" + $.number(val4 - def_val4) + ")";
    				} else {
    					add4 = "(-" + $.number(def_val4 - val4) + ")";
    				}
    				hl["add3"] = add3;
    				hl["add4"] = add4;
    				
    			}
    		}
    		holyList[i] = hl;
    		if (hl["val"] != 0 || hl["val2"] != 0) isZero = false;
    	}

    	if (!isZero) {
    		var total_buff_temp = holyList[holyList.length-1];
    		holyList.pop(holyList.length-1);
    		var statStr = ["힘", "지능"];
            var cal;
    		for (var i=0; i<2; i++) {
    			if (i == 0) cal = totalStr;
    			if (i == 1) cal = totalInt;
                var d2 = Object();
    			d2["name"] = "총 " + statStr[i];
    			
    			if (jobGrowName == "헤카테") {
                    d2["value"] = (buffName4[0] + $.number(cal[0][0])
    				+ "<br/>" + buffName4[1] + $.number(cal[0][1])
    				+ "<br/>" + buffName4[2] + $.number(cal[0][2])
    				+ "<br/>" + buffName4[3] + $.number(cal[0][3]));
    			} else {
    				d2["value"] = $.number(cal[0][0]) + "(" + $.number(cal[0][1]) + ")";
    			}

    			if (isCustom) {
    				var add = "";
    				var add2 = "";
    				if (cal[0][0] < cal[1][0]) {
    					add = s[0] + "-" + $.number(cal[1][0] - cal[0][0]) + s[1];
    				} else {
    					add = s[0] + "+" + $.number(cal[0][0] - cal[1][0]) + s[1];
    				}
    				if (cal[0][1] < cal[1][1]) {
    					add2 = "(-" + $.number(cal[1][1] - cal[0][1]) + ")";
    				} else {
    					add2 = "(+" + $.number(cal[0][1] - cal[1][1]) + ")";
    				}

    				d2["add"] = add;
    				if (add2 != "") {
                        d2["add2"] = add2;
    				}

    				if (jobGrowName == "헤카테") {
                        if (cal[0][2] < cal[1][2]) {
    						add = "(-" + $.number(cal[1][2] - cal[0][2]) + ")";
    					} else {
    						add = "(+" + $.number(cal[0][2] - cal[1][2]) + ")";
    					}
    					if (cal[0][3] < cal[1][3]) {
    						add2 = "(-" + $.number(cal[1][3] - cal[0][3]) + ")";
    					} else {
    						add2 = "(+" + $.number(cal[0][3] - cal[1][3]) + ")";
    					}
                        d2["add3"] = add;
                        d2["add4"] = add2;
    				}
    				holyList.push(d2);
    				
    				if ( i == 1 ) holyList.push(total_buff_temp);

    				result["holyListObj"] = holyListDef;
    				result["customHolyListObj"] = holyList;
    			} else {
                    holyList.push(d2);
                    
                    if ( i == 1 ) holyList.push(total_buff_temp);
                    
                    result["holyListObj"] = holyList;
    			}
    		}
    		
    	}
    }
    
    holyBuffSet(jobGrowName, result);
    return result;
}

function holyRank(holy, val, awaken_args) {
    var s = holy[0][val];
    var a = holy[2][val] + holy[3][val] + holy[4][val];
    var p = holy[5][val];
    var k = holy[6][val];
    return parseInt((1+(parseFloat((s+p+Math.round(k*holy[6]["awaken"][awaken_args])+15000)/250)))*(parseInt((a/3))+2650)/10);
}
