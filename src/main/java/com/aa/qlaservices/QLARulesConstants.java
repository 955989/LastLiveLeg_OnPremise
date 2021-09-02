/**
 * Added By Uma Goudar on 14-April-2021
 * This java file contains legality rules and segregated, stored in array list.
 * This list can be used in other files to check which rules covered in what type of legality
 */
package com.aa.qlaservices;

import java.util.ArrayList;

public class QLARulesConstants {
	
	public ArrayList<String> legalRulesSet = new ArrayList<String>();
	public ArrayList<String> ContractualRulesSet_AllowLLL = new ArrayList<String>();
	public ArrayList<String> ContractualRulesSet_DenyLLL = new ArrayList<String>();
	public ArrayList<String> qualRulesSet = new ArrayList<String>();
	
	public QLARulesConstants() {
		// TODO Auto-generated constructor stub
		
		this.legalRulesSet.add("24X7REST");
		this.legalRulesSet.add("AVLCLSTR");
		this.legalRulesSet.add("AVLNORLS");
		this.legalRulesSet.add("AVLORIG");
		this.legalRulesSet.add("BASENE");
		this.legalRulesSet.add("BLCKLIM");
		this.legalRulesSet.add("BLCKLIMA");
		this.legalRulesSet.add("DBLILLGL");
		this.legalRulesSet.add("DBLSTBY");
		this.legalRulesSet.add("DBLSTN");
		this.legalRulesSet.add("DBLTRNG");
		this.legalRulesSet.add("AVLNORLS");
		this.legalRulesSet.add("DONOTFND");
		this.legalRulesSet.add("DUTYDBL");
		this.legalRulesSet.add("DUTYLIMA");
		this.legalRulesSet.add("RSTCOMP");
		this.legalRulesSet.add("RSTCOMP24");
		this.legalRulesSet.add("RSTREQ");
		this.legalRulesSet.add("SEQCMPLT");
		this.legalRulesSet.add("SEQINPRG");
		this.legalRulesSet.add("SEQRSTRC");
		this.legalRulesSet.add("STBCREDIT");
		this.legalRulesSet.add("STBERROR");
		this.legalRulesSet.add("TOUCHGST");
		this.legalRulesSet.add("TOUCHSEQ");
		this.legalRulesSet.add("TRADERR");
		this.legalRulesSet.add("VACLSTR");
		this.legalRulesSet.add("VACNOTFN");
		this.legalRulesSet.add("VACYEAR");
		this.legalRulesSet.add("TABEEXCEP");
		
		this.ContractualRulesSet_AllowLLL.add("30X7BLOC");
		this.ContractualRulesSet_AllowLLL.add("30X7WVOV");
		this.ContractualRulesSet_AllowLLL.add("35X7BLOC");
		this.ContractualRulesSet_AllowLLL.add("35X7WVOV");
		this.ContractualRulesSet_AllowLLL.add("DBLBACK");
		this.ContractualRulesSet_AllowLLL.add("DBLFRONT");
 		this.ContractualRulesSet_AllowLLL.add("HOMEREST");
		this.ContractualRulesSet_AllowLLL.add("ISOVRMAX");
		this.ContractualRulesSet_AllowLLL.add("ISOVRMAXB");
		this.ContractualRulesSet_AllowLLL.add("ISUNDER");
		this.ContractualRulesSet_AllowLLL.add("ISUNDERB");
		this.ContractualRulesSet_AllowLLL.add("MLTDUTY");
//		this.ContractualRulesSet_AllowLLL.add("SEQNFND");
//		this.ContractualRulesSet_AllowLLL.add("TOUCHFD");
		this.ContractualRulesSet_AllowLLL.add("TOUCHL/H");
		this.ContractualRulesSet_AllowLLL.add("TOUCHREL");
		this.ContractualRulesSet_AllowLLL.add("TOUCHVAC");
		this.ContractualRulesSet_AllowLLL.add("WILLOVRP");
		this.ContractualRulesSet_AllowLLL.add("WILLUNDP");

		
		this.qualRulesSet.add("BASICQUAL");
		this.qualRulesSet.add("DITCHIN");
		this.qualRulesSet.add("EQPQUALS");
		this.qualRulesSet.add("LICQUAL");
		this.qualRulesSet.add("PPSTQUAL");
		this.qualRulesSet.add("SECQUAL");
		this.qualRulesSet.add("SVCQUALS");
		this.qualRulesSet.add("VISAQUAL");
		
		
		this.ContractualRulesSet_DenyLLL.add("OFFRLSE");
		this.ContractualRulesSet_DenyLLL.add("OFFRPT");
		this.ContractualRulesSet_DenyLLL.add("PURSQUAL");
		this.ContractualRulesSet_DenyLLL.add("SPKRQUAL");
		this.ContractualRulesSet_DenyLLL.add("TOUCHAVL");
		this.ContractualRulesSet_DenyLLL.add("TOUCHGD");
		this.ContractualRulesSet_DenyLLL.add("TOUCHSTB");
		this.ContractualRulesSet_DenyLLL.add("TRN24WRN");
		
	}

}
