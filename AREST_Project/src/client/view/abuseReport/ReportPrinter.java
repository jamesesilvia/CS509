package client.view.abuseReport;

import java.io.*;

import javax.swing.JOptionPane;

import client.model.*;

public class ReportPrinter
{
	public ReportPrinter(Report rep) throws Exception
	{ 
		
		String myFile = "C:\\AREST\\ARESTReport" + String.valueOf(rep.id) + ".txt";
		
		try {
		
			FileWriter myFileWriter = new FileWriter(myFile);
			BufferedWriter bw = new BufferedWriter(myFileWriter);
						
			bw.write("AREST REPORT #" + String.valueOf(rep.id));
			bw.newLine();
			bw.newLine();
			bw.newLine();
		
			bw.write("REPORTER");
			bw.newLine();
			bw.write("Reporter Name: " + rep.reporter.firstName + " " + rep.reporter.lastName);
			bw.newLine();
		
			bw.write("Reporter Address: " + rep.reporter.address);
			bw.newLine();
		
			bw.write("Reporter Telephone: " + rep.reporter.phoneNumber);
			bw.newLine();
		
			if(rep.reporter.isMandated())
			{
				bw.write("Mandated");
				bw.newLine();
			}
		
			if(!rep.reporter.isMandated())
			{
				bw.write("Nonmandated");
				bw.newLine();
			}
		
			bw.write("Reporter Relationship to Victim: " + rep.reporter.relationshipToVictim);
			bw.newLine();
			bw.newLine();
			
			bw.write("VICTIM");
			bw.newLine();
			bw.write("Victim Name: " + rep.victim.firstName + " " + rep.victim.lastName);
			bw.newLine();
		
			bw.write("Victim Address: " + rep.victim.address);
			bw.newLine();
			
			bw.write("Victim Telephone: " + rep.victim.phoneNumber);
			bw.newLine();
		
			if(rep.victim.getSex().toUpperCase() == "MALE")
			{
				bw.write("Male");
				bw.newLine();
			}
		
			if(rep.victim.getSex().toUpperCase() == "FEMALE")
			{
				bw.write("FEMALE");
				bw.newLine();
			}
		
			bw.write("Victim Date of Birth: " + rep.victim.dob);
			bw.newLine();
		
			bw.write("Victim Age: " + rep.victim.age);
			bw.newLine();
		
			bw.write("Victim Marital Status: " + rep.victim.maritalStatus);
			bw.newLine();
			bw.newLine();
		
			bw.write("ABUSER");
			bw.newLine();
			bw.write("Abuser Name: " + rep.abuser.firstName + " " + rep.abuser.lastName);
			bw.newLine();
		
			bw.write("Abuser Address: " + rep.abuser.address);
			bw.newLine();
		
			bw.write("Abuser Relationship to Victim: " + rep.abuser.relationshipToVictim);
			bw.newLine();
		
			bw.write("Abuser SSN: " + rep.abuser.social);
			bw.newLine();
		
			bw.write("Abuser Date of Birth: " + rep.abuser.dob);
			bw.newLine();
		
			bw.write("Abuser Telephone: " + rep.abuser.phoneNumber);
			bw.newLine();
			bw.newLine();
		
			bw.write("DISABILITIES");
			bw.newLine();
			String disabled = rep.victim.disability.toUpperCase();
			if(disabled.contains("MENTAL RETARDATION"))
			{
				bw.write("Mental Retardation");
				bw.newLine();
				disabled = disabled.replace("MENTAL RETARDATION", "");
			}
		
			if(disabled.contains("MENTAL ILLNESS"))
			{
				bw.write("Mental Illness");
				bw.newLine();
				disabled = disabled.replace("MENTAL ILLNESS", "");
			}
		
			if(disabled.contains("MOBILITY"))
			{
				bw.write("Mobility");
				bw.newLine();
				disabled = disabled.replace("MOBILITY", "");
			}
		
			if(disabled.contains("HEAD INJURY"))
			{
				bw.write("Head Injury");
				bw.newLine();
				disabled = disabled.replace("HEAD INJURY", "");
			}
		
			if(disabled.contains("VISUAL"))
			{
				bw.write("Visual");
				bw.newLine();
				disabled = disabled.replace("VISUAL", "");
			}
		
			if(disabled.contains("DEAF / HARD OF HEARING"))
			{
				bw.write("Deaf / Hard of Hearing");
				bw.newLine();
				disabled = disabled.replace("DEAF / HARD OF HEARING", "");
			}
		
			if(disabled.contains("CEREBRAL PALSY"))
			{
				bw.write("Cerebral Palsy");
				bw.newLine();
				disabled = disabled.replace("CEREBRAL PALSY", "");
			}

			if(disabled.contains("MULTIPLE SCLEROSIS"))
			{
				bw.write("Multiple Sclerosis");
				bw.newLine();
				disabled = disabled.replace("MULTIPLE SCLEROSIS", "");
			}
		
			if(disabled.contains("SEIZURES"))
			{
				bw.write("Seizures");
				bw.newLine();
				disabled = disabled.replace("SEIZURES", "");
			}
		
			disabled = disabled.trim();		
			if(disabled != "")
			{
				bw.write("Other: " + disabled);
				bw.newLine();
			}
			
			bw.newLine();
			bw.write("COMMUNICATION NEEDS");
			bw.newLine();
			String comms = rep.victim.communicationNeeds.toUpperCase();
			if(comms.contains("TTY"))
			{
				bw.write("TTY");
				bw.newLine();
				comms = comms.replace("TTY", "");
			}
		
			if(comms.contains("SIGN INTERPRETER"))
			{
				bw.write("Sign Interpreter");
				bw.newLine();
				comms = comms.replace("SIGN INTERPRETER", "");
			}
		
			comms = comms.trim();
			if(comms != "")
			{
				bw.write("Other: " + comms);
				bw.newLine();
			}
			
			bw.write("GUARDIAN");
			if(rep.guardian.firstName != null && rep.guardian.lastName != null)
			{
				bw.write("Guardian Name: " + rep.guardian.firstName + " " + rep.guardian.lastName);
				bw.newLine();
			}
		
			if(rep.guardian.address != null)
			{
				bw.write("Guardian Address: " + rep.guardian.address);
				bw.newLine();
			}
		
			if(rep.guardian.relationshipToVictim != null)
			{
				bw.write("Guardian Relationship to Victim: " + rep.guardian.relationshipToVictim);
				bw.newLine();
			}
		
			if(rep.guardian.phoneNumber != null)
			{
				bw.write("Guardian Telephone: " + rep.guardian.phoneNumber);
				bw.newLine();
			}
		
			bw.newLine();
			bw.write("CURRENTLY SERVED BY");
			bw.newLine();
			String served = rep.victim.currentlyServedBy.toUpperCase();
			if(served.contains("DEPT. OF MENTAL HEALTH"))
			{
				bw.write("Dept. of Mental Health");
				bw.newLine();
				served = served.replace("DEPT. OF MENTAL HEALTH", "");
			}
		
			if(served.contains("MASS COMM./BLIND"))
			{
				bw.write("Mass Comm./Blind");
				bw.newLine();
				served = served.replace("MASS COMM./BLIND", "");
			}
		
			if(served.contains("DEPT. OF DEVELOPMENTAL SVCS."))
			{
				bw.write("Dept. of Developmental Svcs.");
				bw.newLine();
				served = served.replace("DEPT. OF DEVELOPMENTAL SVCS.", "");
			}
		
			if(served.contains("MASS. COMM./DEAF/HH"))
			{
				bw.write("Mass. Comm./Deaf/HH");
				bw.newLine();
				served = served.replace("MASS. COMM./DEAF/HH", "");
			}
		
			if(served.contains("MASS. REHAB. COMM."))
			{
				bw.write("Mass. Rehab. Comm.");
				bw.newLine();
				served = served.replace("MASS. REHAB. COMM.", "");
			}
		
			if(served.contains("UNKNOWN"))
			{
				bw.write("Unknown");
				bw.newLine();
				served = served.replace("UNKNOWN", "");
			}
		
			if(served.contains("DEPT. OF CORRECTION"))
			{
				bw.write("Dept. of Correction");
				bw.newLine();
				served = served.replace("DEPT. OF CORRECTION", "");
			}
		
			if(served.contains("DEPT. OF PUBLIC HEALTH"))
			{
				bw.write("Dept. of Public Health");
				bw.newLine();
				served = served.replace("DEPT. OF PUBLIC HEALTH", "");
			}
		
			if(served.contains("NONE"))
			{
				bw.write("None");
				bw.newLine();
				served = served.replace("NONE", "");
			}
		
			served = served.trim();
			if(served != "")
			{
				bw.write("Other: " + served);
				bw.newLine();
			}
			
			bw.newLine();
			bw.write("COLLATERAL CONTACTS");
			bw.newLine();
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
				bw.write(coll);
				bw.newLine();
			}
			else
			{
				bw.write("None Listed");
				bw.newLine();
			}
		
			bw.newLine();
			bw.write("TYPE OF SERVICE");
			bw.newLine();
			String service = rep.victim.typeOfService.toUpperCase();
			if(service.contains("INSTITUTIONAL"))
			{
				bw.write("Institutional");
				bw.newLine();
				service = service.replace("INSTITUTIONAL", "");
			}
		
			if(service.contains("SERVICE COORDINATION"))
			{
				bw.write("Service Coordination");
				bw.newLine();
				service = service.replace("SERVICE COORDINATION", "");
			}
		
			if(service.contains("RESIDENTIAL"))
			{
				bw.write("Residential");
				bw.newLine();
				service = service.replace("RESIDENTIAL", "");
			}
		
			if(service.contains("FOSTER / SPEC. HOME CARE"))
			{
				bw.write("Foster / Spec. Home Care");
				bw.newLine();
				service = service.replace("FOSTER / SPEC. HOME CARE", "");
			}
		
			if(service.contains("DAY PROGRAM"))
			{
				bw.write("Day Program");
				bw.newLine();
				service = service.replace("DAY PROGRAM", "");
			}
		
			if(service.contains("RESPITE"))
			{
				bw.write("Respite");
				bw.newLine();
				service = service.replace("RESPITE", "");
			}
		
			if(service.contains("CASE MANAGEMENT"))
			{
				bw.write("Case Management");
				bw.newLine();
				service = service.replace("CASE MANAGEMENT", "");
			}
		
			service = service.trim();
			if(service != "")
			{
				bw.write("Other: " + service);
				bw.newLine();
			}				
		
			bw.newLine();
			bw.write("ETHNICITY");
			bw.newLine();
			String ethnicity = rep.victim.ethnicity.toUpperCase();
			if(ethnicity.contains("CAUCASIAN"))
			{
				bw.write("Caucasian");
				bw.newLine();
				ethnicity = ethnicity.replace("CAUCASIAN", "");
			}
		
			if(ethnicity.contains("HISPANIC"))
			{
				bw.write("Hispanic");
				bw.newLine();
				ethnicity = ethnicity.replace("HISPANIC", "");
			}
		
			if(ethnicity.contains("ASIAN"))
			{
				bw.write("Asian");
				bw.newLine();
				ethnicity = ethnicity.replace("ASIAN", "");
			}
		
			if(ethnicity.contains("AFRICAN AMERICAN"))
			{
				bw.write("African American");
				bw.newLine();
				ethnicity = ethnicity.replace("AFRICAN AMERICAN", "");
			}
		
			if(ethnicity.contains("NATIVE AMERICAN"))
			{
				bw.write("Native American");
				bw.newLine();
				ethnicity = ethnicity.replace("NATIVE AMERICAN", "");
			}
		
			ethnicity = ethnicity.trim();
			if(ethnicity != "")
			{
				bw.write("Other: " + ethnicity);
				bw.newLine();
			}
		
			bw.newLine();
			bw.write("FREQUENCY OF ABUSE");
			bw.newLine();
			String frequency = rep.victim.freqOfAbuse.toUpperCase();
			if(frequency.contains("DAILY"))
			{
				bw.write("Daily");
				bw.newLine();
			}
		
			if(frequency.contains("INCREASING"))
			{
				bw.write("Increasing");
				bw.newLine();
			}
		
			if(frequency.contains("WEEKLY"))
			{
				bw.write("Weekly");
				bw.newLine();
			}
		
			if(frequency.contains("DECREASING"))
			{
				bw.write("Decreasing");
				bw.newLine();
			}
		
			if(frequency.contains("EPISODIC"))
			{
				bw.write("Episodic");
				bw.newLine();
			}
		
			if(frequency.contains("CONSTANT"))
			{
				bw.write("Constant");
				bw.newLine();
			}
		
			if(frequency.contains("UNKNOWN"))
			{
				bw.write("Unknown");
				bw.newLine();
			}
		
			bw.write("Last Abuse Date: " + rep.victim.dateOfLastIncident);
			bw.newLine();
		
			bw.newLine();
			bw.write("VICTIM AWARENESS OF REPORT");
			bw.newLine();
			if(rep.victim.awarenessOfReport)
			{
				bw.write("Aware");
				bw.newLine();
			}
		
			if(!rep.victim.awarenessOfReport)
			{
				bw.write("Not Aware");
				bw.newLine();
			}
		
			bw.newLine();
			bw.write("TYPES OF ABUSE");
			bw.newLine();
			String abuseType = rep.victim.typesOfAbuse.toUpperCase();
			if(abuseType.contains("PHYSICAL"))
			{
				bw.write("Physical");
				bw.newLine();
				abuseType = abuseType.replace("PHYSICAL", "");
			}
		
			if(abuseType.contains("OMISSION"))
			{
				bw.write("Omission");
				bw.newLine();
				abuseType = abuseType.replace("OMISSION", "");
			}
		
			if(abuseType.contains("SEXUAL"))
			{
				bw.write("Sexual");
				bw.newLine();
				abuseType = abuseType.replace("SEXUAL", "");
			}
		
			if(abuseType.contains("EMOTIONAL"))
			{
				bw.write("Emotional");
				bw.newLine();
				abuseType = abuseType.replace("EMOTIONAL", "");
			}
		
			abuseType = abuseType.trim();
			if(abuseType != "")
			{
				bw.write("Other: " + abuseType);
				bw.newLine();
			}
				
			bw.newLine();
			bw.write("In narrative form, please describe the alleged abuse:");
			bw.newLine();
			bw.write(rep.abuseDescr);
			bw.newLine();
			bw.newLine();
		
			bw.write("Please describe the level of risk to the alleged victim, including his/her current physical and emotional state:");
			bw.newLine();
			bw.write(rep.victimRisk);
			bw.newLine();
			bw.newLine();
		
			
			bw.write("Please list any resulting injuries:");
			bw.newLine();
			if(rep.injuryList != null)
			{
				bw.write(rep.injuryList);
				bw.newLine();
			}
		
			bw.newLine();
			bw.write("Please list witnesses, if any, including daytime phone numbers:");
			bw.newLine();
			if(rep.injuryList != null)
			{
				bw.write(rep.witnesses);
				bw.newLine();
			}
		
			bw.newLine();
			bw.write("Please describe caregiver relationship between the alleged abuser and the alleged victim.");
			bw.newLine();
			bw.write("(What assistance, if any, does the alleged abuser provide to the person with the disability?)");
			bw.newLine();
			if(rep.caregiverRel != null)
			{
				bw.write(rep.caregiverRel);
				bw.newLine();
			}
		
			bw.newLine();
			bw.write("Was an oral report filed with the DPPC Hotline?");
			bw.newLine();
			if(rep.isOralReportFiled)
			{
				bw.write("Yes");
				bw.newLine();
			}
		
			if(!rep.isOralReportFiled)
			{
				bw.write("No");
				bw.newLine();
			}
		
			if(rep.oralReportFiledTime != null && rep.isOralReportFiled)
			{
				bw.write(rep.oralReportFiledTime);
				bw.newLine();
			}
		
			bw.newLine();
			bw.write("Is there any risk to the investigator?");
			bw.newLine();
			if(rep.isRiskToInvestigator)
			{
				bw.write("Yes");
				bw.newLine();
			}	
		
			if(!rep.isRiskToInvestigator)
			{
				bw.write("No");
				bw.newLine();
			}
		
			if(rep.riskDescrToInvestigator != null && rep.isRiskToInvestigator)
			{
				bw.write(rep.riskDescrToInvestigator);
				bw.newLine();
			}
						
			bw.close();
		
			JOptionPane.showMessageDialog(null, "Successfully wrote to file ARESTReport" + rep.getId() + ".txt", "Success!", JOptionPane.INFORMATION_MESSAGE);
			}
			
			catch(IOException e)
			{
				JOptionPane.showMessageDialog(null, "Unable to write to output file.", "ERROR Writing to file", JOptionPane.INFORMATION_MESSAGE);
				//System.out.println("File write error for " + myFile);
			}
	}
}