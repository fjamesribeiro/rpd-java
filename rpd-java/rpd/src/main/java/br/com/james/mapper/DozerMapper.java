package br.com.james.mapper;

import java.util.ArrayList;
import java.util.List;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;

public class DozerMapper {

	private static Mapper mapper = DozerBeanMapperBuilder.buildDefault();
	
	//Dto to entity
	public static <O, D> D parseObject(O oring, Class<D> destination) {
		return mapper.map(oring, destination);
	}
	
	//Dto to entity list
	public static <O, D> List<D> parseListObjects(List<O> oring, Class<D> destination) {
		List<D> dest =  new ArrayList<D>();
		for (O o : oring) {
			dest.add(mapper.map(o, destination));
		}
		return dest;
	}	

}
