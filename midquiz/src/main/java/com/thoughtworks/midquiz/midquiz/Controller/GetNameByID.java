package com.thoughtworks.midquiz.midquiz.Controller;

import com.thoughtworks.midquiz.midquiz.Serveice.GetNameByIdServeice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

public class GetNameByID {
    private final GetNameByIdServeice getNameByIdServeice;

    @Autowired
    public GetNameByID(GetNameByIdServeice getNameByIdServeice){
        this.getNameByIdServeice = getNameByIdServeice;
    }

    @GetMapping("/user/1")
    public String sayName(){
        return getNameByIdServeice.myName();
    }
}
