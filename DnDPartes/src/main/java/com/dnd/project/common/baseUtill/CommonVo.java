package com.dnd.project.common.baseUtill;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.springframework.data.domain.Pageable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@MappedSuperclass
@Setter
@Getter
@ToString
public abstract class CommonVo {

	@Transient
	protected HashMap<String, Object> likeKeys;
	
	@Transient
	protected HashMap<String, Object> equalKeys;
	
	@JsonIgnore
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(name = "INST_DT")
	private Date instDt;

	@JsonIgnore
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(name = "UPD_DT")
	private Date updDt;
    
    @PrePersist
    protected void onPersist() {
            this.instDt = this.updDt = Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant());
    }
    
    @PreUpdate
    protected void onUpdate() {
            this.updDt = Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant());
    }

	public HashMap<String, Object> getLikeKeys() {
		return this.likeKeys;
	}
	
	public HashMap<String, Object> getEqualKeys() {
		return this.equalKeys;
	}
	
	public Long getPkId() {
		return null;
	}
}
