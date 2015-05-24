package com.easynutrition.business.facade;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.easynutrition.business.mail.BusinessMailSender;
import com.easynutrition.data.dao.DataDaoEvaluation;
import com.easynutrition.data.dao.DataDaoPatient;
import com.easynutrition.data.dao.DataDaoUser;
import com.easynutrition.data.dao.DataDaoUserRole;
import com.easynutrition.data.entity.DataEntityEvaluation;
import com.easynutrition.data.entity.DataEntityPatient;
import com.easynutrition.data.entity.DataEntityUser;
import com.easynutrition.data.type.DataTypeUserRole;

@Service
public class BusinessFacadePatient {
	@Autowired
	private DataDaoPatient daoPatient;
	@Autowired
	private DataDaoEvaluation daoEvaluation;
	@Autowired
	private DataDaoUser daoUser;
	@Autowired
	private DataDaoUserRole daoUserRole;

	@Autowired
	private BusinessMailSender sender;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;


	@Transactional
	public DataEntityPatient findById(Long id) {
		return daoPatient.findById(id);
	}
	
	public List<DataEntityPatient> findAll() {
		return daoPatient.findAll("id");
	}

	public List<DataEntityEvaluation> findEvaluations(Long patientId) {
		return daoEvaluation.findByPatientId(patientId);
	}

	public void createPatient(DataEntityPatient patient, String nutricionist, Locale locale) {
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
			sender.sendMailNewPatient(username, username, password, nutricionist, locale);
		}
		
		// persists data
		daoPatient.merge(patient);
	}

}