package eStore;

public class SupportTicket 
{
	String supportTicketID;
	String problemDetails;
	String reporter;
	String assignee;
	String proposedSolution;
	String status;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getSupportTicketID() {
		return supportTicketID;
	}
	public void setSupportTicketID(String supportTicketID) {
		this.supportTicketID = supportTicketID;
	}
	public String getProblemDetails() {
		return problemDetails;
	}
	public void setProblemDetails(String problemDetails) {
		this.problemDetails = problemDetails;
	}
	public String getReporter() {
		return reporter;
	}
	public void setReporter(String reporter) {
		this.reporter = reporter;
	}
	public String getAssignee() {
		return assignee;
	}
	public void setAssignee(String assignee) {
		this.assignee = assignee;
	}
	public String getProposedSolution() {
		return proposedSolution;
	}
	public void setProposedSolution(String proposedSolution) {
		this.proposedSolution = proposedSolution;
	}
	
}