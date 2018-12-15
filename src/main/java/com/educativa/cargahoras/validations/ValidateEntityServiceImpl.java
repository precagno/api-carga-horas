package com.educativa.cargahoras.validations;

import org.springframework.stereotype.Service;

@Service
public class ValidateEntityServiceImpl implements ValidateEntityService{
    public boolean isNull(Object elem){
        return elem==null;
    }
    public boolean isEmpty(String elem){
        boolean isElemEmpty=true;

        if(!this.isNull(elem)){
            isElemEmpty=elem.trim().equals("");
        }

        return isElemEmpty;
    }
}