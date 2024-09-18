package socialTest;

import java.util.HashMap;
import java.util.Map;

public class ClassMap<BaseClass> {
    private Map<Class<? extends BaseClass>, BaseClass> map = new HashMap<>();

    public boolean containsKey(Class<? extends BaseClass> clazz) {
        return map.containsKey(clazz);
    }

    public <T extends BaseClass> T get(Class<T> classType) {
        BaseClass page = map.get(classType);
        if (!page.getClass().equals(classType)) {
            throw new RuntimeException("invalid type" + page.getClass() +"for" + classType);
        }
        return (T) map.get(classType);
    }

    public void put(BaseClass page) {
        map.put((Class<? extends BaseClass>) page.getClass(), page);
    }
}
