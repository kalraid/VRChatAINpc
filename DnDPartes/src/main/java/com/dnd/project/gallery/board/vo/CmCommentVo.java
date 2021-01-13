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

import com.dnd.project.common.baseUtill.CommonVo;

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
public class CmCommentVo extends CommonVo{
 
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
		return this.commentKey;
	}
	
}