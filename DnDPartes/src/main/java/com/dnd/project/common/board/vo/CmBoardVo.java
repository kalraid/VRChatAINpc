package com.dnd.project.common.board.vo;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
public class CmBoardVo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long boardKey;

    @ManyToOne
    @JoinColumn
	private CmGalleryVo cmGalleryVo;
	
    @ManyToOne
    @JoinColumn
	private CmUserVo cmUserVo;
	
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private CmBoardVo parentBoard;

    @OneToMany(mappedBy = "parentBoard", fetch = FetchType.LAZY)
    private List<CmBoardVo> childrenBoard;
    
	private String name;

	private String content;

	@Temporal(value = TemporalType.TIMESTAMP)
	private Date instDt;

	@Temporal(value = TemporalType.TIMESTAMP)
	private Date updDt;

}