package com.dnd.project.common.point.vo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.dnd.project.common.user.vo.CmUserVo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
public class CmPointVo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long pointKey;
	
	private int pointIncreseDecrese;
	
	private Boolean pointSign;
	
    @ManyToOne
    @JoinColumn
    private CmUserVo cmUser;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date instDt;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date updDt;
}
