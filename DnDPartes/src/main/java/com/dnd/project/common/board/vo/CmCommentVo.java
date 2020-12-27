package com.dnd.project.common.board.vo;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
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
public class CmCommentVo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long commentKey;

    @ManyToOne
    @JoinColumn
	private CmBoardVo cmBoardVo;
	
	private String name;

	private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private CmCommentVo parentComment;

    @OneToMany(mappedBy = "parentComment", fetch = FetchType.LAZY)
    private List<CmCommentVo> childrenComments;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date instDt;

	@Temporal(value = TemporalType.TIMESTAMP)
	private Date updDt;

}