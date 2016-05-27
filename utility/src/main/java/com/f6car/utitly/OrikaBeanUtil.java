package com.f6car.utitly;


import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

import java.util.List;

public class OrikaBeanUtil {

    private static MapperFacade mapperFacade = null;

    private static MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();

    private static void init() {

        mapperFacade = mapperFactory.getMapperFacade();
    }


    static{
        init();
    }




    public  static <V, P> P convert(V base, Class<P> target) {

        return mapperFacade.map(base, target);
    }

    public static <V, P> List<P> convertList(List<V> baseList, Class<P> target) {

        return mapperFacade.mapAsList(baseList, target);
    }
}
