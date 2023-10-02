import javafx.application.Application;
import java.io.FileInputStream;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.SepiaTone;
import javafx.scene.effect.Glow;
import javafx.scene.effect.Shadow;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.FontPosture;
import javafx.scene.paint.Color;
import javafx.geometry.Pos;
import javafx.stage.Stage;
public class virat extends Application
{
    public void start(Stage primaryStage)throws Exception
    {
        BorderPane root1=new BorderPane();
        VBox root2=new VBox();
        VBox root=new VBox();
        
        Text title=new Text("Virat Kohli");
        title.setFont(Font.font("Times New Roman",FontWeight.BOLD,FontPosture.REGULAR,20));
        FileInputStream input=new FileInputStream("download.jpeg");
        Image image=new Image(input);
        ImageView imageview=new ImageView(image);
        Text info=new Text("Virat Kohli is an international cricketer and the former India Captain who also plays for RCB in the IPL");
        info.setWrappingWidth(300);
        
        root2.getChildren().addAll(title,imageview,info);
        root2.setAlignment(Pos.CENTER);
        
        MenuBar menubar=new MenuBar();
        Menu FileMenu=new Menu("File");
        Menu EditMenu=new Menu("Edit");
        Menu PictEffMenu=new Menu("Picture Effect");
        MenuItem NoEffMenu=new MenuItem("No Effects");
        MenuItem SepToMenu=new MenuItem("Sepia Tone");
        SepToMenu.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent arg0){
                SepiaTone sepia=new SepiaTone();
                sepia.setLevel(0.75);
                imageview.setEffect(sepia);
            }
        });
        MenuItem GloMenu=new MenuItem("Glow");
        GloMenu.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent arg0){
                Glow glow=new Glow();
                glow.setLevel(10);
                imageview.setEffect(glow);
            }
        });
        MenuItem ShadMenu=new MenuItem("Shadow");
        ShadMenu.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent arg0){
                Shadow shadow=new Shadow();
                shadow.setBlurType(BlurType.GAUSSIAN);
                shadow.setColor(Color.BLACK);
                shadow.setHeight(30);
                shadow.setRadius(12);
                shadow.setWidth(20);
                imageview.setEffect(shadow);
            }
        });
        Menu ViewMenu=new Menu("View");
        EditMenu.getItems().addAll(PictEffMenu,NoEffMenu);
        PictEffMenu.getItems().addAll(SepToMenu,GloMenu,ShadMenu);
        root1.setTop(menubar);
        menubar.getMenus().addAll(FileMenu,EditMenu,ViewMenu);
        
        root.getChildren().addAll(root1,root2);
        Scene scene=new Scene(root,300,300);
        primaryStage.setTitle("Menu Sample");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String args[])
    {
        launch(args);
    }
}