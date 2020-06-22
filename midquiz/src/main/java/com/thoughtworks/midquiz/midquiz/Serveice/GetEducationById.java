package com.thoughtworks.midquiz.midquiz.Serveice;

import com.thoughtworks.midquiz.midquiz.Model.Education;
import com.thoughtworks.midquiz.midquiz.Model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetEducationById {

    private Map<Long, ArrayList<Education>> educationMap = new HashMap<>();
    private List<Education> educationArray = new ArrayList<>();
    

    public GetEducationById() {
        educationArray.add(new Education((long)2,(long)2014,"Bacholar","Jiangxi Agricultueal University"));
        educationArray.add(new Education((long)2,(long)2018,"Postgraduate","City University Of HongKong"));
    }

    public List<Education> getEducationById(long id) {
        return educationMap.get(id);
    }

    public void createEducation(Education education,long id) {
        education.setUserId(id);

    }

}
