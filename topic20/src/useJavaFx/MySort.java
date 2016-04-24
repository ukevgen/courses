package useJavaFx;

/**
 * Created by Администратор on 22.04.2016.
 */
public class MySort extends MainFrame {


    public static void main(String[] args) {



        launch(args);


        //main.init();



    }

    private static void printNumbers(int[] input) {

        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i] + ", ");
        }
        System.out.println("\n");
    }


}
