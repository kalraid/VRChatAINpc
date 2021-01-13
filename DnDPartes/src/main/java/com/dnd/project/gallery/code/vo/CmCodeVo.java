package com.dnd.project.gallery.code.vo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.dnd.project.gallery.board.vo.CmGalleryVo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
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
