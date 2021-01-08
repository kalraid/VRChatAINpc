package com.dnd.project.mabinogi.stuff.packging.vo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.dnd.project.mabinogi.stuff.character.vo.MbCharacterVo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@Entity
public class MbBagpackVo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long bagpackKey;
	
    @ManyToOne
    @JoinColumn
    private MbCharacterVo mbCharacterVo;
	
	private String name;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date instDt;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date updDt;
}