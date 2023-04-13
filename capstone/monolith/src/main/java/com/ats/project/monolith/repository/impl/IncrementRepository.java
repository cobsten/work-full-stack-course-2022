package com.ats.project.monolith.repository.impl;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ats.project.monolith.entity.Passenger;
import com.ats.project.monolith.repository.PassengerRepository;

@Repository
public class IncrementRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	public BigInteger getPassengerIdCounter() {
		return getCounter("seq_tb_passenger");
	}
	
	public BigInteger getAirportIdCounter() {
		return getCounter("seq_tb_airport");
	}
	
	public BigInteger getPlaneRegNoCounter() {
		return getCounter("seq_tb_plane");
	}
	
	public BigInteger getScheduleIdCounter() {
		return getCounter("seq_tb_schedule");
	}
	
	public BigInteger getBookingIdCounter() {
		return getCounter("seq_tb_booking");
	}
	
	private BigInteger getCounter(String seqTableName) {
		Query query = entityManager.createNativeQuery("INSERT INTO EFSNATDB."+seqTableName+"(id,date_time) VALUES (null,DEFAULT);");
		query.executeUpdate();
		Query queryIncrement = entityManager.createNativeQuery("SELECT LAST_INSERT_ID();");
		return (BigInteger) queryIncrement.getSingleResult();
	}

}
