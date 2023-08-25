package com.notify.entity;

import java.util.Date;

	
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class Audit {

		
		@Temporal(TemporalType.DATE)
		@CreatedDate
		@Column(name = "create_dt",nullable = false,updatable = false)
		private Date cratedDate;
		
		
		@Temporal(TemporalType.DATE)
		@LastModifiedDate
		@Column(name = "update_dt",nullable = false)
		private Date updateDate;


}
