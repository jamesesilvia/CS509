package client.view;

import java.io.*;

import client.model.*;

import com.justformspdf.pdf.*;

public class ReportPrinter
{
	public ReportPrinter(Report rep) throws Exception
	{ 
		File myFile = new File("C:/AREST/ARESTTemplate.pdf");
		FileInputStream fis = new FileInputStream(myFile);				
		PDF pdf = new PDF(new PDFReader(fis));
		Form form = pdf.getForm();
		
		FormText reporterName = (FormText) form.getElement("ReporterName");
		reporterName.setValue(rep.reporter.firstName + " " + rep.reporter.lastName);
		
		FormText reporterAddress = (FormText) form.getElement("ReporterAddress");
		reporterAddress.setValue(rep.reporter.address);
		
		FormText reporterTelephone = (FormText) form.getElement("ReporterTelephone");
		reporterTelephone.setValue(rep.reporter.phoneNumber);
		
		FormText reporterMandated = (FormText) form.getElement("ReporterMandated");
		if(rep.reporter.isMandated())
		{
			reporterMandated.setValue("X");
		}
		
		FormText reporterNonmandated = (FormText) form.getElement("ReporterNonmandated");
		if(!rep.reporter.isMandated())
		{
			reporterMandated.setValue("X");
		}
		
		FormText reporterRelationship = (FormText) form.getElement("ReporterRelationship");
		reporterRelationship.setValue(rep.reporter.relationshipToVictim);
		
		FormText victimName = (FormText) form.getElement("VictimName");
		victimName.setValue(rep.victim.firstName + " " + rep.victim.lastName);
		
		FormText victimAddress = (FormText) form.getElement("VictimAddress");
		victimAddress.setValue(rep.victim.address);
		
		FormText victimTelephone = (FormText) form.getElement("VictimTelephone");
		victimTelephone.setValue(rep.victim.phoneNumber);
		
		FormText victimMale = (FormText) form.getElement("VictimMale");
		if(rep.victim.getSex().toUpperCase() == "MALE")
		{
			victimMale.setValue("X");
		}
		
		FormText victimFemale = (FormText) form.getElement("VictimFemale");
		if(rep.victim.getSex().toUpperCase() == "FEMALE")
		{
			victimMale.setValue("X");
		}
		
		FormText victimDOB = (FormText) form.getElement("VictimDOB");
		victimDOB.setValue(rep.victim.dob);
		
		FormText victimAge = (FormText) form.getElement("VictimAge");
		victimAge.setValue(rep.victim.age);
		
		FormText victimMaritalStatus = (FormText) form.getElement("VictimMaritalStatus");
		victimMaritalStatus.setValue(rep.victim.maritalStatus);
		
		FormText abuserName = (FormText) form.getElement("AbuserName");
		abuserName.setValue(rep.abuser.firstName + " " + rep.abuser.lastName);
		
		FormText abuserAddress = (FormText) form.getElement("AbuserAddress");
		abuserAddress.setValue(rep.abuser.address);
		
		FormText abuserRelationship = (FormText) form.getElement("AbuserRelationship");
		abuserRelationship.setValue(rep.abuser.relationshipToVictim);
		
		FormText ssn = (FormText) form.getElement("SSN");
		ssn.setValue(rep.abuser.social);
		
		FormText abuserDOB = (FormText) form.getElement("AbuserDOB");
		abuserDOB.setValue(rep.abuser.dob);
		
		FormText abuserTelephone = (FormText) form.getElement("AbuserTelephone");
		abuserTelephone.setValue(rep.abuser.phoneNumber);
		
		String disabled = rep.victim.disability.toUpperCase();
		FormText mentalRetardation = (FormText) form.getElement("MentalRetardation");
		if(disabled.contains("MENTAL RETARDATION"))
		{
			mentalRetardation.setValue("X");
			disabled = disabled.replace("MENTAL RETARDATION", "");
		}
		
		FormText mentalIllness = (FormText) form.getElement("MentalIllness");
		if(disabled.contains("MENTAL ILLNESS"))
		{
			mentalIllness.setValue("X");
			disabled = disabled.replace("MENTAL ILLNESS", "");
		}
		
		FormText mobility = (FormText) form.getElement("Mobility");
		if(disabled.contains("MOBILITY"))
		{
			mobility.setValue("X");
			disabled = disabled.replace("MOBILITY", "");
		}
		
		FormText headInjury = (FormText) form.getElement("HeadInjury");
		if(disabled.contains("HEAD INJURY"))
		{
			headInjury.setValue("X");
			disabled = disabled.replace("HEAD INJURY", "");
		}
		
		FormText visual = (FormText) form.getElement("Visual");
		if(disabled.contains("VISUAL"))
		{
			visual.setValue("X");
			disabled = disabled.replace("VISUAL", "");
		}
		
		FormText deaf = (FormText) form.getElement("Deaf");
		if(disabled.contains("DEAF / HARD OF HEARING"))
		{
			deaf.setValue("X");
			disabled = disabled.replace("DEAF / HARD OF HEARING", "");
		}
		
		FormText cerebralPalsy = (FormText) form.getElement("CerebralPalsy");
		if(disabled.contains("CEREBRAL PALSY"))
		{
			cerebralPalsy.setValue("X");
			disabled = disabled.replace("CEREBRAL PALSY", "");
		}

		FormText multipleSclerosis = (FormText) form.getElement("MultipleSclerosis");
		if(disabled.contains("MULTIPLE SCLEROSIS"))
		{
			multipleSclerosis.setValue("X");
			disabled = disabled.replace("MULTIPLE SCLEROSIS", "");
		}
		
		FormText seizures = (FormText) form.getElement("Seizures");
		if(disabled.contains("SEIZURES"))
		{
			seizures.setValue("X");
			disabled = disabled.replace("SEIZURES", "");
		}
		
		disabled = disabled.trim();		
		FormText otherDisability = (FormText) form.getElement("OtherDisability");
		if(disabled != "")
		{
			otherDisability.setValue("X");
		}
		
		FormText specifyDisability = (FormText) form.getElement("SpecifyDisability");
		if(disabled != "")
		{
			specifyDisability.setValue(disabled);
		}
				
		String comms = rep.victim.communicationNeeds.toUpperCase();
		FormText tty = (FormText) form.getElement("TTY");
		if(comms.contains("TTY"))
		{
			tty.setValue("X");
			comms = comms.replace("TTY", "");
		}
		
		FormText signInterpreter = (FormText) form.getElement("SignInterpreter");
		if(comms.contains("SIGN INTERPRETER"))
		{
			signInterpreter.setValue("X");
			comms = comms.replace("SIGN INTERPRETER", "");
		}
		
		comms = comms.trim();
		FormText otherCommunicationNeeds = (FormText) form.getElement("OtherCommunicationNeeds");
		if(comms != "")
		{
		otherCommunicationNeeds.setValue("X");
		}
		
		FormText specifyCommNeed = (FormText) form.getElement("SpecifyCommNeed");
		if(comms != "")
		{
		specifyCommNeed.setValue(comms);
		}
		
		FormText guardianName = (FormText) form.getElement("GuardianName");
		if(rep.guardian.firstName != null && rep.guardian.lastName != null)
		{
		guardianName.setValue(rep.guardian.firstName + " " + rep.guardian.lastName);
		}
		
		FormText guardianAddress = (FormText) form.getElement("GuardianAddress");
		if(rep.guardian.address != null)
		{
		guardianAddress.setValue(rep.guardian.address);
		}
		
		FormText guardianRelationship = (FormText) form.getElement("GuardianRelationship");
		if(rep.guardian.relationshipToVictim != null)
		{
		guardianRelationship.setValue(rep.guardian.relationshipToVictim);
		}
		
		FormText guardianTelephone = (FormText) form.getElement("GuardianTelephone");
		if(rep.guardian.phoneNumber != null)
		{
		guardianTelephone.setValue(rep.guardian.phoneNumber);
		}
		
		String served = rep.victim.currentlyServedBy.toUpperCase();
		FormText deptMentalHealth = (FormText) form.getElement("DeptMentalHealth");
		if(served.contains("DEPT. OF MENTAL HEALTH"))
		{
			deptMentalHealth.setValue("X");
			served = served.replace("DEPT. OF MENTAL HEALTH", "");
		}
		
		FormText massBlind = (FormText) form.getElement("MassBlind");
		if(served.contains("MASS COMM./BLIND"))
		{
			massBlind.setValue("X");
			served = served.replace("MASS COMM./BLIND", "");
		}
		
		FormText deptDevelopmentalServices = (FormText) form.getElement("DeptDevelopmentalServices");
		if(served.contains("DEPT. OF DEVELOPMENTAL SVCS."))
		{
			deptDevelopmentalServices.setValue("X");
			served = served.replace("DEPT. OF DEVELOPMENTAL SVCS.", "");
		}
		
		FormText massDeaf = (FormText) form.getElement("MassDeaf");
		if(served.contains("MASS. COMM./DEAF/HH"))
		{
			massDeaf.setValue("X");
			served = served.replace("MASS. COMM./DEAF/HH", "");
		}
		
		FormText massRehab = (FormText) form.getElement("MassRehab");
		if(served.contains("MASS. REHAB. COMM."))
		{
			massRehab.setValue("X");
			served = served.replace("MASS. REHAB. COMM.", "");
		}
		
		FormText servedByUnknown = (FormText) form.getElement("ServedByUnknown");
		if(served.contains("UNKNOWN"))
		{
			servedByUnknown.setValue("X");
			served = served.replace("UNKNOWN", "");
		}
		
		FormText deptCorrection = (FormText) form.getElement("DeptCorrection");
		if(served.contains("DEPT. OF CORRECTION"))
		{
			deptCorrection.setValue("X");
			served = served.replace("DEPT. OF CORRECTION", "");
		}
		
		FormText deptPublicHealth = (FormText) form.getElement("DeptPublicHealth");
		if(served.contains("DEPT. OF PUBLIC HEALTH"))
		{
			deptPublicHealth.setValue("X");
			served = served.replace("DEPT. OF PUBLIC HEALTH", "");
		}
		
		FormText none = (FormText) form.getElement("None");
		if(served.contains("NONE"))
		{
			none.setValue("X");
			served = served.replace("NONE", "");
		}
		
		served = served.trim();
		FormText servedByOther = (FormText) form.getElement("ServedByOther");
		if(served != "")
		{
			servedByOther.setValue("X");
		}
		
		FormText specifyServedBy = (FormText) form.getElement("SpecifyServedBy");
		if(served != "")
		{
			specifyServedBy.setValue(served);
		}
		
		FormText collateral = (FormText) form.getElement("Collateral");
		String coll = null;
		if(rep.collateralContact1 != null)
		{
			if(rep.collateralContact1.firstName != null && rep.collateralContact1.lastName != null && rep.collateralContact1.phoneNumber != null)
		coll += rep.collateralContact1.firstName + " " + rep.collateralContact1.getLastName() + "\n" + rep.collateralContact1.phoneNumber + "\n";
		}
		if(rep.collateralContact2 != null)
		{
			if(rep.collateralContact2.firstName != null && rep.collateralContact2.lastName != null && rep.collateralContact2.phoneNumber != null)
		coll += rep.collateralContact2.firstName + " " + rep.collateralContact2.getLastName() + "\n" + rep.collateralContact2.phoneNumber + "\n";
		}
		if(rep.collateralContact3 != null)
		{
			if(rep.collateralContact3.firstName != null && rep.collateralContact3.lastName != null && rep.collateralContact3.phoneNumber != null)
		coll += rep.collateralContact3.firstName + " " + rep.collateralContact3.getLastName() + "\n" + rep.collateralContact3.phoneNumber + "\n";
		}
		if(rep.collateralContact4 != null)
		{
			if(rep.collateralContact4.firstName != null && rep.collateralContact4.lastName != null && rep.collateralContact4.phoneNumber != null)
		coll += rep.collateralContact4.firstName + " " + rep.collateralContact4.getLastName() + "\n" + rep.collateralContact4.phoneNumber + "\n";
		}
		if(rep.collateralContact5 != null)
		{
			if(rep.collateralContact5.firstName != null && rep.collateralContact5.lastName != null && rep.collateralContact5.phoneNumber != null)
		coll += rep.collateralContact5.firstName + " " + rep.collateralContact5.getLastName() + "\n" + rep.collateralContact5.phoneNumber + "\n";
		}
		if(coll != null)
		{
		collateral.setValue(coll);
		}
		
		String service = rep.victim.typeOfService.toUpperCase();
		FormText institutional = (FormText) form.getElement("Institutional");
		if(service.contains("INSTITUTIONAL"))
		{
			institutional.setValue("X");
			service = service.replace("INSTITUTIONAL", "");
		}
		
		FormText serviceCoordination = (FormText) form.getElement("ServiceCoordination");
		if(service.contains("SERVICE COORDINATION"))
		{
			serviceCoordination.setValue("X");
			service = service.replace("SERVICE COORDINATION", "");
		}
		
		FormText residential = (FormText) form.getElement("Residential");
		if(service.contains("RESIDENTIAL"))
		{
			residential.setValue("X");
			service = service.replace("RESIDENTIAL", "");
		}
		
		FormText foster = (FormText) form.getElement("Foster");
		if(service.contains("FOSTER / SPEC. HOME CARE"))
		{
			foster.setValue("X");
			service = service.replace("FOSTER / SPEC. HOME CARE", "");
		}
		
		FormText dayProgram = (FormText) form.getElement("DayProgram");
		if(service.contains("DAY PROGRAM"))
		{
			dayProgram.setValue("X");
			service = service.replace("DAY PROGRAM", "");
		}
		
		FormText respite = (FormText) form.getElement("Respite");
		if(service.contains("RESPITE"))
		{
			respite.setValue("X");
			service = service.replace("RESPITE", "");
		}
		
		FormText caseManagement = (FormText) form.getElement("CaseManagement");
		if(service.contains("CASE MANAGEMENT"))
		{
			caseManagement.setValue("X");
			service = service.replace("CASE MANAGEMENT", "");
		}
		
		service = service.trim();
		FormText otherService = (FormText) form.getElement("OtherService");
		if(service != "")
		{
			otherService.setValue("X");
		}
		
		FormText specifyService = (FormText) form.getElement("SpecifyService");
		if(service != "")
		{
			specifyService.setValue(service);
		}
		
		
		String ethnicity = rep.victim.ethnicity.toUpperCase();
		FormText caucasian = (FormText) form.getElement("Caucasian");
		if(ethnicity.contains("CAUCASIAN"))
		{
			caucasian.setValue("X");
			ethnicity = ethnicity.replace("CAUCASIAN", "");
		}
		
		FormText hispanic = (FormText) form.getElement("Hispanic");
		if(ethnicity.contains("HISPANIC"))
		{
			hispanic.setValue("X");
			ethnicity = ethnicity.replace("HISPANIC", "");
		}
		
		FormText asian = (FormText) form.getElement("Asian");
		if(ethnicity.contains("ASIAN"))
		{
			asian.setValue("X");
			ethnicity = ethnicity.replace("ASIAN", "");
		}
		
		FormText africanAmerican = (FormText) form.getElement("AfricanAmerican");
		if(ethnicity.contains("AFRICAN AMERICAN"))
		{
			africanAmerican.setValue("X");
			ethnicity = ethnicity.replace("AFRICAN AMERICAN", "");
		}
		
		FormText nativeAmerican = (FormText) form.getElement("NativeAmerican");
		if(ethnicity.contains("NATIVE AMERICAN"))
		{
			nativeAmerican.setValue("X");
			ethnicity = ethnicity.replace("NATIVE AMERICAN", "");
		}
		
		ethnicity = ethnicity.trim();
		FormText otherEthnicity = (FormText) form.getElement("OtherEthnicity");
		if(ethnicity != "")
		{
			otherEthnicity.setValue("X");
		}
		
		FormText specifyEthnicity = (FormText) form.getElement("SpecifyEthnicity");
		if(ethnicity != "")
		{
			specifyEthnicity.setValue(ethnicity);
		}
		
		String frequency = rep.victim.freqOfAbuse.toUpperCase();
		FormText daily = (FormText) form.getElement("Daily");
		if(frequency.contains("DAILY"))
		{
			daily.setValue("X");
		}
		
		FormText increasing = (FormText) form.getElement("Increasing");
		if(frequency.contains("INCREASING"))
		{
			increasing.setValue("X");
		}
		
		FormText weekly = (FormText) form.getElement("Weekly");
		if(frequency.contains("WEEKLY"))
		{
			weekly.setValue("X");
		}
		
		FormText decreasing = (FormText) form.getElement("Decreasing");
		if(frequency.contains("DECREASING"))
		{
			decreasing.setValue("X");
		}
		
		FormText episodic = (FormText) form.getElement("Episodic");
		if(frequency.contains("EPISODIC"))
		{
			episodic.setValue("X");
		}
		
		FormText constant = (FormText) form.getElement("Constant");
		if(frequency.contains("CONSTANT"))
		{
			constant.setValue("X");
		}
		
		FormText unknownFrequency = (FormText) form.getElement("UnknownFrequency");
		if(frequency.contains("UNKNOWN"))
		{
			unknownFrequency.setValue("X");
		}
		
		FormText lastAbuseDate = (FormText) form.getElement("LastAbuseDate");
		lastAbuseDate.setValue(rep.victim.dateOfLastIncident);
		
		FormText aware = (FormText) form.getElement("Aware");
		if(rep.victim.awarenessOfReport)
		{
			aware.setValue("X");
		}
		
		FormText notAware = (FormText) form.getElement("NotAware");
		if(!rep.victim.awarenessOfReport)
		{
			notAware.setValue("X");
		}
		
		String abuseType = rep.victim.typesOfAbuse.toUpperCase();
		FormText physical = (FormText) form.getElement("Physical");
		if(abuseType.contains("PHYSICAL"))
		{
			physical.setValue("X");
			abuseType = abuseType.replace("PHYSICAL", "");
		}
		
		FormText omission = (FormText) form.getElement("Omission");
		if(abuseType.contains("OMISSION"))
		{
			omission.setValue("X");
			abuseType = abuseType.replace("OMISSION", "");
		}
		
		FormText sexual = (FormText) form.getElement("Sexual");
		if(abuseType.contains("SEXUAL"))
		{
			sexual.setValue("X");
			abuseType = abuseType.replace("SEXUAL", "");
		}
		
		FormText emotional = (FormText) form.getElement("Emotional");
		if(abuseType.contains("EMOTIONAL"))
		{
			emotional.setValue("X");
			abuseType = abuseType.replace("EMOTIONAL", "");
		}
		
		abuseType = abuseType.trim();
		FormText otherAbuse = (FormText) form.getElement("OtherAbuse");
		if(abuseType != "")
		{
			otherAbuse.setValue("X");
		}
		
		FormText specifyAbuse = (FormText) form.getElement("SpecifyAbuse");
		if(abuseType != "")
		{
			specifyAbuse.setValue(abuseType);
		}
		
		FormText q1 = (FormText) form.getElement("Q1");
		q1.setValue(rep.abuseDescr);
		
		FormText q2 = (FormText) form.getElement("Q2");
		q2.setValue(rep.victimRisk);
		
		FormText q3 = (FormText) form.getElement("Q3");
		if(rep.injuryList != null)
		{
			q3.setValue(rep.injuryList);
		}
		
		FormText q4 = (FormText) form.getElement("Q4");
		if(rep.injuryList != null)
		{
			q4.setValue(rep.witnesses);
		}
		
		FormText q5 = (FormText) form.getElement("Q5");
		if(rep.caregiverRel != null)
		{
			q5.setValue(rep.caregiverRel);
		}
		
		FormText q6Yes = (FormText) form.getElement("Q6Yes");
		if(rep.isOralReportFiled)
		{
			q6Yes.setValue("X");
		}
		
		FormText q6No = (FormText) form.getElement("Q6No");
		if(!rep.isOralReportFiled)
		{
			q6No.setValue("X");
		}
		
		FormText q6DateTime = (FormText) form.getElement("Q6DateTime");
		if(rep.oralReportFiledTime != null && rep.isOralReportFiled)
		{
			q6DateTime.setValue(rep.oralReportFiledTime);
		}
		
		FormText q7Yes = (FormText) form.getElement("Q7Yes");
		if(rep.isRiskToInvestigator)
		{
			q7Yes.setValue("X");
		}
		
		FormText q7No = (FormText) form.getElement("Q7No");
		if(!rep.isRiskToInvestigator)
		{
			q7No.setValue("X");
		}
		
		FormText q7Specify = (FormText) form.getElement("Q7Specify");
		if(rep.riskDescrToInvestigator != null && rep.isRiskToInvestigator)
		{
			q7Specify.setValue(rep.riskDescrToInvestigator);
		}
		
		pdf.render();		
		pdf.writeTo(new FileOutputStream("C:\\AREST\\" + rep.victim.firstName + rep.victim.lastName + ".pdf"));
		
		System.out.println("Completed.");
	
	}
}