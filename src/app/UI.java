package app;

import java.util.Scanner;

public class UI {
    private Game game;
    private Scanner scanner;
    public UI(){
        game = new Game();
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
        finally{
            scanner.close();
        }
        
    }
    public void ParseCommand(String input) {
        try {
            String input1 = input.split(" ")[0];
            switch (input1) {               
                case "exit":
                    break;

                case "reset":
                    game.Reset();
                    break;

                case "place":
                    ShowField();
                    game.PlaceMark(Integer.parseInt(input.split(" ")[1]),Integer.parseInt(input.split(" ")[2]));
                    break;

                default:
                    ParseCommand(input);
                    break;
        }
        } catch (Exception e) {
            // TODO: handle exception
        }
        
    }
    public void ShowField() {
        GameField field = game.field;
        System.out.println(field.GetState(1,3).toString()+"│"+field.GetState(2,3).toString()+"│"+field.GetState(3,3).toString());
        System.out.println("─┼─┼─");
        System.out.println(field.GetState(1,2).toString()+"│"+field.GetState(2,2).toString()+"│"+field.GetState(3,2).toString());
        System.out.println("─┼─┼─");
        System.out.println(field.GetState(1,1).toString()+"│"+field.GetState(2,1).toString()+"│"+field.GetState(3,1).toString());
        System.out.println("");
    }
    public void AnnounceWin(CellState winner){
        switch (winner) {
            case CellState.Cross:
                System.out.println("Crosses won!");
                break;
            case CellState.Circle:
                System.out.println("Circles won!");
                break;
            case CellState.Empty:
                System.out.println("Draw!");
                break;
            default:
                break;
        }
        System.out.println();
    }
    public void AppStart() {
        String input = GetLine("Enter place, reset or exit");
        ParseCommand(input);
    }
}
