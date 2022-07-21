/**
 * P3D7 - Final project
 */

import java.util.ArrayList;
import java.io.FileInputStream;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.paint.Color;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.control.Button;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class P3D7 extends Application
{
    /**************** Do NOT modify anything above this point ******************/
    /* delete these two lines and replace them with a Java comment containing no 
    more than 5 lines that describe how your code works precisely and concisely */
    public static void coolEffect()
    {
        // do NOT modify this line
        before1.loadPicture(beforePic1Name, width, height);

        // uncomment this line if 2nd picture is needed
        // before2 = new Picture(beforePic2Name,width,height);

        // Implement your cool effect below
        for (int c = 0; c < before1.getWidth(); c++)
        {
            for (int r = 0; r < before1.getHeight(); r++)
            {
                before1.setBlue(170, c, r);
                before1.setRed(150, c, r);
            }
        }
    }// coolEffect method - Do NOT modify this line

    // change ONLY jpg to png (if needed)
    private static String beforePic1Name = "./pics/before1.jpg";

    // uncomment (if 2nd picture is needed) and change ONLY jpg to png (if needed)
    //private static String beforePic2Name = "./pics/before2.jpg";

    // the width and height in pixels of the before1 and after pictures
    private static int width = 600;   // update this line as needed
    private static int height = 480;  // update this line as needed

    /**************** Do NOT modify anything below this point ******************/

    static Picture before1, before2; 
    static Stage stage;

    private static ArrayList<Button> buttons = new ArrayList<Button>();
    private static String[] btnLabels =  
        {   "Cool Effect",
            "Save Picture"
        };

    private static int buttonWidth = 250;

    private static String defaultButtonStyle =
        "-fx-background-radius: 5em; -fx-min-width: " + buttonWidth + "px; " +
        "-fx-min-height: 35px; -fx-max-width: " + buttonWidth + "px; -fx-font-size: 17px; " +
        "-fx-max-height: 35px; -fx-background-color: #4831D4; " +
        "-fx-text-fill: #CCF381; -fx-background-insets: 0px; -fx-padding: 5px; ";

    private static String highlighted = 
        " -fx-background-color: #5978ff; -fx-scale-y: 1.1; -fx-text-fill: white;"; 

    /**
     *  Save the current pic in a file named ./pics/after.jpg
     */
    private static void savePic()
    {
        before1.saveToFile("./pics/after.jpg");
    }// savePic method

    /*************************************************************************
     **************** Do NOT modify the code below this point ****************
     *************************************************************************/

    /**
     * Determines whether a pixel is black or dark enough
     *
     * @param  color  color of the pixel to be checked
     * @return        whether the pixel is black or dark enough
     */
    private static boolean isBlack( Color color )
    {
        return ( (color.getRed() < 0.1) &&
            (color.getGreen() < 0.1) &&
            (color.getBlue() < 0.1) );
    }// isBlack method

    /**
     * Determines whether a pixel is white or light enough
     *
     * @param  color  color of the pixel to be checked
     * @return        whether the pixel is white or light enough
     */
    private static boolean isWhite( Color color )
    {
        return ( (color.getRed() > 0.9) &&
            (color.getGreen() > 0.9) &&
            (color.getBlue() > 0.9) );
    }// isWhite method

    private static void performAction(int actionNumber)
    {
        switch (actionNumber) 
        {
            case 0: coolEffect(); break;
            case 1: savePic(); break;
        }

    }// performAction method

    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) throws Exception
    {   
        stage = primaryStage;

        for ( int i = 0; i < btnLabels.length; i++)
            createButton(i);

        VBox vBox = new VBox(10);
        vBox.setAlignment(Pos.CENTER);
        vBox.setPadding( new Insets(10));
        vBox.getChildren().addAll(buttons);

        before1 = new Picture(beforePic1Name);               // wrong size
        before1.loadPicture(beforePic1Name, width, height);  // resize it

        HBox hBox = new HBox(10);
        hBox.setAlignment(Pos.CENTER_RIGHT);
        hBox.getChildren().addAll(before1,vBox);

        Scene scene = new Scene(hBox,width + buttonWidth + 50, height + 40);
        primaryStage.setTitle("P3D7"); 
        primaryStage.setScene(scene);
        primaryStage.sizeToScene();
        primaryStage.show();
    }// start method

    static void createButton(int n) 
    {
        Button btn = new Button(btnLabels[n]);
        btn.setStyle( defaultButtonStyle );
        btn.setOnAction(actionEvent ->  { performAction(n); });
        btn.setOnMouseEntered(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent t) {
                    btn.setStyle(defaultButtonStyle + highlighted);
                }
            });
        btn.setOnMouseExited(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent t) {
                    btn.setStyle(defaultButtonStyle );
                }
            });

        //;
        buttons.add(btn);
    }// createButton method
} // P3D7 class
