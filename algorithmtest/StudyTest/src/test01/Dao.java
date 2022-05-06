package test01;

import java.util.*;

/**
 * @author hongtao
 * @create 2022-04-21-17:09
 */
@SuppressWarnings("all")
public class Dao<T> {
    private Map<String ,T> map = new HashMap<>();
    public void save(String id,T entity){
        map.put(id,entity);
    }
    public T get(String id ){
        return map.get(id);
    }
    public void upDate(String id,T entity){
        map.put(id,entity);
    }
    public List<T> list(){
        //创建List
        List<T> list = new ArrayList<>();
        Set<String> KeySet = map.keySet();
        for (String key:KeySet){
            list.add(map.get(key));
        }
        return list;
    }
    public void delete(String id){
        map.remove(id);
    }


}
