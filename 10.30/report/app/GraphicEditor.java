package report.app;

/*
 다음코드를 수정하여 Shape 클래스는 graphic 패키지에
 Circle 클래스는 component 클래스에
 GraphicEditor 클래스는 app 패키지에 분리 작성하라.
 */


import report.component.Circle;
import report.graphic.Shape;

import java.awt.*;




public class GraphicEditor {
    public static void main(String[] args){
        Shape shape = new Circle();
        shape.draw();
    }
}
