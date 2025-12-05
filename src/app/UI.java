package app;

import java.util.Scanner;

public class UI {
    //private Game game;
    private Scanner scanner;
    public UI(){
        //game = new Game();
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
            String input1 = input.split(input)[0];
            switch (input1) {
                case "start":
                    switch (input) {
                        default:
                            if (input.split(" ")[0]=="place"){
                                if (Integer.parseInt(input.split(" ")[1])<1||Integer.parseInt(input.split(" ")[1])>3||Integer.parseInt(input.split(" ")[2])<1||Integer.parseInt(input.split(" ")[2])>3){

                                } else {

                                }
                            }
                            break;
                    }
                    break;
                
                case "exit":
                    break;

                case "reset":
                    break;

                case "place":
                    ShowField();
                    //game.PlaceMark(Integer.parseInt(input.split(" ")[1],Integer.parseInt(input.split(" ")[2]);

                    break;

                default:
                    break;
        }
        } catch (Exception e) {
            // TODO: handle exception
        }
        
    }
    public void ShowField() {

    }
    public void AnnounceWin(CellState winner){

    }
    public void AppStart() {
        String input = GetLine("Enter place, reset or exit");
        ParseCommand(input);
    }
}
