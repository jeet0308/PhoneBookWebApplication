package com.example.demo.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="CONTACT_DTLS")
@Getter
@Setter
@NoArgsConstructor
public class Contact {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer contactId;
	
	@Column(name="CONTACT_NAME" , length = 20 )
	private String contactName;
	
	@Column(name="CONTACT_NUMBER" , length = 20)
	private String contactNumber;
	
	@Column(name="CONTACT_EMAIL" , length = 40)
	private String contactEmail;
	
	@Column(name="ACTIVE_SWITCH")
	private Character activeSwitch;
	
	@Column(name="CREATED_DATE", updatable = false)
	@CreationTimestamp
	private LocalDate createDate;
	
	@Column(name="UPDATED_DATE")
	@UpdateTimestamp
	private LocalDate updateDate;
}
