package sourabhs.designpatterns.structural;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sourabh
 * 
 *  Structural design pattern 
 *  
 * It is used when we have to represent a part-whole hierarchy. 
 *   When we need to create a structure in a way that the objects 
 *   in the structure has to be treated the same way, we can apply composite design pattern.
 *   Example drawing has different objects Circle, rectangle etc. we fill colour to Circle
 *   rectangles and also to the objects of drawing
 */

//The Base component
interface Shape {
	public void draw(String fillColor);
}

// Leaf objects which implements base component 
class Triangle implements Shape {

	@Override
	public void draw(String fillColor) {
		System.out.println("Drawing Triangle with color "+fillColor);
	}
}

//Leaf objects which implements base component 
class Circle implements Shape {

	@Override
	public void draw(String fillColor) {
		System.out.println("Drawing Circle with color "+fillColor);
	}
}

//Leaf objects which implements base component with other funtions
class Drawing implements Shape{

	//collection of Shapes
	private List<Shape> shapes = new ArrayList<Shape>();
	
	@Override
	public void draw(String fillColor) {
		for(Shape sh : shapes)
			sh.draw(fillColor);
	}
	
	public void add(Shape s){
		this.shapes.add(s);
	}
	
	public void remove(Shape s){
		shapes.remove(s);
	}
	
	public void clear(){
		System.out.println("Clearing all the shapes from drawing");
		this.shapes.clear();
	}
}

public class CompositePattern {

	public static void main(String[] args) {
		
		Shape tri = new Triangle();
		Shape tri1 = new Triangle();
		Shape cir = new Circle();
		
		Drawing drawing = new Drawing();
		drawing.add(tri1);
		drawing.add(tri1);
		drawing.add(cir);
		
		drawing.draw("Red");
		
		drawing.clear();
		
		drawing.add(tri);
		drawing.add(cir);
		drawing.draw("Green");
	}

}
