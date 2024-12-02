package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CalculadoraTest {
    
    @Test
    public void testSomar() {
        Calculadora calc = new Calculadora();
        int resultado = calc.somar(1, 2);
        assertEquals(3, resultado);
    }
}
