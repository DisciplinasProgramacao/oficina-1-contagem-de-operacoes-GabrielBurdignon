import java.util.Random;

public class App {
    static int[] tamanhosTesteGrande =  { 500_000, 1_000_000, 2_000_000, 3_000_000, 5_000_000, 10_000_000 };
    static int[] tamanhosTesteMedio =   {  12_500,  25_000,  50_000,   100_000,   200_000 };
    static int[] tamanhosTestePequeno = {       3,       6,      12,        24,        48 };
    static Random aleatorio = new Random(42);

   //Código de teste 1 - Conta quantos números pares existem nas posições pares do vetor. 
    static int codigo1(int[] vetor) {
        int resposta = 0;
        int operacoes = 0;
        for (int i = 0; i < vetor.length; i += 2) {
            resposta += vetor[i] % 2;
            operacoes++;
        }
        System.out.println("Operações código 1: " + operacoes);
        return resposta;
    }

  //Código de teste 2 - Conta quantas operações são feitas no loop duplo 
    static int codigo2(int[] vetor) {
        int contador = 0;
        int operacoes = 0;
        for (int k = (vetor.length - 1); k > 0; k /= 2) {
            for (int i = 0; i <= k; i++) {
                contador++;
                operacoes++;
            }
        }
        System.out.println("Operações código 2: " + operacoes);
        return contador;
    }

  // Código de teste 3 - Ordenação por seleção
    static void codigo3(int[] vetor) {
        int operacoes = 0;
        for (int i = 0; i < vetor.length - 1; i++) {
            int menor = i;
            for (int j = i + 1; j < vetor.length; j++) {
                if (vetor[j] < vetor[menor]) menor = j;
                operacoes++;
            }
            int temp = vetor[i];
            vetor[i] = vetor[menor];
            vetor[menor] = temp;
            operacoes++;
        }
        System.out.println("Operações código 3: " + operacoes);
    }

// Código de teste 4 - Fibonacci recursivo
    static int codigo4(int n) {
        if (n <= 2) return 1;
        return codigo4(n - 1) + codigo4(n - 2);
    }

// Gerador de vetores aleatórios
    static int[] gerarVetor(int tamanho) {
        int[] vetor = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            vetor[i] = aleatorio.nextInt(1, tamanho / 2);
        }
        return vetor;
    }

    public static void main(String[] args) {
        long inicio, fim;
        
        // Execução Código 1
        System.out.println("Executando Código 1:");
        for (int tamanho : tamanhosTesteGrande) {
            int[] vetor = gerarVetor(tamanho);
            inicio = System.nanoTime();
            codigo1(vetor);
            fim = System.nanoTime();
            System.out.println("Tempo Código 1 (" + tamanho + "): " + (fim - inicio) / 1e6 + " ms");
        }

        // Execução Código 2
        System.out.println("\nExecutando Código 2:");
        for (int tamanho : tamanhosTesteGrande) {
            int[] vetor = gerarVetor(tamanho);
            inicio = System.nanoTime();
            codigo2(vetor);
            fim = System.nanoTime();
            System.out.println("Tempo Código 2 (" + tamanho + "): " + (fim - inicio) / 1e6 + " ms");
        }

        // Execução Código 3
        System.out.println("\nExecutando Código 3:");
        for (int tamanho : tamanhosTesteMedio) {
            int[] vetor = gerarVetor(tamanho);
            inicio = System.nanoTime();
            codigo3(vetor);
            fim = System.nanoTime();
            System.out.println("Tempo Código 3 (" + tamanho + "): " + (fim - inicio) / 1e6 + " ms");
        }

        // Execução Código 4
        System.out.println("\nExecutando Código 4:");
        for (int tamanho : tamanhosTestePequeno) {
            inicio = System.nanoTime();
            int resultado = codigo4(tamanho);
            fim = System.nanoTime();
            System.out.println("Fibonacci(" + tamanho + ") = " + resultado);
            System.out.println("Tempo Código 4 (" + tamanho + "): " + (fim - inicio) / 1e6 + " ms");
        }
    }
}
