package teme.lab3;

import com.jogamp.opengl.*;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.glu.GLUquadric;

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

        gl.glColor3f(0.0f,0.0f,1.0f);

        gl.glBegin(gl.GL_TRIANGLES);
        gl.glVertex3f(-0.25f,-0.0f,0.0f);
        gl.glVertex3f(0.25f,-0.0f,0.0f);
        gl.glVertex3f(-0.0f,0.50f,0.0f);
        gl.glEnd();

        gl.glColor3f(0.0f,0.4f,1.0f);

        gl.glBegin(gl.GL_POLYGON);
        gl.glVertex3f(-0.25f,0.0f,0.0f);
        gl.glVertex3f(0.25f,0.0f,0.0f);
        gl.glVertex3f(0.25f,-0.5f,0.0f);
        gl.glVertex3f(-0.25f,-0.5f,0.0f);
        gl.glEnd();

        gl.glColor3f(1,1,0);

        GLU glu = GLU.createGLU();
        GLUquadric quad =  glu.gluNewQuadric();
        gl.glTranslated(0.5, 0.6, 0.0);
        glu.gluSphere(quad, 0.3f, 360, 360);

        glu.gluDeleteQuadric(quad);

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
