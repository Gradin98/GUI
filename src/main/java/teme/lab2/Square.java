package teme.lab2;

import com.jogamp.opengl.*;
import com.jogamp.opengl.awt.GLCanvas;

import javax.swing.*;

public class Square implements GLEventListener {
    @Override
    public void init(GLAutoDrawable glAutoDrawable) {

    }

    @Override
    public void dispose(GLAutoDrawable glAutoDrawable) {

    }

    @Override
    public void display(GLAutoDrawable glAutoDrawable) {
        final GL2 gl = glAutoDrawable.getGL().getGL2();

        gl.glBegin ( GL2.GL_LINES );
        gl.glColor3f(0.2f,0.5f,0.4f);
        gl.glVertex3f( -0.3f, 0.3f, 0 );
        gl.glVertex3f( 0.3f,0.3f, 0 );
        gl.glEnd();

        //drawing bottom
        gl.glBegin( GL2.GL_LINES );
        gl.glColor3f(0.7f,0.3f,0.4f);
        gl.glVertex3f( -0.3f,-0.3f, 0 );
        gl.glVertex3f( 0.3f,-0.3f, 0 );
        gl.glEnd();

        //drawing the right edge
        gl.glBegin( GL2.GL_LINES );
        gl.glColor3f(0.8f,0.6f,0.4f);
        gl.glVertex3f( -0.3f,0.3f, 0 );
        gl.glVertex3f( -0.3f,-0.3f, 0 );
        gl.glEnd();

        //drawing the left edge
        gl.glBegin( GL2.GL_LINES );
        gl.glColor3f(0.2f,0.1f,0.4f);
        gl.glVertex3f( 0.3f,0.3f,0 );
        gl.glVertex3f( 0.3f,-0.3f,0 );

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
        final GLCanvas glcanvas = new GLCanvas( capabilities );
        Square rhombus = new Square();
        glcanvas.addGLEventListener( rhombus );
        glcanvas.setSize( 400, 400 );

        //creating temalab2
        final JFrame frame = new JFrame ( "Square" );

        //adding canvas to temalab2
        frame.getContentPane().add( glcanvas );
        frame.setSize(frame.getContentPane().getPreferredSize() );
        frame.setVisible( true );
    }
}
