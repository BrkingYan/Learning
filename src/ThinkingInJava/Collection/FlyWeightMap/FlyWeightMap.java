package ThinkingInJava.Collection.FlyWeightMap;

import java.util.*;


/*
*  一个只读的Map，
*  AbstractMap抽象类只实现了
*   keySet()、values()、containsValue()、containsKey()、get(key)、remove(key)、clear()等方法
*   因此Map如果不去重写put方法，就不能往里添加东西
*
*   并且，该Map中的EntrySet继承AbstractSet，
* */
class FlyWeightMap extends AbstractMap {

    // 6 x 2  String[key][value]
    private static final String[][] DATA = {
            {"key1","Algiers"},
            {"key2","Luanda"},
            {"key3","Beijing"},
            {"key4","Beijing"},
            {"key5","Washington"},
            {"key6","London"}
    };
    // 所有 Entry
    private static Set<Map.Entry<String,String>> entries = new EntrySet(DATA.length);

    // 获取所有 Entry
    @Override
    public Set<Map.Entry<String,String>> entrySet() {
        return entries;
    }

    public Set<Map.Entry<String,String>> entrySet(int size) {
        return new EntrySet(size);
    }

    /*
     *  Entry 嵌套类1  key1=Algiers 是 一个Entry
     * */
    private static class Entry implements Map.Entry<String,String> {
        private int index;

        Entry(int index){
            this.index = index;
        }

        // Methods from Map.Entry
        @Override
        public String getKey() {
            return DATA[index][0];
        }

        @Override
        public String getValue() {
            return DATA[index][1];
        }

        @Override
        public String setValue(String value) {
            throw new UnsupportedOperationException();
        }

        @Override
        public String toString() {
            return DATA[index][0] + "=" + DATA[index][1];
        }
    }

    /*
     *  EntrySet 嵌套类2  EntrySet是一个Set，它包含多个Entry
     *
     *  该EntrySet继承AbstractSet，而AbstractSet本身只有 removeAll()一种操作元素的方法，
     *  因此该EntrySet是只读的
     * */

    static class EntrySet extends AbstractSet<Map.Entry<String,String>> {
        private int size;

        EntrySet(int size){
            if (size < 0){
                this.size = 0;
            }else if (size > DATA.length){
                this.size = DATA.length;
            }else {
                this.size = size;
            }
        }

        /*
         *  EntrySet内部实现的迭代器 (迭代的元素类型是 Map.Entry<String,String>)
         * */
        private class Itr implements Iterator<Map.Entry<String,String>> {

            private Entry entry = new Entry(-1);
            @Override
            public boolean hasNext() {
                return entry.index < size-1;
            }
            @Override
            public Map.Entry<String, String> next() {
                entry.index ++;
                return entry;
            }
        }

        @Override
        public Iterator<Map.Entry<String, String>> iterator() {
            return new Itr();
        }

        @Override
        public int size() {
            return size;
        }
    }

}
