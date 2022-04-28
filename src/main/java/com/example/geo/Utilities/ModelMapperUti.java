package com.example.geo.Utilities;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public  class ModelMapperUti {

    private  final ModelMapper modelMapper;
    public  <T,TT> List<TT> mapList(List<T> list,Class<TT> ttClass){
    return     list.stream().map(c->modelMapper.map(c,ttClass)).collect(Collectors.toList());
    }
    public <T,TT> TT map(T t,Class<TT> ttClass){
        return  modelMapper.map(t,ttClass);
    }
}
