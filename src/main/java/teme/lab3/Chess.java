package teme.lab3;

import com.jogamp.opengl.*;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.glu.GLUquadric;

import javax.swing.*;

public class Chess implements GLEventListener {
    @Override
    public void init(GLAutoDrawable glAutoDrawable) {

    }

    @Override
    public void dispose(GLAutoDrawable glAutoDrawable) {

    }

    @Override
    public void display(GLAutoDrawable glAutoDrawable) {
        final GL2 gl = glAutoDrawable.getGL().getGL2();
        boolean reverse = false;
        for(float f = -1.0f; f <= 1.0f; f += 0.25){
            drawOneRow(gl, f, reverse);
            reverse = !reverse;
        }
    }

    public void drawOneRow(GL2 gl, float row, boolean reverse){
        boolean black = reverse;
        for(float f = -1.0f; f <= 1.0f; f += 0.25){
            if(!black){
                gl.glColor3f(1.0f,1.0f,1.0f);
            }
            else{
                gl.glColor3f(0.0f,0.0f,0.0f);
            }

            gl.glBegin(gl.GL_POLYGON);
            gl.glVertex3f(f,            row,0.0f);
            gl.glVertex3f((f + 0.25f),  row,0.0f);
            gl.glVertex3f((f + 0.25f),  (row + 0.25f),0.0f);
            gl.glVertex3f(f,            (row + 0.25f),0.0f);
            gl.glEnd();

            black = !black;
        }
    }

    @Override
    public void reshape(GLAutoDrawable glAutoDrawable, int i, int i1, int i2, int i3) {

    }


    public static void main( String[] args ) {

        //getting the capabilities object of GL2 profile
        final GLProfile profile = GLProfile.get( GLProfile.GL2 );
        GLCapabilities capabilities = new GLCapabilities(profile);

        // The canvas
        final GLCanvas glcanvas = new GLCanvas( capabilities );
        Chess chess = new Chess();
        glcanvas.addGLEventListener( chess );
        glcanvas.setSize(400, 400);

        //creating temalab2
        final JFrame frame = new JFrame( "Chess" );

        //adding canvas to temalab2
        frame.getContentPane().add( glcanvas );
        frame.setSize(frame.getContentPane().getPreferredSize() );
        frame.setVisible( true );

    }
}
