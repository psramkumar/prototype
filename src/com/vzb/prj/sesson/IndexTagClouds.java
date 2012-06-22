package com.vzb.prj.sesson;


import java.io.Serializable;

import javax.inject.Named;

import lombok.Getter;

import org.primefaces.model.tagcloud.DefaultTagCloudItem;
import org.primefaces.model.tagcloud.DefaultTagCloudModel;
import org.primefaces.model.tagcloud.TagCloudModel;

@Named
@javax.enterprise.context.SessionScoped
public class IndexTagClouds implements Serializable {

	private static final long serialVersionUID = 6909938849298733631L;
	@Getter private TagCloudModel model;
	//@Getter private DashboardModel dashModel;

	public IndexTagClouds() {
		model = new DefaultTagCloudModel();
		model.addTag(new DefaultTagCloudItem("Portfolio", "#", 1));
		model.addTag(new DefaultTagCloudItem("CIM", "#", 3));
		model.addTag(new DefaultTagCloudItem("MIDAS", "#", 2));
		model.addTag(new DefaultTagCloudItem("AccountAdmin", "#", 5));
		model.addTag(new DefaultTagCloudItem("PQS", "#", 4));
		model.addTag(new DefaultTagCloudItem("eBilling", "#", 2));
		model.addTag(new DefaultTagCloudItem("LECTarrif", "#", 5));
		model.addTag(new DefaultTagCloudItem("Verizon", "#", 3));
		model.addTag(new DefaultTagCloudItem("VZB", "#", 4));
		model.addTag(new DefaultTagCloudItem("Tulsa", "#", 1));
		
		/*dashModel = new DefaultDashboardModel();  
        DashboardColumn column1 = new DefaultDashboardColumn();  
        DashboardColumn column2 = new DefaultDashboardColumn();  
        DashboardColumn column3 = new DefaultDashboardColumn();  
          
        column1.addWidget("sports");  
        column1.addWidget("finance");  
          
        column2.addWidget("lifestyle");  
        column2.addWidget("weather");  
          
        column3.addWidget("politics");
        column3.addWidget("events");  
  
        dashModel.addColumn(column1);  
        dashModel.addColumn(column2);  
        dashModel.addColumn(column3); 
        <!-- <h:form id="form">
			    <p:growl id="homeDashMessage" showDetail="true" />
			   
			    <p:dashboard id="board" model="#{indexTagClouds.dashModel}">
			        <p:ajax event="reorder" listener="#{indexTagClouds.handleReorder}" update="homeDashMessage" />
			
			        <p:panel id="sports" header="Sports" closable="true">
			            <h:outputText value="Sports Content" />
			        </p:panel>
			
			        <p:panel id="finance" header="Finance">
			            <h:outputText value="Finance Content" />
			        </p:panel>
			
			        <p:panel id="lifestyle" header="Clouds" >
			            <p:tagCloud model="#{indexTagClouds.model}" /> 
			        </p:panel>
			
			        <p:panel id="weather" header="Weather">
			            <h:outputText value="Weather Content" />
			        </p:panel>
			
			        <p:panel id="politics" header="User Inofrmation">
			            <h:outputText value="Welcome"/> <b>#{identity.user.id}</b> 
			        </p:panel>
			         <p:panel id="events" header="News Evnents">
			            <h:outputText value="Welcome"/> <b>#{identity.user.id}</b> 
			        </p:panel>
			    </p:dashboard>
			
			</h:form> -->
        */
	}
	
	/*public void handleReorder(DashboardReorderEvent event) {
		FacesMessage message = new FacesMessage();
		message.setSeverity(FacesMessage.SEVERITY_INFO);
		message.setSummary("Reordered: " + event.getWidgetId());
		message.setDetail("Item index: " + event.getItemIndex() + ", Column index: " + event.getColumnIndex() + ", Sender index: " + event.getSenderColumnIndex());
		addMessage(message);
	}
	
	private void addMessage(FacesMessage message) {
		FacesContext.getCurrentInstance().addMessage("homeDashMessage", message);
	}*/
	
}
                    