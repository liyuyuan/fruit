package afternow.cn.service.impl;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestMain {

    public static void main(String[] args) {
        Node node = new Node();


    }







    static class Node{
        int value;
        Node next;
        Node pre;
        Node cur;
        Node head;
        Node last;


        public Node(int value, Node next, Node pre, Node cur) {
            this.value = value;
            this.next = next;
            this.pre = pre;
            this.cur = cur;
        }

        public Node() {

        }




    }


    public static Node reverLinked(Node head){
        if (null==head ){
            return head;
        }

        Node next = head.next;
        head.next=null;

        while (null!=next){
            Node cur = next.next;
            next.next= head;
            head = next;
            next = cur;
        }
        return head;
    }

}
