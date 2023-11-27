package com.abw12.absolutefitness.usermgmt.mappers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GenericMapper<T,R> {

    @Autowired
    private ObjectMapper objectMapper;

    public R mapTo(T obj, Class<? extends R> R){
        return objectMapper.convertValue(obj,R);
    }
    public List<R> mapEntityToDTO(List<T> productList, Class<? extends R> R){
        return productList.stream().map(T -> mapTo(T,R)).collect(Collectors.toList());
    }

}

