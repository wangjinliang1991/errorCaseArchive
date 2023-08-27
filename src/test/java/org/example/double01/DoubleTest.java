package org.example.double01;

import org.junit.jupiter.api.Test;

public class DoubleTest {
    @Test
    public void testDouble01() {
        // 计算机是以二进制存储数值的
        System.out.println(0.1+0.2);
        System.out.println(1.0-0.8);
        System.out.println(4.015*100);
        System.out.println(123.3/100);

        double amount1 = 2.15;
        double amount2 = 1.10;

        if (amount1 - amount2 == 1.05) {
            System.out.println("ok");
        }
    }


}
