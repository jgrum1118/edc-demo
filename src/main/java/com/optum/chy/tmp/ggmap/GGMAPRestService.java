package com.optum.chy.tmp.ggmap;



import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;

import javax.crypto.NoSuchPaddingException;

import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;
import com.optum.chy.tmp.ggmap.CharFormatConverter;
import com.optum.chy.tmp.ggmap.DesEncryption;

public class GGMAPRestService {
	final String recDelimiter = "/!"; 
	final String fldDelimiter = "/~";
    final String rspDelimiter = "|";
    final String nullString = "";
    
    /**
     * Claim Level Fields
     */
    public String requestType;
    public String parInd;
    public String claimId;;
    public String subname;
    public String subid;
    public String payid;
    public String dob;
    public String gender;
    public String billTypeCode;
    public String dischargeStatus;
    
    public String[] conditionCode;
    public String totalBilledCharges;
    public String serviceFromDate;
    public String serviceToDate;
    
    public String admitDiagnosis;
    public String admitDiagnosisTypeCd;
    
    public String primaryDiagnosis;
	public String primaryTypeCd;
    public SecondaryDiagnosis[] secondaryDiagnosis;
    
    public ReasonforVisitDiagnosis[] reasonforVisitDiagnosis;
    
    public String externalVendorID;
    public String serviceLineTot;
    public String icd9ICD10Cd;
    public String operationCd;
    public String analyzerType;
    public String versionNumber;
    public String edcAction;
    public String levelChangeOption;
    public String startLevelOption1;
    public String startLevelOption2;
    public String startLevelOption3;
    public String startLevelOption4;
    public String startLevelOption5;
    
    /**
     * Line Level Fields
     */
    public List<ServiceLines> serviceLines = new ArrayList<ServiceLines>();
    public String lineID;
    public String units;
    public String unitsType;
    public String billedCharges;
    public String beginDate;
    public String endDate;
    public String cptCode;
    public String cptModifier1;	
    public String cptModifier2;	
    public String cptModifier3;	
    public String cptModifier4;	
    
    public List<String> rspList = new ArrayList<String>();
    public String jsonString = "";
    public String jsonRequest = "";
    
    
    @SuppressWarnings("unused")
	public List<String> callRestService(String host, String resource, String client_id, String client_secret, String env, String timestamp, String scope, String actor) {
    	/**
    	 * Clear response list & JSON areas
    	 */
    		rspList.clear();
    		jsonRequest = "";
    	 
    	/**
		 *  Split & Trim input variables to ensure no garbage data at end of string from oo-Cobol program
		 */			
			String[] parts = host.split(recDelimiter);
			host = parts[0].trim();
			parts = resource.split(recDelimiter);
			resource = parts[0].trim();
			parts = client_id.split(recDelimiter);
			client_id = parts[0].trim();
			parts = client_secret.split(recDelimiter);
			client_secret = parts[0].trim();
			
			parts = timestamp.split(recDelimiter);
			timestamp = parts[0].trim();
			parts = scope.split(recDelimiter);
			scope = parts[0].trim();
			parts = actor.split(recDelimiter);
			actor = parts[0].trim();
		
		/**
		 *  Decrypt Client Secret - decrypted string is returned in ASCII
		 *  If z/OS UNIX then convert ASCII to EBCDIC
		 */	
			DesEncryption des = new DesEncryption();
			try {
				client_secret = des.decryptString(client_secret);
			} catch (NoSuchPaddingException e) {
				rspList.add("HTP" + rspDelimiter + "900" + rspDelimiter + "NoSuchPaddingException - " + e.getMessage() + rspDelimiter);
				return rspList;
			} catch (GeneralSecurityException e) {
				rspList.add("HTP" + rspDelimiter + "901" + rspDelimiter + "GeneralSecurityException - " + e.getMessage() + rspDelimiter);
				return rspList;
			}
			
		/**
		 * Identify operating system... If NOT Windows assume z/OS UNIX and convert client_secret from ASCII to EBCDIC
		 */
			String operatingSystem = System.getProperty("os.name");
	        operatingSystem = operatingSystem.toUpperCase();
	        CharFormatConverter cfc = new CharFormatConverter();
			
	        if (!"WIN".equals(operatingSystem.substring(0, 3))) {
	           byte[] asciiBytes = client_secret.getBytes();
	           byte[] fromASCII2 = cfc.convertStrToEBCDIC(asciiBytes);
	           client_secret = new String(fromASCII2);
	        }
			
		/**
		 *  Set environment ("P"=Prod and "T"=Test)
		 */
			parts = env.split(recDelimiter);
			env = parts[0].trim();
			String environment = "";
			if ("P".equals(env)) environment = "Prod"; else environment = "Test";
			parts[0] = environment;

			
		/**
		 *  Generate a JSON request
		 */			
			generateJSON();

			
		/**
	     *  If not Windows assume z/OS UNIX and transform EBCDIC to ASCII
	     */
	        if(!"WIN".equals(operatingSystem.substring(0, 3))) {
	        	jsonString = jsonString.replaceAll("\u001a", "");	
	        	byte[] ebcdicBytes = jsonString.getBytes();
	        	byte[] fromEDCDIC2 = cfc.convertStrToASCII(ebcdicBytes);
	        	jsonString = new String(fromEDCDIC2);
	        }
            
            rspList.add("HTP DUMMY RETURN");
        
            return rspList;
    }
    
    
    public void sendRequestFields(String requestFields) {
		if (requestFields == null || requestFields.length() == 0) return;
		
		String[] parts = requestFields.split(recDelimiter);
		
		if (parts.length > 0) {
			for (int i=0; i < parts.length; i++) {					
				String[] fields = parts[i].split(fldDelimiter);
				if (fields.length > 2) {
					storeRequestFields(fields);
				}
			}
		}
    }

    
	public void storeRequestFields(String[] fields) {
		int level = Integer.parseInt(fields[0]);
		boolean claimLevel = false;
		if (level == 0) claimLevel = true;
		
		if (claimLevel) {
			serviceLines.clear();
			requestType = fields[1].trim();
		    parInd = fields[2].trim();
		    claimId = fields[3].trim();
		    subname = fields[4].trim();
		    subid = fields[5].trim();
		    payid = fields[6].trim();
		    dob = fields[7].trim();
		    gender = fields[8].trim();
		    billTypeCode = fields[9].trim();
		    dischargeStatus = fields[10].trim();
		    
		    conditionCode = new String[12];
		    conditionCode[0] = new String(fields[11].trim());
		    conditionCode[1] = new String(fields[12].trim());
		    conditionCode[2] = new String(fields[13].trim());
		    conditionCode[3] = new String(fields[14].trim());
		    conditionCode[4] = new String(fields[15].trim());
		    conditionCode[5] = new String(fields[16].trim());
		    conditionCode[6] = new String(fields[17].trim());
		    conditionCode[7] = new String(fields[18].trim());
		    conditionCode[8] = new String(fields[19].trim());
		    conditionCode[9] = new String(fields[20].trim());
		    conditionCode[10] = new String(fields[21].trim());
		    conditionCode[11] = new String(fields[22].trim());
		    
		    totalBilledCharges = fields[23].trim();
		    serviceFromDate = fields[24].trim();
		    serviceToDate = fields[25].trim();
		    
		    admitDiagnosis = fields[26].trim();
		    admitDiagnosisTypeCd = fields[27].trim();
		    
		    primaryDiagnosis = fields[28].trim();
		    primaryTypeCd = fields[29].trim();
		    
		    secondaryDiagnosis = new SecondaryDiagnosis[24];
		    secondaryDiagnosis[0] = new SecondaryDiagnosis(fields[30].trim(), fields[31].trim());
		    secondaryDiagnosis[1] = new SecondaryDiagnosis(fields[32].trim(), fields[33].trim());
		    secondaryDiagnosis[2] = new SecondaryDiagnosis(fields[34].trim(), fields[35].trim());
		    secondaryDiagnosis[3] = new SecondaryDiagnosis(fields[36].trim(), fields[37].trim());
		    secondaryDiagnosis[4] = new SecondaryDiagnosis(fields[38].trim(), fields[39].trim());
		    secondaryDiagnosis[5] = new SecondaryDiagnosis(fields[40].trim(), fields[41].trim());
		    secondaryDiagnosis[6] = new SecondaryDiagnosis(fields[42].trim(), fields[43].trim());
		    secondaryDiagnosis[7] = new SecondaryDiagnosis(fields[44].trim(), fields[45].trim());
		    secondaryDiagnosis[8] = new SecondaryDiagnosis(fields[46].trim(), fields[47].trim());
		    secondaryDiagnosis[9] = new SecondaryDiagnosis(fields[48].trim(), fields[49].trim());
		    
		    secondaryDiagnosis[10] = new SecondaryDiagnosis(fields[50].trim(), fields[51].trim());
		    secondaryDiagnosis[11] = new SecondaryDiagnosis(fields[52].trim(), fields[53].trim());
		    secondaryDiagnosis[12] = new SecondaryDiagnosis(fields[54].trim(), fields[55].trim());
		    secondaryDiagnosis[13] = new SecondaryDiagnosis(fields[56].trim(), fields[57].trim());
		    secondaryDiagnosis[14] = new SecondaryDiagnosis(fields[58].trim(), fields[59].trim());
		    secondaryDiagnosis[15] = new SecondaryDiagnosis(fields[60].trim(), fields[61].trim());
		    secondaryDiagnosis[16] = new SecondaryDiagnosis(fields[62].trim(), fields[63].trim());
		    secondaryDiagnosis[17] = new SecondaryDiagnosis(fields[64].trim(), fields[65].trim());
		    secondaryDiagnosis[18] = new SecondaryDiagnosis(fields[66].trim(), fields[67].trim());
		    secondaryDiagnosis[19] = new SecondaryDiagnosis(fields[68].trim(), fields[69].trim());
		    
		    secondaryDiagnosis[20] = new SecondaryDiagnosis(fields[70].trim(), fields[71].trim());
		    secondaryDiagnosis[21] = new SecondaryDiagnosis(fields[72].trim(), fields[73].trim());
		    secondaryDiagnosis[22] = new SecondaryDiagnosis(fields[74].trim(), fields[75].trim());
		    secondaryDiagnosis[23] = new SecondaryDiagnosis(fields[76].trim(), fields[77].trim());
		    
		    reasonforVisitDiagnosis = new ReasonforVisitDiagnosis[3];
		    reasonforVisitDiagnosis[0] = new ReasonforVisitDiagnosis(fields[78].trim(), fields[79].trim());
		    reasonforVisitDiagnosis[1] = new ReasonforVisitDiagnosis(fields[80].trim(), fields[81].trim());
		    reasonforVisitDiagnosis[2] = new ReasonforVisitDiagnosis(fields[82].trim(), fields[83].trim());

		    externalVendorID = fields[84].trim();
		    serviceLineTot = fields[85].trim();
		    
		    icd9ICD10Cd = fields[86].trim();
		    operationCd = fields[87].trim();
		    
		    analyzerType = fields[88].trim();
		    versionNumber = fields[89].trim();
		    edcAction = fields[90].trim();
		    levelChangeOption = fields[91].trim();
		    startLevelOption1 = fields[92].trim();
		    startLevelOption2 = fields[93].trim();
		    startLevelOption3 = fields[94].trim();
		    startLevelOption4 = fields[95].trim();
		    startLevelOption5 = fields[96].trim();
		} else {
			initLineLevelFields();
			
			lineID = fields[1].trim(); 
			units = fields[2].trim(); 
			unitsType = fields[3].trim(); 
			billedCharges = fields[4].trim(); 
			beginDate = fields[5].trim(); 
			endDate = fields[6].trim(); 
			cptCode = fields[7].trim();
		    cptModifier1 = fields[8].trim();	
		    cptModifier2 = fields[9].trim();	
		    cptModifier3 = fields[10].trim();	
		    cptModifier4 = fields[11].trim();	
			
			serviceLines.add(new ServiceLines(lineID, units, unitsType, billedCharges, beginDate, endDate, cptCode, cptModifier1, cptModifier2, cptModifier3, cptModifier4));
		}
	}

	
	private void initLineLevelFields() {
		lineID = ""; 
		units = ""; 
		unitsType = ""; 
		billedCharges = ""; 
		beginDate = ""; 
		endDate = "";
		cptCode = "";
	    cptModifier1 = "";	
	    cptModifier2 = "";	
	    cptModifier3 = "";	
	    cptModifier4 = "";	
	}

	
	private void generateJSON() {
		/**
		 * claimSubmitter
		 */
		boolean suppressClaimSubmitter = true;
		boolean suppressClaimProcessorSub = true;
		JsonClaimProcessorSub clmProSub = new JsonClaimProcessorSub();
		if (subname != null && subname.length() > 0) { 
			clmProSub.setName(subname);
			suppressClaimProcessorSub = false;
		}
		if (subid != null && subid.length() > 0) {
			clmProSub.setId(subid);
			suppressClaimProcessorSub = false;
		}
		
		JsonClaimSubmitter clmSub = new JsonClaimSubmitter();
		if (claimId != null && claimId.length() > 0) {
			clmSub.setClaimId(claimId);
			suppressClaimSubmitter = false;
		}
		if (!suppressClaimProcessorSub) {
			clmSub.setClaimProcessor(clmProSub);
			suppressClaimSubmitter = false;
		}
		
		/**
		 * claimPayer
		 */
		boolean suppressClaimProcessorPay = true;
		JsonClaimProcessorPay clmProPay = new JsonClaimProcessorPay();
		if (payid != null && payid.length() > 0) {
			clmProPay.setId(payid);
			suppressClaimProcessorPay = false;
		}
		JsonClaimPayer clmPay = new JsonClaimPayer();
		if (!suppressClaimProcessorPay) clmPay.setClaimProcessor(clmProPay);
		
		/**
		 * patient
		 */
		boolean suppressPersonalInfo = true;
		JsonPersonalInfo perInfo = new JsonPersonalInfo();
		if (dob != null && dob.length() > 0) {
			perInfo.setDob(dob);
			suppressPersonalInfo = false;
		}
		if (gender != null && gender.length() > 0) {
			perInfo.setGender(gender);
			suppressPersonalInfo = false;
		}
		JsonPatient pat = new JsonPatient();
		if (!suppressPersonalInfo) pat.setPersonalInfo(perInfo);
		
		/**
		 * facilityClaim
		 */
		boolean suppressConditionCode = true;
		ArrayList<String> ccList = new ArrayList<String>();
		for (int i=0; i < conditionCode.length; i++) {
			if (conditionCode[i] != null && conditionCode[i].length() > 0) {
				ccList.add(conditionCode[i]);
				suppressConditionCode = false;
			}
		}
		
		boolean suppressFacilityClaim = true;
		JsonFacilityClaim facClm = new JsonFacilityClaim();
		if (billTypeCode != null && billTypeCode.length() > 0) {
			facClm.setBillTypeCode(billTypeCode);
			suppressFacilityClaim = false;
		}
		if (dischargeStatus != null && dischargeStatus.length() > 0) {
			facClm.setDischargeStatus(dischargeStatus);
			suppressFacilityClaim = false;
		}
		
		if (!suppressConditionCode) {
			facClm.setConditionCode(ccList);
			suppressFacilityClaim = false;
		}
		
		/**
		 * serviceSummary
		 */
		boolean suppressServiceSummary = true;
		JsonServiceSummary svcSum = new JsonServiceSummary();
		
		if (totalBilledCharges != null && totalBilledCharges.length() > 0) {
			double value = Double.parseDouble(totalBilledCharges);
			svcSum.setTotalBilledCharges(value);
			suppressServiceSummary = false;
		}
		if (serviceFromDate != null && serviceFromDate.length() > 0) {
			svcSum.setServiceFromDate(serviceFromDate);
			suppressServiceSummary = false;
		}
		if (serviceToDate != null && serviceToDate.length() > 0) {
			svcSum.setServiceToDate(serviceToDate);
			suppressServiceSummary = false;
		}
		
		
		/**
		 * secondaryDiagnosis
		 */
		boolean suppressSecondaryDiagnosis = true;
		ArrayList<JsonSecondaryDiagnosis> secDiagList = new ArrayList<JsonSecondaryDiagnosis>();  
		JsonSecondaryDiagnosis secDiag;
		
		for (int i=0; i < secondaryDiagnosis.length; i++) {
			boolean suppressThisOccurrence = true;
			secDiag = new JsonSecondaryDiagnosis();
			if (secondaryDiagnosis[i].secondaryDiagnosisCd != null && secondaryDiagnosis[i].secondaryDiagnosisCd.length() > 0) {
				secDiag.setSecondaryDiagnosisCd(secondaryDiagnosis[i].secondaryDiagnosisCd);
				suppressThisOccurrence = false;
			}
			if (secondaryDiagnosis[i].secondaryTypeCd != null && secondaryDiagnosis[i].secondaryTypeCd.length() > 0) {
				secDiag.setTypeCd(secondaryDiagnosis[i].secondaryTypeCd);
				suppressThisOccurrence = false;
			}
			if (!suppressThisOccurrence) {
				secDiagList.add(secDiag);
				suppressSecondaryDiagnosis = false;
			}
		}
		

		/**
		 * reasonForVisitDiagnosis
		 */
		boolean suppressReasonForVisitDiagnosis = true;
		ArrayList<JsonReasonforVisitDiagnosis> reasonforVisitDiagList = new ArrayList<JsonReasonforVisitDiagnosis>();  
		JsonReasonforVisitDiagnosis reasonForVisitDiag;
		
		for (int i=0; i < reasonforVisitDiagnosis.length; i++) {
			boolean suppressThisOccurrence = true;
			reasonForVisitDiag = new JsonReasonforVisitDiagnosis();

			if (reasonforVisitDiagnosis[i].cd != null && reasonforVisitDiagnosis[i].cd.length() > 0) {
				reasonForVisitDiag.setCd(reasonforVisitDiagnosis[i].cd);
				suppressThisOccurrence = false;
			}
			if (reasonforVisitDiagnosis[i].typeCd != null && reasonforVisitDiagnosis[i].typeCd.length() > 0) {
				reasonForVisitDiag.setTypeCd(reasonforVisitDiagnosis[i].typeCd);
				suppressThisOccurrence = false;
			}
			if (!suppressThisOccurrence) {
				reasonforVisitDiagList.add(reasonForVisitDiag);
				suppressReasonForVisitDiagnosis = false;
			}
		}

		
		/**
		 * diagnosisSummary
		 */
	    boolean suppressDiagnosisSummary = true;
		JsonDiagnosisSummary diagSum = new JsonDiagnosisSummary();
		if (admitDiagnosis != null && admitDiagnosis.length() > 0) {
			diagSum.setAdmitDiagnosis(admitDiagnosis);
	    	suppressDiagnosisSummary = false;
	    }
		if (admitDiagnosisTypeCd != null && admitDiagnosisTypeCd.length() > 0) {
			diagSum.setAdmitDiagnosisTypeCd(admitDiagnosisTypeCd);
	    	suppressDiagnosisSummary = false;
	    }
		if (primaryDiagnosis != null && primaryDiagnosis.length() > 0) {
			diagSum.setPrimaryDiagnosis(primaryDiagnosis);
	    	suppressDiagnosisSummary = false;
	    }
		if (primaryTypeCd != null && primaryTypeCd.length() > 0) {
	    	diagSum.setTypeCd(primaryTypeCd);
	    	suppressDiagnosisSummary = false;
	    }
		if (!suppressSecondaryDiagnosis) {
			diagSum.setSecondaryDiagnosis(secDiagList);
			suppressDiagnosisSummary = false;
		}
		
		if (!suppressReasonForVisitDiagnosis) {
			diagSum.setReasonforVisitDiagnosis(reasonforVisitDiagList);
			suppressDiagnosisSummary = false;
		}
		
				
		/**
		 * policy : eligibility :
		 */
		boolean suppressPolicyEligibility = true;
		JsonPolicyEligibility polElig = new JsonPolicyEligibility();
		if (externalVendorID != null && externalVendorID.length() > 0) {
			polElig.setExternalVendorID(externalVendorID);
			suppressPolicyEligibility = false;
		}

		JsonPolicy pol = new JsonPolicy();
		if (!suppressPolicyEligibility) pol.setEligibility(polElig);
		
		/**
		 * serviceLines 
		 */
		ArrayList<JsonServiceLine> svcLnList = new ArrayList<JsonServiceLine>(); 
		JsonServiceLine svcln;
		JsonChargeCodes chrgcds;
		ArrayList<JsonModifier> modList = new ArrayList<JsonModifier>();  
		JsonModifier mod;
		
		for (int i=0; i < serviceLines.size(); i++) {
			svcln = new JsonServiceLine();
			chrgcds = new JsonChargeCodes();
			
			boolean suppressChargeCodes = true;
			boolean suppressModList = true;
			
			modList = new ArrayList<JsonModifier>();
			
			if (serviceLines.get(i).cptModifier1 != null && serviceLines.get(i).cptModifier1.length() > 0) {
				mod = new JsonModifier();
				mod.setCd(serviceLines.get(i).cptModifier1);
				modList.add(mod);
				mod = null;
				suppressModList = false;
			}
			if (serviceLines.get(i).cptModifier2 != null && serviceLines.get(i).cptModifier2.length() > 0) {
				mod = new JsonModifier();
				mod.setCd(serviceLines.get(i).cptModifier2);
				modList.add(mod);
				mod = null;
				suppressModList = false;
			}
			if (serviceLines.get(i).cptModifier3 != null && serviceLines.get(i).cptModifier3.length() > 0) {
				mod = new JsonModifier();
				mod.setCd(serviceLines.get(i).cptModifier3);
				modList.add(mod);
				mod = null;
				suppressModList = false;
			}
			if (serviceLines.get(i).cptModifier4 != null && serviceLines.get(i).cptModifier4.length() > 0) {
				mod = new JsonModifier();
				mod.setCd(serviceLines.get(i).cptModifier4);
				modList.add(mod);
				mod = null;
				suppressModList = false;
			}
			
			if (!suppressModList) {
				chrgcds.setModifier(modList);
				suppressChargeCodes = false;
			}
			modList = null;
			
			if (serviceLines.get(i).cptCode != null && serviceLines.get(i).cptCode.length() > 0) {
				chrgcds.setCptCode(serviceLines.get(i).cptCode);
				suppressChargeCodes = false;
			}
			
			if (serviceLines.get(i).lineID != null && serviceLines.get(i).lineID.length() > 0) svcln.setLineID(serviceLines.get(i).lineID);
			if (serviceLines.get(i).units != null && serviceLines.get(i).units.length() > 0) {
				double value = Double.parseDouble(serviceLines.get(i).units);
				svcln.setUnits(value);
			}
			if (serviceLines.get(i).unitsType != null && serviceLines.get(i).unitsType.length() > 0) svcln.setUnitsType(serviceLines.get(i).unitsType);
			if (serviceLines.get(i).billedCharges != null && serviceLines.get(i).billedCharges.length() > 0) {
				double value = Double.parseDouble(serviceLines.get(i).billedCharges);
				svcln.setBilledCharges(value);
			}
			if (serviceLines.get(i).beginDate != null && serviceLines.get(i).beginDate.length() > 0) svcln.setBeginDate(serviceLines.get(i).beginDate);
			if (serviceLines.get(i).endDate != null && serviceLines.get(i).endDate.length() > 0) svcln.setEndDate(serviceLines.get(i).endDate);
			if (!suppressChargeCodes) svcln.setChargeCodes(chrgcds);
			
			svcLnList.add(svcln);
		} 
		
		/**
		 * claim
		 */
		JsonClaim clm = new JsonClaim();
		if (!suppressClaimSubmitter) clm.setClaimSubmitter(clmSub);
		if (!suppressClaimProcessorPay) clm.setClaimPayer(clmPay);
		if (!suppressPersonalInfo) clm.setPatient(pat);
		if (!suppressFacilityClaim) clm.setFacilityClaim(facClm);
		if (!suppressServiceSummary) clm.setServiceSummary(svcSum);
		if (!suppressDiagnosisSummary) clm.setDiagnosisSummary(diagSum);
		if (!suppressPolicyEligibility) clm.setPolicy(pol);
		clm.setServiceLines(svcLnList);
		
		if (serviceLineTot != null && serviceLineTot.length() > 0) {
			clm.setServiceLineTot(Integer.parseInt(serviceLineTot));
		}
		
		
		/**
		 * claimPrice	
		 */
		JsonClaimPrice clmPri = new JsonClaimPrice();
		
		if (requestType != null && requestType.length() > 0) clmPri.setRequestType(requestType);
		if (parInd != null && parInd.length() > 0) clmPri.setParInd(parInd);
		clmPri.setClaim(clm);
		if (icd9ICD10Cd != null && icd9ICD10Cd.length() > 0) clmPri.setIcd9ICD10Cd(icd9ICD10Cd);
		
		
		/**
		 * ezGroup
		 */
		boolean suppressEzGroupAnalyzer = true;
		JsonEzGroupAnalyzer ezA = new JsonEzGroupAnalyzer();
		if (analyzerType != null && analyzerType.length() > 0) {
			ezA.setType(Integer.parseInt(analyzerType));
			suppressEzGroupAnalyzer = false;
		}
		if (versionNumber != null && versionNumber.length() > 0) {
			ezA.setVersionNumber(Integer.parseInt(versionNumber));
			suppressEzGroupAnalyzer = false;
		}
		if (edcAction != null && edcAction.length() > 0) {
			ezA.setEdcAction(Integer.parseInt(edcAction));
			suppressEzGroupAnalyzer = false;
		}
		if (levelChangeOption != null && levelChangeOption.length() > 0) {
			ezA.setLevelChangeOption(Integer.parseInt(levelChangeOption));
			suppressEzGroupAnalyzer = false;
		}
		if (startLevelOption1 != null && startLevelOption1.length() > 0) {
			ezA.setStartLevelOption1(startLevelOption1);
			suppressEzGroupAnalyzer = false;
		}
		if (startLevelOption2 != null && startLevelOption2.length() > 0) {
			ezA.setStartLevelOption2(startLevelOption2);
			suppressEzGroupAnalyzer = false;
		}
		if (startLevelOption3 != null && startLevelOption3.length() > 0) {
			ezA.setStartLevelOption3(startLevelOption3);
			suppressEzGroupAnalyzer = false;
		}
		if (startLevelOption4 != null && startLevelOption4.length() > 0) {
			ezA.setStartLevelOption4(startLevelOption4);
			suppressEzGroupAnalyzer = false;
		}
		if (startLevelOption5 != null && startLevelOption5.length() > 0) {
			ezA.setStartLevelOption5(startLevelOption5);
			suppressEzGroupAnalyzer = false;
		}
		
		boolean suppressEzGroup = true;
		JsonEzGroup ez = new JsonEzGroup();
		if (operationCd != null && operationCd.length() > 0 ) {
			ez.setOperationCd(operationCd);
			suppressEzGroup = false;
		}
		
		if (!suppressEzGroupAnalyzer) ez.setEzGroupAnalyzer(ezA);
		
		JsonRoot root = new JsonRoot();
		root.setClaimPrice(clmPri);
		
		if (!suppressEzGroup || !suppressEzGroupAnalyzer) root.setEzGroup(ez);
		
 		//Gson gson = new GsonBuilder().setPrettyPrinting().create();
		Gson gson = new Gson();
		jsonString = gson.toJson(root);
		jsonRequest = jsonString;
	}
	

	public String getJsonRequest() {
		return jsonRequest.length() + rspDelimiter + jsonRequest + rspDelimiter;
		
	}

}
