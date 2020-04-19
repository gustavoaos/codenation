package com.challenge.desafio;

import com.challenge.annotation.Somar;
import com.challenge.annotation.Subtrair;
import com.challenge.interfaces.Calculavel;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.math.BigDecimal;

public class CalculadorDeClasses implements Calculavel {

    @Override
    public BigDecimal somar(Object obj) {
        return this.addByAnnotation(obj, Somar.class);
    }

    @Override
    public BigDecimal subtrair(Object obj) {
        return this.addByAnnotation(obj, Subtrair.class);
    }

    @Override
    public BigDecimal totalizar(Object obj) {
        return this.somar(obj).subtract(this.subtrair(obj));
    }

    private BigDecimal addByAnnotation(Object obj, Class<? extends Annotation> annotation) {
        Field[] fields = obj.getClass().getDeclaredFields();
        BigDecimal total = BigDecimal.ZERO;

        for (Field field : fields) {
            if (field.getType().equals(BigDecimal.class) && field.isAnnotationPresent(annotation)) {
                try {
                    field.setAccessible(true);
                    total = total.add((BigDecimal) field.get(obj));
                } catch (IllegalArgumentException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

        return total;
    }

}