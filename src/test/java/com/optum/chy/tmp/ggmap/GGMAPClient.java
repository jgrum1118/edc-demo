package com.optum.chy.tmp.ggmap;

import java.io.FileNotFoundException;
import java.util.List;

public class GGMAPClient {

	public static List<ServiceLines> xServiceLines;
	
	@SuppressWarnings("unused")
	public static void main(String[] args) throws FileNotFoundException  {

		final String recDelimiter = "/!"; 
        final String fldDelimiter = "/~";
        
		String rec = "";
		String requestType = "NEW";
		String parInd = "N";

		String claimId = "100054934123";
		String subname = "TOPS";
		String subid = "03";
		String payid = "000";

		String dob = "1977-09-26";
		String gender = "M";

		String billTypeCode = "721";
		String dischargeStatus = "09";
		
		String conditionCode1 = "02";
		String conditionCode2 = "20";
		String conditionCode3 = " ";
		String conditionCode4 = " ";
		String conditionCode5 = " ";
		String conditionCode6 = " ";
		String conditionCode7 = " ";
		String conditionCode8 = " ";
		String conditionCode9 = " ";
		String conditionCode10 = " ";
		String conditionCode11 = " ";
		String conditionCode12 = " ";

		String totalBilledCharges = "1432.87";
		String serviceFromDate = "2017-09-01";
		String serviceToDate = "2017-09-01";

		String admitDiagnosis = "J320";
		String admitDiagnosisTypeCd = "ABF";
		
		String primaryDiagnosis = "G8254";
		String primaryTypeCd = "ABK";
		
		String secondaryDiagnosisCd1 = "Z760";
		String secondaryTypeCd1 = "APR";
		
		String secondaryDiagnosisCd2 = "B889";
		String secondaryTypeCd2 = "APR";
		
		String secondaryDiagnosisCd3 = "H00025";
		String secondaryTypeCd3 = "ABF";

		String secondaryDiagnosisCd4 = " ";
		String secondaryTypeCd4 = " ";
		
		String secondaryDiagnosisCd5 = " ";
		String secondaryTypeCd5 = " ";
		
		String secondaryDiagnosisCd6 = " ";
		String secondaryTypeCd6 = " ";
		
		String secondaryDiagnosisCd7 = " ";
		String secondaryTypeCd7 = " ";

		String secondaryDiagnosisCd8 = " ";
		String secondaryTypeCd8 = " ";

		String secondaryDiagnosisCd9 = " ";
		String secondaryTypeCd9 = " ";

		String secondaryDiagnosisCd10 = " ";
		String secondaryTypeCd10 = " ";

		String secondaryDiagnosisCd11 = " ";
		String secondaryTypeCd11 = " ";

		String secondaryDiagnosisCd12 = " ";
		String secondaryTypeCd12 = " ";

		String secondaryDiagnosisCd13 = " ";
		String secondaryTypeCd13 = " ";

		String secondaryDiagnosisCd14 = " ";
		String secondaryTypeCd14 = " ";

		String secondaryDiagnosisCd15 = " ";
		String secondaryTypeCd15 = " ";

		String secondaryDiagnosisCd16 = " ";
		String secondaryTypeCd16 = " ";

		String secondaryDiagnosisCd17 = " ";
		String secondaryTypeCd17 = " ";

		String secondaryDiagnosisCd18 = " ";
		String secondaryTypeCd18 = " ";

		String secondaryDiagnosisCd19 = " ";
		String secondaryTypeCd19 = " ";

		String secondaryDiagnosisCd20 = " ";
		String secondaryTypeCd20 = " ";

		String secondaryDiagnosisCd21 = " ";
		String secondaryTypeCd21 = " ";

		String secondaryDiagnosisCd22 = " ";
		String secondaryTypeCd22 = " ";

		String secondaryDiagnosisCd23 = " ";
		String secondaryTypeCd23 = " ";

		String secondaryDiagnosisCd24 = " ";
		String secondaryTypeCd24 = " ";
		
		//@
		String reasonCd1 = "Z760";
		String reasontypeCd1 = "APR";
		
		String reasonCd2 = "";
		String reasontypeCd2 = "";
		
		String reasonCd3 = "";
		String reasontypeCd3 = "";
		
		String externalVendorID = "ANALYZE";
		
		String serviceLineTot = "60";
		
		String cptCode_01 = "99285";
		String cptModifier1_01 = "25";
		String cptModifier2_01 = " ";
		String cptModifier3_01 = " ";
		String cptModifier4_01 = " ";

		
		String cptCode_02 = "71010";
		String cptModifier1_02 = "26";
		String cptModifier2_02 = " ";
		String cptModifier3_02 = " ";
		String cptModifier4_02 = " ";
		
		String cptCode_03 = "74185";
		String cptModifier1_03 = " ";
		String cptModifier2_03 = " ";
		String cptModifier3_03 = " ";
		String cptModifier4_03 = " ";
		
		String cptCode_04 = "83930";
		String cptModifier1_04 = " ";
		String cptModifier2_04 = " ";
		String cptModifier3_04 = " ";
		String cptModifier4_04 = " ";
		
		String cptCode_05 = "95827";
		String cptModifier1_05 = " ";
		String cptModifier2_05 = " ";
		String cptModifier3_05 = " ";
		String cptModifier4_05 = " ";

		String lineID_01 = "1";
		String units_01 = "1";
		String unitsType_01 = " ";
		String billedCharges_01 = "57";
		String beginDate_01 = "2017-09-01";
		String endDate_01 = "2017-09-01";
		
		String lineID_02 = "2";
		String units_02 = "1";
		String unitsType_02 = " ";
		String billedCharges_02 = "57";
		String beginDate_02 = "2017-09-01";
		String endDate_02 = "2017-09-01";
		
		String lineID_03 = "3";
		String units_03 = "1";
		String unitsType_03 = " ";
		String billedCharges_03 = "425";
		String beginDate_03 = "2017-09-01";
		String endDate_03 = "2017-09-01";
		
		String lineID_04 = "4";
		String units_04 = "1";
		String unitsType_04 = " ";
		String billedCharges_04 = "57";
		String beginDate_04 = "2017-09-01";
		String endDate_04 = "2017-09-01";
		
		String lineID_05 = "5";
		String units_05 = "1";
		String unitsType_05 = " ";
		String billedCharges_05 = "425";
		String beginDate_05 = "2017-09-01";
		String endDate_05 = "2017-09-01";
		
		String icd9ICD10Cd = "0";
		String operationCd = "18";
		
		String analyzerType = "1";
		String versionNumber = "1";
		String edcAction = "2";
		String levelChangeOption = "1";
		String startLevelOption1 = "false";
		String startLevelOption2 = "false";
		String startLevelOption3 = "false";
		String startLevelOption4 = "true";
		String startLevelOption5 = "true";
		
		/**
		 * String together claim level fields...
		 */
		rec = "0" + fldDelimiter +
			requestType + fldDelimiter +
			parInd + fldDelimiter +
			claimId + fldDelimiter +
			subname + fldDelimiter +
			subid + fldDelimiter +
			payid + fldDelimiter +
			dob + fldDelimiter +
			gender + fldDelimiter +
			billTypeCode + fldDelimiter +

			dischargeStatus + fldDelimiter +
			conditionCode1 + fldDelimiter +
			conditionCode2 + fldDelimiter +
			conditionCode3 + fldDelimiter +
			conditionCode4 + fldDelimiter +
			conditionCode5 + fldDelimiter +
			conditionCode6 + fldDelimiter +
			conditionCode7 + fldDelimiter +
			conditionCode8 + fldDelimiter +
			conditionCode9 + fldDelimiter +
			conditionCode10 + fldDelimiter +
			conditionCode11 + fldDelimiter +
			conditionCode12 + fldDelimiter +
			totalBilledCharges + fldDelimiter +
			serviceFromDate + fldDelimiter +
			serviceToDate + fldDelimiter +

			admitDiagnosis + fldDelimiter +
			admitDiagnosisTypeCd + fldDelimiter +
			
			primaryDiagnosis + fldDelimiter +
			primaryTypeCd + fldDelimiter +
			secondaryDiagnosisCd1 + fldDelimiter +
			secondaryTypeCd1 + fldDelimiter +
			secondaryDiagnosisCd2 + fldDelimiter +
			secondaryTypeCd2 + fldDelimiter +
			secondaryDiagnosisCd3 + fldDelimiter +
			secondaryTypeCd3 + fldDelimiter +
			secondaryDiagnosisCd4 + fldDelimiter +
			secondaryTypeCd4 + fldDelimiter +
			secondaryDiagnosisCd5 + fldDelimiter +
			secondaryTypeCd5 + fldDelimiter +
			secondaryDiagnosisCd6 + fldDelimiter +
			secondaryTypeCd6 + fldDelimiter +
			secondaryDiagnosisCd7 + fldDelimiter +
			secondaryTypeCd7 + fldDelimiter +
			secondaryDiagnosisCd8 + fldDelimiter +
			secondaryTypeCd8 + fldDelimiter +
			secondaryDiagnosisCd9 + fldDelimiter +
			secondaryTypeCd9 + fldDelimiter +
			secondaryDiagnosisCd10 + fldDelimiter +
			secondaryTypeCd10 + fldDelimiter +
			secondaryDiagnosisCd11 + fldDelimiter +
			secondaryTypeCd11 + fldDelimiter +
			secondaryDiagnosisCd12 + fldDelimiter +
			secondaryTypeCd12 + fldDelimiter +
			secondaryDiagnosisCd13 + fldDelimiter +
			secondaryTypeCd13 + fldDelimiter +
			secondaryDiagnosisCd14 + fldDelimiter +
			secondaryTypeCd14 + fldDelimiter +
			secondaryDiagnosisCd15 + fldDelimiter +
			secondaryTypeCd15 + fldDelimiter +
			secondaryDiagnosisCd16 + fldDelimiter +
			secondaryTypeCd16 + fldDelimiter +
			secondaryDiagnosisCd17 + fldDelimiter +
			secondaryTypeCd17 + fldDelimiter +
			secondaryDiagnosisCd18 + fldDelimiter +
			secondaryTypeCd18 + fldDelimiter +
			secondaryDiagnosisCd19 + fldDelimiter +
			secondaryTypeCd19 + fldDelimiter +
			secondaryDiagnosisCd20 + fldDelimiter +
			secondaryTypeCd20 + fldDelimiter +
			secondaryDiagnosisCd21 + fldDelimiter +
			secondaryTypeCd21 + fldDelimiter +
			secondaryDiagnosisCd22 + fldDelimiter +
			secondaryTypeCd22 + fldDelimiter +
			secondaryDiagnosisCd23 + fldDelimiter +
			secondaryTypeCd23 + fldDelimiter +
			secondaryDiagnosisCd24 + fldDelimiter +
			secondaryTypeCd24 + fldDelimiter +
			
			reasonCd1 + fldDelimiter +
			reasontypeCd1 + fldDelimiter +
			reasonCd2 + fldDelimiter +
			reasontypeCd2 + fldDelimiter +
			reasonCd3 + fldDelimiter +
			reasontypeCd3 + fldDelimiter +
			
			externalVendorID + fldDelimiter +
			serviceLineTot + fldDelimiter +
			icd9ICD10Cd + fldDelimiter +
			operationCd + fldDelimiter +
			analyzerType + fldDelimiter +
			versionNumber + fldDelimiter +
			edcAction + fldDelimiter +
			levelChangeOption + fldDelimiter +
			startLevelOption1 + fldDelimiter +
			startLevelOption2 + fldDelimiter +
			startLevelOption3 + fldDelimiter +
			startLevelOption4 + fldDelimiter +
			startLevelOption5 + recDelimiter;
		
		/**
		 * Send claim level fields...
		 */
		GGMAPRestService rest = new GGMAPRestService();
		rest.sendRequestFields(rec);
		
		/**
		 * String together 60 service lines...  
		 */
		rec = "";
		for (int i=0; i < 60; i++) {
			String lineNbr = String.format ("%03d", i + 1);
			rec = rec + lineNbr + fldDelimiter +
					lineID_01 + fldDelimiter +
					units_01 + fldDelimiter +
					unitsType_01 + fldDelimiter +
					billedCharges_01 + fldDelimiter +
					beginDate_01 + fldDelimiter +
					endDate_01 + fldDelimiter +	
					
					cptCode_01 + fldDelimiter +
					cptModifier1_01 + fldDelimiter +	
					cptModifier2_01 + fldDelimiter +	
					cptModifier3_01 + fldDelimiter +	
					cptModifier4_01 + recDelimiter;
		}
		
		/**
		 * Send line level fields...  
		 */
		rest.sendRequestFields(rec);

		/**
		 * Mimic PARMS file on mainframe
		 */
		String host = "https://api-int-stg.uhc.com:8443" + recDelimiter;
		String resource = "/api/ERC/test/provider/pricing/price/ggmapclaim/v1" + recDelimiter;
		String client_id = "l7xx688ad3ce4c86467d83c203e73ac2038b" + recDelimiter;
		String client_secret = "b56f9e4285a3e8a49cacc8f1c3447881f18ed0f68edd1ce12aad6376b735b135f852ec9f4aeb39fc" + recDelimiter;
		String env = "T" + recDelimiter;
		String timestamp = "20171001" + recDelimiter;
		String scope = "read" + recDelimiter;
		String actor = "test" + recDelimiter;

		/**
		 * Call REST service
		 */
		List<String> rsp = rest.callRestService(host, resource, client_id, client_secret, env, timestamp, scope, actor);
		
		/**
		 * Print pipe delimited response
		 */
		System.out.println("Size of response array: " + rsp.size());
		for (int i=0; i < rsp.size(); i++) {
			System.out.println(rsp.get(i));
		}
		
		/**
		 * Print JSON request & response
		 */
		System.out.println("\n" + rest.getJsonRequest());
	}
}
