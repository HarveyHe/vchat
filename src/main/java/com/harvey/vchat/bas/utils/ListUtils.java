package com.harvey.vchat.bas.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class ListUtils {
	
	public static boolean isNotEmpty(List<?> list) {
		if (list != null && list.size() > 0) {
			return true;
		}
		return false;
	}
	
	public static boolean isEmpty(List<?> list) {
		if (list == null || list.size() == 0) {
			return true;
		}
		return false;
	}
	
    public static <T> List<T> findAll(List<T> source, Predicate<T> predicate) {
        List<T> result = null;
        if (source != null && predicate != null) {
            result = new ArrayList<T>();
            for (Iterator<T> iter = source.iterator(); iter.hasNext();) {
                T item = iter.next();
                if (predicate.evaluate(item)) {
                    result.add(item);
                }
            }
        }
        return result;
    }
    
    public static <T> List<T> findAllAndRemove(List<T> source, Predicate<T> predicate) {
        List<T> result = null;
        if (source != null && predicate != null) {
            result = new ArrayList<T>();
            for (Iterator<T> iter = source.iterator(); iter.hasNext();) {
                T item = iter.next();
                if (predicate.evaluate(item)) {
                    result.add(item);
                    iter.remove();
                }
            }
        }
        return result;
    }    
    
    public static <T,T1> List<T1> findAllAndRemove(List<T> source, Predicate<T> predicate,Converter<T,T1> converter) {
        List<T1> result = null;
        if (source != null && predicate != null) {
            result = new ArrayList<T1>();
            for (Iterator<T> iter = source.iterator(); iter.hasNext();) {
                T item = iter.next();
                if (predicate.evaluate(item)) {
                    result.add(converter.convert(item));
                    iter.remove();
                }
            }
        }
        return result;
    }     
    
    
    public interface Predicate<T> {
        public boolean evaluate(T item);
    }
    
    public interface Converter<T1,T2>{
        T2 convert(T1 t1);
    }

}
