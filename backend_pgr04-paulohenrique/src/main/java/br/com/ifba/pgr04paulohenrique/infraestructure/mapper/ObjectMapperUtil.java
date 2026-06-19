package br.com.ifba.pgr04paulohenrique.infraestructure.mapper;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ObjectMapperUtil {

    private final ModelMapper modelMapper;

    public <Input, Output> Output map(final Input object, final Class<Output> clazz) {
        return modelMapper.map(object, clazz);
    }

    public <Input, Output> List<Output> mapAll(final List<Input> objects, final Class<Output> clazz) {
        return objects.stream()
                .map(obj -> modelMapper.map(obj, clazz))
                .collect(Collectors.toList());
    }
}