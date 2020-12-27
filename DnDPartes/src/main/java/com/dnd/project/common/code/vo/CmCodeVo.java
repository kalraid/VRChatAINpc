package com.dnd.project.common.code.vo;

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
public class CmCodeVo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="CODE_KEY")
	private Long codeKey;
	
	private String name1;
	private String name2;
	private String name3;
	private String name4;
	private String name5;
	private String val1;
	private String val2;
	private String val3;
	private String val4;
	private String val5;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date instDt;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date updDt;
}
