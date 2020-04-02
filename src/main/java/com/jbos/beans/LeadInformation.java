package com.jbos.beans;

import javax.persistence.Embeddable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
public class LeadInformation {
	private String leadName;
	private String phoneNumber;
	private String leadEmail;
	private String leadNotes;
}
