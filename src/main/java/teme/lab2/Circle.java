package teme.lab2;

import com.jogamp.opengl.*;
import com.jogamp.opengl.awt.GLCanvas;

import javax.swing.*;

public class Circle implements GLEventListener {

    @Override
    public void init(GLAutoDrawable glAutoDrawable) {

    }

    @Override
    public void dispose(GLAutoDrawable glAutoDrawable) {

    }

    @Override
    public void display(GLAutoDrawable glAutoDrawable) {
        drawCircle(glAutoDrawable,0f, 0f, 0.3f, 360);
    }

    private void drawCircle(GLAutoDrawable glAutoDrawable,float cx, float cy, float r, int num_segments)
    {
        final GL2 gl = glAutoDrawable.getGL().getGL2();
        gl.glLineWidth(5);
        gl.glEnable(GL2.GL_LINE_WIDTH);
        gl.glBegin(GL2.GL_LINES);

        for (int i=0; i < 360; i++) {
            float theta = 2.0f * 3.1415926f * (float) i / (float) num_segments;
            float x = (float) (r * Math.cos(theta));
            float y = (float) (r * Math.sin(theta));
            gl.glVertex2f(x + cx, y + cy);
        }

        gl.glEnd();
        gl.glFlush();
    }

    @Override
    public void reshape(GLAutoDrawable glAutoDrawable, int i, int i1, int i2, int i3) {

    }

    public static void main( String[] args ) {

        //getting the capabilities object of GL2 profile
        final GLProfile profile = GLProfile.get( GLProfile.GL2 );
        GLCapabilities capabilities = new GLCapabilities(profile);

        // The canvas
        final GLCanvas glcanvas = new GLCanvas(capabilities);
        Circle house = new Circle();
        glcanvas.addGLEventListener( house );
        glcanvas.setSize(400, 400);

        //creating temalab2
        final JFrame frame = new JFrame( "Circle" );

        //adding canvas to temalab2
        frame.getContentPane().add( glcanvas );
        frame.setSize(frame.getContentPane().getPreferredSize() );
        frame.setVisible( true );

    }
}
