package com.baidu.mapp.bcd.common.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

public class MyCollections {
    public static <T> List<List<T>> partition(List<T> source, int partitionSize) {
        List<List<T>> result = new ArrayList<>();
        if (source == null || source.size() <= partitionSize) {
            result.add(source);
            return result;
        }
        int size = source.size();
        int offset = 0;
        while (offset < size) {
            List<T> part = new ArrayList<>();
            result.add(part);
            int endIndex = offset + partitionSize;
            endIndex = endIndex > size ? size : endIndex;
            for (int i = offset; i < endIndex; i++) {
                part.add(source.get(i));
            }
            offset += endIndex;
        }
        return result;
    }

    public static <T> List<T> join(List<T>... source) {
        if (source == null || source.length <= 0) {
            return new ArrayList<>(0);
        }

        List<T> list = new ArrayList<>();
        for (List<T> ts : source) {
            if (ts == null || ts.isEmpty()) {
                continue;
            }
            for (T t : ts) {
                list.add(t);
            }
        }
        return list;
    }

    public static <T> List<T> join(List<List<T>> source) {
        if (source == null || source.size() <= 0) {
            return new ArrayList<>(0);
        }

        List<T> list = new ArrayList<>();
        for (List<T> ts : source) {
            if (ts == null || ts.isEmpty()) {
                continue;
            }
            for (T t : ts) {
                list.add(t);
            }
        }
        return list;
    }

    /**
     * Source 转换成单项
     *
     * @param convert
     * @param source
     * @param <T>
     * @param <S>
     *
     * @return
     */
    public static <T, S> List<T> join(Function<S, T> convert, List<S>... source) {
        if (source == null || source.length <= 0) {
            return new ArrayList<>(0);
        }

        List<T> list = new ArrayList<>();
        for (List<S> s : source) {
            if (s == null) {
                continue;
            }
            for (S s1 : s) {
                T ts = convert.apply(s1);

                list.add(ts);
            }
        }
        return list;
    }

    /**
     * Source 转换成 List
     *
     * @param convert
     * @param source
     * @param <T>
     * @param <S>
     *
     * @return
     */
    public static <T, S> List<T> joinList(Function<S, List<T>> convert, List<S>... source) {
        if (source == null || source.length <= 0) {
            return new ArrayList<>(0);
        }

        List<T> list = new ArrayList<>();
        for (List<S> s : source) {
            if (s == null) {
                continue;
            }
            for (S s1 : s) {
                List<T> ts = convert.apply(s1);
                if (ts == null || ts.isEmpty()) {
                    continue;
                }

                for (T t : ts) {
                    list.add(t);
                }
            }
        }
        return list;
    }

    public static <K, V> Map<K, V> toMap(List<V> source, Function<V, K> keyConvert) {
        if (source == null || source.isEmpty()) {
            return new HashMap<>(0);
        }

        Map<K, V> map = new HashMap<>();
        for (V v : source) {
            K k = keyConvert.apply(v);
            map.put(k, v);
        }
        return map;
    }

    public static <S, K, V> Map<K, V> toMap(List<S> source, Function<S, K> keyConvert, Function<S, V> valueConvert) {
        if (source == null || source.isEmpty()) {
            return new HashMap<>(0);
        }

        Map<K, V> map = new HashMap<>();
        for (S s : source) {
            K k = keyConvert.apply(s);
            V v = valueConvert.apply(s);
            map.put(k, v);
        }
        return map;
    }

    public static <K, V> Map<K, List<V>> toMapList(List<V> source, Function<V, K> keyConvert) {
        if (source == null || source.isEmpty()) {
            return new HashMap<>(0);
        }

        Map<K, List<V>> map = new HashMap<>();
        for (V v : source) {
            K k = keyConvert.apply(v);
            List<V> vs = map.get(k);
            if (vs == null) {
                vs = new ArrayList<>();
                map.put(k, vs);
            }
            vs.add(v);
        }
        return map;
    }

    public static <S, K, V> Map<K, List<V>> toMapList(List<S> source, Function<S, K> keyConvert,
                                                   Function<S, V> valueConvert) {
        if (source == null || source.isEmpty()) {
            return new HashMap<>(0);
        }

        Map<K, List<V>> map = new HashMap<>();
        for (S s : source) {
            K k = keyConvert.apply(s);
            V v = valueConvert.apply(s);
            List<V> vs = map.get(k);
            if (vs == null) {
                vs = new ArrayList<>();
                map.put(k, vs);
            }
            vs.add(v);
        }
        return map;
    }

    public static <R, C, V> Table<R, C, V> toGoogleTable(
            List<V> source,
            Function<V, R> rowKeyConvert,
            Function<V, C> columnKeyConvert) {
        Table<R, C, V> table = HashBasedTable.create();
        if (source == null || source.isEmpty()) {
            return table;
        }

        for (V s : source) {
            if (s == null) {
                continue;
            }

            R rowKey = rowKeyConvert.apply(s);
            C columnKey = columnKeyConvert.apply(s);
            table.put(rowKey, columnKey, s);
        }
        return table;
    }


    // @Nullable Object rowKey, @Nullable Object columnKey
    public static <S, R, C, V> Table<R, C, V> toGoogleTable(
            List<S> source,
            Function<S, R> rowKeyConvert,
            Function<S, C> columnKeyConvert,
            Function<S, V> valueKeyConvert) {
        Table<R, C, V> table = HashBasedTable.create();
        if (source == null || source.isEmpty()) {
            return table;
        }

        for (S s : source) {
            if (s == null) {
                continue;
            }

            R rowKey = rowKeyConvert.apply(s);
            C columnKey = columnKeyConvert.apply(s);
            V value = valueKeyConvert.apply(s);
            table.put(rowKey, columnKey, value);
        }
        return table;
    }
}
