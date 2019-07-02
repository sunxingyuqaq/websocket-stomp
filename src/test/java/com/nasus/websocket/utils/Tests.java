package com.nasus.websocket.utils;

import com.nasus.websocket.ThreadLocalSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringJoiner;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @author Xingyu Sun
 * @date 2019/3/6 15:39
 */
public class Tests {

    @Test
    public void test(){
        List<String> strings = new ArrayList<>();
        strings.add("111");
        strings.add("222");
        strings.add("333");
        strings.add("444");
        System.out.println(strings);
        List<String> list = new ArrayList<>();
        list.add("2224");
        list.add("333");
        Iterator<String> iterator = strings.iterator();
        while (iterator.hasNext()){
            String next = iterator.next();
            for (String s : list) {
                if(s.equals(next)){
                    iterator.remove();
                }

            }
        }
        System.out.println(strings);
    }

    @Test
    public void test2() throws InterruptedException {
        new Thread(()->{
            ThreadLocalSession.setMap("thread-"+Thread.currentThread().getName()+"-ok");
            System.out.println(ThreadLocalSession.get());
        }).start();
        new Thread(()->{
            ThreadLocalSession.setMap("thread-"+Thread.currentThread().getName()+"-ok");
            System.out.println(ThreadLocalSession.get());
        }).start();
        //ThreadLocalSession.setMap("ok");
        TimeUnit.SECONDS.sleep(2);
        System.out.println(ThreadLocalSession.get());
        ThreadLocalSession.remove();
    }

    @Test
    public void join(){
        StringJoiner joiner = new StringJoiner(";");
        StringJoiner add = joiner.add("java").add("c++").add("python").add("");
        System.out.println(add.toString());
        List<String> list = new ArrayList<>();
        list.add("java");
        list.add("c++");
        list.add("python");
        list.add("");
        String collect = String.join(";", list);
        System.out.println(collect);
    }
}
