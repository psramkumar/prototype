package com.vzb.prj.sesson;


import javax.inject.Named;

import org.primefaces.model.tagcloud.DefaultTagCloudItem;
import org.primefaces.model.tagcloud.DefaultTagCloudModel;
import org.primefaces.model.tagcloud.TagCloudModel;
import java.io.Serializable;

@Named("indexTagClouds")
@javax.enterprise.context.SessionScoped
public class IndexTagClouds implements Serializable {

	private static final long serialVersionUID = 6909938849298733631L;
	private TagCloudModel model;

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
    }

    public TagCloudModel getModel() {
        return model;
    }
}
                    