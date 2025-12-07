package app;

import java.util.Scanner;

public class UI {
    private Game game;
    private Scanner scanner;
    public UI(){
        game = new Game();
    }
    public boolean AppStart() {
        String input = GetLine("place [..] [..], чтобы сделать ход в указанных координатах,\nreset, чтобы начать игру заново\nили exit, чтобы завершить работу приложения");
        return ParseCommand(input);
    }
    public String GetLine(String text) {
        try {
            scanner = new Scanner(System.in);
            System.out.println(text);
            if (scanner.hasNext()){
                return scanner.nextLine();
            } else {
                return "";
            }
        } catch (Exception e) {
            return "";
        }
    }
    public boolean ParseCommand(String input) {
        try {
            String[] inputArr = input.split("\s");
            switch (inputArr[0]) {
                case "exit":
                    return false;

                case "reset":
                    game.Reset();
                    ShowField();
                    return true;

                case "place":
                    if ((inputArr.length==3)/*&&(inputArr[1].equals("1")||inputArr[1].equals("2")||inputArr[1].equals("3"))&&(inputArr[2].equals("1")||inputArr[2].equals("2")||inputArr[2].equals("3"))*/) {
                        game.PlaceMark(Integer.parseInt(inputArr[1]),Integer.parseInt(inputArr[2]));
                        ShowField();
                    }
                    return true;
                default:
                    return true;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return true;
        }
        
    }
    public void ShowField() {
        try {
            GameField field = game.field;
            String[][] fieldToShow = new String[3][3];
            for (int i=0; i<3; i++) {
                for (int j=0; j<3; j++) {
                    switch (field.GetState(i,j)){
                        case CellState.Cross:
                            fieldToShow[i][j]="X";
                            break;
                        case CellState.Circle:
                            fieldToShow[i][j]="O";
                            break;
                        case CellState.Empty:
                            fieldToShow[i][j]=" ";
                            break;
                    }
                }
            }
            System.out.println("");
            System.out.println(fieldToShow[0][2]+"│"+fieldToShow[1][2]+"│"+fieldToShow[2][2]);
            System.out.println("─┼─┼─");
            System.out.println(fieldToShow[0][1]+"│"+fieldToShow[1][1]+"│"+fieldToShow[2][1]);
            System.out.println("─┼─┼─");
            System.out.println(fieldToShow[0][0]+"│"+fieldToShow[1][0]+"│"+fieldToShow[2][0]);
            System.out.println("");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }
    public void AnnounceWin(CellState winner){
        switch (winner) {
            case CellState.Cross:
                System.out.println("Крестики выиграли!");
                break;
            case CellState.Circle:
                System.out.println("Круги выиграли!");
                break;
            case CellState.Empty:
                System.out.println("Ничья!");
                break;
            default:
                break;
        }
        System.out.println();
    }
}
