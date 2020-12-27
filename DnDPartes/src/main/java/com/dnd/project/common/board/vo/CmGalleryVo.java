package com.dnd.project.common.board.vo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
public class CmGalleryVo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long galleryKey;

	private String name;

	private String type;

	@Temporal(value = TemporalType.TIMESTAMP)
	private Date instDt;

	@Temporal(value = TemporalType.TIMESTAMP)
	private Date updDt;

}