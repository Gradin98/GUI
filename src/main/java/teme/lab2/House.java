package teme.lab2;

import com.jogamp.opengl.*;
import com.jogamp.opengl.awt.GLCanvas;

import javax.swing.*;

public class House implements GLEventListener {
    @Override
    public void init(GLAutoDrawable glAutoDrawable) {

    }

    @Override
    public void dispose(GLAutoDrawable glAutoDrawable) {

    }

    @Override
    public void display(GLAutoDrawable glAutoDrawable) {
        final GL2 gl = glAutoDrawable.getGL().getGL2();

        //drawing top
        gl.glBegin ( GL2.GL_LINES );
        gl.glVertex3f( -0.3f, 0.3f, 0 );
        gl.glVertex3f( 0.3f,0.3f, 0 );
        gl.glEnd();

        //drawing bottom
        gl.glBegin( GL2.GL_LINES );
        gl.glVertex3f( -0.3f,-0.3f, 0 );
        gl.glVertex3f( 0.3f,-0.3f, 0 );
        gl.glEnd();

        //drawing the right edge
        gl.glBegin( GL2.GL_LINES );
        gl.glVertex3f( -0.3f,0.3f, 0 );
        gl.glVertex3f( -0.3f,-0.3f, 0 );
        gl.glEnd();

        //drawing the left edge
        gl.glBegin( GL2.GL_LINES );
        gl.glVertex3f( 0.3f,0.3f,0 );
        gl.glVertex3f( 0.3f,-0.3f,0 );
        gl.glEnd();

        //building roof
        //building lft dia
        gl.glBegin( GL2.GL_LINES );
        gl.glVertex3f( 0f,0.6f, 0 );
        gl.glVertex3f( -0.3f,0.3f, 0 );
        gl.glEnd();

        //building rt dia
        gl.glBegin( GL2.GL_LINES );
        gl.glVertex3f( 0f,0.6f, 0 );
        gl.glVertex3f( 0.3f,0.3f, 0 );
        gl.glEnd();

        //building door
        //drawing top
        gl.glBegin ( GL2.GL_LINES );
        gl.glVertex3f( -0.05f, 0.05f, 0 );
        gl.glVertex3f( 0.05f, 0.05f, 0 );
        gl.glEnd();

        //drawing the left edge
        gl.glBegin ( GL2.GL_LINES );
        gl.glVertex3f( -0.05f, 0.05f, 0 );
        gl.glVertex3f( -0.05f, -0.3f, 0 );
        gl.glEnd();

        //drawing the right edge
        gl.glBegin ( GL2.GL_LINES );
        gl.glVertex3f( 0.05f, 0.05f, 0 );
        gl.glVertex3f( 0.05f, -0.3f, 0 );
        gl.glEnd();


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
        House house = new House();
        glcanvas.addGLEventListener( house );
        glcanvas.setSize(400, 400);

        //creating temalab2
        final JFrame frame = new JFrame( "House" );

        //adding canvas to temalab2
        frame.getContentPane().add( glcanvas );
        frame.setSize(frame.getContentPane().getPreferredSize() );
        frame.setVisible( true );

    }
}
