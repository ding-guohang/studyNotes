package com.dgh.study.jvm.oom;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * VM Args: -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 * 最小最大都20m，以防自动扩展
 * oom时dump内存堆的存储快照
 * <p>
 * Result:
 * java.lang.OutOfMemoryError: Java heap space
 * Dumping heap to java_pid9805.hprof ...
 * Heap dump file created [27785282 bytes in 0.275 secs]
 *
 * @author guohang.ding on 2017/6/8.
 */
public class HeapOOM {

    private static class OOMObject {
    }

    public static void main(String[] args) {
        List<OOMObject> list = Lists.newArrayList();
        while (true) {
            list.add(new OOMObject());
        }
    }
}
