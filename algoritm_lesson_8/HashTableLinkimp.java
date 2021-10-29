package algoritm_lesson_8;
/**
 *      Домашнее задание к 8 лекции Шевеленко Андрея Александровича
 */

import java.util.LinkedList;

public class HashTableLinkimp <K, V> implements HashTable<K, V>{


    static class Item<K, V> implements Entry<K, V> {

        private final K key;
        private V value;
        public Item(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public void setValue(V value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Item{" + "key=" + key + ", value=" + value + '}';
        }
    }

    private final LinkedList [] data;
    private final Item<K, V> emptyEntry;
    private int size;

    public HashTableLinkimp(int initialCapacity) {
        this.data = new LinkedList[initialCapacity * 2];
        emptyEntry = new Item<>(null, null);
    }

    public HashTableLinkimp() {
        this(16);
    }

    @Override
    public boolean put(K key, V value) {
        if (size() == data.length) {
            return false;
        }
        int index = hashFunc(key);
        if(data[index]==null) {
            data[index] = new LinkedList();
            data[index].add(new Item<>(key, value));
            size++;
            return true;
        }else{
            data[index].add(new Item<>(key, value));
            size++;
            return true;
        }
    }

    public boolean isKeysEquals(Item<K, V> item, K key) {
        if (item == emptyEntry) {
            return false;
        }
        return item.getKey() == null ? key == null : item.getKey().equals(key);
    }

    protected int getStep(K key) {
        return 1;
    }

    protected int hashFunc(K key) {
        return Math.abs(key.hashCode()) % data.length;
    }

    @Override
    public V get(K key) {
        int index = indexOf(key);
        if(index == -1) return null;
        for (Object u: data[index]){
            if(isKeysEquals((Item<K, V>) ((Item<K, V>) u).getKey(), key)){
                return (V) ((Item<?, ?>) u).value;
            }
        }
        return null;
    }

    public int indexOf(K key) {
        int index = hashFunc(key);
        return index;
    }


    @Override
    public V remove(K key) {
        int index = indexOf(key);
        Item<K, V> temp;
        if (index == -1) {
            return null;
        }
        for (Object u: data[index]){
            temp = (Item<K, V>) u;
            //if( ((Product)(((Item) temp).getKey())).getTitle().equals( ((Product)key).getTitle()) ){
            if(isKeysEquals(temp,key)){
                data[index].remove(u);
                if (data[index].size()==0){
                    data[index]=null;
                }
                return (V) temp.getValue();
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size != 0;
    }

    @Override
    public void display() {
        System.out.println("--------------------------");
        for (int i = 0; i < data.length; i++) {
            if (data[i] == null){
                System.out.println("Элемент "+i);
                System.out.println("  null");
            } else{
                System.out.println("Элемент "+i);
                for (Object u: data[i]) {
                    System.out.print("  "+((Item) u).getKey());
                }
                System.out.println();
            }
        }
        System.out.println("--------------------------");
    }
}