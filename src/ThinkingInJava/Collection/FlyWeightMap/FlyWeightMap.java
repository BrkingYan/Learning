package ThinkingInJava.Collection.FlyWeightMap;

import java.util.*;


/*
*  һ��ֻ����Map��
*  AbstractMap������ֻʵ����
*   keySet()��values()��containsValue()��containsKey()��get(key)��remove(key)��clear()�ȷ���
*   ���Map�����ȥ��дput�������Ͳ���������Ӷ���
*
*   ���ң���Map�е�EntrySet�̳�AbstractSet��
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
    // ���� Entry
    private static Set<Map.Entry<String,String>> entries = new EntrySet(DATA.length);

    // ��ȡ���� Entry
    @Override
    public Set<Map.Entry<String,String>> entrySet() {
        return entries;
    }

    public Set<Map.Entry<String,String>> entrySet(int size) {
        return new EntrySet(size);
    }

    /*
     *  Entry Ƕ����1  key1=Algiers �� һ��Entry
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
     *  EntrySet Ƕ����2  EntrySet��һ��Set�����������Entry
     *
     *  ��EntrySet�̳�AbstractSet����AbstractSet����ֻ�� removeAll()һ�ֲ���Ԫ�صķ�����
     *  ��˸�EntrySet��ֻ����
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
         *  EntrySet�ڲ�ʵ�ֵĵ����� (������Ԫ�������� Map.Entry<String,String>)
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
