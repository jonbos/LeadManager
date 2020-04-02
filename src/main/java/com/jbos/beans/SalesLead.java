package com.jbos.beans;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class SalesLead {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Autowired
	private LeadInformation info;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "salesLead", cascade = {CascadeType.MERGE, CascadeType.REMOVE})
	@OrderBy("contactDate DESC")
	private List<Touch> touches;
}
