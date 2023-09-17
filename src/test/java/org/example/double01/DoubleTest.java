package org.example.double01;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.HashSet;
import java.util.Set;

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

    @Test
    public void testBigDecimal01() {
        System.out.println(new BigDecimal(0.1).add(new BigDecimal(0.2)));
        System.out.println(new BigDecimal(1.0).subtract(new BigDecimal(0.8)));
        System.out.println(new BigDecimal(4.015).multiply(new BigDecimal(100)));
        System.out.println(new BigDecimal(123.3).divide(new BigDecimal(100)));
    }

    @Test
    public void testBigDecimal02() {
        System.out.println(new BigDecimal("0.1").add(new BigDecimal("0.2")));
        System.out.println(new BigDecimal("1.0").subtract(new BigDecimal("0.8")));
        System.out.println(new BigDecimal("4.015").multiply(new BigDecimal("100")));
        System.out.println(new BigDecimal("123.3").divide(new BigDecimal("100")));
    }

    @Test
    public void testDouble02() {
        System.out.println(new BigDecimal(Double.toString(4.015)).multiply(new BigDecimal(Double.toString(100))));
    }

    @Test
    public void testPrecision() {
        double num1 = 3.35;
        float num2 = 3.35f;

        System.out.println(String.format("%.1f", num1));//四舍五入
        System.out.println(String.format("%.1f", num2));
    }

    @Test
    public void testDecimalFormat() {
        double num1 = 3.35;
        float num2 = 3.35f;
        DecimalFormat format = new DecimalFormat("#.##");

        format.setRoundingMode(RoundingMode.DOWN); //向下取舍
        System.out.println(format.format(num1));
        format.setRoundingMode(RoundingMode.DOWN);
        System.out.println(format.format(num2));
    }

    @Test
    public void testDecimalFormat2() {
        BigDecimal num1 = new BigDecimal("3.35");
        BigDecimal num2 = num1.setScale(1, BigDecimal.ROUND_DOWN);

        System.out.println(num2);
        BigDecimal num3 = num1.setScale(1, BigDecimal.ROUND_HALF_UP);//四舍五入
        System.out.println(num3);
    }

    @Test
    public void testBigDecimalEquals() {
        System.out.println(new BigDecimal("1.0").equals(new BigDecimal("1")));
    }

    @Test
    public void testBigDecimalEquals2() {
        System.out.println(new BigDecimal("1.0").compareTo(new BigDecimal("1")) == 0);
    }

    @Test
    public void testBigDecimalHashCode() {
        Set<BigDecimal> hashSet1 = new HashSet<>();
        hashSet1.add(new BigDecimal("1.0"));
        System.out.println(hashSet1.contains(new BigDecimal("1")));//返回false
    }
}
