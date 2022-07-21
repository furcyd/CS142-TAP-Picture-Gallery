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
    // This filter places a pixel art horse somewhere on the picture. It uses for loops to accomplish this
    // I did this by using a method to create a rectangle inside of an image. I then added IF statements
    // on the inside to further divide the filter as to be more precise with my pixel placements 
    // Originally it only made a 7x6 horse but I was able to make it larger by multiplying the ranges
    // by 4. 
    public static void coolEffect()
    {
        // do NOT modify this line
        before1.loadPicture(beforePic1Name, width, height);
        int randX = new java.util.Random().nextInt(before1.getWidth() - 40);
        int randY = new java.util.Random().nextInt(before1.getHeight() - 40);
        for (int c = randX; c <= randX + 28; c++) {
            if (c <= randX + 4) {
                for (int r = randY; r < randY + 24; r++) {
                    if (r <= randY + 8) {
                        before1.setRed(255, c, r);
                        before1.setGreen(255, c, r);
                        before1.setBlue(255, c, r);
                    }
                    else {
                        before1.setRed(95, c, r);
                        before1.setGreen(76, c, r);
                        before1.setBlue(49, c, r);
                    }
                }
            } 
            // line 2 +3
            else if (c <= randX + 12) {
                for (int r = randY; r < randY + 24; r++) {
                    if (r <= randY + 8) {
                        before1.setRed(255, c, r);
                        before1.setGreen(255, c, r);
                        before1.setBlue(255, c, r);
                    }
                    else if (r <= randY + 15) {
                        before1.setRed(95, c, r);
                        before1.setGreen(76, c, r);
                        before1.setBlue(49, c, r);
                    }
                    else {
                        before1.setRed(255, c, r);
                        before1.setGreen(255, c, r);
                        before1.setBlue(255, c, r);
                    }
                }
            }
            //line 4
            else if (c <= randX + 16) {
                for (int r = randY; r < randY + 24; r++) {
                    if (r <= randY + 15) {
                        before1.setRed(95, c, r);
                        before1.setGreen(76, c, r);
                        before1.setBlue(49, c, r);
                    }
                    else {
                        before1.setRed(255, c, r);
                        before1.setGreen(255, c, r);
                        before1.setBlue(255, c, r);
                    }
                }
            }
            //line 5
            else if (c <= randX + 20) {
                for (int r = randY; r < randY + 24; r++) {
                    if (r <= randY + 4) {
                        before1.setRed(95, c, r);
                        before1.setGreen(76, c, r);
                        before1.setBlue(49, c, r);
                    }
                    else if (r <= randY + 8) {
                        before1.setRed(255, c, r);
                        before1.setGreen(255, c, r);
                        before1.setBlue(255, c, r);
                    }
                    else {
                        before1.setRed(95, c, r);
                        before1.setGreen(76, c, r);
                        before1.setBlue(49, c, r);
                    }
                }
            }
            // line 6
            else if (c <= randX + 24){
                for (int r = randY; r < randY + 24; r++) {
                    if (r <= randY + 4) {
                        before1.setRed(95, c, r);
                        before1.setGreen(76, c, r);
                        before1.setBlue(49, c, r);
                    }
                    else if (r <= randY + 8) {
                        before1.setRed(0, c, r);
                        before1.setGreen(0, c, r);
                        before1.setBlue(0, c, r);
                    }
                    else if (r <= randY + 12) {
                        before1.setRed(95, c, r);
                        before1.setGreen(76, c, r);
                        before1.setBlue(49, c, r);
                    }
                    else {
                        before1.setRed(255, c, r);
                        before1.setGreen(255, c, r);
                        before1.setBlue(255, c, r);
                    }
                }
            }
            else if (c <= randX + 30) {
                for (int r = randY; r < randY + 24; r++) {
                    if (r <= randY + 12) {
                        before1.setRed(95, c, r);
                        before1.setGreen(76, c, r);
                        before1.setBlue(49, c, r);
                    }
                    else {
                        before1.setRed(255, c, r);
                        before1.setGreen(255, c, r);
                        before1.setBlue(255, c, r);
                    }
                }
            }
        }
    }// coolEffect method
    
    // change ONLY jpg to png (if needed)
    private static String beforePic1Name = "./pics/before1.jpg";

    // the width and height in pixels of the before1 and after pictures
    private static int width = 500;   // update this line as needed
    private static int height = 465;  // update this line as needed

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
