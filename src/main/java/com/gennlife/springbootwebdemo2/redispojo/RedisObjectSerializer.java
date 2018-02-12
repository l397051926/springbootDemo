package com.gennlife.springbootwebdemo2.redispojo;

import org.springframework.core.convert.converter.Converter;
import org.springframework.core.serializer.support.DeserializingConverter;
import org.springframework.core.serializer.support.SerializingConverter;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;


/**
 * @author liumingxin
 * @create 2018 12 16:21
 * @desc
 **/
public class RedisObjectSerializer  implements RedisSerializer {

    private Converter<Object,byte[]> serializer =new SerializingConverter();

    private Converter<byte[],Object> deSerialiazer = new DeserializingConverter();

    static final byte[] EMPTY_ARRAY=new byte[0];

    @Override
    public byte[] serialize(Object o) throws SerializationException {

        if(o == null){
            return EMPTY_ARRAY;
        }
        try {
            return serializer.convert(o);
        }catch (Exception e){
            return EMPTY_ARRAY;
        }
    }

    @Override
    public Object deserialize(byte[] bytes) throws SerializationException {
        if (isEmpty(bytes)) {
            return null;
        }

        try {
            return deSerialiazer.convert(bytes);
        } catch (Exception ex) {
            throw new SerializationException("Cannot deserialize", ex);
        }
    }

    private boolean isEmpty(byte[] data) {
        return (data == null || data.length == 0);
    }
}
