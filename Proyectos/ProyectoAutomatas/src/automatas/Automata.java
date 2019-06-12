/*
 * Autómatas
 */
package automatas;

import javafx.animation.AnimationTimer;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

/**
 *
 * @author blackzafiro
 */
public class Automata extends AnimationTimer {
    
    private Group root;
    private Text text;
    private Rectangle [][] array;
    private Epidemia cel;
    private long timestamp;
    public static final long VAR = 1000000000;
    public int M;
    public int G;

    public Automata(Group root, int ren, int col, int M, int G) {
        this.root = root;
        this.M = M;
        this.G = G;
        text = new Text ("Inicio");
        text.setStroke(Color.WHITE);
        root.getChildren().add(text);
        cel = new Epidemia(ren, col, M, G);

        array = new Rectangle[ren][col];
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array[0].length; j++){
                array[i][j] = new Rectangle();
                array [i][j].setX(10 + 10  * i);
                array [i][j].setY(10 + 10 * j);
                array [i][j].setWidth(9);
                array [i][j].setHeight(9);
                array [i][j].setArcWidth(0);
                array [i][j].setArcHeight(0);
                Color c = Color.web("rgb(0,0,255)");
                array [i][j].setFill(c);
                root.getChildren().add(array[i][j]);
            }
        }
        timestamp = 0;
    }

   public void update(){
        int m;
        int col;
        String s;
        Color c;
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array[0].length; j++){
                m = cel.array[i][j];
                if(cel.suceptible(m))
                    s = "rgb(255,0,0)";
                else if(cel.infectada(m)){
                    col = m * (255/M);
                    s = "rgb(0," + col + ",0)";
                }else{
                    col = m * (255/M);
                    s = "rgb(223, 17, 29)";
                }
                c = Color.web(s);
                array[i][j].setFill(c); 
            }
        }
    }

    @Override
    public void handle(long now) {
        text.setText("tiempo " + now);
        if(now >= timestamp + VAR){
            timestamp = now;
            cel.next();
            update();
        }
    }
    
}
