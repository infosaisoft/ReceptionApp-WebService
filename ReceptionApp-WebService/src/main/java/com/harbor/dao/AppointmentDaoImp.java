package com.harbor.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.harbor.bo.AppointmentsBo;

@Repository
public class AppointmentDaoImp implements AppointmentDao {

	private static final String INSERT_QUERY = "INSERT INTO appointments (app_id,hid,patient_name,contact,time,appointment_date,status) VALUES (?,?,?,?,?,?,?)"; 

	private static final String GET_ALL_QUERY = "SELECT app_id,hid,patient_name,contact,time,appointment_date FROM appointments WHERE hid=? AND appointment_date=?";

	@Autowired
	JdbcTemplate jt;

	@Override
	public int insertAppintment(AppointmentsBo abo) {
		int count = 0;
		count = jt.update(INSERT_QUERY, abo.getApp_id(), abo.getHid(), abo.getPatient_name(), abo.getContact(),
				abo.getTime(), new Date(),abo.getStatus());

		return count;
	}

	@Override
	public List<AppointmentsBo> getAllAppointment(String hid, Date date) {
		List<AppointmentsBo> listbo = null;

		listbo = jt.query(GET_ALL_QUERY, new ResultSetExtractor<List<AppointmentsBo>>() {

			@Override
			public List<AppointmentsBo> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<AppointmentsBo> listbo = new ArrayList<>();
				AppointmentsBo abo = null;

				while (rs.next()) {
					abo = new AppointmentsBo();

					abo.setApp_id(rs.getString(1));
					abo.setHid(rs.getString(2));
					abo.setPatient_name(rs.getString(3));
					abo.setContact(rs.getString(4));
					abo.setTime(rs.getString(5));
					abo.setDate(rs.getDate(6));
					listbo.add(abo);

				}

				return listbo;
			}

		}, hid, date);
		return listbo;
	}

}
