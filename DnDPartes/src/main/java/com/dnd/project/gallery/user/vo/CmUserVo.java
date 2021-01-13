package com.dnd.project.gallery.user.vo;

import java.util.HashMap;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.dnd.project.common.baseUtill.CommonVo;
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
public class CmUserVo extends CommonVo{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USER_KEY")
	private Long userKey;

	@Column(name = "ID")
	private String id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "ALIAS")
	private String alias;

	@Column(name = "PASSWORD")
	private String password;

	@Column(name = "EMAIL")
	private String email;

	@Transient
	private String token;
	
	@Override
	public HashMap<String, Object> getLikeKeys(){
		HashMap<String, Object> map = new HashMap<String, Object>();

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
		return this.userKey;
	}
}
