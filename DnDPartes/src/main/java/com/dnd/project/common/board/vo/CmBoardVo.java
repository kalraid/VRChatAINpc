package com.dnd.project.common.board.vo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.dnd.project.common.baseUtill.CommonVo;
import com.dnd.project.common.user.vo.CmUserVo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Builder
public class CmBoardVo extends CommonVo{

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

	
	@Override
	public HashMap<String, Object> getLikeKeys(){
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("name", this.name);
		map.put("content", this.content);
		
		super.likeKeys = map;
		return super.likeKeys;
	}
	
	@Override
	public HashMap<String, Object> getEqualKeys(){
		HashMap<String, Object> map = new HashMap<String, Object>();
		super.equalKeys = map;
		return super.equalKeys;
	}
	
	@Override
	public Long getPkId() {
		return this.boardKey;
	}
}