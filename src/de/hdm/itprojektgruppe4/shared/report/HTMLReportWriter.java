package de.hdm.itprojektgruppe4.shared.report;
import java.util.List;
import java.util.Vector;

import de.hdm.itprojektgruppe4.shared.bo.Kontakt;

public class HTMLReportWriter extends ReportWriter {

	  private String reportText = "";

	
	  public void resetReportText() {
	    this.reportText = "";
	  }

	 
	  public String paragraph2HTML(Paragraph p) {
	    if (p instanceof CompositeParagraph) {
	      return this.paragraph2HTML((CompositeParagraph) p);
	    }
	    else {
	      return this.paragraph2HTML((SimpleParagraph) p);
	    }
	  }

	
	  public String paragraph2HTML(CompositeParagraph p) {
	    StringBuffer result = new StringBuffer();

	    for (int i = 0; i < p.getNumParagraphs(); i++) {
	      result.append("<p>" + p.getParagraphAt(i) + "</p>");
	    }

	    return result.toString();
	  }

	 
	  public String paragraph2HTML(SimpleParagraph p) {
	    return "<p>" + p.toString() + "</p>";
	  }

	 
	  public String getHeader() {
	    StringBuffer result = new StringBuffer();

	    result.append("<html><head><title></title></head><body>");
	    return result.toString();
	  }

	
	  public String getTrailer() {
	    return "</body></html>";
	  }
	  
	  public String getReportText(){
		  return this.getHeader() + this.reportText + this.getTrailer();
	  }


		
	

	@Override
	public void process(AllEigeneKontakteReport p) {
	    this.resetReportText();
	    
	    StringBuffer result = new StringBuffer();
	   
		  
		  result.append("<h3>"+ p.getTitle() + "</h3>");
		  result.append("<table style=\"width:400px;border:1px solid silver\"><tr>");
		  result.append("</tr><tr><td></td><td>" + p.getCreated().toString() + "</td></tr></table>");

		  	 Vector<Row> rows = p.getRows();
		     result.append("<table style=\"width:400px\">");
		     for (int i = 0; i < rows.size(); i++) {
		         Row row = rows.elementAt(i);
		         result.append("<tr>");
		         for (int k = 0; k < row.getColumns().size(); k++) {
		           if (i == 0) {
		        	
		             result.append("<td style=\"background:silver;font-weight:bold\">" + row.getColumnAt(k)
		                 + "</td>");	             
		           }
		           else {
		             if (i > 1) {
		               result.append("<td style=\"border-top:1px solid silver\">"
		                   + row.getColumnAt(k) + "</td>");
		             }
		             else {
		               result.append("<td valign=\"top\">" + row.getColumnAt(k) + "</td>");
		             }
		           }
		         }
		         result.append("</tr>");
		       }

		       result.append("</table>");    
		       this.reportText = result.toString();
		
	}

	@Override
	public void process(KontakteMitBestimmterTeilhaberschaftReport p) {
	    this.resetReportText();
		
	    StringBuffer result = new StringBuffer();
	    
	    result.append("<h3>"+ p.getTitle() + "</h3>");
		  result.append("<table style=\"width:400px;border:1px solid silver\"><tr>");
		  result.append("</tr><tr><td></td><td>" + p.getCreated().toString() + "</td></tr></table>");

		  	 Vector<Row> rows = p.getRows();
		     result.append("<table style=\"width:400px\">");
		     for (int i = 0; i < rows.size(); i++) {
		         Row row = rows.elementAt(i);
		         result.append("<tr>");
		         for (int k = 0; k < row.getColumns().size(); k++) {
		           if (i == 0) {
		        	
		             result.append("<td style=\"background:silver;font-weight:bold\">" + row.getColumnAt(k)
		                 + "</td>");	             
		           }
		           else {
		             if (i > 1) {
		               result.append("<td style=\"border-top:1px solid silver\">"
		                   + row.getColumnAt(k) + "</td>");
		             }
		             else {
		               result.append("<td valign=\"top\">" + row.getColumnAt(k) + "</td>");
		             }
		           }
		         }
		         result.append("</tr>");
		       }

		       result.append("</table>");    
		       this.reportText = result.toString();
	
	}


//	public void process( AllEigeneKontakteReport p) {
//		// TODO Auto-generated method stub
//		this.resetReportText();
//			    
//			    StringBuffer result5 = new StringBuffer();
//			   
//				  
//			    result5.append("<h3>"+ p.getTitle() + "</h3>");
//			    result5.append("<table style=\"width:400px;border:1px solid silver\"><tr>");
//			    result5.append("</tr><tr><td></td><td>" + p.getCreated().toString() + "</td></tr></table>");
//		
//				  	 Vector<Row> rows = p.getRows();
//				  	result5.append("<table style=\"width:400px\">");
//				     for (int i = 0; i < rows.size(); i++) {
//				         Row row = rows.elementAt(i);
//				         result5.append("<tr>");
//				         for (int k = 0; k < row.getColumns().size(); k++) {
//				           if (i == 0) {
//				        	
//				        	   result5.append("<td style=\"background:silver;font-weight:bold\">" + row.getColumnAt(k)
//				                 + "</td>");	             
//				           }
//				           else {
//				             if (i > 1) {
//				            	 result5.append("<td style=\"border-top:1px solid silver\">"
//				                   + row.getColumnAt(k) + "</td>");
//				             }
//				             else {
//				            	 result5.append("<td valign=\"top\">" + row.getColumnAt(k) + "</td>");
//				             }
//				           }
//				         }
//				         result5.append("</tr>");
//				       }
//		
//				     result5.append("</table>");    
//				       this.reportText = result.toString();
//			}


	@Override
	public void process(KontakteMitBestimmtenEigenschaftsAuspraegungenReport c) {
		// TODO Auto-generated method stub
		
	}

	

	
	
}
