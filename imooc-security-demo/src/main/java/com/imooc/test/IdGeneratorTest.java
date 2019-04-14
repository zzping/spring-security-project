package com.imooc.test;

import org.springframework.data.keyvalue.core.IdentifierGenerator;
import org.springframework.util.*;

import java.util.ArrayList;

/**
 * @author Trig
 * @create 2019-04-14 14:53
 */
public class IdGeneratorTest {

    public static void main(String[] args) {

        System.out.println("================================================================================");
        idGeneratorTest3();
    }

    private static void idGeneratorTest1() {
        System.out.println("======================SimpleIdGenerator============================");
        IdGenerator idGenerator = new SimpleIdGenerator();
        for (int i = 0; i < 100; i++) {
            System.out.println(idGenerator.generateId());
        }

        System.out.println("======================JdkIdGenerator============================");
        idGenerator = new JdkIdGenerator();
        for (int i = 0; i < 20; i++) {
            System.out.println(idGenerator.generateId());
        }

        System.out.println("======================AlternativeJdkIdGenerator============================");
        idGenerator = new AlternativeJdkIdGenerator();
        for (int i = 0; i < 20; i++) {
            System.out.println(idGenerator.generateId());
        }
    }
    private static void idGeneratorTest2() {
        String id1 = "00000000-0000-0000-0000-000000000001";
        String id2 = "00000000-0000-0000-0000-000000000002";
        String id3 = "00000000-0000-0000-0000-000000000003";
        String id4 = "00000000-0000-0000-0000-00000000000f";
        String id5 = "00000000-0000-0000-0000-000000000012";

        System.out.println(id1.replaceAll("-", ""));
    }

    private static void idGeneratorTest3() {
        System.out.println(ClassUtils.getQualifiedName(IdGeneratorTest.class));
        ArrayList<Object> arrayList = new ArrayList<>();
        System.out.println(CollectionUtils.isEmpty(arrayList));


    }

}
