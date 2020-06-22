package com.thoughtworks.midquiz.midquiz.Serveice;

import com.thoughtworks.midquiz.midquiz.Model.Education;
import com.thoughtworks.midquiz.midquiz.Model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GetEducationByIdService {

    private Map<Long, ArrayList<Education>> educationMap = new HashMap<>();
    private List<Education> educationArray = new ArrayList<>();
    

    public GetEducationByIdService() {
        educationArray.add(new Education((long)2,(long)2014,"Bacholar","Jiangxi Agricultueal University"));
        educationArray.add(new Education((long)2,(long)2018,"Postgraduate","City University Of HongKong"));
        educationMap.put((long)2, (ArrayList<Education>) educationArray);
    }

    public List<Education> getEducationById(long id) {
        return educationMap.get(id);
    }

    public void createEducation(Education education,long id) {
        education.setUserId(id);
        if(educationMap.containsKey(id)){
            ArrayList<Education> arr = educationMap.get(id);
            arr.add(education);
            educationMap.put(id,arr);
        }
        else{
            ArrayList<Education> createdarr = new ArrayList<>();
            createdarr.add(education);
            educationMap.put(id,createdarr);
        }

    }

}
