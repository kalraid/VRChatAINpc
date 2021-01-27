package com.dnd.project.gallery.board.vo;

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

import org.hibernate.annotations.BatchSize;

import com.dnd.project.common.baseUtill.CommonVo;
import com.dnd.project.gallery.user.vo.CmUserVo;

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
public class CmBoardVo extends CommonVo{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long boardKey;

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    @BatchSize(size=10)
	private CmGalleryVo cmGalleryVo;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
	private CmUserVo cmUserVo;
	
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    @BatchSize(size=10)
    private CmBoardVo parentBoard;

    @OneToMany(mappedBy = "parentBoard", fetch = FetchType.LAZY)
    private List<CmBoardVo> childrenBoard;
    
	private String title;

	private String content;

	
	@Override
	public HashMap<String, Object> getLikeKeys(){
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("title", this.title);
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
	public HashMap<String, Object> getJoinKeys(){
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("cmGalleryVo-alias", this.cmGalleryVo.getAlias());
		
		super.joinKeys = map;
		return super.joinKeys;
	}
	
	@Override
	public Long getPkId() {
		return this.boardKey;
	}
	
	
}