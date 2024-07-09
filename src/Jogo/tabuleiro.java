package Jogo;

import java.util.Scanner;

public class tabuleiro {

    private String[][] matriz;

    public tabuleiro() {
        grid();
    }

    public void grid() {
        matriz = new String[3][3];
        for (int i = 0;i < 3; i++){
            for (int j = 0; j < 3; j++){
                matriz[i][j] = "()";
            }
        }
    }

    public void exibirtabuleiro(){
        for (int i = 0;i < 3; i++){
            for (int j = 0; j < 3; j++){
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }



        //Marcador de posição
    public boolean marcador(int linha, int coluna, String marca){
            if (linha >= 0 && linha < 3 && coluna >= 0 && coluna < 3 && matriz[linha][coluna].equals("()")){
                matriz[linha][coluna] = marca;
                return true;
            } else {
                System.out.println("Posição invalida ou já ocuapada, tente novamente");
                return false;
            }


        }
    public boolean vencer(String marca) {
        // Verifica linhas
        for (int i = 0; i < 3; i++) {
            if (matriz[i][0].equals(marca) && matriz[i][1].equals(marca) && matriz[i][2].equals(marca)) {
                return true;
            }
        }
        // Verifica colunas
        for (int i = 0; i < 3; i++) {
            if (matriz[0][i].equals(marca) && matriz[1][i].equals(marca) && matriz[2][i].equals(marca)) {
                return true;
            }
        }
        // Verifica diagonais
        if (matriz[0][0].equals(marca) && matriz[1][1].equals(marca) && matriz[2][2].equals(marca)) {
            return true;
        } else if (matriz[0][2].equals(marca) && matriz[1][1].equals(marca) && matriz[2][0].equals(marca)) {
            return true;
        }
        return false;
    }

    public boolean empate() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (matriz[i][j].equals("()")) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc1 = new Scanner(System.in);
        tabuleiro table = new tabuleiro();
        String playeratual = "X";
        Boolean playercontinue = true;


        while (playercontinue) {
            table.exibirtabuleiro();;
            System.out.println("Jogador " + playeratual + ", é sua vez.");
            System.out.println("Digite a linha (0-2): ");
            int linha = sc1.nextInt();
            System.out.println("Digite a coluna (0-2): ");
            int coluna = sc1.nextInt();

            if (table.marcador(linha, coluna, playeratual)) {
                if (table.vencer(playeratual)) {
                    table.exibirtabuleiro();
                    System.out.println("Jogador " + playeratual + " venceu!");
                    playercontinue = false;
                } else if (table.empate()) {
                    table.exibirtabuleiro();
                    System.out.println("Empate!");
                    playercontinue = false;
                } else {
                    playeratual = playeratual.equals("X") ? "O" : "X";
                }
            }
        }

        sc1.close();



    }
}



