import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.Random;


//1224
public class Main extends Application {
    public static void main(String[] args){
        System.out.println("launch");
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        System.out.println("Start");
        primaryStage.setTitle("Skeleton");
        FlowPane rootNode= new FlowPane();
        Scene myScene= new Scene(rootNode,300  ,200);

        Button alpha= new Button("Alpha");
        Button beta =new Button("Beta");
        alpha.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Alert al=new Alert(Alert.AlertType.INFORMATION);
                al.setContentText("alpha");
                al.showAndWait();
            }
        });
        beta.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Alert al=new Alert(Alert.AlertType.INFORMATION);
                al.setContentText("beta");
                al.showAndWait();
            }
        });
        beta.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("1");
                Random r = new Random();
                double h=myScene.getHeight();
                double w= myScene.getWidth();
                double bh=beta.getHeight();
                double bw=beta.getWidth();
                double rh=r.nextInt((int)(h-bh));
                double rw=r.nextInt((int)(w-bw));
                for(int i =0;i<1000;i++){
                    h= beta.translateYProperty().get();
                    w= beta.translateXProperty().get();

                    if(rw>w){
                        double res=(w+0.1-rw)/(w-rw)*(h-rh)+rh;
                        beta.translateYProperty().set(res);
                        beta.translateXProperty().set(w+0.1);
                    }
                    else{
                        double res=(w-0.1-rw)/(w-rw)*(h-rh)+rh;
                        beta.translateYProperty().set(res);
                        beta.translateXProperty().set(w-0.1);
                    }
                    //System.out.println(rw+"  "+rh);
                    //System.out.println(beta.translateXProperty().get()+"  "+beta.translateYProperty().get());
                }
            }
        });
        rootNode.getChildren().addAll(alpha, beta);


        primaryStage.setScene(myScene);
        primaryStage.show();
    }
}
