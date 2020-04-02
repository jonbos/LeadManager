package com.jbos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jbos.beans.SalesLead;

@Repository
public interface LeadRepository extends JpaRepository<SalesLead, Long> {

	@Query(nativeQuery = true, value = "SELECT  sl.lead_name, sl.id, sl.lead_notes,sl.lead_email, sl.phone_number, t.contact_date \n"
			+ "FROM leads.sales_lead AS sl \n" + "LEFT JOIN leads.touch \n" + "AS t ON sl.id = t.sales_lead_id \n"
			+ "GROUP BY sl.lead_name, sl.id, sl.lead_notes,sl.lead_email, sl.phone_number, t.contact_date \n"
			+ "ORDER BY t.contact_date ")
	List<SalesLead> getOldestContacts();
}
