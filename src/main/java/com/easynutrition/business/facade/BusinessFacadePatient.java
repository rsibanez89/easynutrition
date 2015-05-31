package com.easynutrition.business.facade;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.easynutrition.business.mail.BusinessMailSender;
import com.easynutrition.data.dao.DataDaoPatient;
import com.easynutrition.data.dao.DataDaoUser;
import com.easynutrition.data.dao.DataDaoUserRole;
import com.easynutrition.data.entity.DataEntityPatient;
import com.easynutrition.data.entity.DataEntityUser;
import com.easynutrition.data.type.DataTypeUserRole;

@Service
@Transactional
public class BusinessFacadePatient {
	@Autowired
	private DataDaoPatient daoPatient;
	@Autowired
	private DataDaoUser daoUser;
	@Autowired
	private DataDaoUserRole daoUserRole;

	@Autowired
	private BusinessMailSender sender;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;


	public DataEntityPatient findById(Long id) {
		return daoPatient.findById(id);
	}
	
	public void delete(Long patientId) {
		DataEntityPatient patient = daoPatient.findById(patientId);
		daoPatient.delete(patientId);
		daoUser.delete(patient.getEmail());
	}

	public void merge(DataEntityPatient patient, String nutricionist, Locale locale, boolean sendmail) {
		// checks if it is a create action
		if (patient.getId() == null && !patient.getEmail().isEmpty()) {
			// gets data
			String username = patient.getEmail();
			String password = patient.getFirstName();
			
			// creates user
			DataEntityUser user = new DataEntityUser();
			user.setUsername(username);
			user.setPassword(passwordEncoder.encode(password));
			user.setEnabled(true);
			user.setRole(daoUserRole.findByName(DataTypeUserRole.USER));
			daoUser.persist(user);
			
			// sends mail on patient create
			if (sendmail) {
				sender.sendMailNewPatient(username, username, password, nutricionist, locale);
			}
		}
		
		// persists data
		daoPatient.merge(patient);
	}
	
}