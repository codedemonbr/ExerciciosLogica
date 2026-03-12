package com.codedemonbr;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows; // Opcional, se quiser testar entradas inválidas

// Assumindo que a classe a ser testada se chama Interval e o método sumIntervals é estático
// Ajuste o import conforme o pacote real da sua implementação
import static com.codedemonbr.Interval.sumIntervals;

class IntervalTest {

    @Test
    @DisplayName("Deve retornar 0 para array vazio")
    void testEmptyArray() {
        assertEquals(0, sumIntervals(new int[][]{}));
    }

    @Test
    @DisplayName("Deve retornar 0 quando todos os intervalos têm comprimento zero")
    void testZeroLengthIntervals() {
        assertEquals(0, sumIntervals(new int[][]{{4, 4}, {6, 6}, {8, 8}}));
        assertEquals(0, sumIntervals(new int[][]{{-5, -5}, {0, 0}, {100, 100}}));
    }

    @Test
    @DisplayName("Deve somar corretamente intervalos disjuntos")
    void testDisjointIntervals() {
        assertEquals(9, sumIntervals(new int[][]{{1, 2}, {6, 10}, {11, 15}}));
        assertEquals(11, sumIntervals(new int[][]{{4, 8}, {9, 10}, {15, 21}}));
        assertEquals(7, sumIntervals(new int[][]{{-1, 4}, {-5, -3}}));
        assertEquals(78, sumIntervals(new int[][]{{-245, -218}, {-194, -179}, {-155, -119}}));
    }

    @Test
    @DisplayName("Deve somar corretamente intervalos adjacentes (sem sobreposição)")
    void testAdjacentIntervals() {
        // Adjacentes: [1,2] e [2,6] se tocam, mas não sobrepõem
        assertEquals(1 + 4 + 49, sumIntervals(new int[][]{{1, 2}, {2, 6}, {6, 55}}));
        assertEquals(2 + 3, sumIntervals(new int[][]{{-10, -8}, {-8, -5}}));
    }

    @Test
    @DisplayName("Deve mesclar intervalos sobrepostos simples")
    void testSimpleOverlapping() {
        // [1,4] e [3,5] -> mescla para [1,5] (comprimento 4)
        assertEquals(4 + 3, sumIntervals(new int[][]{{1, 4}, {7, 10}, {3, 5}})); // 4 + 3 = 7
    }

    @Test
    @DisplayName("Deve mesclar múltiplas sobreposições em cadeia")
    void testChainOverlapping() {
        // [1,5], [2,6], [3,7] -> tudo mescla para [1,7] (comprimento 6)
        assertEquals(6, sumIntervals(new int[][]{{1, 5}, {2, 6}, {3, 7}}));
    }

    @Test
    @DisplayName("Deve lidar com intervalos que contêm outros completamente")
    void testContainedIntervals() {
        // [1,10] contém [2,5] e [6,8] -> apenas [1,10] conta (comprimento 9)
        assertEquals(9, sumIntervals(new int[][]{{1, 10}, {2, 5}, {6, 8}}));
    }

    @Test
    @DisplayName("Deve funcionar com intervalos em ordem não classificada")
    void testUnsortedIntervals() {
        assertEquals(19, sumIntervals(new int[][]{
                {1, 5}, {10, 20}, {1, 6}, {16, 19}, {5, 11}
        }));
        // Mesmo conjunto, ordem diferente
        assertEquals(19, sumIntervals(new int[][]{
                {16, 19}, {1, 6}, {10, 20}, {5, 11}, {1, 5}
        }));
    }

    @Test
    @DisplayName("Deve lidar com intervalos negativos e positivos")
    void testMixedSignIntervals() {
        assertEquals(5 + 5 + 10, sumIntervals(new int[][]{{-5, 0}, {0, 5}, {5, 15}}));
        assertEquals(20, sumIntervals(new int[][]{{-10, 10}})); // comprimento 20
    }

    @Test
    @DisplayName("Deve lidar com intervalos grandes nos limites especificados")
    void testLargeIntervals() {
        // Teste com valores próximos aos limites: [-1_000_000_000, 1_000_000_000]
        assertEquals(2_000_000_000, sumIntervals(new int[][]{{-1_000_000_000, 1_000_000_000}}));
        assertEquals(1_500_000_000, sumIntervals(new int[][]{{-1_000_000_000, 500_000_000}, {500_000_000, 1_000_000_000}}));
    }

    @Test
    @DisplayName("Deve lidar com o exemplo de grandes intervalos do enunciado")
    void testExampleLargeIntervals() {
        // Exemplo fornecido: [[0, 20], [-100000000, 10], [30, 40]] -> 100000030
        assertEquals(100_000_030, sumIntervals(new int[][]{{0, 20}, {-100_000_000, 10}, {30, 40}}));
    }

    @Test
    @DisplayName("Deve lidar com intervalos que começam e terminam no mesmo número (comprimento zero)")
    void testZeroLengthIncluded() {
        // Intervalos de comprimento zero não devem afetar o resultado
        assertEquals(5, sumIntervals(new int[][]{{1, 6}, {3, 3}, {4, 4}}));
        assertEquals(0, sumIntervals(new int[][]{{0, 0}, {0, 0}}));
    }

    @Test
    @DisplayName("Deve funcionar com um único intervalo")
    void testSingleInterval() {
        assertEquals(4, sumIntervals(new int[][]{{1, 5}}));
        assertEquals(10, sumIntervals(new int[][]{{-5, 5}}));
    }

    // Teste opcional para verificar se o método lança exceção para null (se aplicável)
    // @Test
    // @DisplayName("Deve lançar NullPointerException para entrada null")
    // void testNullInput() {
    //     assertThrows(NullPointerException.class, () -> sumIntervals(null));
    // }

    // Teste de desempenho (opcional, pode ser marcado como integração)
    // @Test
    // @DisplayName("Deve processar muitos intervalos rapidamente")
    // void testPerformance() {
    //     int[][] manyIntervals = new int[10000][2];
    //     for (int i = 0; i < 10000; i++) {
    //         manyIntervals[i][0] = i * 2;
    //         manyIntervals[i][1] = i * 2 + 1;
    //     }
    //     // Apenas verifica se não lança exceção, sem medição rigorosa de tempo
    //     assertEquals(10000, sumIntervals(manyIntervals));
    // }
}