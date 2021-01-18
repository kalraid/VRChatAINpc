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
public class CmGalleryVo extends CommonVo{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long galleryKey;

	private String name;

	private String type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    @BatchSize(size=10)
    private CmGalleryVo parentGallery;

    @OneToMany(mappedBy = "parentGallery", fetch = FetchType.LAZY)
    private List<CmGalleryVo> childrenGallery;
	
	@Override
	public HashMap<String, Object> getLikeKeys(){
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("name", this.name);
		
		super.likeKeys = map;
		return super.likeKeys;
	}
	
	@Override
	public HashMap<String, Object> getEqualKeys(){
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("type", this.type);
		
		super.equalKeys = map;
		return super.equalKeys;
	}
	
	@Override
	public Long getPkId() {
		return this.galleryKey;
	}
	
}