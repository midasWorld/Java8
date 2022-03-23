package com;

// 모든 함수가 추상 메소드로 구성된 클래스!
interface Runnable {
    void run();
}

public class Main implements Runnable {
    public static void main(String[] args) {
        Runnable m = new Main();
        m.run();
    }

    @Override
    public void run() {
        System.out.println("Hello World");
    }
}
